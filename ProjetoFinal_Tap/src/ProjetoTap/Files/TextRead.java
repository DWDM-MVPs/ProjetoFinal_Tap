package ProjetoTap.Files;

import ProjetoTap.Data.Data;
import ProjetoTap.Data.Lang;
import ProjetoTap.Data.Settings;
import ProjetoTap.Functions;
import ProjetoTap.StructureActions.Create;
import ProjetoTap.StructureActions.Delete;
import ProjetoTap.Structures.Client;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.MessageFormat;

public class TextRead
{
    //      ██████╗░██████╗░░█████╗░██████╗░██╗░░░██╗░█████╗░████████╗░██████╗
    //      ██╔══██╗██╔══██╗██╔══██╗██╔══██╗██║░░░██║██╔══██╗╚══██╔══╝██╔════╝
    //      ██████╔╝██████╔╝██║░░██║██║░░██║██║░░░██║██║░░╚═╝░░░██║░░░╚█████╗░
    //      ██╔═══╝░██╔══██╗██║░░██║██║░░██║██║░░░██║██║░░██╗░░░██║░░░░╚═══██╗
    //      ██║░░░░░██║░░██║╚█████╔╝██████╔╝╚██████╔╝╚█████╔╝░░░██║░░░██████╔╝
    //      ╚═╝░░░░░╚═╝░░╚═╝░╚════╝░╚═════╝░░╚═════╝░░╚════╝░░░░╚═╝░░░╚═════╝░
    public static int readProducts()
    {
        if (!Functions.doesFileExist(Settings.productsTextPath)) return -1;

        int successfulReadings = 0;
        boolean errors = false;

        try
        {
            BufferedReader bf = new BufferedReader(new FileReader(Settings.productsTextPath));

            String line;
            if ((line = bf.readLine()) != null)
            {
                while ((line = bf.readLine()) != null)
                {
                    // CODE \t NAME \t CATEGORY \t STOCK \t PRICE
                    String[] splitLine = line.split("\t");

                    try
                    {
                        int productCode = Integer.parseInt(splitLine[0]);
                        String name = splitLine[1];
                        String category = splitLine[2];
                        int stock = Integer.parseInt(splitLine[3]);
                        double price = Double.parseDouble(splitLine[4]);

                        if (Create.createProduct(productCode, name, category, stock, price, true) != null)
                        {
                            successfulReadings++;
                        }
                        else
                        {
                            Delete.deleteProduct(productCode);
                            System.out.println(Lang.errorUnknown);
                            errors = true;
                        }
                    }
                    catch (Exception ignored) { }
                }
            }
            else
            {
                return -1;
            }
        }
        catch (Exception ex)
        {
            return -1;
        }

        if (errors) Functions.pressEnterToContinue();
        return successfulReadings;
    }
    //      ░█████╗░██╗░░░░░██╗███████╗███╗░░██╗████████╗░██████╗
    //      ██╔══██╗██║░░░░░██║██╔════╝████╗░██║╚══██╔══╝██╔════╝
    //      ██║░░╚═╝██║░░░░░██║█████╗░░██╔██╗██║░░░██║░░░╚█████╗░
    //      ██║░░██╗██║░░░░░██║██╔══╝░░██║╚████║░░░██║░░░░╚═══██╗
    //      ╚█████╔╝███████╗██║███████╗██║░╚███║░░░██║░░░██████╔╝
    //      ░╚════╝░╚══════╝╚═╝╚══════╝╚═╝░░╚══╝░░░╚═╝░░░╚═════╝░
    public static int readClients()
    {
        if (!Functions.doesFileExist(Settings.clientsTextPath)) return -1;

        int successfulReadings = 0;
        boolean errors = false;

        try
        {
            BufferedReader bf = new BufferedReader(new FileReader(Settings.clientsTextPath));

            String line;
            if ((line = bf.readLine()) != null)
            {
                while ((line = bf.readLine()) != null)
                {
                    // ID \t NAME \t CITY \t BIRTH_YEAR \t SALE_IDS,SALE_IDS,SALE_IDS,...
                    String[] splitLine = line.split("\t");

                    try
                    {
                        int clientId = Integer.parseInt(splitLine[0]);
                        String name = splitLine[1];
                        String city = splitLine[2];
                        int birthYear = Integer.parseInt(splitLine[3]);
                        String saleIds = splitLine[4];

                        Client c = Create.createClient(clientId, name, city, birthYear, true);

                        if (c != null)
                        {
                            for (String saleId : saleIds.split(","))
                            {
                                int parsedSaleId = Integer.parseInt(saleId);

                                if (Data.sales.containsKey(parsedSaleId))
                                {
                                    c.addSale(parsedSaleId);
                                }
                                else
                                {
                                    System.out.println(MessageFormat.format(Lang.ignoringSaleNotFound, parsedSaleId));
                                    errors = true;
                                }
                            }

                            Create.createClient(c, true);

                            successfulReadings++;
                        }
                        else
                        {
                            Delete.deleteClient(clientId);
                            System.out.println(Lang.errorUnknown);
                            errors = true;
                        }
                    }
                    catch (Exception ignored) { }
                }
            }
            else
            {
                return -1;
            }
        }
        catch (Exception ignored)
        {
            return -1;
        }

        if (errors) Functions.pressEnterToContinue();
        return successfulReadings;
    }
    //      ░██████╗░█████╗░██╗░░░░░███████╗░██████╗
    //      ██╔════╝██╔══██╗██║░░░░░██╔════╝██╔════╝
    //      ╚█████╗░███████║██║░░░░░█████╗░░╚█████╗░
    //      ░╚═══██╗██╔══██║██║░░░░░██╔══╝░░░╚═══██╗
    //      ██████╔╝██║░░██║███████╗███████╗██████╔╝
    //      ╚═════╝░╚═╝░░╚═╝╚══════╝╚══════╝╚═════╝░
    public static int readSales()
    {
        // <SALE ID> \t <TOTAL PRICE> \t <PRODUCT ID> \t <AMOUNT>
        if (!Functions.doesFileExist(Settings.salesTextPath)) return -1;

        int successfulReadings = 0;
        boolean errors = false;

        try
        {
            BufferedReader bf = new BufferedReader(new FileReader(Settings.salesTextPath));

            String line;

            if ((line = bf.readLine()) != null)
            {
                while ((line = bf.readLine()) != null)
                {
                    // ID \t TOTAL_PRICE \t PRODUCT_CODE|AMOUNT,PRODUCT_CODE|AMOUNT,...
                    String[] splitLine = line.split("\t");

                    try
                    {
                        int saleId = Integer.parseInt(splitLine[0]);
                        double totalPrice = Double.parseDouble(splitLine[1]);
                        String productsString = splitLine[2];

                        for (String productSplit : productsString.split(","))
                        {
                            String[] productData = productSplit.split("-");

                            int productCode = Integer.parseInt(productData[0]);
                            int stock = Integer.parseInt(productData[1]);

                            if (Data.products.containsKey(productCode))
                            {

                            }
                            else
                            {
                                System.out.println(Lang.errorProductNotFound);
                            }
                        }

                        successfulReadings++;
                    }
                    catch (Exception ignored) { }
                }
            }
            else
            {
                return -1;
            }
        }
        catch (Exception ignored)
        {
            return -1;
        }

        if (errors) Functions.pressEnterToContinue();
        return successfulReadings;
    }
}

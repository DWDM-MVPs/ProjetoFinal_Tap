package ProjetoTap.Files;

import ProjetoTap.Data.Data;
import ProjetoTap.Data.Settings;
import ProjetoTap.Functions;
import ProjetoTap.StructureActions.Create;
import ProjetoTap.StructureActions.Get;
import ProjetoTap.Structures.Client;
import ProjetoTap.Structures.Product;
import ProjetoTap.Structures.Sale;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

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

        int code;
        String name;
        String category;
        int stock;
        double price;

        String line;
        int successfulReadings = 0;

        try
        {
            BufferedReader bf = new BufferedReader(new FileReader(Settings.productsTextPath));

            if ((line = bf.readLine()) != null)
            {
                while ((line = bf.readLine()) != null)
                {
                    String[] splitLine = line.split("\t");

                    try
                    {
                        code = Integer.parseInt(splitLine[0]);
                        name = splitLine[1];
                        category = splitLine[2];
                        stock = Integer.parseInt(splitLine[3]);
                        price = Double.parseDouble(splitLine[4]);

                        Create.createProduct(code, name, category, stock, price, true);
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
        catch (Exception ex)
        {
            return -1;
        }

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

        int id;
        String name;
        String city;
        int birthYear;

        String line;
        int successfulReadings = 0;

        try
        {
            BufferedReader bf = new BufferedReader(new FileReader(Settings.clientsTextPath));

            if ((line = bf.readLine()) != null)
            {
                while ((line = bf.readLine()) != null)
                {
                    String[] splitLine = line.split("\t");

                    try
                    {
                        id = Integer.parseInt(splitLine[0]);
                        name = splitLine[1];
                        city = splitLine[2];
                        birthYear = Integer.parseInt(splitLine[3]);

                        Client c = new Client(id, name, city, birthYear);

                        Data.clients.put(id, c);

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
        if (!Functions.doesFileExist(Settings.salesTextPath) || true) return -1;

        int successfulReadings = 0;

        try
        {
            BufferedReader bf = new BufferedReader(new FileReader(Settings.salesTextPath));

            String line;

            if ((line = bf.readLine()) != null)
            {
                while ((line = bf.readLine()) != null)
                {
                    String[] splitLine = line.split("\t");

                    try
                    {
                        int saleId = Integer.parseInt(splitLine[0]);
                        double totalPrice = Double.parseDouble(splitLine[1]);

                        Map<Integer, Integer> products = new HashMap<>(); // <PRODUCT CODE>, <AMOUNT>

                        String[] productsSplit = splitLine[2].split("\t");
                        if (productsSplit.length > 0)
                        {
                            // STORE PRODUCT INFO
                            int productCode;
                            String productName;
                            String productCategory;
                            int productStock;
                            double productPrice;

                            // READ EVERY PRODUCT
                            for (String productString : productsSplit)
                            {
                                String[] productStringSplit = productString.split(",");

                                productCode = Integer.parseInt(productStringSplit[0]);
                                productName = productStringSplit[1];
                                productCategory = productStringSplit[2];
                                productStock = Integer.parseInt(productStringSplit[3]);
                                productPrice = Double.parseDouble(productStringSplit[4]);

                                Product p = new Product(productCode, productName, productCategory, productStock, productPrice);
                                Create.createProduct(p, false);

                                if (!products.containsKey(p.getCode()))
                                {
                                    products.put(p.getCode(), 1);
                                }
                                else
                                {
                                    int existingAmount = products.get(p.getCode());
                                    products.put(p.getCode(), existingAmount + 1);
                                }
                            }
                        }

                        Sale s = new Sale(saleId, products);
                        if (Get.getSale(s.getId()) != null)
                        {
                            s.setId(Functions.generateId(Data.sales));
                        }
                        Data.sales.put(s.getId(), s);

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

        return successfulReadings;
    }
}

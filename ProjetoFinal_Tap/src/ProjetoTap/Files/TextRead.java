package ProjetoTap.Files;

import ProjetoTap.StructureActions.Create;
import ProjetoTap.StructureActions.Get;
import ProjetoTap.Data.Data;
import ProjetoTap.Functions;
import ProjetoTap.Data.Settings;
import ProjetoTap.Structures.Client;
import ProjetoTap.Structures.Product;
import ProjetoTap.Structures.Sale;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

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
        if (Functions.doesFileExist(Settings.productsTextPath)) return -1;

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
        if (Functions.doesFileExist(Settings.clientsTextPath)) return -1;

        int id;
        String name;
        String city;
        int birthYear;

        String line;
        int successfulReadings = 0;

        try
        {
            BufferedReader bf = new BufferedReader(new FileReader(Settings.clientsTextPath));

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
        catch (Exception ignored)
        {
            System.out.println(ignored.getMessage());
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
        if (Functions.doesFileExist(Settings.salesTextPath)) return -1;

        int id;
        int clientId;
        ArrayList<Product> products = new ArrayList<>();

        String line;
        int successfulReadings = 0;

        try
        {
            BufferedReader bf = new BufferedReader(new FileReader(Settings.salesTextPath));

            while ((line = bf.readLine()) != null)
            {
                String[] splitLine = line.split("\t");

                try
                {
                    id = Integer.parseInt(splitLine[0]);
                    clientId = Integer.parseInt(splitLine[1]);

                    String[] productsSplit = splitLine[2].split("\t");
                    if (productsSplit.length > 0)
                    {
                        int productCode;
                        String productName;
                        String productCategory;
                        int productStock;
                        double productPrice;

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
                            products.add(p);
                        }
                    }


                    Sale s = new Sale(id, clientId, products);
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
        catch (Exception ignored)
        {
            return -1;
        }

        return successfulReadings;
    }
}

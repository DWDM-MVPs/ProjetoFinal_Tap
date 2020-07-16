package ProjetoTap.Files;

import ProjetoTap.Data.Data;
import ProjetoTap.Data.Settings;
import ProjetoTap.StructureActions.Get;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

public class TextSave
{
    public static int saveProducts()
    {
        if (Data.products.size() == 0) return 0;

        try
        {
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(Settings.productsTextPath)));

            writer.println("PRODUCTS BACKUP");
            Data.products.forEach((key, p) ->
            {
                writer.println(p.getCode() + "\t" + p.getName() + "\t" + p.getCategory() + "\t" + p.getStock() + "\t" + p.getPrice());
            });

            writer.close();

            return Data.products.size();
        }
        catch (Exception ignored)
        {
            return -1;
        }
    }
    //      ░█████╗░██╗░░░░░██╗███████╗███╗░░██╗████████╗░██████╗
    //      ██╔══██╗██║░░░░░██║██╔════╝████╗░██║╚══██╔══╝██╔════╝
    //      ██║░░╚═╝██║░░░░░██║█████╗░░██╔██╗██║░░░██║░░░╚█████╗░
    //      ██║░░██╗██║░░░░░██║██╔══╝░░██║╚████║░░░██║░░░░╚═══██╗
    //      ╚█████╔╝███████╗██║███████╗██║░╚███║░░░██║░░░██████╔╝
    //      ░╚════╝░╚══════╝╚═╝╚══════╝╚═╝░░╚══╝░░░╚═╝░░░╚═════╝░
    public static int saveClients()
    {
        if (Data.products.isEmpty()) return 0;

        try
        {
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(Settings.clientsTextPath)));

            writer.println("CLIENTS BACKUP");
            Data.clients.forEach((key, c) ->
            {
                StringBuilder salesString = new StringBuilder();
                boolean addComma = false;
                for (int saleId : c.getSalesIds())
                {
                    if (addComma) salesString.append(",");
                    addComma = true;

                    salesString.append(saleId);
                }

                writer.println(c.getId() + "\t" + c.getName() + "\t" + c.getCity() + "\t" + c.getBirthYear() + "\t" + c.getTotalMoneySpent() + "\t" + salesString.toString());
            });

            writer.close();

            return Data.clients.size();
        }
        catch (Exception ignored)
        {
            return -1;
        }
    }
    //      ░██████╗░█████╗░██╗░░░░░███████╗░██████╗
    //      ██╔════╝██╔══██╗██║░░░░░██╔════╝██╔════╝
    //      ╚█████╗░███████║██║░░░░░█████╗░░╚█████╗░
    //      ░╚═══██╗██╔══██║██║░░░░░██╔══╝░░░╚═══██╗
    //      ██████╔╝██║░░██║███████╗███████╗██████╔╝
    //      ╚═════╝░╚═╝░░╚═╝╚══════╝╚══════╝╚═════╝░
    public static int saveSales()
    {
        if (Data.sales.size() == 0) return 0;

        try
        {
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(Settings.salesTextPath)));

            writer.println("SALES BACKUP");
            Data.sales.forEach((key, s) ->
            {
                if (!s.getSaleProducts().isEmpty())
                {
                    StringBuilder productsString = new StringBuilder();
                    boolean addComma = false;
                    for (int productCode : s.getSaleProducts().keySet())
                    {
                        if (addComma) productsString.append(",");
                        addComma = true;

                        productsString.append(productCode + "-" + Get.getProduct(productCode).getStock());
                    }

                    writer.println(s.getSaleId() + "\t" + s.getTotalPrice() + "\t" + productsString);
                }
            });

            writer.close();

            return Data.sales.size();
        }
        catch (Exception ignored)
        {
            return -1;
        }
    }
}

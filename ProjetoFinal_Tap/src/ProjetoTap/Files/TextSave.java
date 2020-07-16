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
        if (Data.products.size() == 0) return 0;

        try
        {
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(Settings.clientsTextPath)));

            writer.println("CLIENTS BACKUP");
            Data.clients.forEach((key, c) ->
            {
                writer.println(c.getId() + "\t" + c.getName() + "\t" + c.getCity() + "\t" + c.getBirthYear());
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
                StringBuilder productsString = new StringBuilder();

                boolean addTab = false;
                for (int code : s.getSaleProducts().keySet())
                {
                    int stock = Get.getProduct(code).getStock();

                    if (addTab)
                    {
                        addTab = false;
                        productsString.append("\t");
                    }
                    productsString.append(code + "|" + stock);
                    addTab = true;
                }

                writer.println(s.getId() + "\t" + productsString);
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

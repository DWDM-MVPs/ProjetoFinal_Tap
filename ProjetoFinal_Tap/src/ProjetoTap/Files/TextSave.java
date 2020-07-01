package ProjetoTap.Files;

import ProjetoTap.Data.Data;
import ProjetoTap.Data.Settings;
import ProjetoTap.Structures.Product;

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

            Data.sales.forEach((key, s) ->
            {
                StringBuilder productsString = new StringBuilder();

                boolean addTab = false;
                for (Product p : s.getProducts())
                {
                    if (addTab)
                    {
                        addTab = false;
                        productsString.append("\t");
                    }
                    productsString.append(p.getCode());
                    addTab = true;
                }

                writer.println(s.getId() + "\t" + s.getClientId() + productsString);
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

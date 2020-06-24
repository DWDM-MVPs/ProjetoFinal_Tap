package ProjetoTap.Files;

import ProjetoTap.Data.Data;
import ProjetoTap.Data.Settings;
import ProjetoTap.Structures.Product;
import ProjetoTap.Structures.Result;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

public class TextSave
{
    public static Result saveProducts()
    {
        if (Data.products.size() == 0) return new Result(true, "There are no Products to save.");

        try
        {
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(Settings.productsTextPath)));

            Data.products.forEach((key, p) ->
            {
                writer.println(p.getCode() + "\t" + p.getName() + "\t" + p.getCategory() + "\t" + p.getStock() + "\t" + p.getPrice());
            });

            writer.close();

            return new Result(false, "Saved '" + Data.products.size() + "' Products to the file.");
        }
        catch (Exception ignored)
        {
            return new Result(true, "There was an error writing to the file '" + Settings.clientsTextPath + "'.");
        }
    }
    //      ░█████╗░██╗░░░░░██╗███████╗███╗░░██╗████████╗░██████╗
    //      ██╔══██╗██║░░░░░██║██╔════╝████╗░██║╚══██╔══╝██╔════╝
    //      ██║░░╚═╝██║░░░░░██║█████╗░░██╔██╗██║░░░██║░░░╚█████╗░
    //      ██║░░██╗██║░░░░░██║██╔══╝░░██║╚████║░░░██║░░░░╚═══██╗
    //      ╚█████╔╝███████╗██║███████╗██║░╚███║░░░██║░░░██████╔╝
    //      ░╚════╝░╚══════╝╚═╝╚══════╝╚═╝░░╚══╝░░░╚═╝░░░╚═════╝░
    public static Result saveClients()
    {
        if (Data.products.size() == 0) return new Result(true, "There are no Clients to save.");

        try
        {
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(Settings.clientsTextPath)));

            Data.clients.forEach((key, c) ->
            {
                writer.println(c.getId() + "\t" + c.getName() + "\t" + c.getCity() + "\t" + c.getBirthYear());
            });

            writer.close();

            return new Result(false, "Saved '" + Data.clients.size() + "' Clients to the file.");
        }
        catch (Exception ignored)
        {
            return new Result(true, "There was an error writing to the file '" + Settings.clientsTextPath + "'.");
        }
    }
    //      ░██████╗░█████╗░██╗░░░░░███████╗░██████╗
    //      ██╔════╝██╔══██╗██║░░░░░██╔════╝██╔════╝
    //      ╚█████╗░███████║██║░░░░░█████╗░░╚█████╗░
    //      ░╚═══██╗██╔══██║██║░░░░░██╔══╝░░░╚═══██╗
    //      ██████╔╝██║░░██║███████╗███████╗██████╔╝
    //      ╚═════╝░╚═╝░░╚═╝╚══════╝╚══════╝╚═════╝░
    public static Result saveSales()
    {
        if (Data.sales.size() == 0) return new Result(true, "There are no Sales to save.");

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

            return new Result(false, "Saved '" + Data.sales.size() + "' Sales to the file.");
        }
        catch (Exception ignored)
        {
            return new Result(true, "There was an error writing to the file '" + Settings.salesTextPath + "'.");
        }
    }
}

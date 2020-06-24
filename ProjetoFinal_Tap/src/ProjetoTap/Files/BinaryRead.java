package ProjetoTap.Files;

import ProjetoTap.StructureActions.Create;
import ProjetoTap.Data.Data;
import ProjetoTap.Functions;
import ProjetoTap.Data.Settings;
import ProjetoTap.Structures.Client;
import ProjetoTap.Structures.Product;
import ProjetoTap.Structures.Result;
import ProjetoTap.Structures.Sale;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Map;

public class BinaryRead
{
    //      ██████╗░██████╗░░█████╗░██████╗░██╗░░░██╗░█████╗░████████╗░██████╗
    //      ██╔══██╗██╔══██╗██╔══██╗██╔══██╗██║░░░██║██╔══██╗╚══██╔══╝██╔════╝
    //      ██████╔╝██████╔╝██║░░██║██║░░██║██║░░░██║██║░░╚═╝░░░██║░░░╚█████╗░
    //      ██╔═══╝░██╔══██╗██║░░██║██║░░██║██║░░░██║██║░░██╗░░░██║░░░░╚═══██╗
    //      ██║░░░░░██║░░██║╚█████╔╝██████╔╝╚██████╔╝╚█████╔╝░░░██║░░░██████╔╝
    //      ╚═╝░░░░░╚═╝░░╚═╝░╚════╝░╚═════╝░░╚═════╝░░╚════╝░░░░╚═╝░░░╚═════╝░
    public static Result readProducts()
    {
        if (!Functions.doesFileExist(Settings.productsBinaryPath)) return new Result(true, "The file '" + Settings.productsBinaryPath + "' was not found.");

        try
        {
            FileInputStream fis = new FileInputStream(new File(Settings.productsBinaryPath));
            ObjectInputStream ois = new ObjectInputStream(fis);

            Map<Integer, Product> map = (Map<Integer, Product>)ois.readObject();

            map.forEach((key, p) ->
            {
                Create.createProduct(p, false);
            });

            return new Result(false, "The Products where successfully read and added to the list. (amount: '" + map.size() + "')");
        }
        catch (Exception ignored)
        {
            return new Result(true, "There was an error reading the file.");
        }
    }
    //      ░█████╗░██╗░░░░░██╗███████╗███╗░░██╗████████╗░██████╗
    //      ██╔══██╗██║░░░░░██║██╔════╝████╗░██║╚══██╔══╝██╔════╝
    //      ██║░░╚═╝██║░░░░░██║█████╗░░██╔██╗██║░░░██║░░░╚█████╗░
    //      ██║░░██╗██║░░░░░██║██╔══╝░░██║╚████║░░░██║░░░░╚═══██╗
    //      ╚█████╔╝███████╗██║███████╗██║░╚███║░░░██║░░░██████╔╝
    //      ░╚════╝░╚══════╝╚═╝╚══════╝╚═╝░░╚══╝░░░╚═╝░░░╚═════╝░
    public static Result readClients()
    {
        if (!Functions.doesFileExist(Settings.clientsBinaryPath)) return new Result(true, "The file '" + Settings.clientsBinaryPath + "' was not found.");

        try
        {
            FileInputStream fis = new FileInputStream(new File(Settings.clientsBinaryPath));
            ObjectInputStream ois = new ObjectInputStream(fis);

            Map<Integer, Client> map = (Map<Integer, Client>)ois.readObject();

            map.forEach((key, c) ->
            {
                Data.clients.put(key, c);
            });

            return new Result(false, "The Clients where successfully read and added to the list. (amount: '" + map.size() + "')");
        }
        catch (Exception ignored)
        {
            return new Result(true, "There was an error reading the file.");
        }
    }
    //      ░██████╗░█████╗░██╗░░░░░███████╗░██████╗
    //      ██╔════╝██╔══██╗██║░░░░░██╔════╝██╔════╝
    //      ╚█████╗░███████║██║░░░░░█████╗░░╚█████╗░
    //      ░╚═══██╗██╔══██║██║░░░░░██╔══╝░░░╚═══██╗
    //      ██████╔╝██║░░██║███████╗███████╗██████╔╝
    //      ╚═════╝░╚═╝░░╚═╝╚══════╝╚══════╝╚═════╝░
    public static Result readSales()
    {
        if (!Functions.doesFileExist(Settings.salesBinaryPath)) return new Result(true, "The file '" + Settings.salesBinaryPath + "' was not found.");

        try
        {
            FileInputStream fis = new FileInputStream(new File(Settings.salesBinaryPath));
            ObjectInputStream ois = new ObjectInputStream(fis);

            Map<Integer, Sale> map = (Map<Integer, Sale>)ois.readObject();

            map.forEach((key, s) ->
            {
                Data.sales.put(key, s);
            });

            return new Result(false, "The Sales where successfully read and added to the list. (amount: '" + map.size() + "')");
        }
        catch (Exception ignored)
        {
            return new Result(true, "There was an error reading the file.");
        }
    }
}

package ProjetoTap.Files;

import ProjetoTap.Data.Data;
import ProjetoTap.Functions;
import ProjetoTap.Data.Settings;
import ProjetoTap.Structures.Client;
import ProjetoTap.Structures.Product;
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
    public static int readProducts()
    {
        if (!Functions.doesFileExist(Settings.productsBinaryPath)) return 0;

        try
        {
            FileInputStream fis = new FileInputStream(new File(Settings.productsBinaryPath));
            ObjectInputStream ois = new ObjectInputStream(fis);

            Map<Integer, Product> map = (Map<Integer, Product>)ois.readObject();

            map.forEach((key, p) ->
            {
                Data.products.put(key, p);
            });

            return map.size();
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
    public static int readClients()
    {
        if (!Functions.doesFileExist(Settings.clientsBinaryPath)) return 0;

        try
        {
            FileInputStream fis = new FileInputStream(new File(Settings.clientsBinaryPath));
            ObjectInputStream ois = new ObjectInputStream(fis);

            Map<Integer, Client> map = (Map<Integer, Client>)ois.readObject();

            map.forEach((key, c) ->
            {
                Data.clients.put(key, c);
            });

            return map.size();
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
    public static int readSales()
    {
        if (!Functions.doesFileExist(Settings.salesBinaryPath)) return 0;

        try
        {
            FileInputStream fis = new FileInputStream(new File(Settings.salesBinaryPath));
            ObjectInputStream ois = new ObjectInputStream(fis);

            Map<Integer, Sale> map = (Map<Integer, Sale>)ois.readObject();

            map.forEach((key, s) ->
            {
                Data.sales.put(key, s);
            });

            return map.size();
        }
        catch (Exception ignored)
        {
            return -1;
        }
    }
}

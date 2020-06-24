package ProjetoTap.Files;

import ProjetoTap.Data.Data;
import ProjetoTap.Data.Settings;
import ProjetoTap.Structures.Result;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class BinarySave
{
    //      ██████╗░██████╗░░█████╗░██████╗░██╗░░░██╗░█████╗░████████╗░██████╗
    //      ██╔══██╗██╔══██╗██╔══██╗██╔══██╗██║░░░██║██╔══██╗╚══██╔══╝██╔════╝
    //      ██████╔╝██████╔╝██║░░██║██║░░██║██║░░░██║██║░░╚═╝░░░██║░░░╚█████╗░
    //      ██╔═══╝░██╔══██╗██║░░██║██║░░██║██║░░░██║██║░░██╗░░░██║░░░░╚═══██╗
    //      ██║░░░░░██║░░██║╚█████╔╝██████╔╝╚██████╔╝╚█████╔╝░░░██║░░░██████╔╝
    //      ╚═╝░░░░░╚═╝░░╚═╝░╚════╝░╚═════╝░░╚═════╝░░╚════╝░░░░╚═╝░░░╚═════╝░
    public static Result saveProducts()
    {
        if (Data.products.size() == 0) return new Result(true, "There are no Products to save.");

        try
        {
            FileOutputStream fos = new FileOutputStream(new File(Settings.productsBinaryPath));
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(Data.products);

            return new Result(false, "The Products where successfully saved to the file '" + Settings.productsBinaryPath + "'.");
        }
        catch (Exception ignored)
        {
            return new Result(true, "There was an error writing to the file.");
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
        if (Data.clients.size() == 0) return new Result(true, "There are no Clients to save.");

        try
        {
            FileOutputStream fos = new FileOutputStream(new File(Settings.clientsBinaryPath));
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(Data.clients);

            return new Result(false, "The Clients where successfully saved to the file '" + Settings.clientsBinaryPath + "'.");
        }
        catch (Exception ignored)
        {
            return new Result(true, "There was an error writing to the file.");
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
            FileOutputStream fos = new FileOutputStream(new File(Settings.salesBinaryPath));
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(Data.sales);

            return new Result(false, "The Sales where successfully saved to the file '" + Settings.salesBinaryPath + "'.");
        }
        catch (Exception ignored)
        {
            return new Result(true, "There was an error writing to the file.");
        }
    }
}

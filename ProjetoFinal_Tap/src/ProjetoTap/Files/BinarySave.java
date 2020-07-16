package ProjetoTap.Files;

import ProjetoTap.Data.Data;
import ProjetoTap.Data.Settings;

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
    public static int saveProducts()
    {
        if (Data.products.isEmpty()) return 0;

        try
        {
            FileOutputStream fos = new FileOutputStream(new File(Settings.productsBinaryPath));
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(Data.products);

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
        if (Data.clients.isEmpty()) return 0;

        try
        {
            FileOutputStream fos = new FileOutputStream(new File(Settings.clientsBinaryPath));
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(Data.clients);

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
        if (Data.sales.isEmpty()) return 0;

        try
        {
            FileOutputStream fos = new FileOutputStream(new File(Settings.salesBinaryPath));
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(Data.sales);

            return Data.sales.size();
        }
        catch (Exception ignored)
        {
            return -1;
        }
    }
}

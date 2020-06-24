package ProjetoTap.StructureActions;

import ProjetoTap.Data.Data;
import ProjetoTap.Structures.Client;
import ProjetoTap.Structures.Product;
import ProjetoTap.Structures.Sale;

public class Get
{
    //      ██████╗░██████╗░░█████╗░██████╗░██╗░░░██╗░█████╗░████████╗░██████╗
    //      ██╔══██╗██╔══██╗██╔══██╗██╔══██╗██║░░░██║██╔══██╗╚══██╔══╝██╔════╝
    //      ██████╔╝██████╔╝██║░░██║██║░░██║██║░░░██║██║░░╚═╝░░░██║░░░╚█████╗░
    //      ██╔═══╝░██╔══██╗██║░░██║██║░░██║██║░░░██║██║░░██╗░░░██║░░░░╚═══██╗
    //      ██║░░░░░██║░░██║╚█████╔╝██████╔╝╚██████╔╝╚█████╔╝░░░██║░░░██████╔╝
    //      ╚═╝░░░░░╚═╝░░╚═╝░╚════╝░╚═════╝░░╚═════╝░░╚════╝░░░░╚═╝░░░╚═════╝░
    public static Product getProduct(int code)
    {
        if (Data.products.containsKey(code))
        {
            return Data.products.get(code);
        }
        return null;
    }
    public static Product getProduct(String name)
    {
        for (Product p : Data.products.values())
        {
            if (p.getName().equals(name))
            {
                return p;
            }
        }
        return null;
    }
    //      ░█████╗░██╗░░░░░██╗███████╗███╗░░██╗████████╗░██████╗
    //      ██╔══██╗██║░░░░░██║██╔════╝████╗░██║╚══██╔══╝██╔════╝
    //      ██║░░╚═╝██║░░░░░██║█████╗░░██╔██╗██║░░░██║░░░╚█████╗░
    //      ██║░░██╗██║░░░░░██║██╔══╝░░██║╚████║░░░██║░░░░╚═══██╗
    //      ╚█████╔╝███████╗██║███████╗██║░╚███║░░░██║░░░██████╔╝
    //      ░╚════╝░╚══════╝╚═╝╚══════╝╚═╝░░╚══╝░░░╚═╝░░░╚═════╝░
    public static Client getClient(int id)
    {
        if (!Data.clients.containsKey(id)) return null;

        return Data.clients.get(id);
    }
    public static Client getClient(String name)
    {
        for (Client c : Data.clients.values())
        {
            if (c.getName().equals(name))
            {
                return c;
            }
        }

        return null;
    }
    //      ░██████╗░█████╗░██╗░░░░░███████╗░██████╗
    //      ██╔════╝██╔══██╗██║░░░░░██╔════╝██╔════╝
    //      ╚█████╗░███████║██║░░░░░█████╗░░╚█████╗░
    //      ░╚═══██╗██╔══██║██║░░░░░██╔══╝░░░╚═══██╗
    //      ██████╔╝██║░░██║███████╗███████╗██████╔╝
    //      ╚═════╝░╚═╝░░╚═╝╚══════╝╚══════╝╚═════╝░
    public static Sale getSale(int id)
    {
        if (!Data.sales.containsKey(id)) return null;

        return Data.sales.get(id);
    }
    public static Sale getSale(Client client)
    {
        for (Sale sale : Data.sales.values())
        {
            if (sale.getClientId() == client.getId())
            {
                return sale;
            }
        }

        return null;
    }
}

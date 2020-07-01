package ProjetoTap.StructureActions;

import ProjetoTap.Data.Data;
import ProjetoTap.Files.BinarySave;
import ProjetoTap.Functions;
import ProjetoTap.Structures.Client;
import ProjetoTap.Structures.Product;
import ProjetoTap.Structures.Sale;

import java.util.ArrayList;

public class Create
{
    //      ██████╗░██████╗░░█████╗░██████╗░██╗░░░██╗░█████╗░████████╗░██████╗
    //      ██╔══██╗██╔══██╗██╔══██╗██╔══██╗██║░░░██║██╔══██╗╚══██╔══╝██╔════╝
    //      ██████╔╝██████╔╝██║░░██║██║░░██║██║░░░██║██║░░╚═╝░░░██║░░░╚█████╗░
    //      ██╔═══╝░██╔══██╗██║░░██║██║░░██║██║░░░██║██║░░██╗░░░██║░░░░╚═══██╗
    //      ██║░░░░░██║░░██║╚█████╔╝██████╔╝╚██████╔╝╚█████╔╝░░░██║░░░██████╔╝
    //      ╚═╝░░░░░╚═╝░░╚═╝░╚════╝░╚═════╝░░╚═════╝░░╚════╝░░░░╚═╝░░░╚═════╝░
    public static Product createProduct(int code, String name, String category, int stock, double price, boolean canCodeAlreadyExist)
    {
        if (!canCodeAlreadyExist && Data.products.containsKey(code))
        {
            return null;
        }
        else
        {
            Product p = new Product(code, name, category, stock, price);
            Data.products.put(code, p);

            return p;
        }
    }
    public static Product createProduct(Product p, boolean canCodeAlreadyExist)
    {
        if (!canCodeAlreadyExist && Data.products.containsKey(p.getCode()))
        {
            return null;
        }
        else
        {
            Data.products.put(p.getCode(), p);

            return p;
        }
    }
    //      ░█████╗░██╗░░░░░██╗███████╗███╗░░██╗████████╗░██████╗
    //      ██╔══██╗██║░░░░░██║██╔════╝████╗░██║╚══██╔══╝██╔════╝
    //      ██║░░╚═╝██║░░░░░██║█████╗░░██╔██╗██║░░░██║░░░╚█████╗░
    //      ██║░░██╗██║░░░░░██║██╔══╝░░██║╚████║░░░██║░░░░╚═══██╗
    //      ╚█████╔╝███████╗██║███████╗██║░╚███║░░░██║░░░██████╔╝
    //      ░╚════╝░╚══════╝╚═╝╚══════╝╚═╝░░╚══╝░░░╚═╝░░░╚═════╝░
    public static Client createClient(int id, String name, String city, int birthYear, boolean canIdAlreadyExist)
    {
        if (!canIdAlreadyExist && Data.clients.containsKey(id))
        {
            return null;
        }
        else
        {
            Client c = new Client(id, name, city, birthYear);
            Data.clients.put(id, c);

            return c;
        }
    }
    //      ░██████╗░█████╗░██╗░░░░░███████╗░██████╗
    //      ██╔════╝██╔══██╗██║░░░░░██╔════╝██╔════╝
    //      ╚█████╗░███████║██║░░░░░█████╗░░╚█████╗░
    //      ░╚═══██╗██╔══██║██║░░░░░██╔══╝░░░╚═══██╗
    //      ██████╔╝██║░░██║███████╗███████╗██████╔╝
    //      ╚═════╝░╚═╝░░╚═╝╚══════╝╚══════╝╚═════╝░
    public static Sale createSale(int clientId, ArrayList<Product> products)
    {
        int saleId = Functions.generateId(Data.sales);

        Sale s = new Sale(saleId, clientId, products);
        Data.sales.put(saleId, s);

        return s;
    }
}

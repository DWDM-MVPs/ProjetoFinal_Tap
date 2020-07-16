package ProjetoTap.StructureActions;

import ProjetoTap.Data.Data;
import ProjetoTap.Files.BinarySave;
import ProjetoTap.Structures.Client;
import ProjetoTap.Structures.Product;
import ProjetoTap.Structures.Sale;

import java.util.ArrayList;
import java.util.Map;

public class Create
{
    //      ██████╗░██████╗░░█████╗░██████╗░██╗░░░██╗░█████╗░████████╗░██████╗
    //      ██╔══██╗██╔══██╗██╔══██╗██╔══██╗██║░░░██║██╔══██╗╚══██╔══╝██╔════╝
    //      ██████╔╝██████╔╝██║░░██║██║░░██║██║░░░██║██║░░╚═╝░░░██║░░░╚█████╗░
    //      ██╔═══╝░██╔══██╗██║░░██║██║░░██║██║░░░██║██║░░██╗░░░██║░░░░╚═══██╗
    //      ██║░░░░░██║░░██║╚█████╔╝██████╔╝╚██████╔╝╚█████╔╝░░░██║░░░██████╔╝
    //      ╚═╝░░░░░╚═╝░░╚═╝░╚════╝░╚═════╝░░╚═════╝░░╚════╝░░░░╚═╝░░░╚═════╝░
    public static Product createProduct(int productCode, String name, String category, int stock, double price, boolean overrideExisting)
    {
        if (!overrideExisting && Data.products.containsKey(productCode))
        {
            return null;
        }
        else
        {
            if (Data.products.containsKey(productCode)) Delete.deleteProduct(productCode);

            Product p = new Product(productCode, name, category, stock, price);
            Data.products.put(productCode, p);

            // ADD PRODUCT TO CATEGORY
            ArrayList<Integer> categoryProducts = new ArrayList<>();
            if (Data.categories.containsKey(category.toLowerCase()))
            {
                categoryProducts = Data.categories.get(category.toLowerCase());
            }
            categoryProducts.add(productCode);
            Data.categories.put(category.toLowerCase(), categoryProducts);

            BinarySave.saveProducts();

            return p;
        }
    }
    public static Product createProduct(Product p, boolean overrideExisting)
    {
        return createProduct(p.getCode(), p.getName(), p.getCategory(), p.getStock(), p.getPrice(), overrideExisting);
    }
    //      ░█████╗░██╗░░░░░██╗███████╗███╗░░██╗████████╗░██████╗
    //      ██╔══██╗██║░░░░░██║██╔════╝████╗░██║╚══██╔══╝██╔════╝
    //      ██║░░╚═╝██║░░░░░██║█████╗░░██╔██╗██║░░░██║░░░╚█████╗░
    //      ██║░░██╗██║░░░░░██║██╔══╝░░██║╚████║░░░██║░░░░╚═══██╗
    //      ╚█████╔╝███████╗██║███████╗██║░╚███║░░░██║░░░██████╔╝
    //      ░╚════╝░╚══════╝╚═╝╚══════╝╚═╝░░╚══╝░░░╚═╝░░░╚═════╝░
    public static Client createClient(int clientId, String name, String city, int birthYear, boolean overrideExisting)
    {
        if (!overrideExisting && Data.clients.containsKey(clientId))
        {
            return null;
        }
        else
        {
            if (Data.clients.containsKey(clientId)) Delete.deleteClient(clientId);

            Client c = new Client(clientId, name, city, birthYear);
            Data.clients.put(clientId, c);

            BinarySave.saveClients();

            return c;
        }
    }
    public static Client createClient(Client c, boolean overrideExisting)
    {
        return createClient(c.getId(), c.getName(), c.getCity(), c.getBirthYear(), overrideExisting);
    }
    //      ░██████╗░█████╗░██╗░░░░░███████╗░██████╗
    //      ██╔════╝██╔══██╗██║░░░░░██╔════╝██╔════╝
    //      ╚█████╗░███████║██║░░░░░█████╗░░╚█████╗░
    //      ░╚═══██╗██╔══██║██║░░░░░██╔══╝░░░╚═══██╗
    //      ██████╔╝██║░░██║███████╗███████╗██████╔╝
    //      ╚═════╝░╚═╝░░╚═╝╚══════╝╚══════╝╚═════╝░
    public static Sale createSale(int clientId, Map<Integer, Integer> products)
    {
        // NOTE: PRODUCT STOCK IS ALREADY BEING REMOVED WHEN THE SALE IS CREATED
        Sale s = new Sale(clientId, products);

        Data.sales.put(s.getSaleId(), s);
        Data.clients.get(clientId).addSale(s.getSaleId());

        BinarySave.saveProducts();
        BinarySave.saveClients();
        BinarySave.saveSales();

        return s;
    }
}

package ProjetoTap.StructureActions;

import ProjetoTap.Data.Data;
import ProjetoTap.Functions;
import ProjetoTap.Structures.Product;

import java.util.ArrayList;

public class Delete
{
    //      ██████╗░██████╗░░█████╗░██████╗░██╗░░░██╗░█████╗░████████╗░██████╗
    //      ██╔══██╗██╔══██╗██╔══██╗██╔══██╗██║░░░██║██╔══██╗╚══██╔══╝██╔════╝
    //      ██████╔╝██████╔╝██║░░██║██║░░██║██║░░░██║██║░░╚═╝░░░██║░░░╚█████╗░
    //      ██╔═══╝░██╔══██╗██║░░██║██║░░██║██║░░░██║██║░░██╗░░░██║░░░░╚═══██╗
    //      ██║░░░░░██║░░██║╚█████╔╝██████╔╝╚██████╔╝╚█████╔╝░░░██║░░░██████╔╝
    //      ╚═╝░░░░░╚═╝░░╚═╝░╚════╝░╚═════╝░░╚═════╝░░╚════╝░░░░╚═╝░░░╚═════╝░
    public static void deleteProduct(int code)
    {
        Data.products.remove(code);
    }
    public static void deleteProduct(String name)
    {
        for (Product p : Data.products.values())
        {
            if (p.getName().equals(name))
            {
                Data.products.remove(p.getCode());
            }
        }
    }
    //      ░█████╗░██╗░░░░░██╗███████╗███╗░░██╗████████╗░██████╗
    //      ██╔══██╗██║░░░░░██║██╔════╝████╗░██║╚══██╔══╝██╔════╝
    //      ██║░░╚═╝██║░░░░░██║█████╗░░██╔██╗██║░░░██║░░░╚█████╗░
    //      ██║░░██╗██║░░░░░██║██╔══╝░░██║╚████║░░░██║░░░░╚═══██╗
    //      ╚█████╔╝███████╗██║███████╗██║░╚███║░░░██║░░░██████╔╝
    //      ░╚════╝░╚══════╝╚═╝╚══════╝╚═╝░░╚══╝░░░╚═╝░░░╚═════╝░
    public static void deleteClient(int id)
    {
        Data.clients.remove(id);
    }
    //      ░██████╗░█████╗░██╗░░░░░███████╗░██████╗
    //      ██╔════╝██╔══██╗██║░░░░░██╔════╝██╔════╝
    //      ╚█████╗░███████║██║░░░░░█████╗░░╚█████╗░
    //      ░╚═══██╗██╔══██║██║░░░░░██╔══╝░░░╚═══██╗
    //      ██████╔╝██║░░██║███████╗███████╗██████╔╝
    //      ╚═════╝░╚═╝░░╚═╝╚══════╝╚══════╝╚═════╝░
    public static void deleteSale(int id, boolean returnProductsToStock)
    {
        if (returnProductsToStock)
        {
            ArrayList<Product> saleProducts = Data.sales.get(id).getProducts();
            saleProducts.forEach((p ->
            {
                // GET PRODUCT
                Product existingProduct = Get.getProduct(p.getCode());

                // EDIT EXISTING PRODUCT
                if (existingProduct != null)
                {
                    existingProduct.setStock(existingProduct.getStock() + p.getStock());

                    Data.products.put(existingProduct.getCode(), existingProduct);
                }
                // CREATE NEW PRODUCT
                else
                {
                    int productId = Functions.generateId(Data.products);

                    Data.products.put(productId, p);
                }
            }));
        }
        else
        {
            Data.sales.remove(id);
        }
    }
}

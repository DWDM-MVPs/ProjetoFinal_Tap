package ProjetoTap.StructureActions;

import ProjetoTap.Data.Data;
import ProjetoTap.Data.Lang;
import ProjetoTap.Functions;
import ProjetoTap.Structures.Client;
import ProjetoTap.Structures.Product;
import ProjetoTap.Structures.Sale;

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
    public static void deleteSale(int saleId, boolean returnProductsToStock)
    {
        Sale s = Get.getSale(saleId);

        if (returnProductsToStock)
        {
            if (s != null)
            {
                for (int productCode : s.getSaleProducts().keySet())
                {
                    // EDIT EXISTING PRODUCT
                    if (Get.getProduct(productCode) != null)
                    {
                        Get.getProduct(productCode).addStock(s.getSaleProducts().get(productCode));
                    }
                    // PRODUCT DOES NOT EXIST, DISCARD AND PRINT ERROR
                    else
                    {
                        System.out.println(Lang.errorProductRefundDoesNotExist);
                    }
                }
            }
            else
            {
                System.out.println(Lang.errorUnknown);
            }
        }
        else
        {
            // REMOVE SALE FROM CLIENT
            if (s != null)
            {
                Client c = Get.getClient(s.getClientId());

                if (c != null)
                {
                    c.removeSale(saleId);
                }
                else
                {
                    System.out.println(Lang.errorUnknown);
                }
            }
            else
            {
                System.out.println(Lang.errorUnknown);
            }
            // REMOVE SALE
            Data.sales.remove(saleId);
        }

        Functions.pressEnterToContinue();
    }
}

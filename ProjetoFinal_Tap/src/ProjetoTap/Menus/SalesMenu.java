package ProjetoTap.Menus;

import ProjetoTap.StructureActions.Create;
import ProjetoTap.StructureActions.Get;
import ProjetoTap.Data.Data;
import ProjetoTap.Functions;
import ProjetoTap.Data.Lang;
import ProjetoTap.Structures.Sale;
import ProjetoTap.UserInput.ReadClient;
import ProjetoTap.UserInput.ReadProduct;
import ProjetoTap.Structures.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static ProjetoTap.Functions.errorReset;
import static ProjetoTap.Main.readMenuOption;
import static ProjetoTap.Main.sc;

public class SalesMenu
{
    //      ░██████╗██╗░░██╗░█████╗░░██╗░░░░░░░██╗  ░██████╗░█████╗░██╗░░░░░███████╗░██████╗  ███╗░░░███╗███████╗███╗░░██╗██╗░░░██╗
    //      ██╔════╝██║░░██║██╔══██╗░██║░░██╗░░██║  ██╔════╝██╔══██╗██║░░░░░██╔════╝██╔════╝  ████╗░████║██╔════╝████╗░██║██║░░░██║
    //      ╚█████╗░███████║██║░░██║░╚██╗████╗██╔╝  ╚█████╗░███████║██║░░░░░█████╗░░╚█████╗░  ██╔████╔██║█████╗░░██╔██╗██║██║░░░██║
    //      ░╚═══██╗██╔══██║██║░░██║░░████╔═████║░  ░╚═══██╗██╔══██║██║░░░░░██╔══╝░░░╚═══██╗  ██║╚██╔╝██║██╔══╝░░██║╚████║██║░░░██║
    //      ██████╔╝██║░░██║╚█████╔╝░░╚██╔╝░╚██╔╝░  ██████╔╝██║░░██║███████╗███████╗██████╔╝  ██║░╚═╝░██║███████╗██║░╚███║╚██████╔╝
    //      ╚═════╝░╚═╝░░╚═╝░╚════╝░░░░╚═╝░░░╚═╝░░  ╚═════╝░╚═╝░░╚═╝╚══════╝╚══════╝╚═════╝░  ╚═╝░░░░░╚═╝╚══════╝╚═╝░░╚══╝░╚═════╝░
    public static void showSalesMenu()
    {
        int option;
        do
        {
            Functions.prepareMenu(Lang.colorYellow + Lang.salesMenu);

            System.out.println(Lang.colorYellow + "0. " + Lang.exit);
            System.out.println(Lang.colorGreen + "1. " + Lang.makeSaleMenu);
            System.out.println(Lang.colorGreen + "2. " + Lang.categoriesWithMostSalesMenu);

            option = readMenuOption(0, 3);
            switch (option)
            {
                case 1: // MAKE SALE
                    showMakeSale();
                    break;
                case 2: // CATEGORIES WITH MOST SALES
                    showCategoriesWithMostSales();
                    break;
            }
        } while (option != 0);
    }
    //      ███╗░░░███╗░█████╗░██╗░░██╗███████╗  ░██████╗░█████╗░██╗░░░░░███████╗
    //      ████╗░████║██╔══██╗██║░██╔╝██╔════╝  ██╔════╝██╔══██╗██║░░░░░██╔════╝
    //      ██╔████╔██║███████║█████═╝░█████╗░░  ╚█████╗░███████║██║░░░░░█████╗░░
    //      ██║╚██╔╝██║██╔══██║██╔═██╗░██╔══╝░░  ░╚═══██╗██╔══██║██║░░░░░██╔══╝░░
    //      ██║░╚═╝░██║██║░░██║██║░╚██╗███████╗  ██████╔╝██║░░██║███████╗███████╗
    //      ╚═╝░░░░░╚═╝╚═╝░░╚═╝╚═╝░░╚═╝╚══════╝  ╚═════╝░╚═╝░░╚═╝╚══════╝╚══════╝
    public static void showMakeSale()
    {
        Functions.prepareMenu(Lang.buyProducts);

        int clientId = ReadClient.existingClientId();

        Map<Integer, Integer> saleProducts = new HashMap<>();

        do
        {
            int productCode = ReadProduct.existingProductCode();
            int stock = ReadProduct.productStock(true);

            if (Data.products.get(productCode).getStock() < stock)
            {
                System.out.println(Lang.errorNotEnoughStock);
            }
            else
            {
                if (Data.products.get(productCode).getStock() == stock)
                {
                    System.out.println(String.format(Lang.outOfStock, Data.products.get(productCode).getName()));
                }
                if (saleProducts.containsKey(productCode))
                {
                    saleProducts.put(productCode, stock);
                }
                else
                {
                    int amount = saleProducts.get(productCode);

                    saleProducts.put(productCode, amount + stock);
                }
            }
        } while (addMoreProducts());

        ArrayList<Product> productsArray = new ArrayList<>();
        for (int key : saleProducts.keySet())
        {
            Product p = Get.getProduct(saleProducts.get(key));

            p.removeStock(key);
            Data.products.put(p.getCode(), p);

            for (int i = 0; i < key; i++)
            {
                productsArray.add(p);
            }
        }

        Create.createSale(clientId, productsArray);
        System.out.println(Lang.saleCreated);
    }
    public static boolean addMoreProducts()
    {
        try
        {
            System.out.println(Lang.addMoreProducts);

            String cont = sc.next();

            if (cont.toLowerCase().equals("y") || cont.toLowerCase().equals("n"))
            {
                return cont.toLowerCase().equals("y");
            }
            else
            {
                errorReset(Lang.errorInvalidBooleanOption);
                return addMoreProducts();
            }
        }
        catch (Exception ignored)
        {
            errorReset(Lang.errorWrongDataType);
            return addMoreProducts();
        }
    }
    //      ░█████╗░░█████╗░████████╗███████╗░██████╗░░█████╗░██████╗░██╗███████╗░██████╗  ░██╗░░░░░░░██╗██╗████████╗██╗░░██╗  ███╗░░░███╗░█████╗░░██████╗████████╗  ░██████╗░█████╗░██╗░░░░░███████╗░██████╗
    //      ██╔══██╗██╔══██╗╚══██╔══╝██╔════╝██╔════╝░██╔══██╗██╔══██╗██║██╔════╝██╔════╝  ░██║░░██╗░░██║██║╚══██╔══╝██║░░██║  ████╗░████║██╔══██╗██╔════╝╚══██╔══╝  ██╔════╝██╔══██╗██║░░░░░██╔════╝██╔════╝
    //      ██║░░╚═╝███████║░░░██║░░░█████╗░░██║░░██╗░██║░░██║██████╔╝██║█████╗░░╚█████╗░  ░╚██╗████╗██╔╝██║░░░██║░░░███████║  ██╔████╔██║██║░░██║╚█████╗░░░░██║░░░  ╚█████╗░███████║██║░░░░░█████╗░░╚█████╗░
    //      ██║░░██╗██╔══██║░░░██║░░░██╔══╝░░██║░░╚██╗██║░░██║██╔══██╗██║██╔══╝░░░╚═══██╗  ░░████╔═████║░██║░░░██║░░░██╔══██║  ██║╚██╔╝██║██║░░██║░╚═══██╗░░░██║░░░  ░╚═══██╗██╔══██║██║░░░░░██╔══╝░░░╚═══██╗
    //      ╚█████╔╝██║░░██║░░░██║░░░███████╗╚██████╔╝╚█████╔╝██║░░██║██║███████╗██████╔╝  ░░╚██╔╝░╚██╔╝░██║░░░██║░░░██║░░██║  ██║░╚═╝░██║╚█████╔╝██████╔╝░░░██║░░░  ██████╔╝██║░░██║███████╗███████╗██████╔╝
    //      ░╚════╝░╚═╝░░╚═╝░░░╚═╝░░░╚══════╝░╚═════╝░░╚════╝░╚═╝░░╚═╝╚═╝╚══════╝╚═════╝░  ░░░╚═╝░░░╚═╝░░╚═╝░░░╚═╝░░░╚═╝░░╚═╝  ╚═╝░░░░░╚═╝░╚════╝░╚═════╝░░░░╚═╝░░░  ╚═════╝░╚═╝░░╚═╝╚══════╝╚══════╝╚═════╝░
    public static void showCategoriesWithMostSales()
    {
        Functions.prepareMenu(Lang.categoriesWithMostSalesMenu);

        Map<String, Integer> salesList = new HashMap<>();
        for (Sale s : Data.sales.values())
        {
            for (Product p : s.getProducts())
            {
                if (!salesList.containsKey(p.getCategory()))
                {
                    salesList.put(p.getCategory(), 1);
                }
                else
                {
                    int existingValue = salesList.get(p.getCategory());
                    salesList.put(p.getCategory(), existingValue + 1);
                }
            }
        }

        int mostSales = 0;
        ArrayList<String> mostSoldCategories = new ArrayList<>();
        for (String category : salesList.keySet())
        {
            int sales = salesList.get(category);
            if (sales > mostSales)
            {
                mostSales = sales;
                mostSoldCategories.clear();
            }
            if (sales == mostSales)
            {
                mostSoldCategories.add(category);
            }
        }

        System.out.println(String.format(Lang.mostSoldCategories, mostSales));
        for (String category : mostSoldCategories)
        {
            System.out.println(" » " + category);
        }
    }
}

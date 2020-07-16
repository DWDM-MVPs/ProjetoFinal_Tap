package ProjetoTap.Menus;

import ProjetoTap.Data.Data;
import ProjetoTap.Data.Lang;
import ProjetoTap.Functions;
import ProjetoTap.ReadInput.ReadClient;
import ProjetoTap.ReadInput.ReadProduct;
import ProjetoTap.StructureActions.Create;
import ProjetoTap.StructureActions.Get;
import ProjetoTap.Structures.Client;
import ProjetoTap.Structures.Product;
import ProjetoTap.Structures.Sale;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static ProjetoTap.Functions.errorReset;
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
            ArrayList<String> options = new ArrayList<String>()
            {{
                add(Lang.makeSaleMenu);
                add(Lang.categoriesWithMostSalesMenu);
                add(Lang.clientViewPurchasesMenu);
            }};

            option = Functions.printMenu(Lang.salesMenu, options, true);
            switch (option)
            {
                case 1: // MAKE SALE
                    showMakeSale();
                    break;
                case 2: // CATEGORIES WITH MOST SALES
                    showCategoriesWithMostSales();
                    break;
                case 3: // VIEW CLIENT PURCHASES
                    showViewClientPurchases();
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

        if (Data.products.size() <= 0)
        {
            // ERROR: THERE ARE NO PRODUCTS
            System.out.println(Lang.errorLoadingProducts);
        }
        else if (Data.clients.size() <= 0)
        {
            // ERROR: THERE ARE NO CLIENTS
            System.out.println(Lang.errorLoadingClients);
        }
        else
        {
            // READ A CLIENT ID FROM THE USER
            int clientId = ReadClient.existingClientId();

            // <PRODUCT CODE, AMOUNT>
            Map<Integer, Integer> saleProducts = new HashMap<>();

            // READ PRODUCTS FROM THE USER TO ADD TO THE SALE
            do
            {
                // READ A PRODUCT CODE
                int productCode = ReadProduct.existingProductCode();
                // READ AMOUNT OF PRODUCT TO SELL
                int stock = ReadProduct.productStock(true);

                // ERROR: THE PRODUCT DOES NOT HAVE ENOUGH STOCK
                if (Data.products.get(productCode).getStock() < stock)
                {
                    System.out.println(Lang.errorNotEnoughStock);
                }
                // IF THE PRODUCT HAS ENOUGH STOCK
                else
                {
                    // IF THIS SALE IS GOING TO SET THE PRODUCT STOCK TO 0
                    if (Data.products.get(productCode).getStock() == stock)
                    {
                        // PRINT A MESSAGE INFORMING THE USER THAT THE PRODUCT IS OUT OF STOCK
                        System.out.println(MessageFormat.format(Lang.outOfStock, Data.products.get(productCode).getName()));
                    }

                    // ADD THE PRODUCT TO THE SALE MAP
                    if (!saleProducts.containsKey(productCode))
                    {
                        saleProducts.put(productCode, stock);
                    }
                    else
                    {
                        int existingAmount = saleProducts.get(productCode);
                        saleProducts.put(productCode, existingAmount + stock);
                    }
                }
                // READ IF THE USER WANTS TO ADD ANOTHER PRODUCT
            } while (Functions.yesOrNo(Lang.addMoreProducts));

            // LOOP EVERY SALE PRODUCT AND REMOVE IT'S STOCK ACCORDING TO THE SOLD AMOUNT
            for (int productCode : saleProducts.keySet())
            {
                // GET THE PRODUCT
                Get.getProduct(productCode).removeStock(saleProducts.get(productCode));
            }

            // CREATE THE SALE
            Create.createSale(clientId, saleProducts);

            System.out.println(Lang.saleCreated);
        }

        Functions.pressEnterToContinue();
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

        // CHECKS IF THERE ARE ANY SALES
        if (Data.sales.size() > 0)
        {
            // <CATEGORY NAME, AMOUNT OF SALES>
            Map<String, Integer> salesList = new HashMap<>();
            for (Sale s : Data.sales.values())
            {
                for (int code : s.getSaleProducts().keySet())
                {
                    Product p = Get.getProduct(code);

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

            System.out.println(MessageFormat.format(Lang.mostSoldCategories, mostSales));
            for (String category : mostSoldCategories)
            {
                System.out.println(" » " + category);
            }
        }
        else
        {
            System.out.println(Lang.errorLoadingSales);
        }
        Functions.pressEnterToContinue();
    }
    //      ██╗░░░██╗██╗███████╗░██╗░░░░░░░██╗  ░█████╗░██╗░░░░░██╗███████╗███╗░░██╗████████╗  ██████╗░██╗░░░██╗██████╗░░█████╗░██╗░░██╗░█████╗░░██████╗███████╗░██████╗
    //      ██║░░░██║██║██╔════╝░██║░░██╗░░██║  ██╔══██╗██║░░░░░██║██╔════╝████╗░██║╚══██╔══╝  ██╔══██╗██║░░░██║██╔══██╗██╔══██╗██║░░██║██╔══██╗██╔════╝██╔════╝██╔════╝
    //      ╚██╗░██╔╝██║█████╗░░░╚██╗████╗██╔╝  ██║░░╚═╝██║░░░░░██║█████╗░░██╔██╗██║░░░██║░░░  ██████╔╝██║░░░██║██████╔╝██║░░╚═╝███████║███████║╚█████╗░█████╗░░╚█████╗░
    //      ░╚████╔╝░██║██╔══╝░░░░████╔═████║░  ██║░░██╗██║░░░░░██║██╔══╝░░██║╚████║░░░██║░░░  ██╔═══╝░██║░░░██║██╔══██╗██║░░██╗██╔══██║██╔══██║░╚═══██╗██╔══╝░░░╚═══██╗
    //      ░░╚██╔╝░░██║███████╗░░╚██╔╝░╚██╔╝░  ╚█████╔╝███████╗██║███████╗██║░╚███║░░░██║░░░  ██║░░░░░╚██████╔╝██║░░██║╚█████╔╝██║░░██║██║░░██║██████╔╝███████╗██████╔╝
    //      ░░░╚═╝░░░╚═╝╚══════╝░░░╚═╝░░░╚═╝░░  ░╚════╝░╚══════╝╚═╝╚══════╝╚═╝░░╚══╝░░░╚═╝░░░  ╚═╝░░░░░░╚═════╝░╚═╝░░╚═╝░╚════╝░╚═╝░░╚═╝╚═╝░░╚═╝╚═════╝░╚══════╝╚═════╝░
    public static void showViewClientPurchases()
    {
        Functions.prepareMenu(Lang.clientViewPurchasesMenu);

        if (Data.clients.size() <= 0)
        {
            System.out.println(Lang.errorLoadingClients);
        }
        else if (Data.sales.size() <= 0)
        {
            System.out.println(Lang.errorLoadingSales);
        }
        else
        {
            int clientId = ReadClient.existingClientId();

            Client c = Get.getClient(clientId);

            if (c.getSalesIds().size() > 0)
            {
                Map<Integer, Integer> totalProductsSold = new HashMap<>();

                // MIX EVERY SALE IN A SINGLE MAP
                for (int saleId : c.getSalesIds())
                {
                    Sale s = Get.getSale(saleId);
                    Map<Integer, Integer> saleProducts = s.getSaleProducts(); // <PRODUCT ID>, <AMOUNT>

                    for (int productCode : saleProducts.keySet())
                    {
                        if (!totalProductsSold.containsKey(productCode))
                        {
                            totalProductsSold.put(productCode, 1);
                        }
                        else
                        {
                            int existingAmount = totalProductsSold.get(productCode);
                            totalProductsSold.put(productCode, existingAmount + 1);
                        }
                    }
                }

                System.out.println(MessageFormat.format(Lang.salesOfClient, c.getName(), c.getId()));

                // PRINT SALES
                for (int productCode : totalProductsSold.keySet())
                {
                    Product p = Get.getProduct(productCode);
                    double totalPrice = p.getPrice() * totalProductsSold.get(productCode);
                    System.out.println(MessageFormat.format(Lang.clientSaleListEntry, totalProductsSold.get(productCode), p.getName(), totalPrice));
                }
            }
            else
            {
                System.out.println(Lang.errorClientHasNoSales);
            }
        }
        Functions.pressEnterToContinue();
    }
}

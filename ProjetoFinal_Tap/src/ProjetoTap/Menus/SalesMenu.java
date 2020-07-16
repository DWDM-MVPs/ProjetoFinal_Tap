package ProjetoTap.Menus;

import ProjetoTap.Data.Data;
import ProjetoTap.Data.Lang;
import ProjetoTap.Functions;
import ProjetoTap.ReadInput.ReadClient;
import ProjetoTap.ReadInput.ReadProduct;
import ProjetoTap.ReadInput.ReadSale;
import ProjetoTap.StructureActions.Create;
import ProjetoTap.StructureActions.Delete;
import ProjetoTap.StructureActions.Get;
import ProjetoTap.Structures.Client;
import ProjetoTap.Structures.Product;
import ProjetoTap.Structures.Sale;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
                add(Lang.deleteSaleMenu);
                /*
                add(Lang.editSaleMenu);
                */
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
                case 4: // DELETE SALE
                    showDeleteSale();
                    break;
                    /*
                case 5: // EDIT SALE
                    showEditSale();
                    break;
                    */
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

        if (Data.products.isEmpty())
        {
            // ERROR: THERE ARE NO PRODUCTS
            System.out.println(Lang.errorNoProductsFound);
        }
        else if (Data.clients.isEmpty())
        {
            // ERROR: THERE ARE NO CLIENTS
            System.out.println(Lang.errorNoClientsFound);
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
                int stock = 0;
                while (true)
                {
                    stock = ReadProduct.productStock(true);
                    // ERROR: THE PRODUCT DOES NOT HAVE ENOUGH STOCK
                    if (Get.getProduct(productCode).getStock() < stock)
                    {
                        System.out.println(Lang.errorNotEnoughStock);
                    }
                    else
                    {
                        break;
                    }
                }

                // IF THIS SALE IS GOING TO SET THE PRODUCT STOCK TO 0
                if (Get.getProduct(productCode).getStock() == stock)
                {
                    // PRINT A MESSAGE INFORMING THE USER THAT THE PRODUCT IS OUT OF STOCK
                    System.out.println(MessageFormat.format(Lang.outOfStock, Get.getProduct(productCode).getName()));
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
            System.out.println(Lang.errorNoSalesFound);
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

        if (Data.clients.isEmpty())
        {
            System.out.println(Lang.errorNoClientsFound);
        }
        else if (Data.sales.isEmpty())
        {
            System.out.println(Lang.errorNoSalesFound);
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
    //      ██████╗░███████╗██╗░░░░░███████╗████████╗███████╗  ░██████╗░█████╗░██╗░░░░░███████╗
    //      ██╔══██╗██╔════╝██║░░░░░██╔════╝╚══██╔══╝██╔════╝  ██╔════╝██╔══██╗██║░░░░░██╔════╝
    //      ██║░░██║█████╗░░██║░░░░░█████╗░░░░░██║░░░█████╗░░  ╚█████╗░███████║██║░░░░░█████╗░░
    //      ██║░░██║██╔══╝░░██║░░░░░██╔══╝░░░░░██║░░░██╔══╝░░  ░╚═══██╗██╔══██║██║░░░░░██╔══╝░░
    //      ██████╔╝███████╗███████╗███████╗░░░██║░░░███████╗  ██████╔╝██║░░██║███████╗███████╗
    //      ╚═════╝░╚══════╝╚══════╝╚══════╝░░░╚═╝░░░╚══════╝  ╚═════╝░╚═╝░░╚═╝╚══════╝╚══════╝
    private static void showDeleteSale()
    {
        Functions.prepareMenu(Lang.deleteSaleMenu);

        if (Data.sales.isEmpty())
        {
            System.out.println(Lang.errorNoSalesFound);
        }
        else
        {
            int saleId = ReadSale.existingSaleId();

            if (Functions.yesOrNo(Lang.areYouSureToDeleteSaleWithId) && Functions.yesOrNo(Lang.areYouReallySureYouWantToDoThis))
            {
                Delete.deleteSale(saleId, Functions.yesOrNo(Lang.returnProductsToStock));
                System.out.println(Lang.saleDeleteSuccessfully);
            }
        }
        Functions.pressEnterToContinue();
    }
    /*
    //      ███████╗██████╗░██╗████████╗  ░██████╗░█████╗░██╗░░░░░███████╗
    //      ██╔════╝██╔══██╗██║╚══██╔══╝  ██╔════╝██╔══██╗██║░░░░░██╔════╝
    //      █████╗░░██║░░██║██║░░░██║░░░  ╚█████╗░███████║██║░░░░░█████╗░░
    //      ██╔══╝░░██║░░██║██║░░░██║░░░  ░╚═══██╗██╔══██║██║░░░░░██╔══╝░░
    //      ███████╗██████╔╝██║░░░██║░░░  ██████╔╝██║░░██║███████╗███████╗
    //      ╚══════╝╚═════╝░╚═╝░░░╚═╝░░░  ╚═════╝░╚═╝░░╚═╝╚══════╝╚══════╝
    public static void showEditSale()
    {
        Functions.prepareMenu(Lang.editSaleMenu);

        if (!Data.sales.isEmpty())
        {
            int saleId = ReadSale.existingSaleId();
            Sale s = Get.getSale(saleId);

            if (s != null)
            {
                int clientId = s.getClientId();
                Client c = Get.getClient(clientId);

                if (c != null)
                {
                    System.out.println(MessageFormat.format(Lang.editingClientSale, saleId, c.getName(), clientId));
                    System.out.println(Lang.saleProducts);

                    Map<Integer, Integer> saleProducts = s.getSaleProducts();

                    ArrayList<Integer> validProductCodes = new ArrayList<>();
                    for (int productCode : s.getSaleProducts().keySet())
                    {
                        validProductCodes.add(productCode);
                        Product p = Get.getProduct(productCode);

                        if (p != null)
                        {
                            int amount = s.getSaleProducts().get(productCode);
                            double totalPrice = p.getPrice() * amount;

                            System.out.println(Lang.colorCyan + " » " + p.getCode() + ". " + Lang.colorWhite + p.getName() + Lang.colorReset + " (Quantidade: " + Lang.colorWhite + amount + Lang.colorGreen + ", Total Price: " + Lang.colorWhite + totalPrice + "€" + Lang.colorReset + ")");
                        }
                        else
                        {
                            System.out.println(Lang.errorUnknown);
                        }
                    }

                    int option = 0;
                    do
                    {
                        ArrayList<String> options = new ArrayList<String>()
                        {{
                            add("Adicionar Produto");
                            add("Remover Produto");
                            add("Adicionar Stock");
                            add("Remover Stock");
                        }};

                        option = Functions.printMenu(null, options, false);

                        switch (option)
                        {
                            case 1:
                            {
                                int productCode
                            }
                        }
                        productCode = readEditProductCode(validProductCodes);
                        Product p = Get.getProduct(productCode);
                        int soldStock = s.getSaleProducts().get(productCode);

                        if (p != null)
                        {
                            System.out.println(Lang.readProductStock);
                            int stock = readEditProductStock(soldStock);

                            if (stock > 0)
                            {
                                if (p.getStock() >= )
                                p.addStock(stock);
                            }
                            else if (stock == 0)
                            {

                            }
                        }
                        else
                        {
                            System.out.println(Lang.errorUnknown);
                        }
                    } while (option != 0);
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
        }
        else
        {
            System.out.println(Lang.errorNoSalesFound);
        }
        Functions.pressEnterToContinue();
    }
    public static int readEditProductCode(ArrayList<Integer> validProductCodes)
    {
        System.out.println(Lang.readEditProductCode);
        try
        {
            int productCode = sc.nextInt();

            if (!validProductCodes.contains(productCode))
            {
                errorReset(Lang.errorInvalidEditSaleOption);
                return readEditProductCode(validProductCodes);
            }
            return productCode;
        }
        catch (Exception ignored)
        {
            errorReset(Lang.errorWrongDataType);
            return readEditProductCode(validProductCodes);
        }
    }
    public static int readEditProductStock(int availableStock)
    {
        System.out.println(Lang.readProductStock);
        try
        {
            int stock = sc.nextInt();

            if (stock > availableStock || stock < availableStock / -1)
            {
                errorReset(Lang.errorInvalidStock);
                return readEditProductStock(availableStock);
            }
            return stock;
        }
        catch (Exception ignored)
        {
            errorReset(Lang.errorWrongDataType);
            return readEditProductStock(availableStock);
        }
    }
    */
}

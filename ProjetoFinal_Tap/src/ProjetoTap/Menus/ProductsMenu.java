package ProjetoTap.Menus;

import ProjetoTap.Data.Data;
import ProjetoTap.Data.Lang;
import ProjetoTap.Functions;
import ProjetoTap.ReadInput.ReadProduct;
import ProjetoTap.StructureActions.Create;
import ProjetoTap.StructureActions.Delete;
import ProjetoTap.StructureActions.Get;
import ProjetoTap.Structures.Product;
import ProjetoTap.Structures.Sale;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ProductsMenu
{
    //      ░██████╗██╗░░██╗░█████╗░░██╗░░░░░░░██╗  ███╗░░░███╗███████╗███╗░░██╗██╗░░░██╗
    //      ██╔════╝██║░░██║██╔══██╗░██║░░██╗░░██║  ████╗░████║██╔════╝████╗░██║██║░░░██║
    //      ╚█████╗░███████║██║░░██║░╚██╗████╗██╔╝  ██╔████╔██║█████╗░░██╔██╗██║██║░░░██║
    //      ░╚═══██╗██╔══██║██║░░██║░░████╔═████║░  ██║╚██╔╝██║██╔══╝░░██║╚████║██║░░░██║
    //      ██████╔╝██║░░██║╚█████╔╝░░╚██╔╝░╚██╔╝░  ██║░╚═╝░██║███████╗██║░╚███║╚██████╔╝
    //      ╚═════╝░╚═╝░░╚═╝░╚════╝░░░░╚═╝░░░╚═╝░░  ╚═╝░░░░░╚═╝╚══════╝╚═╝░░╚══╝░╚═════╝░
    public static void showProductsMenu()
    {
        int option;
        do
        {
            ArrayList<String> options = new ArrayList<String>()
            {{
                add(Lang.listProducts);
                add(Lang.createProductMenu);
                add(Lang.categoriesSizeMenu);
                add(Lang.listOutOfStockMenu);
                add(Lang.viewIfExistsByCodeMenu);
                add(Lang.averagePricePerCategoryMenu);
                add(Lang.addStockMenu);
                add(Lang.editProductMenu);
                add(Lang.removeProductMenu);
                add(Lang.removeStockMenu);
                add(Lang.mostExpensiveProductMenu);
                add(Lang.mostSoldProductsMenu);
                add(Lang.largestCategoryMenu);
            }};

            option = Functions.printMenu(Lang.productsMenu, options, true);
            switch (option)
            {
                case 1: // LIST PRODUCTS
                    showListProducts();
                    break;
                case 2: // CREATE NEW PRODUCT
                    showCreateProduct();
                    break;
                case 3: // CATEGORIES SIZE
                    showCategoriesSize();
                    break;
                case 4: // LIST OUT OF STOCK
                    showListOutOfStock();
                    break;
                case 5: // VIEW IF EXISTS BY CODE
                    showViewIfProductExistsByCode();
                    break;
                case 6: // AVERAGE PRICE PER CATEGORY
                    showAveragePricePerCategory();
                    break;
                case 7: // ADD STOCK
                    showAddStock();
                    break;
                case 8: // EDIT PRODUCT
                    showEditProduct();
                    break;
                case 9: // REMOVE PRODUCT
                    showRemoveProduct();
                    break;
                case 10: // REMOVE STOCK
                    showRemoveStock();
                    break;
                case 11: // MOST EXPENSIVE PRODUCT
                    showMostExpensiveProduct();
                    break;
                case 12: // MOST SOLD PRODUCTS
                    showMostSoldProducts();
                    break;
                case 13: // LARGEST CATEGORY
                    showLargestCategory();
                    break;
            }
        } while (option != 0);
    }
    //      ██╗░░░░░██╗░██████╗████████╗  ██████╗░██████╗░░█████╗░██████╗░██╗░░░██╗░█████╗░████████╗░██████╗
    //      ██║░░░░░██║██╔════╝╚══██╔══╝  ██╔══██╗██╔══██╗██╔══██╗██╔══██╗██║░░░██║██╔══██╗╚══██╔══╝██╔════╝
    //      ██║░░░░░██║╚█████╗░░░░██║░░░  ██████╔╝██████╔╝██║░░██║██║░░██║██║░░░██║██║░░╚═╝░░░██║░░░╚█████╗░
    //      ██║░░░░░██║░╚═══██╗░░░██║░░░  ██╔═══╝░██╔══██╗██║░░██║██║░░██║██║░░░██║██║░░██╗░░░██║░░░░╚═══██╗
    //      ███████╗██║██████╔╝░░░██║░░░  ██║░░░░░██║░░██║╚█████╔╝██████╔╝╚██████╔╝╚█████╔╝░░░██║░░░██████╔╝
    //      ╚══════╝╚═╝╚═════╝░░░░╚═╝░░░  ╚═╝░░░░░╚═╝░░╚═╝░╚════╝░╚═════╝░░╚═════╝░░╚════╝░░░░╚═╝░░░╚═════╝░
    public static void showListProducts()
    {
        Functions.prepareMenu(Lang.listProducts);

        if (!Data.products.isEmpty())
        {
            Map<String, ArrayList<Product>> productsMap = new HashMap<>();

            for (Product p : Data.products.values())
            {
                if (!productsMap.containsKey(p.getCategory()))
                {
                    ArrayList<Product> productsArray = new ArrayList<>();
                    productsArray.add(p);

                    productsMap.put(p.getCategory(), productsArray);
                }
                else
                {
                    ArrayList<Product> productsArray = productsMap.get(p.getCategory());
                    productsArray.add(p);

                    productsMap.put(p.getCategory(), productsArray);
                }
            }

            for (String category : productsMap.keySet())
            {
                System.out.println(category);
                ArrayList<Product> categoryProducts = productsMap.get(category);

                for (Product p : categoryProducts)
                {
                    System.out.println(" » " + p.getCode() + " - " + p.getName() + " - " + p.getStock() + " - " +  p.getPrice());
                }
            }
        }
        else
        {
            System.out.println(Lang.errorNoProductsFound);
        }
        Functions.pressEnterToContinue();
    }
    //      ░█████╗░██████╗░███████╗░█████╗░████████╗███████╗  ██████╗░██████╗░░█████╗░██████╗░██╗░░░██╗░█████╗░████████╗
    //      ██╔══██╗██╔══██╗██╔════╝██╔══██╗╚══██╔══╝██╔════╝  ██╔══██╗██╔══██╗██╔══██╗██╔══██╗██║░░░██║██╔══██╗╚══██╔══╝
    //      ██║░░╚═╝██████╔╝█████╗░░███████║░░░██║░░░█████╗░░  ██████╔╝██████╔╝██║░░██║██║░░██║██║░░░██║██║░░╚═╝░░░██║░░░
    //      ██║░░██╗██╔══██╗██╔══╝░░██╔══██║░░░██║░░░██╔══╝░░  ██╔═══╝░██╔══██╗██║░░██║██║░░██║██║░░░██║██║░░██╗░░░██║░░░
    //      ╚█████╔╝██║░░██║███████╗██║░░██║░░░██║░░░███████╗  ██║░░░░░██║░░██║╚█████╔╝██████╔╝╚██████╔╝╚█████╔╝░░░██║░░░
    //      ░╚════╝░╚═╝░░╚═╝╚══════╝╚═╝░░╚═╝░░░╚═╝░░░╚══════╝  ╚═╝░░░░░╚═╝░░╚═╝░╚════╝░╚═════╝░░╚═════╝░░╚════╝░░░░╚═╝░░░
    public static void showCreateProduct()
    {
        Functions.prepareMenu(Lang.createProductMenu);

        int code = ReadProduct.productCode(false, Lang.readProductCode);
        String name = ReadProduct.productName();
        String category = ReadProduct.productCategory();
        int stock = ReadProduct.productStock(false);
        double price = ReadProduct.productPrice();

        Product p = Create.createProduct(code, name, category, stock, price, false);

        if (p == null)
        {
            System.out.println(Lang.errorCreatingProduct);
        }
        else
        {
            System.out.println(Lang.productCreatedSuccessfully);
        }
        Functions.pressEnterToContinue();
    }
    //      ░█████╗░░█████╗░████████╗███████╗░██████╗░░█████╗░██████╗░██╗███████╗░██████╗  ░██████╗██╗███████╗███████╗
    //      ██╔══██╗██╔══██╗╚══██╔══╝██╔════╝██╔════╝░██╔══██╗██╔══██╗██║██╔════╝██╔════╝  ██╔════╝██║╚════██║██╔════╝
    //      ██║░░╚═╝███████║░░░██║░░░█████╗░░██║░░██╗░██║░░██║██████╔╝██║█████╗░░╚█████╗░  ╚█████╗░██║░░███╔═╝█████╗░░
    //      ██║░░██╗██╔══██║░░░██║░░░██╔══╝░░██║░░╚██╗██║░░██║██╔══██╗██║██╔══╝░░░╚═══██╗  ░╚═══██╗██║██╔══╝░░██╔══╝░░
    //      ╚█████╔╝██║░░██║░░░██║░░░███████╗╚██████╔╝╚█████╔╝██║░░██║██║███████╗██████╔╝  ██████╔╝██║███████╗███████╗
    //      ░╚════╝░╚═╝░░╚═╝░░░╚═╝░░░╚══════╝░╚═════╝░░╚════╝░╚═╝░░╚═╝╚═╝╚══════╝╚═════╝░  ╚═════╝░╚═╝╚══════╝╚══════╝
    public static void showCategoriesSize()
    {
        Functions.prepareMenu(Lang.categoriesSizeMenu);

        Map<String, Integer> categoriesSize = new HashMap<>();

        if (!Data.products.isEmpty())
        {
            for (Product p : Data.products.values())
            {
                if (categoriesSize.containsKey(p.getCategory()))
                {
                    categoriesSize.put(p.getCategory(), 1);
                }
                else
                {
                    int currentValue = categoriesSize.get(p.getCategory());
                    categoriesSize.put(p.getCategory(), currentValue + 1);
                }
            }

            if (categoriesSize.size() > 0)
            {
                for (String a : categoriesSize.keySet())
                {
                    System.out.println(MessageFormat.format(Lang.categoriesSizeList, a, categoriesSize.get(a)));
                }
            }
            else
            {
                System.out.println(Lang.errorUnknown);
            }
        }
        else
        {
            System.out.println(Lang.errorNoProductsFound);
        }
        Functions.pressEnterToContinue();
    }
    //      ██╗░░░░░██╗░██████╗████████╗  ░█████╗░██╗░░░██╗████████╗  ░█████╗░███████╗  ░██████╗████████╗░█████╗░░█████╗░██╗░░██╗
    //      ██║░░░░░██║██╔════╝╚══██╔══╝  ██╔══██╗██║░░░██║╚══██╔══╝  ██╔══██╗██╔════╝  ██╔════╝╚══██╔══╝██╔══██╗██╔══██╗██║░██╔╝
    //      ██║░░░░░██║╚█████╗░░░░██║░░░  ██║░░██║██║░░░██║░░░██║░░░  ██║░░██║█████╗░░  ╚█████╗░░░░██║░░░██║░░██║██║░░╚═╝█████═╝░
    //      ██║░░░░░██║░╚═══██╗░░░██║░░░  ██║░░██║██║░░░██║░░░██║░░░  ██║░░██║██╔══╝░░  ░╚═══██╗░░░██║░░░██║░░██║██║░░██╗██╔═██╗░
    //      ███████╗██║██████╔╝░░░██║░░░  ╚█████╔╝╚██████╔╝░░░██║░░░  ╚█████╔╝██║░░░░░  ██████╔╝░░░██║░░░╚█████╔╝╚█████╔╝██║░╚██╗
    //      ╚══════╝╚═╝╚═════╝░░░░╚═╝░░░  ░╚════╝░░╚═════╝░░░░╚═╝░░░  ░╚════╝░╚═╝░░░░░  ╚═════╝░░░░╚═╝░░░░╚════╝░░╚════╝░╚═╝░░╚═╝
    public static void showListOutOfStock()
    {
        Functions.prepareMenu(Lang.listOutOfStockMenu);

        if (!Data.products.isEmpty())
        {
            System.out.println(Lang.outOfStockProducts);
            for (Product p : Data.products.values())
            {
                if (p.getStock() == 0)
                {
                    System.out.println(" » " + p.getName() + " (#" + p.getCode() + ", Category: " + p.getCategory() + ")");
                }
            }
        }
        else
        {
            System.out.println(Lang.errorNoProductsFound);
        }
        Functions.pressEnterToContinue();
    }
    //      ██╗░░░██╗██╗███████╗░██╗░░░░░░░██╗  ██╗███████╗  ██████╗░██████╗░░█████╗░██████╗░██╗░░░██╗░█████╗░████████╗  ███████╗██╗░░██╗██╗░██████╗████████╗░██████╗  ██████╗░██╗░░░██╗  ░█████╗░░█████╗░██████╗░███████╗
    //      ██║░░░██║██║██╔════╝░██║░░██╗░░██║  ██║██╔════╝  ██╔══██╗██╔══██╗██╔══██╗██╔══██╗██║░░░██║██╔══██╗╚══██╔══╝  ██╔════╝╚██╗██╔╝██║██╔════╝╚══██╔══╝██╔════╝  ██╔══██╗╚██╗░██╔╝  ██╔══██╗██╔══██╗██╔══██╗██╔════╝
    //      ╚██╗░██╔╝██║█████╗░░░╚██╗████╗██╔╝  ██║█████╗░░  ██████╔╝██████╔╝██║░░██║██║░░██║██║░░░██║██║░░╚═╝░░░██║░░░  █████╗░░░╚███╔╝░██║╚█████╗░░░░██║░░░╚█████╗░  ██████╦╝░╚████╔╝░  ██║░░╚═╝██║░░██║██║░░██║█████╗░░
    //      ░╚████╔╝░██║██╔══╝░░░░████╔═████║░  ██║██╔══╝░░  ██╔═══╝░██╔══██╗██║░░██║██║░░██║██║░░░██║██║░░██╗░░░██║░░░  ██╔══╝░░░██╔██╗░██║░╚═══██╗░░░██║░░░░╚═══██╗  ██╔══██╗░░╚██╔╝░░  ██║░░██╗██║░░██║██║░░██║██╔══╝░░
    //      ░░╚██╔╝░░██║███████╗░░╚██╔╝░╚██╔╝░  ██║██║░░░░░  ██║░░░░░██║░░██║╚█████╔╝██████╔╝╚██████╔╝╚█████╔╝░░░██║░░░  ███████╗██╔╝╚██╗██║██████╔╝░░░██║░░░██████╔╝  ██████╦╝░░░██║░░░  ╚█████╔╝╚█████╔╝██████╔╝███████╗
    //      ░░░╚═╝░░░╚═╝╚══════╝░░░╚═╝░░░╚═╝░░  ╚═╝╚═╝░░░░░  ╚═╝░░░░░╚═╝░░╚═╝░╚════╝░╚═════╝░░╚═════╝░░╚════╝░░░░╚═╝░░░  ╚══════╝╚═╝░░╚═╝╚═╝╚═════╝░░░░╚═╝░░░╚═════╝░  ╚═════╝░░░░╚═╝░░░  ░╚════╝░░╚════╝░╚═════╝░╚══════╝
    public static void showViewIfProductExistsByCode()
    {
        Functions.prepareMenu(Lang.viewIfProductExistsByCodeMenu);

        if (!Data.products.isEmpty())
        {
            int code = ReadProduct.productCode(true, Lang.readExistingProductCode);

            if (Data.products.containsKey(code))
            {
                Product p = Get.getProduct(code);
                System.out.println(MessageFormat.format(Lang.listedProductFoundByCode, code, p.getName(), p.getCategory(), p.getStock(), p.getPrice()));
            }
            else
            {
                System.out.println(Lang.errorProductNotFound);
            }
        }
        else
        {
            System.out.println(Lang.errorNoProductsFound);
        }
        Functions.pressEnterToContinue();
    }
    //      ░█████╗░██╗░░░██╗███████╗██████╗░░█████╗░░██████╗░███████╗  ██████╗░██████╗░██╗░█████╗░███████╗  ██████╗░███████╗██████╗░  ░█████╗░░█████╗░████████╗███████╗░██████╗░░█████╗░██████╗░██╗░░░██╗
    //      ██╔══██╗██║░░░██║██╔════╝██╔══██╗██╔══██╗██╔════╝░██╔════╝  ██╔══██╗██╔══██╗██║██╔══██╗██╔════╝  ██╔══██╗██╔════╝██╔══██╗  ██╔══██╗██╔══██╗╚══██╔══╝██╔════╝██╔════╝░██╔══██╗██╔══██╗╚██╗░██╔╝
    //      ███████║╚██╗░██╔╝█████╗░░██████╔╝███████║██║░░██╗░█████╗░░  ██████╔╝██████╔╝██║██║░░╚═╝█████╗░░  ██████╔╝█████╗░░██████╔╝  ██║░░╚═╝███████║░░░██║░░░█████╗░░██║░░██╗░██║░░██║██████╔╝░╚████╔╝░
    //      ██╔══██║░╚████╔╝░██╔══╝░░██╔══██╗██╔══██║██║░░╚██╗██╔══╝░░  ██╔═══╝░██╔══██╗██║██║░░██╗██╔══╝░░  ██╔═══╝░██╔══╝░░██╔══██╗  ██║░░██╗██╔══██║░░░██║░░░██╔══╝░░██║░░╚██╗██║░░██║██╔══██╗░░╚██╔╝░░
    //      ██║░░██║░░╚██╔╝░░███████╗██║░░██║██║░░██║╚██████╔╝███████╗  ██║░░░░░██║░░██║██║╚█████╔╝███████╗  ██║░░░░░███████╗██║░░██║  ╚█████╔╝██║░░██║░░░██║░░░███████╗╚██████╔╝╚█████╔╝██║░░██║░░░██║░░░
    //      ╚═╝░░╚═╝░░░╚═╝░░░╚══════╝╚═╝░░╚═╝╚═╝░░╚═╝░╚═════╝░╚══════╝  ╚═╝░░░░░╚═╝░░╚═╝╚═╝░╚════╝░╚══════╝  ╚═╝░░░░░╚══════╝╚═╝░░╚═╝  ░╚════╝░╚═╝░░╚═╝░░░╚═╝░░░╚══════╝░╚═════╝░░╚════╝░╚═╝░░╚═╝░░░╚═╝░░░
    public static void showAveragePricePerCategory()
    {
        Functions.prepareMenu(Lang.averagePricePerCategoryMenu);

        if (!Data.products.isEmpty())
        {
            Map<String, Integer> categoriesSize = new HashMap<>();
            Map<String, Double> categoriesValue = new HashMap<>();
            for (Product p : Data.products.values())
            {
                if (!categoriesSize.containsKey(p.getCategory()))
                {
                    categoriesSize.put(p.getCategory(), 1);
                    categoriesValue.put(p.getCategory(), p.getPrice());
                }
                else
                {
                    int existingSizeValue = categoriesSize.get(p.getCategory());
                    categoriesSize.put(p.getCategory(), existingSizeValue + 1);

                    double existingValueValue = categoriesValue.get(p.getCategory());
                    categoriesValue.put(p.getCategory(), existingValueValue + p.getPrice());
                }
            }

            System.out.println(Lang.averagePricePerCategory);
            for (String category : categoriesSize.keySet())
            {
                double averagePrice = categoriesValue.get(category) / categoriesSize.get(category);
                System.out.println(" » " + category + " - " + averagePrice + " €");
            }
        }
        else
        {
            System.out.println(Lang.errorNoProductsFound);
        }
        Functions.pressEnterToContinue();
    }
    //      ░█████╗░██████╗░██████╗░  ░██████╗████████╗░█████╗░░█████╗░██╗░░██╗
    //      ██╔══██╗██╔══██╗██╔══██╗  ██╔════╝╚══██╔══╝██╔══██╗██╔══██╗██║░██╔╝
    //      ███████║██║░░██║██║░░██║  ╚█████╗░░░░██║░░░██║░░██║██║░░╚═╝█████═╝░
    //      ██╔══██║██║░░██║██║░░██║  ░╚═══██╗░░░██║░░░██║░░██║██║░░██╗██╔═██╗░
    //      ██║░░██║██████╔╝██████╔╝  ██████╔╝░░░██║░░░╚█████╔╝╚█████╔╝██║░╚██╗
    //      ╚═╝░░╚═╝╚═════╝░╚═════╝░  ╚═════╝░░░░╚═╝░░░░╚════╝░░╚════╝░╚═╝░░╚═╝
    public static void showAddStock()
    {
        Functions.prepareMenu(Lang.addStockMenu);

        if (!Data.products.isEmpty())
        {
            int code = ReadProduct.existingProductCode();
            int stock = ReadProduct.productStock(true);

            Get.getProduct(code).addStock(stock);
        }
        else
        {
            System.out.println(Lang.errorNoProductsFound);
        }
        Functions.pressEnterToContinue();
    }
    //      ███████╗██████╗░██╗████████╗  ██████╗░██████╗░░█████╗░██████╗░██╗░░░██╗░█████╗░████████╗
    //      ██╔════╝██╔══██╗██║╚══██╔══╝  ██╔══██╗██╔══██╗██╔══██╗██╔══██╗██║░░░██║██╔══██╗╚══██╔══╝
    //      █████╗░░██║░░██║██║░░░██║░░░  ██████╔╝██████╔╝██║░░██║██║░░██║██║░░░██║██║░░╚═╝░░░██║░░░
    //      ██╔══╝░░██║░░██║██║░░░██║░░░  ██╔═══╝░██╔══██╗██║░░██║██║░░██║██║░░░██║██║░░██╗░░░██║░░░
    //      ███████╗██████╔╝██║░░░██║░░░  ██║░░░░░██║░░██║╚█████╔╝██████╔╝╚██████╔╝╚█████╔╝░░░██║░░░
    //      ╚══════╝╚═════╝░╚═╝░░░╚═╝░░░  ╚═╝░░░░░╚═╝░░╚═╝░╚════╝░╚═════╝░░╚═════╝░░╚════╝░░░░╚═╝░░░
    public static void showEditProduct()
    {
        Functions.prepareMenu(Lang.editProductMenu);

        if (!Data.products.isEmpty())
        {
            int code = ReadProduct.existingProductCode();
            Product p = Get.getProduct(code);

            String newName = p.getName(), newCategory = p.getCategory();
            int newStock = p.getStock();
            double newPrice = p.getPrice();

            System.out.println(Lang.editProductName);
            if (Functions.readBoolean())
            {
                newName = ReadProduct.productName();
            }
            System.out.println(Lang.editProductCategory);
            if (Functions.readBoolean())
            {
                newCategory = ReadProduct.productCategory();
            }
            System.out.println(Lang.editProductStock);
            if (Functions.readBoolean())
            {
                newStock = ReadProduct.productStock(false);
            }
            System.out.println(Lang.editProductPrice);
            if (Functions.readBoolean())
            {
                newPrice = ReadProduct.productPrice();
            }

            Product newProduct = new Product(code, newName, newCategory, newStock, newPrice);
            Create.createProduct(newProduct, false);

            System.out.println(Lang.productUpdatedSuccessfully);
        }
        else
        {
            System.out.println(Lang.errorNoProductsFound);
        }
        Functions.pressEnterToContinue();
    }
    //      ██████╗░███████╗███╗░░░███╗░█████╗░██╗░░░██╗███████╗  ██████╗░██████╗░░█████╗░██████╗░██╗░░░██╗░█████╗░████████╗
    //      ██╔══██╗██╔════╝████╗░████║██╔══██╗██║░░░██║██╔════╝  ██╔══██╗██╔══██╗██╔══██╗██╔══██╗██║░░░██║██╔══██╗╚══██╔══╝
    //      ██████╔╝█████╗░░██╔████╔██║██║░░██║╚██╗░██╔╝█████╗░░  ██████╔╝██████╔╝██║░░██║██║░░██║██║░░░██║██║░░╚═╝░░░██║░░░
    //      ██╔══██╗██╔══╝░░██║╚██╔╝██║██║░░██║░╚████╔╝░██╔══╝░░  ██╔═══╝░██╔══██╗██║░░██║██║░░██║██║░░░██║██║░░██╗░░░██║░░░
    //      ██║░░██║███████╗██║░╚═╝░██║╚█████╔╝░░╚██╔╝░░███████╗  ██║░░░░░██║░░██║╚█████╔╝██████╔╝╚██████╔╝╚█████╔╝░░░██║░░░
    //      ╚═╝░░╚═╝╚══════╝╚═╝░░░░░╚═╝░╚════╝░░░░╚═╝░░░╚══════╝  ╚═╝░░░░░╚═╝░░╚═╝░╚════╝░╚═════╝░░╚═════╝░░╚════╝░░░░╚═╝░░░
    public static void showRemoveProduct()
    {
        Functions.prepareMenu(Lang.removeProductMenu);

        if (!Data.products.isEmpty())
        {
            int code = ReadProduct.existingProductCode();

            System.out.println(MessageFormat.format(Lang.confirmProductDelete, code));
            if (Functions.readBoolean())
            {
                Delete.deleteProduct(code);

                System.out.println(Lang.productDeletedSuccessfully);
            }
        }
        else
        {
            System.out.println(Lang.errorNoProductsFound);
        }
        Functions.pressEnterToContinue();
    }
    //      ██████╗░███████╗███╗░░░███╗░█████╗░██╗░░░██╗███████╗  ░██████╗████████╗░█████╗░░█████╗░██╗░░██╗
    //      ██╔══██╗██╔════╝████╗░████║██╔══██╗██║░░░██║██╔════╝  ██╔════╝╚══██╔══╝██╔══██╗██╔══██╗██║░██╔╝
    //      ██████╔╝█████╗░░██╔████╔██║██║░░██║╚██╗░██╔╝█████╗░░  ╚█████╗░░░░██║░░░██║░░██║██║░░╚═╝█████═╝░
    //      ██╔══██╗██╔══╝░░██║╚██╔╝██║██║░░██║░╚████╔╝░██╔══╝░░  ░╚═══██╗░░░██║░░░██║░░██║██║░░██╗██╔═██╗░
    //      ██║░░██║███████╗██║░╚═╝░██║╚█████╔╝░░╚██╔╝░░███████╗  ██████╔╝░░░██║░░░╚█████╔╝╚█████╔╝██║░╚██╗
    //      ╚═╝░░╚═╝╚══════╝╚═╝░░░░░╚═╝░╚════╝░░░░╚═╝░░░╚══════╝  ╚═════╝░░░░╚═╝░░░░╚════╝░░╚════╝░╚═╝░░╚═╝
    public static void showRemoveStock()
    {
        Functions.prepareMenu(Lang.removeStockMenu);

        if (!Data.products.isEmpty())
        {
            int productCode = ReadProduct.existingProductCode();
            Product p = Get.getProduct(productCode);

            if (p != null)
            {
                int stock;
                do
                {
                    stock = ReadProduct.productStock(true);
                    if (stock > p.getStock())
                    {
                        System.out.println(Lang.errorInvalidRemoveStock);
                    }
                } while (stock > p.getStock());

                p.removeStock(stock);
            }
            else
            {
                System.out.println(Lang.errorUnknown);
            }
        }
        else
        {
            System.out.println(Lang.errorNoProductsFound);
        }
        Functions.pressEnterToContinue();
    }
    //      ███╗░░░███╗░█████╗░░██████╗████████╗  ███████╗██╗░░██╗██████╗░███████╗███╗░░██╗░██████╗██╗██╗░░░██╗███████╗  ██████╗░██████╗░░█████╗░██████╗░██╗░░░██╗░█████╗░████████╗
    //      ████╗░████║██╔══██╗██╔════╝╚══██╔══╝  ██╔════╝╚██╗██╔╝██╔══██╗██╔════╝████╗░██║██╔════╝██║██║░░░██║██╔════╝  ██╔══██╗██╔══██╗██╔══██╗██╔══██╗██║░░░██║██╔══██╗╚══██╔══╝
    //      ██╔████╔██║██║░░██║╚█████╗░░░░██║░░░  █████╗░░░╚███╔╝░██████╔╝█████╗░░██╔██╗██║╚█████╗░██║╚██╗░██╔╝█████╗░░  ██████╔╝██████╔╝██║░░██║██║░░██║██║░░░██║██║░░╚═╝░░░██║░░░
    //      ██║╚██╔╝██║██║░░██║░╚═══██╗░░░██║░░░  ██╔══╝░░░██╔██╗░██╔═══╝░██╔══╝░░██║╚████║░╚═══██╗██║░╚████╔╝░██╔══╝░░  ██╔═══╝░██╔══██╗██║░░██║██║░░██║██║░░░██║██║░░██╗░░░██║░░░
    //      ██║░╚═╝░██║╚█████╔╝██████╔╝░░░██║░░░  ███████╗██╔╝╚██╗██║░░░░░███████╗██║░╚███║██████╔╝██║░░╚██╔╝░░███████╗  ██║░░░░░██║░░██║╚█████╔╝██████╔╝╚██████╔╝╚█████╔╝░░░██║░░░
    //      ╚═╝░░░░░╚═╝░╚════╝░╚═════╝░░░░╚═╝░░░  ╚══════╝╚═╝░░╚═╝╚═╝░░░░░╚══════╝╚═╝░░╚══╝╚═════╝░╚═╝░░░╚═╝░░░╚══════╝  ╚═╝░░░░░╚═╝░░╚═╝░╚════╝░╚═════╝░░╚═════╝░░╚════╝░░░░╚═╝░░░
    public static void showMostExpensiveProduct()
    {
        Functions.prepareMenu(Lang.mostExpensiveProductMenu);

        if (!Data.products.isEmpty())
        {
            Product mostExpensiveProduct = null;
            int code = -1;
            for (Product p : Data.products.values())
            {
                if (mostExpensiveProduct == null || p.getPrice() > mostExpensiveProduct.getPrice())
                {
                    mostExpensiveProduct = p;
                }
            }

            if (mostExpensiveProduct != null)
            {
                System.out.println(MessageFormat.format(Lang.listMostExpensiveProduct, code, mostExpensiveProduct.getName(), mostExpensiveProduct.getCategory(), mostExpensiveProduct.getStock(), mostExpensiveProduct.getPrice()));
            }
            else
            {
                System.out.println(Lang.errorUnknown);
            }
        }
        else
        {
            System.out.println(Lang.errorNoProductsFound);
        }
        Functions.pressEnterToContinue();
    }
    //      ███╗░░░███╗░█████╗░░██████╗████████╗  ░██████╗░█████╗░██╗░░░░░██████╗░  ██████╗░██████╗░░█████╗░██████╗░██╗░░░██╗░█████╗░████████╗░██████╗
    //      ████╗░████║██╔══██╗██╔════╝╚══██╔══╝  ██╔════╝██╔══██╗██║░░░░░██╔══██╗  ██╔══██╗██╔══██╗██╔══██╗██╔══██╗██║░░░██║██╔══██╗╚══██╔══╝██╔════╝
    //      ██╔████╔██║██║░░██║╚█████╗░░░░██║░░░  ╚█████╗░██║░░██║██║░░░░░██║░░██║  ██████╔╝██████╔╝██║░░██║██║░░██║██║░░░██║██║░░╚═╝░░░██║░░░╚█████╗░
    //      ██║╚██╔╝██║██║░░██║░╚═══██╗░░░██║░░░  ░╚═══██╗██║░░██║██║░░░░░██║░░██║  ██╔═══╝░██╔══██╗██║░░██║██║░░██║██║░░░██║██║░░██╗░░░██║░░░░╚═══██╗
    //      ██║░╚═╝░██║╚█████╔╝██████╔╝░░░██║░░░  ██████╔╝╚█████╔╝███████╗██████╔╝  ██║░░░░░██║░░██║╚█████╔╝██████╔╝╚██████╔╝╚█████╔╝░░░██║░░░██████╔╝
    //      ╚═╝░░░░░╚═╝░╚════╝░╚═════╝░░░░╚═╝░░░  ╚═════╝░░╚════╝░╚══════╝╚═════╝░  ╚═╝░░░░░╚═╝░░╚═╝░╚════╝░╚═════╝░░╚═════╝░░╚════╝░░░░╚═╝░░░╚═════╝░
    public static void showMostSoldProducts()
    {
        Functions.prepareMenu(Lang.mostSoldProductsMenu);

        if (!Data.sales.isEmpty())
        {
            Map<Integer, Integer> productSales = new HashMap<>();
            for (Sale s : Data.sales.values())
            {
                for (int code : s.getSaleProducts().keySet())
                {
                    Product p = Get.getProduct(code);

                    if (!productSales.containsKey(p.getCode()))
                    {
                        productSales.put(p.getCode(), 1);
                    }
                    else
                    {
                        int existingValue = productSales.get(p.getCode());
                        productSales.put(p.getCode(), existingValue + 1);
                    }
                }
            }

            int mostSales = 0;
            ArrayList<Integer> mostSoldProducts = new ArrayList<>();
            for (Integer key : productSales.keySet())
            {
                int sales = productSales.get(key);
                if (sales > 0)
                {
                    mostSales = sales;
                    mostSoldProducts.clear();
                }
                if (sales == mostSales)
                {
                    mostSoldProducts.add(key);
                }
            }

            System.out.println(MessageFormat.format(Lang.mostSoldProducts, mostSales));
            for (Integer code : mostSoldProducts)
            {
                Product p = Get.getProduct(code);
                System.out.println(MessageFormat.format(Lang.listedProductByMostSales, code, p.getName(), p.getCategory(), p.getPrice(), p.getPrice()));
            }
        }
        else
        {
            System.out.println(Lang.errorNoSalesFound);
        }
        Functions.pressEnterToContinue();
    }
    //      ██╗░░░░░░█████╗░██████╗░░██████╗░███████╗░██████╗████████╗  ░█████╗░░█████╗░████████╗███████╗░██████╗░░█████╗░██████╗░██╗░░░██╗
    //      ██║░░░░░██╔══██╗██╔══██╗██╔════╝░██╔════╝██╔════╝╚══██╔══╝  ██╔══██╗██╔══██╗╚══██╔══╝██╔════╝██╔════╝░██╔══██╗██╔══██╗╚██╗░██╔╝
    //      ██║░░░░░███████║██████╔╝██║░░██╗░█████╗░░╚█████╗░░░░██║░░░  ██║░░╚═╝███████║░░░██║░░░█████╗░░██║░░██╗░██║░░██║██████╔╝░╚████╔╝░
    //      ██║░░░░░██╔══██║██╔══██╗██║░░╚██╗██╔══╝░░░╚═══██╗░░░██║░░░  ██║░░██╗██╔══██║░░░██║░░░██╔══╝░░██║░░╚██╗██║░░██║██╔══██╗░░╚██╔╝░░
    //      ███████╗██║░░██║██║░░██║╚██████╔╝███████╗██████╔╝░░░██║░░░  ╚█████╔╝██║░░██║░░░██║░░░███████╗╚██████╔╝╚█████╔╝██║░░██║░░░██║░░░
    //      ╚══════╝╚═╝░░╚═╝╚═╝░░╚═╝░╚═════╝░╚══════╝╚═════╝░░░░╚═╝░░░  ░╚════╝░╚═╝░░╚═╝░░░╚═╝░░░╚══════╝░╚═════╝░░╚════╝░╚═╝░░╚═╝░░░╚═╝░░░
    public static void showLargestCategory()
    {
        Functions.prepareMenu(Lang.largestCategoryMenu);

        if (!Data.products.isEmpty())
        {
            String largestCategory = null;
            int largestCategorySize = 0;

            for (String category : Data.categories.keySet())
            {
                int categorySize = Data.categories.get(category).size();
                if (categorySize > largestCategorySize)
                {
                    largestCategory = category;
                    largestCategorySize = categorySize;
                }
            }

            if (largestCategory != null)
            {
                ArrayList<Integer> productCodes = Data.categories.get(largestCategory);

                for (int productCode : productCodes)
                {
                    Product p = Get.getProduct(productCode);

                    if (p != null)
                    {
                        System.out.println(" » " + p.getCode() + " - " + p.getName() + " - " + p.getStock() + " - " +  p.getPrice());
                    }
                    else
                    {
                        System.out.println(Lang.errorUnknown);
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
            System.out.println(Lang.errorNoProductsFound);
        }

        Functions.pressEnterToContinue();
    }
}
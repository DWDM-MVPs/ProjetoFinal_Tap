package ProjetoTap.Menus;

import ProjetoTap.StructureActions.Create;
import ProjetoTap.Data.Data;
import ProjetoTap.Functions;
import ProjetoTap.Data.Lang;
import ProjetoTap.StructureActions.Get;
import ProjetoTap.Structures.Sale;
import ProjetoTap.UserInput.ReadProduct;
import ProjetoTap.Structures.Product;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static ProjetoTap.Main.readMenuOption;

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
            Functions.prepareMenu(Lang.colorYellow + Lang.productsMenu);

            System.out.println(Lang.colorYellow + "0. " + Lang.exit);
            System.out.println(Lang.colorGreen + "1. " + Lang.listProducts);
            System.out.println(Lang.colorGreen + "2. " + Lang.createProductMenu);
            System.out.println(Lang.colorGreen + "3. " + Lang.categoriesSizeMenu);
            System.out.println(Lang.colorGreen + "4. " + Lang.listOutOfStockMenu);
            System.out.println(Lang.colorGreen + "5. " + Lang.viewIfExistsByCodeMenu);
            System.out.println(Lang.colorGreen + "6. " + Lang.averagePricePerCategoryMenu);
            System.out.println(Lang.colorGreen + "7. " + Lang.addStockMenu);
            System.out.println(Lang.colorGreen + "8. " + Lang.editProductMenu);
            System.out.println(Lang.colorGreen + "9. " + Lang.removeProductMenu);
            System.out.println(Lang.colorGreen + "10. " + Lang.removeStockMenu);
            System.out.println(Lang.colorGreen + "11. " + Lang.mostExpensiveProductMenu);
            System.out.println(Lang.colorGreen + "12. " + Lang.mostSoldProducts);

            option = readMenuOption(0, 12);
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

        if (Data.products.size() > 0)
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
                    System.out.println(p.getCode() + " - " + p.getName() + " - " + p.getStock() + " - " +  p.getPrice());
                }
            }
        }
        else
        {
            System.out.println(Lang.errorNoProductsFound);
        }
        Functions.pressAnyKeyToContinue();
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

        int code = ReadProduct.productCode(false);
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
        Functions.pressAnyKeyToContinue();
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

        if (Data.products.size() > 0)
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
        Functions.pressAnyKeyToContinue();
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

        if (Data.products.size() > 0)
        {
            ArrayList<String> outOfStockProducts = new ArrayList<>();

            for (Product p : Data.products.values())
            {
                if (p.getStock() == 0)
                {
                    outOfStockProducts.add(p.getName() + " (#" + p.getCode() + ")");
                }
            }

            StringBuilder outString = null;
            for (String s : outOfStockProducts)
            {
                if (outString == null)
                {
                    outString = new StringBuilder(s);
                }
                else
                {
                    outString.append(", ").append(s);
                }
            }

            System.out.println(Lang.outOfStockProducts);
        }
        else
        {
            System.out.println(Lang.errorNoProductsFound);
        }
        Functions.pressAnyKeyToContinue();
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

        if (Data.products.size() > 0)
        {
            int code = ReadProduct.productCode(true);

            if (Data.products.containsKey(code))
            {
                Product p = Data.products.get(code);
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
        Functions.pressAnyKeyToContinue();
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

        if (Data.products.size() > 0)
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
        Functions.pressAnyKeyToContinue();
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

        if (Data.products.size() > 0)
        {
            int code = ReadProduct.existingProductCode();
            int stock = ReadProduct.productStock(true);

            Product p = Data.products.get(code);
            p.addStock(stock);

            Data.products.put(p.getCode(), p);
        }
        else
        {
            System.out.println(Lang.errorNoProductsFound);
        }
        Functions.pressAnyKeyToContinue();
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

        if (Data.products.size() > 0)
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
            Data.products.put(code, newProduct);

            System.out.println(Lang.productUpdatedSuccessfully);
        }
        else
        {
            System.out.println(Lang.errorNoProductsFound);
        }
        Functions.pressAnyKeyToContinue();
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

        if (Data.products.size() > 0)
        {
            int code = ReadProduct.existingProductCode();

            System.out.println(MessageFormat.format(Lang.confirmProductDelete, code));
            if (Functions.readBoolean())
            {
                Data.products.remove(code);

                System.out.println(Lang.productDeletedSuccessfully);
            }
        }
        else
        {
            System.out.println(Lang.errorNoProductsFound);
        }
        Functions.pressAnyKeyToContinue();
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

        if (Data.products.size() > 0)
        {
            int code = ReadProduct.existingProductCode();
            Product p = Get.getProduct(code);

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

            Data.products.put(p.getCode(), p);
        }
        else
        {
            System.out.println(Lang.errorNoProductsFound);
        }
        Functions.pressAnyKeyToContinue();
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

        if (Data.products.size() > 0)
        {
            double mostExpensive = 0;
            int code = -1;
            for (Product p : Data.products.values())
            {
                if (p.getPrice() > mostExpensive)
                {
                    mostExpensive = p.getPrice();
                    code = p.getCode();
                }
            }

            if (code != -1)
            {
                Product p = Get.getProduct(code);
                System.out.println(MessageFormat.format(Lang.listMostExpensiveProduct, code, p.getName(), p.getCategory(), p.getStock(), p.getPrice()));
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
        Functions.pressAnyKeyToContinue();
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

        if (Data.sales.size() > 0)
        {
            Map<Integer, Integer> productSales = new HashMap<>();
            for (Sale s : Data.sales.values())
            {
                for (Product p : s.getProducts())
                {
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
        Functions.pressAnyKeyToContinue();
    }
}
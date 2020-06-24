package ProjetoTap.Menus;

import ProjetoTap.StructureActions.Create;
import ProjetoTap.Data.Data;
import ProjetoTap.Functions;
import ProjetoTap.Data.Lang;
import ProjetoTap.StructureActions.Get;
import ProjetoTap.UserInput.ReadProduct;
import ProjetoTap.Structures.Product;

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
            Functions.prepareMenu(Lang.colorYellow + Lang.salesMenu);

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

            option = readMenuOption(0, 10);
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

        showListProducts();
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

        for (String a : categoriesSize.keySet())
        {
            System.out.println(String.format(Lang.categoriesSizeList, a, categoriesSize.get(a)));
        }
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
    //      ██╗░░░██╗██╗███████╗░██╗░░░░░░░██╗  ██╗███████╗  ██████╗░██████╗░░█████╗░██████╗░██╗░░░██╗░█████╗░████████╗  ███████╗██╗░░██╗██╗░██████╗████████╗░██████╗  ██████╗░██╗░░░██╗  ░█████╗░░█████╗░██████╗░███████╗
    //      ██║░░░██║██║██╔════╝░██║░░██╗░░██║  ██║██╔════╝  ██╔══██╗██╔══██╗██╔══██╗██╔══██╗██║░░░██║██╔══██╗╚══██╔══╝  ██╔════╝╚██╗██╔╝██║██╔════╝╚══██╔══╝██╔════╝  ██╔══██╗╚██╗░██╔╝  ██╔══██╗██╔══██╗██╔══██╗██╔════╝
    //      ╚██╗░██╔╝██║█████╗░░░╚██╗████╗██╔╝  ██║█████╗░░  ██████╔╝██████╔╝██║░░██║██║░░██║██║░░░██║██║░░╚═╝░░░██║░░░  █████╗░░░╚███╔╝░██║╚█████╗░░░░██║░░░╚█████╗░  ██████╦╝░╚████╔╝░  ██║░░╚═╝██║░░██║██║░░██║█████╗░░
    //      ░╚████╔╝░██║██╔══╝░░░░████╔═████║░  ██║██╔══╝░░  ██╔═══╝░██╔══██╗██║░░██║██║░░██║██║░░░██║██║░░██╗░░░██║░░░  ██╔══╝░░░██╔██╗░██║░╚═══██╗░░░██║░░░░╚═══██╗  ██╔══██╗░░╚██╔╝░░  ██║░░██╗██║░░██║██║░░██║██╔══╝░░
    //      ░░╚██╔╝░░██║███████╗░░╚██╔╝░╚██╔╝░  ██║██║░░░░░  ██║░░░░░██║░░██║╚█████╔╝██████╔╝╚██████╔╝╚█████╔╝░░░██║░░░  ███████╗██╔╝╚██╗██║██████╔╝░░░██║░░░██████╔╝  ██████╦╝░░░██║░░░  ╚█████╔╝╚█████╔╝██████╔╝███████╗
    //      ░░░╚═╝░░░╚═╝╚══════╝░░░╚═╝░░░╚═╝░░  ╚═╝╚═╝░░░░░  ╚═╝░░░░░╚═╝░░╚═╝░╚════╝░╚═════╝░░╚═════╝░░╚════╝░░░░╚═╝░░░  ╚══════╝╚═╝░░╚═╝╚═╝╚═════╝░░░░╚═╝░░░╚═════╝░  ╚═════╝░░░░╚═╝░░░  ░╚════╝░░╚════╝░╚═════╝░╚══════╝
    public static void showViewIfProductExistsByCode()
    {
        Functions.prepareMenu(Lang.viewIfProductExistsByCodeMenu);

        int code = ReadProduct.productCode(true);

        if (Data.products.containsKey(code))
        {
            Product p = Data.products.get(code);
            System.out.println(String.format(Lang.listedProductFoundByCode, code, p.getName(), p.getCategory(), p.getStock(), p.getPrice()));
        }
        else
        {
            System.out.println(Lang.errorProductNotFound);
        }
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
    //      ░█████╗░██████╗░██████╗░  ░██████╗████████╗░█████╗░░█████╗░██╗░░██╗
    //      ██╔══██╗██╔══██╗██╔══██╗  ██╔════╝╚══██╔══╝██╔══██╗██╔══██╗██║░██╔╝
    //      ███████║██║░░██║██║░░██║  ╚█████╗░░░░██║░░░██║░░██║██║░░╚═╝█████═╝░
    //      ██╔══██║██║░░██║██║░░██║  ░╚═══██╗░░░██║░░░██║░░██║██║░░██╗██╔═██╗░
    //      ██║░░██║██████╔╝██████╔╝  ██████╔╝░░░██║░░░╚█████╔╝╚█████╔╝██║░╚██╗
    //      ╚═╝░░╚═╝╚═════╝░╚═════╝░  ╚═════╝░░░░╚═╝░░░░╚════╝░░╚════╝░╚═╝░░╚═╝
    public static void showAddStock()
    {
        Functions.prepareMenu(Lang.addStockMenu);

        int code = ReadProduct.existingProductCode();
        int stock = ReadProduct.productStock(true);

        Product p = Data.products.get(code);
        p.addStock(stock);

        Data.products.put(p.getCode(), p);
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
    //      ██████╗░███████╗███╗░░░███╗░█████╗░██╗░░░██╗███████╗  ██████╗░██████╗░░█████╗░██████╗░██╗░░░██╗░█████╗░████████╗
    //      ██╔══██╗██╔════╝████╗░████║██╔══██╗██║░░░██║██╔════╝  ██╔══██╗██╔══██╗██╔══██╗██╔══██╗██║░░░██║██╔══██╗╚══██╔══╝
    //      ██████╔╝█████╗░░██╔████╔██║██║░░██║╚██╗░██╔╝█████╗░░  ██████╔╝██████╔╝██║░░██║██║░░██║██║░░░██║██║░░╚═╝░░░██║░░░
    //      ██╔══██╗██╔══╝░░██║╚██╔╝██║██║░░██║░╚████╔╝░██╔══╝░░  ██╔═══╝░██╔══██╗██║░░██║██║░░██║██║░░░██║██║░░██╗░░░██║░░░
    //      ██║░░██║███████╗██║░╚═╝░██║╚█████╔╝░░╚██╔╝░░███████╗  ██║░░░░░██║░░██║╚█████╔╝██████╔╝╚██████╔╝╚█████╔╝░░░██║░░░
    //      ╚═╝░░╚═╝╚══════╝╚═╝░░░░░╚═╝░╚════╝░░░░╚═╝░░░╚══════╝  ╚═╝░░░░░╚═╝░░╚═╝░╚════╝░╚═════╝░░╚═════╝░░╚════╝░░░░╚═╝░░░
    public static void showRemoveProduct()
    {
        Functions.prepareMenu(Lang.removeProductMenu);

        int code = ReadProduct.existingProductCode();

        System.out.println(String.format(Lang.confirmProductDelete, code));
        if (Functions.readBoolean())
        {
            Data.products.remove(code);

            System.out.println(Lang.productDeletedSuccessfully);
        }
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
}
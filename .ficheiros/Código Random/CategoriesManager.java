package ProjetoTap.Managers;

import ProjetoTap.Data;
import ProjetoTap.Functions;
import ProjetoTap.Settings;
import ProjetoTap.Structures.*;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class CategoriesManager
{
    public static Result createCategory(int id, String name)
    {
        if (id <= 0) return new Result(true, "Category IDs cannot be '0' or negative.");
        if (!Data.categories.containsKey(id)) return new Result(true, "A Category with ID '" + id + "' does not exist.");
        if (name.equals(Settings.NoCategoryString)) return new Result(true, "The name '" + Settings.NoCategoryString + "' cannot be used as a Category name.");
        if (getCategory(name) != null) return new Result(true, "A Category named '" + name + "' already exists.");

        Category c = new Category(id, name);
        Data.categories.put(id, c);
        return new Result(false, "Category named '" + name + "' (ID: '" + id + "') successfully added!", c);
    }

    public static Category getOrCreateCategory(String name)
    {
        Category c = CategoriesManager.getCategory(name);

        // CATEGORY DOESN'T EXIST
        if (c == null)
        {
            c = (Category)CategoriesManager.createCategory(Functions.generateId(Data.categories), name).returnObject;
        }

        return c;
    }

    public static Result deleteCategory(int id)
    {
        if (!Data.categories.containsKey(id)) return new Result(true, "There is no Category with ID '" + id + "'.");

        Map<Integer, Product> categoryProducts = getProductsFromCategoryById(id);
        if (categoryProducts.size() > 0)
        {
            categoryProducts.forEach((k, p) ->
            {
                p.setCategoryId(0);
                Data.products.put(k, p);
            });
        }

        Data.categories.remove(id);
        return new Result(false, "Category with ID '" + id + "' successfully removed!");
    }

    public static Category getCategory(int id)
    {
        if (!Data.categories.containsKey(id)) return null;

        return Data.categories.get(id);
    }

    public static Category getCategory(String name)
    {
        for (Category c : Data.categories.values())
        {
            if (c.getName().equals(name))
            {
                return c;
            }
        }

       return null;
    }

    public static boolean doesCategoryExist(int id)
    {
        return getCategory(id) != null;
    }

    public static boolean doesCategoryExist(String name)
    {
        return getCategory(name) != null;
    }

    public static Map<Integer, Product> getCategoryProducts(Category c)
    {
        Map<Integer, Product> products = new HashMap<>();

        Data.products.forEach((key, p) ->
        {
            if (ProductsManager.getProductCategory(p) == c)
            {
                products.put(p.getCode(), p);
            }
        });

        return products.size() > 0 ? products : null;
    }

    public static Map<Integer, Product> getProductsFromCategoryById(int id)
    {
        return Data.categories.containsKey(id) ? getCategoryProducts(Data.categories.get(id)) : null;
    }

    public static Result importCategoriesFromTextFile(String filePath, boolean overrideExisting)
    {
        File f = new File(filePath);
        if (!f.exists() || !f.isFile()) return new Result(true, "The specified file was not found.");

        Map<Integer, Category> map = new HashMap<>();

        // Format: <id>\t<name>
        int id;
        String name;

        String line;
        int successfulReadings = 0, failedReadings = 0;

        try
        {
            BufferedReader bf = new BufferedReader(new FileReader(filePath));

            while ((line = bf.readLine()) != null)
            {
                String[] splitLine = line.split("\t");

                try
                {
                    id = Integer.parseInt(splitLine[0]);
                    name = splitLine[1];

                    Category c = new Category(id, name);

                    if (!map.containsKey(id) || overrideExisting)
                    {
                        map.put(id, c);
                    }
                    successfulReadings++;
                }
                catch (Exception ignored)
                {
                    failedReadings++;
                }
            }
        }
        catch (Exception ignored)
        {
            return new Result(true, "There was an error reading the file.");
        }

        return new Result(false, "The Categories from the file '" + filePath + "' were successfully imported! ('" + successfulReadings + "' imported, '" + failedReadings + "' failed)");
    }

    public static Result exportCategoriesToTextFile(String filePath)
    {
        try
        {
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(filePath)));

            Data.categories.forEach((key, c) ->
            {
                writer.println(c.getId() + "\t" + c.getName());
            });

            writer.close();

            return new Result(false, "Saved '" + Data.categories.size() + "' Categories to the file '" + filePath + "'.");
        }
        catch (Exception ignored)
        {
            return new Result(true, "There was an error writing to the file.");
        }
    }

    public static Result readCategoriesFromBinaryFile(String filePath, boolean overrideExisting)
    {
        File file = new File(filePath);
        if (!file.exists() || !file.isFile()) return new Result(true, "The specified file was not found.");

        try
        {
            FileInputStream fis = new FileInputStream(new File(filePath));
            ObjectInputStream ois = new ObjectInputStream(fis);

            Map<Integer, Category> map = (Map<Integer, Category>) ois.readObject();
            map.forEach((key, c) ->
            {
                if (!Data.categories.containsKey(key) || overrideExisting)
                {
                    map.put(key, c);
                }
            });

            return new Result(false, "The Categories where successfully read and added to the list.", map.size());
        }
        catch (Exception ignored)
        {
            return new Result(true, "There was an error reading the file.");
        }
    }

    public static Result saveCategoriesToBinaryFile(String filePath, Map<Integer, Product> categories)
    {
        try
        {
            FileOutputStream fos = new FileOutputStream(new File(filePath));
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(categories);

            return new Result(false, "The Categories where successfully saved to the file '" + filePath + "'.");
        }
        catch (Exception ignored)
        {
            return new Result(true, "There was an error writing to the file.");
        }
    }
}

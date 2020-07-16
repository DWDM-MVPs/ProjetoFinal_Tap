package ProjetoTap.Structures;

import java.io.Serializable;
import java.util.ArrayList;

public class Category implements Serializable
{
    private String name;
    private ArrayList<Integer> productCodes = new ArrayList<>(); // <PRODUCT CODE>
    private int productsSoldCount;
    private double moneyEarned;

    public Category(String name, ArrayList<Integer> productCodes, int productsSoldCount)
    {
        setName(name);
        addProduct(productCodes);
        setProductsSoldCount(productsSoldCount);
    }

    public Category(String name)
    {
        this.name = name;
    }

    // ############# NAME
    public void setName(String name) { this.name = name; }
    public String getName() { return this.name; }
    // ############# PRODUCT CODES
    public void setProductCodes(ArrayList<Integer> productCodes) { this.productCodes = productCodes; }
    public ArrayList<Integer> getProductCodes() { return this.productCodes; }
    // ############# PRODUCTS SOLD
    public void setProductsSoldCount(int productsSoldCount) { this.productsSoldCount = productsSoldCount; }
    public int getProductsSoldCount() { return this.productsSoldCount; }
    // ############# MONEY EARNED
    public void setMoneyEarned(double moneyEarned) { this.moneyEarned = moneyEarned; }
    public double getMoneyEarned() { return this.moneyEarned; }





    public void addProduct(Product p) { addProduct(p.getCode()); }
    public void addProduct(ArrayList<Integer> productCodes)
    {
        for (int productCode : productCodes)
        {
            addProduct(productCode);
        }
    }
    public void addProduct(int productCode)
    {
        if (!this.productCodes.contains(productCode))
        {
            this.productCodes.add(productCode);
        }
    }

    public void removeProduct(Product p)
    {
        removeProduct(p.getCode());
    }
    public void removeProduct(ArrayList<Integer> productCodes)
    {
        for (int productCode : productCodes)
        {
            removeProduct(productCode);
        }
    }
    public void removeProduct(int productCode)
    {
        for (int i = 0; i < productCodes.size(); i++)
        {
            if (productCodes.get(i) == productCode)
            {
                productCodes.remove(i);
                break;
            }
        }
    }
}

package ProjetoTap.Structures;

import ProjetoTap.StructureActions.Get;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Sale implements Serializable
{
    private int id;
    private Map<Integer, Integer> saleProducts = new HashMap<>(); // ID PRODUTO, QUANTIDADE DE PRODUTOS
    private double totalPrice;

    public Sale(int id, Map<Integer, Integer> products)
    {
        setId(id);
        if (products != null)
        {
            for (int productCode : products.keySet())
            {
                addProduct(productCode, products.get(productCode));
            }
        }
    }
    public Sale(int id)
    {
        setId(id);
    }

    // ############# ID
    public void setId(int id) { this.id = id; }
    public int getId() { return id; }
    // ############# PRODUCTS
    public void setSaleProducts(Map<Integer, Integer> saleProducts) { this.saleProducts = saleProducts; }
    public Map<Integer, Integer> getSaleProducts() { return saleProducts; }
    // ############# TOTAL PRICE
    public void setTotalPrice(double totalPrice) { this.totalPrice = totalPrice; }
    public double getTotalPrice() { return this.totalPrice; }





    public void addProduct(Product p, int amount) { addProduct(p.getCode(), amount); }
    public void addProduct(int productCode, int amount)
    {
        // UPDATE SALE TOTAL VALUE
        totalPrice += Get.getProduct(productCode).getPrice() * amount;

        // THE PRODUCT ALREADY EXISTS ON THE LIST, SO WE NEED TO GET THE ALREADY SAVED STOCK AND ADD MORE
        if (saleProducts.containsKey(productCode))
        {
            int existingAmount = saleProducts.get(productCode);
            saleProducts.put(productCode, existingAmount + amount);
        }
        // THE PRODUCT DOES NOT EXIST ON THE LIST
        else
        {
            saleProducts.put(productCode, amount);
        }
    }
}

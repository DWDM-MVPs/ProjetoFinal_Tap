package ProjetoTap.Structures;

import ProjetoTap.Data.Data;
import ProjetoTap.Functions;
import ProjetoTap.StructureActions.Create;
import ProjetoTap.StructureActions.Get;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Sale implements Serializable
{
    private int saleId = Functions.generateId(Data.sales);
    private int clientId;
    private Map<Integer, Integer> saleProducts = new HashMap<>(); // ID PRODUTO, QUANTIDADE DE PRODUTOS
    private double totalPrice;

    public Sale() { }
    public Sale(int clientId, Map<Integer, Integer> products)
    {
        setClientId(clientId);
        if (products != null)
        {
            for (int productCode : products.keySet())
            {
                addProduct(productCode, products.get(productCode));
            }
        }
    }

    // ############# ID
    public int getSaleId() { return saleId; }
    // ############# CLIENT ID
    public void setClientId(int clientId) { this.clientId = clientId; }
    public int getClientId() { return clientId; }
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
    public void removeProduct(int productCode, int amount)
    {
        int existingAmount = saleProducts.get(productCode);
        if (amount > existingAmount)
        {
            saleProducts.put(productCode, existingAmount - amount);
        }

        Sale s = Create.createSale(clientId, saleProducts);

        Get.getClient(clientId).removeSale(saleId);
        Get.getClient(clientId).addSale(s.getSaleId());
    }
    public void removeProduct(int productCode)
    {
        saleProducts.remove(productCode);

        Sale s = Create.createSale(clientId, saleProducts);

        Get.getClient(clientId).removeSale(saleId);
        Get.getClient(clientId).addSale(s.getSaleId());
    }
}

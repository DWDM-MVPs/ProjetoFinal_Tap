package ProjetoTap.Structures;

import java.util.ArrayList;

public class Sale {
    private int id;
    private int clientId;
    private ArrayList<Product> products;

    public Sale(int id, int clientId, ArrayList<Product> products)
    {
        setId(id);
        setClientId(clientId);
        setProducts(products);
    }

    // ############# ID
    public void setId(int id) { this.id = id; }
    public int getId() { return id; }
    // ############# CLIENT ID
    public void setClientId(int clientId) { this.clientId = clientId; }
    public int getClientId() { return clientId; }
    // ############# PRODUCTS
    public void setProducts(ArrayList<Product> products) { this.products = products; }
    public ArrayList<Product> getProducts() { return products; }
}

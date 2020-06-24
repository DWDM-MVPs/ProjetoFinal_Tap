package ProjetoTap.Structures;

public class Product
{
    private int code;
    private String name;
    private String category;
    private int stock;
    private double price;

    public Product(int code, String name, String category, int stock, double price)
    {
        setCode(code);
        setName(name);
        setCategory(category);
        setStock(stock);
        setPrice(price);
    }

    // ############# CODE
    public void setCode(int code) { this.code = code; }
    public int getCode() { return code; }
    // ############# NAME
    public void setName(String name) { this.name = name; }
    public String getName() { return name; }
    // ############# CATEGORY ID
    public void setCategory(String category) { this.category = category; }
    public String getCategory() { return category; }
    // ############# STOCK
    public void setStock(int stock) { this.stock = stock; }
    public int getStock() { return stock; }
    public void addStock(int stock) { this.stock += stock; }
    public void removeStock(int stock) { this.stock -= stock; }
    // ############# PRICE
    public void setPrice(double price) { this.price = price; }
    public double getPrice() { return price; }
}

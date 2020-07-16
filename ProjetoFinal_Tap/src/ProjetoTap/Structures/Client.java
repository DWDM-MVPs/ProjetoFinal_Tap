package ProjetoTap.Structures;

import ProjetoTap.Data.Data;
import ProjetoTap.Functions;

import java.io.Serializable;
import java.util.ArrayList;

public class Client implements Serializable
{
    private int id;
    private String name;
    private String city;
    private int birthYear;
    private ArrayList<Integer> salesIds = new ArrayList<>(); // <SALE ID>
    private double totalMoneySpent;

    public Client(int id, String name, String city, int birthYear)
    {
        setID(id);
        setName(name);
        setCity(city);
        setBirthYear(birthYear);
    }

    public Client(int id, String name, String city, int birthYear, ArrayList<Integer> salesIds, double totalMoneySpent)
    {
        setID(id);
        setName(name);
        setCity(city);
        setBirthYear(birthYear);
        setSalesIds(salesIds);
        setTotalMoneySpent(totalMoneySpent);
    }

    // ############# ID
    public void setID(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    // ############# NAME
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    // ############# CITY
    public void setCity(String city) {
        this.city = city;
    }
    public String getCity() {
        return city;
    }
    // ############# BIRTH YEAR
    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }
    public int getBirthYear() {
        return birthYear;
    }
    // ############# SALES ID
    public void setSalesIds(ArrayList<Integer> salesIds) { this.salesIds = salesIds; }
    public ArrayList<Integer> getSalesIds() { return this.salesIds; }
    // ############# TOTAL MONEY SPENT
    public void setTotalMoneySpent(double totalMoneySpent) { this.totalMoneySpent = totalMoneySpent; }
    public double getTotalMoneySpent() { return this.totalMoneySpent; }





    public int getAge()
    {
        return Functions.getCurrentYear() - this.getBirthYear();
    }

    public void addSale(int saleId)
    {
        Sale s = Data.sales.get(saleId);

        for (int productCode : s.getSaleProducts().keySet())
        {
            this.totalMoneySpent += Data.products.get(productCode).getPrice() * s.getSaleProducts().get(productCode);
        }

        salesIds.add(saleId);
    }
}

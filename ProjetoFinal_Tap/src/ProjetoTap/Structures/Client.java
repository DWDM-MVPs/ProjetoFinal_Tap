package ProjetoTap.Structures;

import ProjetoTap.Functions;

public class Client
{
    private int id;
    private String name;
    private String city;
    private int birthYear;

    public Client(int id, String name, String city, int birthYear)
    {
        setID(id);
        setName(name);
        setCity(city);
        setBirthYear(birthYear);
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





    public int getAge()
    {
        return Functions.getCurrentYear() - this.getBirthYear();
    }
}

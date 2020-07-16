package ProjetoTap.Data;

import ProjetoTap.Structures.Client;
import ProjetoTap.Structures.Product;
import ProjetoTap.Structures.Sale;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Data
{
    // <PRODUCT CODE, PRODUCT>
    public static Map<Integer, Product> products = new HashMap<>();
    // <CLIENT ID, CLIENT>
    public static Map<Integer, Client> clients = new HashMap<>();
    // <SALE ID, SALE>
    public static Map<Integer, Sale> sales = new HashMap<>();

    // <CATEGORY NAME, PRODUCT ID LIST>
    public static Map<String, ArrayList<Integer>> categories = new HashMap<>();
}

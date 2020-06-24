package ProjetoTap.Data;

import ProjetoTap.Structures.Client;
import ProjetoTap.Structures.Product;
import ProjetoTap.Structures.Sale;

import java.util.HashMap;
import java.util.Map;

public class Data
{
    public static Map<Integer, Product> products = new HashMap<>();
    public static Map<Integer, Client> clients = new HashMap<>();
    public static Map<Integer, Sale> sales = new HashMap<>();
}

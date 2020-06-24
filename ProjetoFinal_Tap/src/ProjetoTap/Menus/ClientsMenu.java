package ProjetoTap.Menus;

import ProjetoTap.Data.Settings;
import ProjetoTap.StructureActions.Create;
import ProjetoTap.Data.Data;
import ProjetoTap.Functions;
import ProjetoTap.Data.Lang;
import ProjetoTap.StructureActions.Get;
import ProjetoTap.Structures.Product;
import ProjetoTap.UserInput.ReadClient;
import ProjetoTap.Structures.Client;
import ProjetoTap.Structures.Sale;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static ProjetoTap.Main.*;

public class ClientsMenu
{
    //      ░██████╗██╗░░██╗░█████╗░░██╗░░░░░░░██╗  ███╗░░░███╗███████╗███╗░░██╗██╗░░░██╗
    //      ██╔════╝██║░░██║██╔══██╗░██║░░██╗░░██║  ████╗░████║██╔════╝████╗░██║██║░░░██║
    //      ╚█████╗░███████║██║░░██║░╚██╗████╗██╔╝  ██╔████╔██║█████╗░░██╔██╗██║██║░░░██║
    //      ░╚═══██╗██╔══██║██║░░██║░░████╔═████║░  ██║╚██╔╝██║██╔══╝░░██║╚████║██║░░░██║
    //      ██████╔╝██║░░██║╚█████╔╝░░╚██╔╝░╚██╔╝░  ██║░╚═╝░██║███████╗██║░╚███║╚██████╔╝
    //      ╚═════╝░╚═╝░░╚═╝░╚════╝░░░░╚═╝░░░╚═╝░░  ╚═╝░░░░░╚═╝╚══════╝╚═╝░░╚══╝░╚═════╝░
    public static void showClientsMenu()
    {
        int option;
        do
        {
            Functions.prepareMenu(Lang.colorYellow + Lang.clientsMenu);

            System.out.println(Lang.colorYellow + "0. " + Lang.exit);
            System.out.println(Lang.colorGreen + "1. " + Lang.createClientMenu);
            System.out.println(Lang.colorGreen + "2. " + Lang.oldestClientMenu);
            System.out.println(Lang.colorGreen + "3. " + Lang.averageClientAgeMenu);
            System.out.println(Lang.colorGreen + "4. " + Lang.clientViewPurchasesMenu);
            System.out.println(Lang.colorGreen + "5. " + Lang.viewClientsByUpperAgeMenu);
            System.out.println(Lang.colorGreen + "6. " + Lang.viewClientsByCityMenu);
            System.out.println(Lang.colorGreen + "7. " + Lang.viewIfExistsByName);
            System.out.println(Lang.colorGreen + "8. " + Lang.viewAgeModeMenu);
            System.out.println(Lang.colorGreen + "9. " + Lang.mostSoldProductsMenu);
            System.out.println(Lang.colorGreen + "10. " + Lang.mostExpensiveProductMenu);
            System.out.println(Lang.colorGreen + "11. " + Lang.mostMoneySpentMenu);
            System.out.println(Lang.colorGreen + "12. " + Lang.editClientMenu);
            System.out.println(Lang.colorGreen + "13. " + Lang.removeClientMenu);

            option = readMenuOption(1, 13);
            switch (option)
            {
                case 1: // CREATE CLIENT
                    showCreateClient();
                    break;
                case 2: // OLDEST CLIENT
                    showOldestClient();
                    break;
                case 3: // AVERAGE CLIENT AGE
                    showAverageClientAge();
                    break;
                case 4: // VIEW PURCHASES
                    showViewPurchases();
                    break;
                case 5: // VIEW CLIENTS BY UPPER AGE
                    showViewClientsByUpperAge();
                    break;
                case 6: // VIEW CLIENTS BY CITY
                    showViewClientsByCity();
                    break;
                case 7: // VIEW IF EXISTS BY NAME
                    showViewIfExistsByName();
                    break;
                case 8: // VIEW AGE MODE
                    showViewAgeMode();
                    break;
                case 9: // MOST SOLD PRODUCTS
                    showMostSoldProducts();
                    break;
                case 10: // MOST EXPENSIVE PRODUCT
                    showMostExpensiveProduct();
                    break;
                case 11: // MOST MONEY SPENT
                    showMostMoneySpent();
                    break;
                case 12: // EDIT CLIENT
                    showEditClient();
                    break;
                case 13: // REMOVE CLIENT
                    showRemoveClient();
                    break;
            }
        } while (option != 0);
    }
    //      ░█████╗░██████╗░███████╗░█████╗░████████╗███████╗  ░█████╗░██╗░░░░░██╗███████╗███╗░░██╗████████╗
    //      ██╔══██╗██╔══██╗██╔════╝██╔══██╗╚══██╔══╝██╔════╝  ██╔══██╗██║░░░░░██║██╔════╝████╗░██║╚══██╔══╝
    //      ██║░░╚═╝██████╔╝█████╗░░███████║░░░██║░░░█████╗░░  ██║░░╚═╝██║░░░░░██║█████╗░░██╔██╗██║░░░██║░░░
    //      ██║░░██╗██╔══██╗██╔══╝░░██╔══██║░░░██║░░░██╔══╝░░  ██║░░██╗██║░░░░░██║██╔══╝░░██║╚████║░░░██║░░░
    //      ╚█████╔╝██║░░██║███████╗██║░░██║░░░██║░░░███████╗  ╚█████╔╝███████╗██║███████╗██║░╚███║░░░██║░░░
    //      ░╚════╝░╚═╝░░╚═╝╚══════╝╚═╝░░╚═╝░░░╚═╝░░░╚══════╝  ░╚════╝░╚══════╝╚═╝╚══════╝╚═╝░░╚══╝░░░╚═╝░░░
    public static void showCreateClient()
    {
        Functions.prepareMenu(Lang.createProductMenu);

        int id = ReadClient.clientId(false);
        String name = ReadClient.clientName();
        String city = ReadClient.clientCity();
        int birthYear = ReadClient.clientBirthYear();

        Client c = Create.createClient(id, name, city, birthYear, false);

        if (c == null)
        {
            System.out.println(Lang.errorCreatingClient);
        }
        else
        {
            System.out.println(Lang.clientCreatedSuccessfully);
        }
    }
    //      ░█████╗░██╗░░░░░██████╗░███████╗░██████╗████████╗  ░█████╗░██╗░░░░░██╗███████╗███╗░░██╗████████╗
    //      ██╔══██╗██║░░░░░██╔══██╗██╔════╝██╔════╝╚══██╔══╝  ██╔══██╗██║░░░░░██║██╔════╝████╗░██║╚══██╔══╝
    //      ██║░░██║██║░░░░░██║░░██║█████╗░░╚█████╗░░░░██║░░░  ██║░░╚═╝██║░░░░░██║█████╗░░██╔██╗██║░░░██║░░░
    //      ██║░░██║██║░░░░░██║░░██║██╔══╝░░░╚═══██╗░░░██║░░░  ██║░░██╗██║░░░░░██║██╔══╝░░██║╚████║░░░██║░░░
    //      ╚█████╔╝███████╗██████╔╝███████╗██████╔╝░░░██║░░░  ╚█████╔╝███████╗██║███████╗██║░╚███║░░░██║░░░
    //      ░╚════╝░╚══════╝╚═════╝░╚══════╝╚═════╝░░░░╚═╝░░░  ░╚════╝░╚══════╝╚═╝╚══════╝╚═╝░░╚══╝░░░╚═╝░░░
    public static void showOldestClient()
    {
        Functions.prepareMenu(Lang.oldestClientMenu);

        int oldestAge = 0;

        for (Client c : Data.clients.values())
        {
            if (oldestAge < c.getAge())
            {
                oldestAge = c.getAge();
            }
        }

        System.out.println(String.format(Lang.oldestClientAge, oldestAge));
    }
    //      ░█████╗░██╗░░░██╗███████╗██████╗░░█████╗░░██████╗░███████╗  ░█████╗░██╗░░░░░██╗███████╗███╗░░██╗████████╗  ░█████╗░░██████╗░███████╗
    //      ██╔══██╗██║░░░██║██╔════╝██╔══██╗██╔══██╗██╔════╝░██╔════╝  ██╔══██╗██║░░░░░██║██╔════╝████╗░██║╚══██╔══╝  ██╔══██╗██╔════╝░██╔════╝
    //      ███████║╚██╗░██╔╝█████╗░░██████╔╝███████║██║░░██╗░█████╗░░  ██║░░╚═╝██║░░░░░██║█████╗░░██╔██╗██║░░░██║░░░  ███████║██║░░██╗░█████╗░░
    //      ██╔══██║░╚████╔╝░██╔══╝░░██╔══██╗██╔══██║██║░░╚██╗██╔══╝░░  ██║░░██╗██║░░░░░██║██╔══╝░░██║╚████║░░░██║░░░  ██╔══██║██║░░╚██╗██╔══╝░░
    //      ██║░░██║░░╚██╔╝░░███████╗██║░░██║██║░░██║╚██████╔╝███████╗  ╚█████╔╝███████╗██║███████╗██║░╚███║░░░██║░░░  ██║░░██║╚██████╔╝███████╗
    //      ╚═╝░░╚═╝░░░╚═╝░░░╚══════╝╚═╝░░╚═╝╚═╝░░╚═╝░╚═════╝░╚══════╝  ░╚════╝░╚══════╝╚═╝╚══════╝╚═╝░░╚══╝░░░╚═╝░░░  ╚═╝░░╚═╝░╚═════╝░╚══════╝
    public static void showAverageClientAge()
    {
        Functions.prepareMenu(Lang.averageClientAgeMenu);

        int ageSum = 0;

        for (Client c : Data.clients.values())
        {
            ageSum += c.getAge();
        }

        int avgAge = ageSum / Data.clients.size();

        System.out.println(String.format(Lang.averageClientAge, avgAge));
    }
    //      ██╗░░░██╗██╗███████╗░██╗░░░░░░░██╗  ██████╗░██╗░░░██╗██████╗░░█████╗░██╗░░██╗░█████╗░░██████╗███████╗░██████╗
    //      ██║░░░██║██║██╔════╝░██║░░██╗░░██║  ██╔══██╗██║░░░██║██╔══██╗██╔══██╗██║░░██║██╔══██╗██╔════╝██╔════╝██╔════╝
    //      ╚██╗░██╔╝██║█████╗░░░╚██╗████╗██╔╝  ██████╔╝██║░░░██║██████╔╝██║░░╚═╝███████║███████║╚█████╗░█████╗░░╚█████╗░
    //      ░╚████╔╝░██║██╔══╝░░░░████╔═████║░  ██╔═══╝░██║░░░██║██╔══██╗██║░░██╗██╔══██║██╔══██║░╚═══██╗██╔══╝░░░╚═══██╗
    //      ░░╚██╔╝░░██║███████╗░░╚██╔╝░╚██╔╝░  ██║░░░░░╚██████╔╝██║░░██║╚█████╔╝██║░░██║██║░░██║██████╔╝███████╗██████╔╝
    //      ░░░╚═╝░░░╚═╝╚══════╝░░░╚═╝░░░╚═╝░░  ╚═╝░░░░░░╚═════╝░╚═╝░░╚═╝░╚════╝░╚═╝░░╚═╝╚═╝░░╚═╝╚═════╝░╚══════╝╚═════╝░
    public static void showViewPurchases()
    {
        Functions.prepareMenu(Lang.clientViewPurchasesMenu);

        int id = ReadClient.existingClientId();

        ArrayList<Sale> sales = new ArrayList<>();
        for (Sale sale : Data.sales.values())
        {
            if (sale.getClientId() == id)
            {
                sales.add(sale);
            }
        }

        if (sales.size() > 0)
        {
            for (Sale s : sales)
            {
                System.out.println(String.format(Lang.listProductsForSaleForClient, s.getId(), s.getClientId()));

                Map<Integer, Integer> productsMap = new HashMap<>();
                for (Product p : s.getProducts())
                {
                    if (!productsMap.containsKey(p.getCode()))
                    {
                        productsMap.put(p.getCode(), 1);
                    }
                    else
                    {
                        int existingStock = productsMap.get(p.getCode());
                        productsMap.put(p.getCode(), existingStock + 1);
                    }
                }

                for (Integer key : productsMap.keySet())
                {
                    Product p = Get.getProduct(key);
                    System.out.println(String.format(Lang.listedProductForSaleForClient, key, p.getName(), productsMap.get(key), p.getPrice() * key));
                }
            }
        }
        else
        {
            System.out.println(Lang.errorClientHasNoSales);
        }
    }
    //      ██╗░░░██╗██╗███████╗░██╗░░░░░░░██╗  ░█████╗░██╗░░░░░██╗███████╗███╗░░██╗████████╗░██████╗  ██████╗░██╗░░░██╗  ██╗░░░██╗██████╗░██████╗░███████╗██████╗░  ░█████╗░░██████╗░███████╗
    //      ██║░░░██║██║██╔════╝░██║░░██╗░░██║  ██╔══██╗██║░░░░░██║██╔════╝████╗░██║╚══██╔══╝██╔════╝  ██╔══██╗╚██╗░██╔╝  ██║░░░██║██╔══██╗██╔══██╗██╔════╝██╔══██╗  ██╔══██╗██╔════╝░██╔════╝
    //      ╚██╗░██╔╝██║█████╗░░░╚██╗████╗██╔╝  ██║░░╚═╝██║░░░░░██║█████╗░░██╔██╗██║░░░██║░░░╚█████╗░  ██████╦╝░╚████╔╝░  ██║░░░██║██████╔╝██████╔╝█████╗░░██████╔╝  ███████║██║░░██╗░█████╗░░
    //      ░╚████╔╝░██║██╔══╝░░░░████╔═████║░  ██║░░██╗██║░░░░░██║██╔══╝░░██║╚████║░░░██║░░░░╚═══██╗  ██╔══██╗░░╚██╔╝░░  ██║░░░██║██╔═══╝░██╔═══╝░██╔══╝░░██╔══██╗  ██╔══██║██║░░╚██╗██╔══╝░░
    //      ░░╚██╔╝░░██║███████╗░░╚██╔╝░╚██╔╝░  ╚█████╔╝███████╗██║███████╗██║░╚███║░░░██║░░░██████╔╝  ██████╦╝░░░██║░░░  ╚██████╔╝██║░░░░░██║░░░░░███████╗██║░░██║  ██║░░██║╚██████╔╝███████╗
    //      ░░░╚═╝░░░╚═╝╚══════╝░░░╚═╝░░░╚═╝░░  ░╚════╝░╚══════╝╚═╝╚══════╝╚═╝░░╚══╝░░░╚═╝░░░╚═════╝░  ╚═════╝░░░░╚═╝░░░  ░╚═════╝░╚═╝░░░░░╚═╝░░░░░╚══════╝╚═╝░░╚═╝  ╚═╝░░╚═╝░╚═════╝░╚══════╝
    public static void showViewClientsByUpperAge()
    {
        Functions.prepareMenu(Lang.viewClientsByUpperAgeMenu);

        int baseAge = readAge();

        System.out.println(String.format(Lang.clientsWithMoreAge, baseAge));
        for (Client c : Data.clients.values())
        {
            if (c.getAge() >= baseAge)
            {
                System.out.println(String.format(Lang.listedClient, c.getId(), c.getName(), c.getCity(), c.getAge()));
            }
        }
    }
    public static int readAge()
    {
        try
        {
            int option = sc.nextInt();

            if (option < Settings.minimumAge || option > Settings.maximumAge)
            {
                System.out.println(Lang.errorWrongClientAge);
                sc.nextLine();
                return readAge();
            }

            return option;
        }
        catch (Exception ignored)
        {
            System.out.println(Lang.errorWrongDataType);
            sc.nextLine();
            return readAge();
        }
    }
    //      ██╗░░░██╗██╗███████╗░██╗░░░░░░░██╗  ░█████╗░██╗░░░░░██╗███████╗███╗░░██╗████████╗░██████╗  ██████╗░██╗░░░██╗  ░█████╗░██╗████████╗██╗░░░██╗
    //      ██║░░░██║██║██╔════╝░██║░░██╗░░██║  ██╔══██╗██║░░░░░██║██╔════╝████╗░██║╚══██╔══╝██╔════╝  ██╔══██╗╚██╗░██╔╝  ██╔══██╗██║╚══██╔══╝╚██╗░██╔╝
    //      ╚██╗░██╔╝██║█████╗░░░╚██╗████╗██╔╝  ██║░░╚═╝██║░░░░░██║█████╗░░██╔██╗██║░░░██║░░░╚█████╗░  ██████╦╝░╚████╔╝░  ██║░░╚═╝██║░░░██║░░░░╚████╔╝░
    //      ░╚████╔╝░██║██╔══╝░░░░████╔═████║░  ██║░░██╗██║░░░░░██║██╔══╝░░██║╚████║░░░██║░░░░╚═══██╗  ██╔══██╗░░╚██╔╝░░  ██║░░██╗██║░░░██║░░░░░╚██╔╝░░
    //      ░░╚██╔╝░░██║███████╗░░╚██╔╝░╚██╔╝░  ╚█████╔╝███████╗██║███████╗██║░╚███║░░░██║░░░██████╔╝  ██████╦╝░░░██║░░░  ╚█████╔╝██║░░░██║░░░░░░██║░░░
    //      ░░░╚═╝░░░╚═╝╚══════╝░░░╚═╝░░░╚═╝░░  ░╚════╝░╚══════╝╚═╝╚══════╝╚═╝░░╚══╝░░░╚═╝░░░╚═════╝░  ╚═════╝░░░░╚═╝░░░  ░╚════╝░╚═╝░░░╚═╝░░░░░░╚═╝░░░
    public static void showViewClientsByCity()
    {
        Functions.prepareMenu(Lang.viewClientsByCityMenu);

        String city = ReadClient.clientCity();

        ArrayList<Client> clients = new ArrayList<>();
        for (Client c : Data.clients.values())
        {
            if (c.getCity().toLowerCase().equals(city.toLowerCase()))
            {
                clients.add(c);
            }
        }

        System.out.println(String.format(Lang.clientsInCity, city));
        if (clients.size() > 0)
        {
            for (Client c : clients)
            {
                System.out.println(String.format(Lang.listedClient, c.getId(), c.getName(), c.getCity(), c.getAge()));
            }
        }
        else
        {
            System.out.println(Lang.errorNoClientsFound);
        }
    }
    //      ██╗░░░██╗██╗███████╗░██╗░░░░░░░██╗  ██╗███████╗  ███████╗██╗░░██╗██╗░██████╗████████╗░██████╗  ██████╗░██╗░░░██╗  ███╗░░██╗░█████╗░███╗░░░███╗███████╗
    //      ██║░░░██║██║██╔════╝░██║░░██╗░░██║  ██║██╔════╝  ██╔════╝╚██╗██╔╝██║██╔════╝╚══██╔══╝██╔════╝  ██╔══██╗╚██╗░██╔╝  ████╗░██║██╔══██╗████╗░████║██╔════╝
    //      ╚██╗░██╔╝██║█████╗░░░╚██╗████╗██╔╝  ██║█████╗░░  █████╗░░░╚███╔╝░██║╚█████╗░░░░██║░░░╚█████╗░  ██████╦╝░╚████╔╝░  ██╔██╗██║███████║██╔████╔██║█████╗░░
    //      ░╚████╔╝░██║██╔══╝░░░░████╔═████║░  ██║██╔══╝░░  ██╔══╝░░░██╔██╗░██║░╚═══██╗░░░██║░░░░╚═══██╗  ██╔══██╗░░╚██╔╝░░  ██║╚████║██╔══██║██║╚██╔╝██║██╔══╝░░
    //      ░░╚██╔╝░░██║███████╗░░╚██╔╝░╚██╔╝░  ██║██║░░░░░  ███████╗██╔╝╚██╗██║██████╔╝░░░██║░░░██████╔╝  ██████╦╝░░░██║░░░  ██║░╚███║██║░░██║██║░╚═╝░██║███████╗
    //      ░░░╚═╝░░░╚═╝╚══════╝░░░╚═╝░░░╚═╝░░  ╚═╝╚═╝░░░░░  ╚══════╝╚═╝░░╚═╝╚═╝╚═════╝░░░░╚═╝░░░╚═════╝░  ╚═════╝░░░░╚═╝░░░  ╚═╝░░╚══╝╚═╝░░╚═╝╚═╝░░░░░╚═╝╚══════╝
    public static void showViewIfExistsByName()
    {
        Functions.prepareMenu(Lang.viewIfExistsByCodeMenu);

        String name = ReadClient.clientName();

        ArrayList<Client> clients = new ArrayList<>();
        for (Client c : Data.clients.values())
        {
            if (c.getName().toLowerCase().equals(name.toLowerCase()))
            {
                clients.add(c);
            }
        }

        System.out.println(String.format(Lang.viewIfExistsByName, name));
        if (clients.size() > 0)
        {
            for (Client c : clients)
            {
                System.out.println(String.format(Lang.listedClient, c.getId(), c.getName(), c.getCity(), c.getAge()));
            }
        }
        else
        {
            System.out.println(Lang.errorNoClientsFound);
        }
    }
    //      ██╗░░░██╗██╗███████╗░██╗░░░░░░░██╗  ░█████╗░░██████╗░███████╗  ███╗░░░███╗░█████╗░██████╗░███████╗
    //      ██║░░░██║██║██╔════╝░██║░░██╗░░██║  ██╔══██╗██╔════╝░██╔════╝  ████╗░████║██╔══██╗██╔══██╗██╔════╝
    //      ╚██╗░██╔╝██║█████╗░░░╚██╗████╗██╔╝  ███████║██║░░██╗░█████╗░░  ██╔████╔██║██║░░██║██║░░██║█████╗░░
    //      ░╚████╔╝░██║██╔══╝░░░░████╔═████║░  ██╔══██║██║░░╚██╗██╔══╝░░  ██║╚██╔╝██║██║░░██║██║░░██║██╔══╝░░
    //      ░░╚██╔╝░░██║███████╗░░╚██╔╝░╚██╔╝░  ██║░░██║╚██████╔╝███████╗  ██║░╚═╝░██║╚█████╔╝██████╔╝███████╗
    //      ░░░╚═╝░░░╚═╝╚══════╝░░░╚═╝░░░╚═╝░░  ╚═╝░░╚═╝░╚═════╝░╚══════╝  ╚═╝░░░░░╚═╝░╚════╝░╚═════╝░╚══════╝
    public static void showViewAgeMode()
    {
        Functions.prepareMenu(Lang.viewAgeModeMenu);

        Map<Integer, Integer> ageMap = new HashMap<>();
        for (Client c : Data.clients.values())
        {
            if (!ageMap.containsKey(c.getAge()))
            {
                ageMap.put(c.getAge(), 1);
            }
            else
            {
                int existingAge = ageMap.get(c.getAge());
                ageMap.put(c.getAge(), existingAge + 1);
            }
        }

        int oldestAge = 0;
        StringBuilder ageString = new StringBuilder();
        for (Integer age : ageMap.keySet())
        {
            if (age > oldestAge)
            {
                oldestAge = age;
                ageString = new StringBuilder(age);
            }

            if (oldestAge == age)
            {
                ageString.append(", ").append(age);
            }
        }

        System.out.println(String.format(Lang.listModeClientAge, ageString));
    }
    //      ███╗░░░███╗░█████╗░░██████╗████████╗  ░██████╗░█████╗░██╗░░░░░██████╗░  ██████╗░██████╗░░█████╗░██████╗░██╗░░░██╗░█████╗░████████╗░██████╗
    //      ████╗░████║██╔══██╗██╔════╝╚══██╔══╝  ██╔════╝██╔══██╗██║░░░░░██╔══██╗  ██╔══██╗██╔══██╗██╔══██╗██╔══██╗██║░░░██║██╔══██╗╚══██╔══╝██╔════╝
    //      ██╔████╔██║██║░░██║╚█████╗░░░░██║░░░  ╚█████╗░██║░░██║██║░░░░░██║░░██║  ██████╔╝██████╔╝██║░░██║██║░░██║██║░░░██║██║░░╚═╝░░░██║░░░╚█████╗░
    //      ██║╚██╔╝██║██║░░██║░╚═══██╗░░░██║░░░  ░╚═══██╗██║░░██║██║░░░░░██║░░██║  ██╔═══╝░██╔══██╗██║░░██║██║░░██║██║░░░██║██║░░██╗░░░██║░░░░╚═══██╗
    //      ██║░╚═╝░██║╚█████╔╝██████╔╝░░░██║░░░  ██████╔╝╚█████╔╝███████╗██████╔╝  ██║░░░░░██║░░██║╚█████╔╝██████╔╝╚██████╔╝╚█████╔╝░░░██║░░░██████╔╝
    //      ╚═╝░░░░░╚═╝░╚════╝░╚═════╝░░░░╚═╝░░░  ╚═════╝░░╚════╝░╚══════╝╚═════╝░  ╚═╝░░░░░╚═╝░░╚═╝░╚════╝░╚═════╝░░╚═════╝░░╚════╝░░░░╚═╝░░░╚═════╝░
    public static void showMostSoldProducts()
    {
        Functions.prepareMenu(Lang.mostSoldProductsMenu);

        Map<Integer, Integer> productSales = new HashMap<>();
        for (Sale s : Data.sales.values())
        {
            for (Product p : s.getProducts())
            {
                if (!productSales.containsKey(p.getCode()))
                {
                    productSales.put(p.getCode(), 1);
                }
                else
                {
                    int existingValue = productSales.get(p.getCode());
                    productSales.put(p.getCode(), existingValue + 1);
                }
            }
        }

        int mostSales = 0;
        ArrayList<Integer> mostSoldProducts = new ArrayList<>();
        for (Integer key : productSales.keySet())
        {
            int sales = productSales.get(key);
            if (sales > 0)
            {
                mostSales = sales;
                mostSoldProducts.clear();
            }
            if (sales == mostSales)
            {
                mostSoldProducts.add(key);
            }
        }

        System.out.println(String.format(Lang.mostSoldProducts, mostSales));
        for (Integer code : mostSoldProducts)
        {
            Product p = Get.getProduct(code);
            System.out.println(String.format(Lang.listedProductByMostSales, code, p.getName(), p.getCategory(), p.getPrice(), p.getPrice()));
        }
    }
    //      ███╗░░░███╗░█████╗░░██████╗████████╗  ███████╗██╗░░██╗██████╗░███████╗███╗░░██╗░██████╗██╗██╗░░░██╗███████╗  ██████╗░██████╗░░█████╗░██████╗░██╗░░░██╗░█████╗░████████╗
    //      ████╗░████║██╔══██╗██╔════╝╚══██╔══╝  ██╔════╝╚██╗██╔╝██╔══██╗██╔════╝████╗░██║██╔════╝██║██║░░░██║██╔════╝  ██╔══██╗██╔══██╗██╔══██╗██╔══██╗██║░░░██║██╔══██╗╚══██╔══╝
    //      ██╔████╔██║██║░░██║╚█████╗░░░░██║░░░  █████╗░░░╚███╔╝░██████╔╝█████╗░░██╔██╗██║╚█████╗░██║╚██╗░██╔╝█████╗░░  ██████╔╝██████╔╝██║░░██║██║░░██║██║░░░██║██║░░╚═╝░░░██║░░░
    //      ██║╚██╔╝██║██║░░██║░╚═══██╗░░░██║░░░  ██╔══╝░░░██╔██╗░██╔═══╝░██╔══╝░░██║╚████║░╚═══██╗██║░╚████╔╝░██╔══╝░░  ██╔═══╝░██╔══██╗██║░░██║██║░░██║██║░░░██║██║░░██╗░░░██║░░░
    //      ██║░╚═╝░██║╚█████╔╝██████╔╝░░░██║░░░  ███████╗██╔╝╚██╗██║░░░░░███████╗██║░╚███║██████╔╝██║░░╚██╔╝░░███████╗  ██║░░░░░██║░░██║╚█████╔╝██████╔╝╚██████╔╝╚█████╔╝░░░██║░░░
    //      ╚═╝░░░░░╚═╝░╚════╝░╚═════╝░░░░╚═╝░░░  ╚══════╝╚═╝░░╚═╝╚═╝░░░░░╚══════╝╚═╝░░╚══╝╚═════╝░╚═╝░░░╚═╝░░░╚══════╝  ╚═╝░░░░░╚═╝░░╚═╝░╚════╝░╚═════╝░░╚═════╝░░╚════╝░░░░╚═╝░░░
    public static void showMostExpensiveProduct()
    {
        Functions.prepareMenu(Lang.mostExpensiveProductMenu);

        double mostExpensive = 0;
        int code = -1;
        for (Product p : Data.products.values())
        {
            if (p.getPrice() > mostExpensive)
            {
                mostExpensive = p.getPrice();
                code = p.getCode();
            }
        }

        if (code != -1)
        {
            Product p = Get.getProduct(code);
            System.out.println(String.format(Lang.listMostExpensiveProduct, code, p.getName(), p.getCategory(), p.getStock(), p.getPrice()));
        }
        else
        {
            System.out.println(Lang.errorUnknown);
        }
    }
    //      ███╗░░░███╗░█████╗░░██████╗████████╗  ███╗░░░███╗░█████╗░███╗░░██╗███████╗██╗░░░██╗  ░██████╗██████╗░███████╗███╗░░██╗████████╗
    //      ████╗░████║██╔══██╗██╔════╝╚══██╔══╝  ████╗░████║██╔══██╗████╗░██║██╔════╝╚██╗░██╔╝  ██╔════╝██╔══██╗██╔════╝████╗░██║╚══██╔══╝
    //      ██╔████╔██║██║░░██║╚█████╗░░░░██║░░░  ██╔████╔██║██║░░██║██╔██╗██║█████╗░░░╚████╔╝░  ╚█████╗░██████╔╝█████╗░░██╔██╗██║░░░██║░░░
    //      ██║╚██╔╝██║██║░░██║░╚═══██╗░░░██║░░░  ██║╚██╔╝██║██║░░██║██║╚████║██╔══╝░░░░╚██╔╝░░  ░╚═══██╗██╔═══╝░██╔══╝░░██║╚████║░░░██║░░░
    //      ██║░╚═╝░██║╚█████╔╝██████╔╝░░░██║░░░  ██║░╚═╝░██║╚█████╔╝██║░╚███║███████╗░░░██║░░░  ██████╔╝██║░░░░░███████╗██║░╚███║░░░██║░░░
    //      ╚═╝░░░░░╚═╝░╚════╝░╚═════╝░░░░╚═╝░░░  ╚═╝░░░░░╚═╝░╚════╝░╚═╝░░╚══╝╚══════╝░░░╚═╝░░░  ╚═════╝░╚═╝░░░░░╚══════╝╚═╝░░╚══╝░░░╚═╝░░░
    public static void showMostMoneySpent()
    {
        Functions.prepareMenu(Lang.mostMoneySpentMenu);

        double mostMoneySpent = 0;
        Map<Integer, Double> clients = new HashMap<>();
        for (Sale s : Data.sales.values())
        {
            for (Product p : s.getProducts())
            {
                if (!clients.containsKey(s.getClientId()))
                {
                    clients.put(s.getClientId(), p.getPrice());
                }
                else
                {
                    double existingValue = clients.get(s.getClientId());
                    clients.put(s.getClientId(), existingValue + p.getPrice());
                }
            }
        }

        System.out.println(String.format(Lang.listClientMostMoneySpent, mostMoneySpent));
        for (Integer id : clients.keySet())
        {
            Client c = Get.getClient(id);
            System.out.println(String.format(Lang.listedClientMostMoneySpent, id, c.getName(), c.getCity(), c.getAge()));
        }
    }
    //      ███████╗██████╗░██╗████████╗  ░█████╗░██╗░░░░░██╗███████╗███╗░░██╗████████╗
    //      ██╔════╝██╔══██╗██║╚══██╔══╝  ██╔══██╗██║░░░░░██║██╔════╝████╗░██║╚══██╔══╝
    //      █████╗░░██║░░██║██║░░░██║░░░  ██║░░╚═╝██║░░░░░██║█████╗░░██╔██╗██║░░░██║░░░
    //      ██╔══╝░░██║░░██║██║░░░██║░░░  ██║░░██╗██║░░░░░██║██╔══╝░░██║╚████║░░░██║░░░
    //      ███████╗██████╔╝██║░░░██║░░░  ╚█████╔╝███████╗██║███████╗██║░╚███║░░░██║░░░
    //      ╚══════╝╚═════╝░╚═╝░░░╚═╝░░░  ░╚════╝░╚══════╝╚═╝╚══════╝╚═╝░░╚══╝░░░╚═╝░░░
    public static void showEditClient()
    {
        Functions.prepareMenu(Lang.editClientMenu);

        int id = ReadClient.existingClientId();
        Client c = Get.getClient(id);

        String newName = c.getName();
        String newCity = c.getCity();
        int newBirthYear = c.getBirthYear();

        System.out.println(Lang.editClientName);
        if (Functions.readBoolean())
        {
            newName = ReadClient.clientName();
        }
        System.out.println(Lang.editClientCity);
        if (Functions.readBoolean())
        {
            newCity = ReadClient.clientCity();
        }
        System.out.println(Lang.editClientBirthYear);
        if (Functions.readBoolean())
        {
            newBirthYear = ReadClient.clientBirthYear();
        }

        Client newClient = new Client(id, newName, newCity, newBirthYear);
        Data.clients.put(id, newClient);

        System.out.println(Lang.clientUpdatedSuccessfully);
    }
    //      ██████╗░███████╗███╗░░░███╗░█████╗░██╗░░░██╗███████╗  ░█████╗░██╗░░░░░██╗███████╗███╗░░██╗████████╗
    //      ██╔══██╗██╔════╝████╗░████║██╔══██╗██║░░░██║██╔════╝  ██╔══██╗██║░░░░░██║██╔════╝████╗░██║╚══██╔══╝
    //      ██████╔╝█████╗░░██╔████╔██║██║░░██║╚██╗░██╔╝█████╗░░  ██║░░╚═╝██║░░░░░██║█████╗░░██╔██╗██║░░░██║░░░
    //      ██╔══██╗██╔══╝░░██║╚██╔╝██║██║░░██║░╚████╔╝░██╔══╝░░  ██║░░██╗██║░░░░░██║██╔══╝░░██║╚████║░░░██║░░░
    //      ██║░░██║███████╗██║░╚═╝░██║╚█████╔╝░░╚██╔╝░░███████╗  ╚█████╔╝███████╗██║███████╗██║░╚███║░░░██║░░░
    //      ╚═╝░░╚═╝╚══════╝╚═╝░░░░░╚═╝░╚════╝░░░░╚═╝░░░╚══════╝  ░╚════╝░╚══════╝╚═╝╚══════╝╚═╝░░╚══╝░░░╚═╝░░░
    public static void showRemoveClient()
    {
        Functions.prepareMenu(Lang.removeClientMenu);

        int id = ReadClient.existingClientId();

        System.out.println(String.format(Lang.confirmClientDelete, id));
        if (Functions.readBoolean())
        {
            Data.clients.remove(id);

            System.out.println(Lang.clientDeletedSuccessfully);
        }
    }
}

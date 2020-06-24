package ProjetoTap;

import ProjetoTap.Data.Data;
import ProjetoTap.Data.Lang;
import ProjetoTap.Files.BinaryRead;
import ProjetoTap.Files.BinarySave;
import ProjetoTap.Files.TextRead;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import static ProjetoTap.Menus.ClientsMenu.showClientsMenu;
import static ProjetoTap.Menus.ProductsMenu.showProductsMenu;
import static ProjetoTap.Menus.SalesMenu.showSalesMenu;

public class Main
{
    //      ███╗░░░███╗░█████╗░██╗███╗░░██╗
    //      ████╗░████║██╔══██╗██║████╗░██║
    //      ██╔████╔██║███████║██║██╔██╗██║
    //      ██║╚██╔╝██║██╔══██║██║██║╚████║
    //      ██║░╚═╝░██║██║░░██║██║██║░╚███║
    //      ╚═╝░░░░░╚═╝╚═╝░░╚═╝╚═╝╚═╝░░╚══╝
    public static void main(String[] args)
    {
        // READ
        // READ PRODUCTS
        BinaryRead.readProducts();
        if (Data.products.size() == 0)
        {
            TextRead.readProducts();
        }
        // READ CLIENTS
        BinaryRead.readClients();
        if (Data.clients.size() == 0)
        {
            TextRead.readClients();
        }
        // READ SALES
        BinaryRead.readSales();
        if (Data.sales.size() == 0)
        {
            TextRead.readSales();
        }

        // SHOW THE MAIN MENU
        showMainMenu();

        // SAVE
        // SAVE PRODUCTS
        BinarySave.saveProducts();
        // SAVE CLIENTS
        BinarySave.saveClients();
        // SAVE SALES
        BinarySave.saveSales();
    }
    //      ██████╗░███████╗░█████╗░██████╗░  ███╗░░░███╗███████╗███╗░░██╗██╗░░░██╗  ░█████╗░██████╗░████████╗██╗░█████╗░███╗░░██╗
    //      ██╔══██╗██╔════╝██╔══██╗██╔══██╗  ████╗░████║██╔════╝████╗░██║██║░░░██║  ██╔══██╗██╔══██╗╚══██╔══╝██║██╔══██╗████╗░██║
    //      ██████╔╝█████╗░░███████║██║░░██║  ██╔████╔██║█████╗░░██╔██╗██║██║░░░██║  ██║░░██║██████╔╝░░░██║░░░██║██║░░██║██╔██╗██║
    //      ██╔══██╗██╔══╝░░██╔══██║██║░░██║  ██║╚██╔╝██║██╔══╝░░██║╚████║██║░░░██║  ██║░░██║██╔═══╝░░░░██║░░░██║██║░░██║██║╚████║
    //      ██║░░██║███████╗██║░░██║██████╔╝  ██║░╚═╝░██║███████╗██║░╚███║╚██████╔╝  ╚█████╔╝██║░░░░░░░░██║░░░██║╚█████╔╝██║░╚███║
    //      ╚═╝░░╚═╝╚══════╝╚═╝░░╚═╝╚═════╝░  ╚═╝░░░░░╚═╝╚══════╝╚═╝░░╚══╝░╚═════╝░  ░╚════╝░╚═╝░░░░░░░░╚═╝░░░╚═╝░╚════╝░╚═╝░░╚══╝
    public static Scanner sc = new Scanner(System.in);
    public static int readMenuOption(int min, int max)
    {
        try
        {
            int option = sc.nextInt();

            if (option < min || option > max)
            {
                System.out.println(Lang.errorInvalidMenuOption);
                sc.nextLine();
                return readMenuOption(min, max);
            }

            return option;
        }
        catch (Exception ignored)
        {
            System.out.println(Lang.errorWrongDataType);
            sc.nextLine();
            return readMenuOption(min, max);
        }
    }
    //      ██████╗░███████╗░█████╗░██████╗░  ░██████╗████████╗██████╗░██╗███╗░░██╗░██████╗░
    //      ██╔══██╗██╔════╝██╔══██╗██╔══██╗  ██╔════╝╚══██╔══╝██╔══██╗██║████╗░██║██╔════╝░
    //      ██████╔╝█████╗░░███████║██║░░██║  ╚█████╗░░░░██║░░░██████╔╝██║██╔██╗██║██║░░██╗░
    //      ██╔══██╗██╔══╝░░██╔══██║██║░░██║  ░╚═══██╗░░░██║░░░██╔══██╗██║██║╚████║██║░░╚██╗
    //      ██║░░██║███████╗██║░░██║██████╔╝  ██████╔╝░░░██║░░░██║░░██║██║██║░╚███║╚██████╔╝
    //      ╚═╝░░╚═╝╚══════╝╚═╝░░╚═╝╚═════╝░  ╚═════╝░░░░╚═╝░░░╚═╝░░╚═╝╚═╝╚═╝░░╚══╝░╚═════╝░
    public static String readString() throws IOException
    {
        String my_String;

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        my_String = br.readLine();

        return my_String;
    }
    //      ░██████╗██╗░░██╗░█████╗░░██╗░░░░░░░██╗  ███╗░░░███╗░█████╗░██╗███╗░░██╗  ███╗░░░███╗███████╗███╗░░██╗██╗░░░██╗
    //      ██╔════╝██║░░██║██╔══██╗░██║░░██╗░░██║  ████╗░████║██╔══██╗██║████╗░██║  ████╗░████║██╔════╝████╗░██║██║░░░██║
    //      ╚█████╗░███████║██║░░██║░╚██╗████╗██╔╝  ██╔████╔██║███████║██║██╔██╗██║  ██╔████╔██║█████╗░░██╔██╗██║██║░░░██║
    //      ░╚═══██╗██╔══██║██║░░██║░░████╔═████║░  ██║╚██╔╝██║██╔══██║██║██║╚████║  ██║╚██╔╝██║██╔══╝░░██║╚████║██║░░░██║
    //      ██████╔╝██║░░██║╚█████╔╝░░╚██╔╝░╚██╔╝░  ██║░╚═╝░██║██║░░██║██║██║░╚███║  ██║░╚═╝░██║███████╗██║░╚███║╚██████╔╝
    //      ╚═════╝░╚═╝░░╚═╝░╚════╝░░░░╚═╝░░░╚═╝░░  ╚═╝░░░░░╚═╝╚═╝░░╚═╝╚═╝╚═╝░░╚══╝  ╚═╝░░░░░╚═╝╚══════╝╚═╝░░╚══╝░╚═════╝░
    public static void showMainMenu()
    {
        int option;
        do
        {
            Functions.prepareMenu(Lang.mainMenu);

            System.out.println(Lang.colorYellow + "0. " + Lang.exit + Lang.colorReset);
            System.out.println(Lang.colorGreen + "1. " + Lang.manageProductsMenu + Lang.colorReset);
            System.out.println(Lang.colorGreen + "2. " + Lang.manageClientsMenu + Lang.colorReset);
            System.out.println(Lang.colorGreen + "3. " + Lang.manageSalesMenu + Lang.colorReset);
            System.out.println(Lang.colorYellow + Lang.pick + Lang.colorReset);

            option = readMenuOption(0, 3);
            switch (option)
            {
                case 0:
                    break;
                case 1: // MANAGE PRODUCTS
                    showProductsMenu();
                    break;
                case 2: // MANAGE CLIENTS
                    showClientsMenu();
                    break;
                case 3: // MANAGE SALES
                    showSalesMenu();
                    break;
            }
        } while (option != 0);
    }
}

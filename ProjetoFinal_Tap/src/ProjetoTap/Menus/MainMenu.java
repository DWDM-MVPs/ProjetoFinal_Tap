package ProjetoTap.Menus;

import ProjetoTap.Data.Lang;
import ProjetoTap.Functions;

import java.util.ArrayList;

import static ProjetoTap.Menus.BackupsMenu.showBackupsMenu;
import static ProjetoTap.Menus.ClientsMenu.showClientsMenu;
import static ProjetoTap.Menus.ProductsMenu.showProductsMenu;
import static ProjetoTap.Menus.SalesMenu.showSalesMenu;

public class MainMenu
{
    //      ░██████╗██╗░░██╗░█████╗░░██╗░░░░░░░██╗  ███╗░░░███╗███████╗███╗░░██╗██╗░░░██╗
    //      ██╔════╝██║░░██║██╔══██╗░██║░░██╗░░██║  ████╗░████║██╔════╝████╗░██║██║░░░██║
    //      ╚█████╗░███████║██║░░██║░╚██╗████╗██╔╝  ██╔████╔██║█████╗░░██╔██╗██║██║░░░██║
    //      ░╚═══██╗██╔══██║██║░░██║░░████╔═████║░  ██║╚██╔╝██║██╔══╝░░██║╚████║██║░░░██║
    //      ██████╔╝██║░░██║╚█████╔╝░░╚██╔╝░╚██╔╝░  ██║░╚═╝░██║███████╗██║░╚███║╚██████╔╝
    //      ╚═════╝░╚═╝░░╚═╝░╚════╝░░░░╚═╝░░░╚═╝░░  ╚═╝░░░░░╚═╝╚══════╝╚═╝░░╚══╝░╚═════╝░
    public static void showMainMenu()
    {
        int option;
        do
        {
            ArrayList<String> options = new ArrayList<String>()
            {{
                add(Lang.manageProductsMenu);
                add(Lang.manageClientsMenu);
                add(Lang.manageSalesMenu);
                add(Lang.backupsMenu);
            }};

            option = Functions.printMenu(Lang.mainMenu, options, true);
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
                case 4: // MANAGE BACKUPS
                    showBackupsMenu();
                    break;
            }
        } while (option != 0);
    }
}

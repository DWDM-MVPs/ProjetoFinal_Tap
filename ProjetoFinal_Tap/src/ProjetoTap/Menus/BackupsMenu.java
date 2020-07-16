package ProjetoTap.Menus;

import ProjetoTap.Data.Data;
import ProjetoTap.Data.Lang;
import ProjetoTap.Data.Settings;
import ProjetoTap.Files.BinarySave;
import ProjetoTap.Files.TextRead;
import ProjetoTap.Files.TextSave;
import ProjetoTap.Functions;
import ProjetoTap.Structures.Client;
import ProjetoTap.Structures.Product;
import ProjetoTap.Structures.Sale;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Map;

import static ProjetoTap.Main.sc;

public class BackupsMenu
{
    //      ░██████╗██╗░░██╗░█████╗░░██╗░░░░░░░██╗  ███╗░░░███╗███████╗███╗░░██╗██╗░░░██╗
    //      ██╔════╝██║░░██║██╔══██╗░██║░░██╗░░██║  ████╗░████║██╔════╝████╗░██║██║░░░██║
    //      ╚█████╗░███████║██║░░██║░╚██╗████╗██╔╝  ██╔████╔██║█████╗░░██╔██╗██║██║░░░██║
    //      ░╚═══██╗██╔══██║██║░░██║░░████╔═████║░  ██║╚██╔╝██║██╔══╝░░██║╚████║██║░░░██║
    //      ██████╔╝██║░░██║╚█████╔╝░░╚██╔╝░╚██╔╝░  ██║░╚═╝░██║███████╗██║░╚███║╚██████╔╝
    //      ╚═════╝░╚═╝░░╚═╝░╚════╝░░░░╚═╝░░░╚═╝░░  ╚═╝░░░░░╚═╝╚══════╝╚═╝░░╚══╝░╚═════╝░
    public static void showBackupsMenu()
    {
        int option;
        do
        {
            ArrayList<String> options = new ArrayList<String>()
            {{
                add(Lang.makeBackupMenu);
                add(Lang.restoreBackupMenu);
            }};

            option = Functions.printMenu(Lang.backupsMenu, options, true);
            switch (option)
            {
                case 1: // MAKE BACKUP
                    showMakeBackup();
                    break;
                case 2: // RESTORE BACKUP
                    showRestoreBackup();
                    break;
            }
        } while (option != 0);
    }
    //      ███╗░░░███╗░█████╗░██╗░░██╗███████╗  ██████╗░░█████╗░░█████╗░██╗░░██╗██╗░░░██╗██████╗░
    //      ████╗░████║██╔══██╗██║░██╔╝██╔════╝  ██╔══██╗██╔══██╗██╔══██╗██║░██╔╝██║░░░██║██╔══██╗
    //      ██╔████╔██║███████║█████═╝░█████╗░░  ██████╦╝███████║██║░░╚═╝█████═╝░██║░░░██║██████╔╝
    //      ██║╚██╔╝██║██╔══██║██╔═██╗░██╔══╝░░  ██╔══██╗██╔══██║██║░░██╗██╔═██╗░██║░░░██║██╔═══╝░
    //      ██║░╚═╝░██║██║░░██║██║░╚██╗███████╗  ██████╦╝██║░░██║╚█████╔╝██║░╚██╗╚██████╔╝██║░░░░░
    //      ╚═╝░░░░░╚═╝╚═╝░░╚═╝╚═╝░░╚═╝╚══════╝  ╚═════╝░╚═╝░░╚═╝░╚════╝░╚═╝░░╚═╝░╚═════╝░╚═╝░░░░░
    public static void showMakeBackup()
    {
        Functions.prepareMenu(Lang.makeBackupMenu);

        if (Data.products.isEmpty() && Data.clients.isEmpty() && Data.sales.isEmpty())
        {
            System.out.println(Lang.errorNoDataToBackup);
        }
        else if (Functions.yesOrNo(Lang.makeBackupConfirmation))
        {
            int option;

            ArrayList<String> options = new ArrayList<String>()
            {{
                if (!Data.products.isEmpty()) add(Lang.productsBackup);
                if (!Data.clients.isEmpty()) add(Lang.clientsBackup);
                if (!Data.sales.isEmpty())  add(Lang.salesBackup);
                if (!Data.products.isEmpty() && !Data.clients.isEmpty() || !Data.products.isEmpty() && !Data.sales.isEmpty() || !Data.clients.isEmpty() && !Data.sales.isEmpty()) add(Lang.generalBackup);
                add(Lang.cancel);
            }};

            System.out.println(Lang.chooseBackupType);
            option = Functions.printMenu(null, options, false);
            switch (option)
            {
                case 0:
                    return;
                case 1: // PRODUCTS BACKUP
                    backupProducts();
                    break;
                case 2: // CLIENTS BACKUP
                    backupClients();
                    break;
                case 3: // SALES BACKUP
                    backupSales();
                    break;
                case 4: // GENERAL BACKUP
                    backupProducts();
                    backupClients();
                    backupSales();
                    break;
            }
        }

        Functions.pressEnterToContinue();
    }
    private static void backupProducts()
    {
        int savedProducts = TextSave.saveProducts();

        System.out.println(savedProducts < 0 ? Lang.errorCreatingProductsBackup : MessageFormat.format(Lang.xProductsBackedUp, savedProducts));
    }
    private static void backupClients()
    {
        int savedClients = TextSave.saveClients();

        System.out.println(savedClients < 0 ? Lang.errorCreatingClientsBackup : MessageFormat.format(Lang.xClientsBackedUp, savedClients));
    }
    private static void backupSales()
    {
        int savedSales = TextSave.saveSales();

        System.out.println(savedSales < 0 ? Lang.errorCreatingSalesBackup : MessageFormat.format(Lang.xSalesBackedUp, savedSales));
    }
    //      ██████╗░███████╗░██████╗████████╗░█████╗░██████╗░███████╗  ██████╗░░█████╗░░█████╗░██╗░░██╗██╗░░░██╗██████╗░
    //      ██╔══██╗██╔════╝██╔════╝╚══██╔══╝██╔══██╗██╔══██╗██╔════╝  ██╔══██╗██╔══██╗██╔══██╗██║░██╔╝██║░░░██║██╔══██╗
    //      ██████╔╝█████╗░░╚█████╗░░░░██║░░░██║░░██║██████╔╝█████╗░░  ██████╦╝███████║██║░░╚═╝█████═╝░██║░░░██║██████╔╝
    //      ██╔══██╗██╔══╝░░░╚═══██╗░░░██║░░░██║░░██║██╔══██╗██╔══╝░░  ██╔══██╗██╔══██║██║░░██╗██╔═██╗░██║░░░██║██╔═══╝░
    //      ██║░░██║███████╗██████╔╝░░░██║░░░╚█████╔╝██║░░██║███████╗  ██████╦╝██║░░██║╚█████╔╝██║░╚██╗╚██████╔╝██║░░░░░
    //      ╚═╝░░╚═╝╚══════╝╚═════╝░░░░╚═╝░░░░╚════╝░╚═╝░░╚═╝╚══════╝  ╚═════╝░╚═╝░░╚═╝░╚════╝░╚═╝░░╚═╝░╚═════╝░╚═╝░░░░░
    public static void showRestoreBackup()
    {
        Functions.prepareMenu(Lang.restoreBackupMenu);

        if (Functions.yesOrNo(Lang.restoreBackupConfirmation) && Functions.yesOrNo(Lang.areYouReallySureYouWantToDoThis))
        {
            System.out.println(Lang.insertBackupPath);
            do
            {
                String backupFile = sc.next();
                File f = new File(backupFile);

                if (f.exists())
                {
                    try
                    {
                        String line;
                        BufferedReader bf = new BufferedReader(new FileReader(Settings.clientsTextPath));

                        if ((line = bf.readLine()) != null)
                        {
                            if (line.toLowerCase().contains("products backup"))
                            {
                                Map<Integer, Product> productsRollback = Data.products;
                                Data.products.clear();
                                int restoredProducts = TextRead.readProducts();
                                if (restoredProducts < 0)
                                {
                                    System.out.println(MessageFormat.format(Lang.errorReadingBackupFile, Lang.productsMenu));
                                    Data.products.clear();
                                    Data.products = productsRollback;
                                }
                                else
                                {
                                    BinarySave.saveProducts();
                                    System.out.println(MessageFormat.format(Lang.backupRestoredSuccessfullyRestored, Lang.productsMenu, restoredProducts));
                                }
                            }
                            else if (line.toLowerCase().contains("clients backup"))
                            {
                                Map<Integer, Client> clientsRollback = Data.clients;
                                Data.clients.clear();
                                int restoredClients = TextRead.readClients();
                                if (restoredClients < 0)
                                {
                                    System.out.println(MessageFormat.format(Lang.errorWhileReadingBackupFile, Lang.clientsMenu));
                                    Data.clients.clear();
                                    Data.clients = clientsRollback;
                                }
                                else
                                {
                                    BinarySave.saveClients();
                                    System.out.println(MessageFormat.format(Lang.backupRestoredSuccessfullyRestored, Lang.clientsMenu, restoredClients));
                                }
                            }
                            else if (line.toLowerCase().contains("sales backup"))
                            {
                                Map<Integer, Sale> salesRollback = Data.sales;
                                Data.sales.clear();
                                int restoredSales = TextRead.readSales();
                                if (restoredSales < 0)
                                {
                                    System.out.println(MessageFormat.format(Lang.errorWhileReadingBackupFile, Lang.salesMenu));
                                    Data.sales.clear();
                                    Data.sales = salesRollback;
                                }
                                else
                                {
                                    BinarySave.saveSales();
                                    System.out.println(MessageFormat.format(Lang.backupRestoredSuccessfullyRestored, Lang.salesMenu, restoredSales));
                                }
                            }
                        }
                    }
                    catch(Exception ignored)
                    {
                        System.out.println(Lang.errorReadingBackupFile);
                    }
                }

            } while (Functions.yesOrNo(Lang.searchForAnotherBackupFile));
        }

        Functions.pressEnterToContinue();
    }
}

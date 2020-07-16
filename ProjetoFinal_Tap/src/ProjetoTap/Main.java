package ProjetoTap;

import ProjetoTap.Data.Lang;
import ProjetoTap.Files.BinaryRead;
import ProjetoTap.Files.BinarySave;
import ProjetoTap.Files.TextRead;
import ProjetoTap.Files.TextSave;
import ProjetoTap.Menus.MainMenu;
import sun.plugin2.message.Message;

import java.text.MessageFormat;
import java.util.Scanner;

public class Main
{
    // SCANNER
    public static Scanner sc = new Scanner(System.in);
    //      ███╗░░░███╗░█████╗░██╗███╗░░██╗
    //      ████╗░████║██╔══██╗██║████╗░██║
    //      ██╔████╔██║███████║██║██╔██╗██║
    //      ██║╚██╔╝██║██╔══██║██║██║╚████║
    //      ██║░╚═╝░██║██║░░██║██║██║░╚███║
    //      ╚═╝░░░░░╚═╝╚═╝░░╚═╝╚═╝╚═╝░░╚══╝
    public static void main(String[] args)
    {
        // LOAD MENU
        Functions.prepareMenu(Lang.loadingData);
        // LOAD
        int loadedProducts = BinaryRead.readProducts();
        int loadedClients = BinaryRead.readClients();
        int loadedSales = BinaryRead.readSales();
        // PRINT LOAD INFO
        System.out.println(loadedProducts < 0 ? Lang.errorLoadingProducts : MessageFormat.format(Lang.xProductsLoaded, loadedProducts));
        System.out.println(loadedClients < 0 ? Lang.errorLoadingClients : MessageFormat.format(Lang.xClientsLoaded, loadedClients));
        System.out.println(loadedSales < 0 ? Lang.errorLoadingSales : MessageFormat.format(Lang.xSalesLoaded, loadedSales));
        // LOAD SUCCESSFUL MESSAGE
        System.out.println("\n" + (loadedProducts < 0 && loadedClients < 0 && loadedSales < 0 ? Lang.errorLoadingData : Lang.dataLoaded));
        Functions.pressEnterToContinue();

        // SHOW THE MAIN MENU
        MainMenu.showMainMenu();

        // SAVE MENU
        Functions.prepareMenu(Lang.savingData);
        // SAVE
        int savedProducts = BinarySave.saveProducts();
        int savedClients = BinarySave.saveClients();
        int savedSales = BinarySave.saveSales();
        // PRINT SAVE INFO
        System.out.println(savedProducts < 0 ? Lang.errorSavingProducts : MessageFormat.format(Lang.xProductsSaved, savedProducts));
        System.out.println(savedClients < 0 ? Lang.errorSavingClients : MessageFormat.format(Lang.xClientsSaved, savedClients));
        System.out.println(savedSales < 0 ? Lang.errorSavingSales : MessageFormat.format(Lang.xSalesSaved, savedSales));
        // SAVE SUCCESSFUL MESSAGE
        System.out.println("\n" + (savedProducts < 0 && savedClients < 0 && savedSales < 0 ? Lang.errorSavingData : Lang.dataSaved));
        Functions.pressEnterToContinue();
    }
}

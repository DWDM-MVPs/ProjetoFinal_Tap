package ProjetoTap.Data;

public class Settings
{
    //      ███████╗██╗██╗░░░░░███████╗░██████╗
    //      ██╔════╝██║██║░░░░░██╔════╝██╔════╝
    //      █████╗░░██║██║░░░░░█████╗░░╚█████╗░
    //      ██╔══╝░░██║██║░░░░░██╔══╝░░░╚═══██╗
    //      ██║░░░░░██║███████╗███████╗██████╔╝
    //      ╚═╝░░░░░╚═╝╚══════╝╚══════╝╚═════╝░
    public static String filesDirectory = "data";



    public static String productsTextPath = filesDirectory + "\\products.txt";
    public static String productsBinaryPath = filesDirectory + "\\products.bin";

    public static String clientsTextPath = filesDirectory + "\\clients.txt";
    public static String clientsBinaryPath = filesDirectory + "\\clients.bin";

    public static String salesTextPath = filesDirectory + "\\sales.txt";
    public static String salesBinaryPath = filesDirectory + "\\sales.bin";
    //      ██╗░░░██╗░█████╗░██╗░░░░░██╗██████╗░░█████╗░████████╗██╗░█████╗░███╗░░██╗░██████╗
    //      ██║░░░██║██╔══██╗██║░░░░░██║██╔══██╗██╔══██╗╚══██╔══╝██║██╔══██╗████╗░██║██╔════╝
    //      ╚██╗░██╔╝███████║██║░░░░░██║██║░░██║███████║░░░██║░░░██║██║░░██║██╔██╗██║╚█████╗░
    //      ░╚████╔╝░██╔══██║██║░░░░░██║██║░░██║██╔══██║░░░██║░░░██║██║░░██║██║╚████║░╚═══██╗
    //      ░░╚██╔╝░░██║░░██║███████╗██║██████╔╝██║░░██║░░░██║░░░██║╚█████╔╝██║░╚███║██████╔╝
    //      ░░░╚═╝░░░╚═╝░░╚═╝╚══════╝╚═╝╚═════╝░╚═╝░░╚═╝░░░╚═╝░░░╚═╝░╚════╝░╚═╝░░╚══╝╚═════╝░
    public static int minimumAge = 18;
    public static int maximumAge = 125;
}

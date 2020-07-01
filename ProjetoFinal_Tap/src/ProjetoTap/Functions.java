package ProjetoTap;

import ProjetoTap.Data.Lang;

import java.io.File;
import java.util.Calendar;
import java.util.Map;

import static ProjetoTap.Main.sc;

public class Functions
{
    //      ░██████╗░███████╗███╗░░██╗███████╗██████╗░░█████╗░████████╗███████╗  ██╗██████╗░
    //      ██╔════╝░██╔════╝████╗░██║██╔════╝██╔══██╗██╔══██╗╚══██╔══╝██╔════╝  ██║██╔══██╗
    //      ██║░░██╗░█████╗░░██╔██╗██║█████╗░░██████╔╝███████║░░░██║░░░█████╗░░  ██║██║░░██║
    //      ██║░░╚██╗██╔══╝░░██║╚████║██╔══╝░░██╔══██╗██╔══██║░░░██║░░░██╔══╝░░  ██║██║░░██║
    //      ╚██████╔╝███████╗██║░╚███║███████╗██║░░██║██║░░██║░░░██║░░░███████╗  ██║██████╔╝
    //      ░╚═════╝░╚══════╝╚═╝░░╚══╝╚══════╝╚═╝░░╚═╝╚═╝░░╚═╝░░░╚═╝░░░╚══════╝  ╚═╝╚═════╝░
    public static int generateId(Map map)
    {
        int id = 0;

        do
        {
            id++;
        } while (map.containsKey(id));

        return id;
    }
    //      ██████╗░░█████╗░███████╗░██████╗  ███████╗██╗██╗░░░░░███████╗  ███████╗██╗░░██╗██╗░██████╗████████╗
    //      ██╔══██╗██╔══██╗██╔════╝██╔════╝  ██╔════╝██║██║░░░░░██╔════╝  ██╔════╝╚██╗██╔╝██║██╔════╝╚══██╔══╝
    //      ██║░░██║██║░░██║█████╗░░╚█████╗░  █████╗░░██║██║░░░░░█████╗░░  █████╗░░░╚███╔╝░██║╚█████╗░░░░██║░░░
    //      ██║░░██║██║░░██║██╔══╝░░░╚═══██╗  ██╔══╝░░██║██║░░░░░██╔══╝░░  ██╔══╝░░░██╔██╗░██║░╚═══██╗░░░██║░░░
    //      ██████╔╝╚█████╔╝███████╗██████╔╝  ██║░░░░░██║███████╗███████╗  ███████╗██╔╝╚██╗██║██████╔╝░░░██║░░░
    //      ╚═════╝░░╚════╝░╚══════╝╚═════╝░  ╚═╝░░░░░╚═╝╚══════╝╚══════╝  ╚══════╝╚═╝░░╚═╝╚═╝╚═════╝░░░░╚═╝░░░
    public static boolean doesFileExist(String filePath)
    {
        File file = new File(filePath);

        return file.exists() && file.isFile();
    }
    //      ██████╗░██████╗░███████╗██████╗░░█████╗░██████╗░███████╗  ███╗░░░███╗███████╗███╗░░██╗██╗░░░██╗
    //      ██╔══██╗██╔══██╗██╔════╝██╔══██╗██╔══██╗██╔══██╗██╔════╝  ████╗░████║██╔════╝████╗░██║██║░░░██║
    //      ██████╔╝██████╔╝█████╗░░██████╔╝███████║██████╔╝█████╗░░  ██╔████╔██║█████╗░░██╔██╗██║██║░░░██║
    //      ██╔═══╝░██╔══██╗██╔══╝░░██╔═══╝░██╔══██║██╔══██╗██╔══╝░░  ██║╚██╔╝██║██╔══╝░░██║╚████║██║░░░██║
    //      ██║░░░░░██║░░██║███████╗██║░░░░░██║░░██║██║░░██║███████╗  ██║░╚═╝░██║███████╗██║░╚███║╚██████╔╝
    //      ╚═╝░░░░░╚═╝░░╚═╝╚══════╝╚═╝░░░░░╚═╝░░╚═╝╚═╝░░╚═╝╚══════╝  ╚═╝░░░░░╚═╝╚══════╝╚═╝░░╚══╝░╚═════╝░
    public static void prepareMenu(String menuName)
    {
        for (int i = 0; i < 100; i++)
        {
            System.out.println();
        }

        System.out.println(Lang.colorCyan + "< ======= # " + menuName.toUpperCase() + " # ======= >"  + Lang.colorReset);
    }
    //      ░██████╗░███████╗████████╗  ░█████╗░██╗░░░██╗██████╗░██████╗░███████╗███╗░░██╗████████╗  ██╗░░░██╗███████╗░█████╗░██████╗░
    //      ██╔════╝░██╔════╝╚══██╔══╝  ██╔══██╗██║░░░██║██╔══██╗██╔══██╗██╔════╝████╗░██║╚══██╔══╝  ╚██╗░██╔╝██╔════╝██╔══██╗██╔══██╗
    //      ██║░░██╗░█████╗░░░░░██║░░░  ██║░░╚═╝██║░░░██║██████╔╝██████╔╝█████╗░░██╔██╗██║░░░██║░░░  ░╚████╔╝░█████╗░░███████║██████╔╝
    //      ██║░░╚██╗██╔══╝░░░░░██║░░░  ██║░░██╗██║░░░██║██╔══██╗██╔══██╗██╔══╝░░██║╚████║░░░██║░░░  ░░╚██╔╝░░██╔══╝░░██╔══██║██╔══██╗
    //      ╚██████╔╝███████╗░░░██║░░░  ╚█████╔╝╚██████╔╝██║░░██║██║░░██║███████╗██║░╚███║░░░██║░░░  ░░░██║░░░███████╗██║░░██║██║░░██║
    //      ░╚═════╝░╚══════╝░░░╚═╝░░░  ░╚════╝░░╚═════╝░╚═╝░░╚═╝╚═╝░░╚═╝╚══════╝╚═╝░░╚══╝░░░╚═╝░░░  ░░░╚═╝░░░╚══════╝╚═╝░░╚═╝╚═╝░░╚═╝
    public static int getCurrentYear()
    {
        return Calendar.getInstance().get(Calendar.YEAR);
    }
    //      ███████╗██████╗░██████╗░░█████╗░██████╗░  ██████╗░███████╗░██████╗███████╗████████╗
    //      ██╔════╝██╔══██╗██╔══██╗██╔══██╗██╔══██╗  ██╔══██╗██╔════╝██╔════╝██╔════╝╚══██╔══╝
    //      █████╗░░██████╔╝██████╔╝██║░░██║██████╔╝  ██████╔╝█████╗░░╚█████╗░█████╗░░░░░██║░░░
    //      ██╔══╝░░██╔══██╗██╔══██╗██║░░██║██╔══██╗  ██╔══██╗██╔══╝░░░╚═══██╗██╔══╝░░░░░██║░░░
    //      ███████╗██║░░██║██║░░██║╚█████╔╝██║░░██║  ██║░░██║███████╗██████╔╝███████╗░░░██║░░░
    //      ╚══════╝╚═╝░░╚═╝╚═╝░░╚═╝░╚════╝░╚═╝░░╚═╝  ╚═╝░░╚═╝╚══════╝╚═════╝░╚══════╝░░░╚═╝░░░
    public static void errorReset(String message)
    {
        System.out.println(message);
        sc.nextLine();
    }
    //      ██████╗░███████╗░█████╗░██████╗░  ██████╗░░█████╗░░█████╗░██╗░░░░░███████╗░█████╗░███╗░░██╗
    //      ██╔══██╗██╔════╝██╔══██╗██╔══██╗  ██╔══██╗██╔══██╗██╔══██╗██║░░░░░██╔════╝██╔══██╗████╗░██║
    //      ██████╔╝█████╗░░███████║██║░░██║  ██████╦╝██║░░██║██║░░██║██║░░░░░█████╗░░███████║██╔██╗██║
    //      ██╔══██╗██╔══╝░░██╔══██║██║░░██║  ██╔══██╗██║░░██║██║░░██║██║░░░░░██╔══╝░░██╔══██║██║╚████║
    //      ██║░░██║███████╗██║░░██║██████╔╝  ██████╦╝╚█████╔╝╚█████╔╝███████╗███████╗██║░░██║██║░╚███║
    //      s╚═╝░░╚═╝╚══════╝╚═╝░░╚═╝╚═════╝░  ╚═════╝░░╚════╝░░╚════╝░╚══════╝╚══════╝╚═╝░░╚═╝╚═╝░░╚══╝
    public static boolean readBoolean()
    {
        try
        {
            String cont = sc.next();

            if (cont.toLowerCase().equals("y") || cont.toLowerCase().equals("n"))
            {
                return cont.toLowerCase().equals("y");
            }
            else
            {
                errorReset(Lang.errorInvalidBooleanOption);
                return readBoolean();
            }
        }
        catch (Exception ignored)
        {
            errorReset(Lang.errorWrongDataType);
            return readBoolean();
        }
    }
    //      ██████╗░██████╗░███████╗░██████╗░██████╗  ░█████╗░███╗░░██╗██╗░░░██╗  ██╗░░██╗███████╗██╗░░░██╗  ████████╗░█████╗░  ░█████╗░░█████╗░███╗░░██╗████████╗██╗███╗░░██╗██╗░░░██╗███████╗
    //      ██╔══██╗██╔══██╗██╔════╝██╔════╝██╔════╝  ██╔══██╗████╗░██║╚██╗░██╔╝  ██║░██╔╝██╔════╝╚██╗░██╔╝  ╚══██╔══╝██╔══██╗  ██╔══██╗██╔══██╗████╗░██║╚══██╔══╝██║████╗░██║██║░░░██║██╔════╝
    //      ██████╔╝██████╔╝█████╗░░╚█████╗░╚█████╗░  ███████║██╔██╗██║░╚████╔╝░  █████═╝░█████╗░░░╚████╔╝░  ░░░██║░░░██║░░██║  ██║░░╚═╝██║░░██║██╔██╗██║░░░██║░░░██║██╔██╗██║██║░░░██║█████╗░░
    //      ██╔═══╝░██╔══██╗██╔══╝░░░╚═══██╗░╚═══██╗  ██╔══██║██║╚████║░░╚██╔╝░░  ██╔═██╗░██╔══╝░░░░╚██╔╝░░  ░░░██║░░░██║░░██║  ██║░░██╗██║░░██║██║╚████║░░░██║░░░██║██║╚████║██║░░░██║██╔══╝░░
    //      ██║░░░░░██║░░██║███████╗██████╔╝██████╔╝  ██║░░██║██║░╚███║░░░██║░░░  ██║░╚██╗███████╗░░░██║░░░  ░░░██║░░░╚█████╔╝  ╚█████╔╝╚█████╔╝██║░╚███║░░░██║░░░██║██║░╚███║╚██████╔╝███████╗
    //      ╚═╝░░░░░╚═╝░░╚═╝╚══════╝╚═════╝░╚═════╝░  ╚═╝░░╚═╝╚═╝░░╚══╝░░░╚═╝░░░  ╚═╝░░╚═╝╚══════╝░░░╚═╝░░░  ░░░╚═╝░░░░╚════╝░  ░╚════╝░░╚════╝░╚═╝░░╚══╝░░░╚═╝░░░╚═╝╚═╝░░╚══╝░╚═════╝░╚══════╝
    public static void pressAnyKeyToContinue()
    {
        System.out.println("\n\n" + Lang.pressAnyKeyToContinue);

        try
        {
            System.in.read();
        }
        catch (Exception ignored) { }
    }
}

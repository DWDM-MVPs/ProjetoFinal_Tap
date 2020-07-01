package ProjetoTap.UserInput;

import ProjetoTap.Data.Data;
import ProjetoTap.Data.Settings;
import ProjetoTap.Functions;
import ProjetoTap.Data.Lang;

import java.text.MessageFormat;

import static ProjetoTap.Functions.errorReset;
import static ProjetoTap.Main.readString;
import static ProjetoTap.Main.sc;

public class ReadClient
{
    //      ░█████╗░██╗░░░░░██╗███████╗███╗░░██╗████████╗  ██╗██████╗░
    //      ██╔══██╗██║░░░░░██║██╔════╝████╗░██║╚══██╔══╝  ██║██╔══██╗
    //      ██║░░╚═╝██║░░░░░██║█████╗░░██╔██╗██║░░░██║░░░  ██║██║░░██║
    //      ██║░░██╗██║░░░░░██║██╔══╝░░██║╚████║░░░██║░░░  ██║██║░░██║
    //      ╚█████╔╝███████╗██║███████╗██║░╚███║░░░██║░░░  ██║██████╔╝
    //      ░╚════╝░╚══════╝╚═╝╚══════╝╚═╝░░╚══╝░░░╚═╝░░░  ╚═╝╚═════╝░
    public static int clientId(boolean canAlreadyExist)
    {
        System.out.println(Lang.readClientId);
        try
        {
            int code = sc.nextInt();

            if (!canAlreadyExist && Data.clients.containsKey(code))
            {
                errorReset(MessageFormat.format(Lang.readWrongClientId, code));
                return clientId(false);
            }
            return code;
        }
        catch (Exception ignored)
        {
            errorReset(Lang.errorWrongDataType);
            return clientId(canAlreadyExist);
        }
    }
    //      ░█████╗░██╗░░░░░██╗███████╗███╗░░██╗████████╗  ███╗░░██╗░█████╗░███╗░░░███╗███████╗
    //      ██╔══██╗██║░░░░░██║██╔════╝████╗░██║╚══██╔══╝  ████╗░██║██╔══██╗████╗░████║██╔════╝
    //      ██║░░╚═╝██║░░░░░██║█████╗░░██╔██╗██║░░░██║░░░  ██╔██╗██║███████║██╔████╔██║█████╗░░
    //      ██║░░██╗██║░░░░░██║██╔══╝░░██║╚████║░░░██║░░░  ██║╚████║██╔══██║██║╚██╔╝██║██╔══╝░░
    //      ╚█████╔╝███████╗██║███████╗██║░╚███║░░░██║░░░  ██║░╚███║██║░░██║██║░╚═╝░██║███████╗
    //      ░╚════╝░╚══════╝╚═╝╚══════╝╚═╝░░╚══╝░░░╚═╝░░░  ╚═╝░░╚══╝╚═╝░░╚═╝╚═╝░░░░░╚═╝╚══════╝
    public static String clientName()
    {
        System.out.println(Lang.readClientName);
        try
        {
            return readString();
        }
        catch (Exception ignored)
        {
            errorReset(Lang.errorWrongDataType);
            return clientName();
        }
    }
    //      ░█████╗░██╗░░░░░██╗███████╗███╗░░██╗████████╗  ░█████╗░██╗████████╗██╗░░░██╗
    //      ██╔══██╗██║░░░░░██║██╔════╝████╗░██║╚══██╔══╝  ██╔══██╗██║╚══██╔══╝╚██╗░██╔╝
    //      ██║░░╚═╝██║░░░░░██║█████╗░░██╔██╗██║░░░██║░░░  ██║░░╚═╝██║░░░██║░░░░╚████╔╝░
    //      ██║░░██╗██║░░░░░██║██╔══╝░░██║╚████║░░░██║░░░  ██║░░██╗██║░░░██║░░░░░╚██╔╝░░
    //      ╚█████╔╝███████╗██║███████╗██║░╚███║░░░██║░░░  ╚█████╔╝██║░░░██║░░░░░░██║░░░
    //      ░╚════╝░╚══════╝╚═╝╚══════╝╚═╝░░╚══╝░░░╚═╝░░░  ░╚════╝░╚═╝░░░╚═╝░░░░░░╚═╝░░░
    public static String clientCity()
    {
        System.out.println(Lang.readClientCity);
        try
        {
            return readString();
        }
        catch (Exception ignored)
        {
            errorReset(Lang.errorWrongDataType);
            return clientCity();
        }
    }
    //      ░█████╗░██╗░░░░░██╗███████╗███╗░░██╗████████╗  ██████╗░██╗██████╗░████████╗██╗░░██╗  ██╗░░░██╗███████╗░█████╗░██████╗░
    //      ██╔══██╗██║░░░░░██║██╔════╝████╗░██║╚══██╔══╝  ██╔══██╗██║██╔══██╗╚══██╔══╝██║░░██║  ╚██╗░██╔╝██╔════╝██╔══██╗██╔══██╗
    //      ██║░░╚═╝██║░░░░░██║█████╗░░██╔██╗██║░░░██║░░░  ██████╦╝██║██████╔╝░░░██║░░░███████║  ░╚████╔╝░█████╗░░███████║██████╔╝
    //      ██║░░██╗██║░░░░░██║██╔══╝░░██║╚████║░░░██║░░░  ██╔══██╗██║██╔══██╗░░░██║░░░██╔══██║  ░░╚██╔╝░░██╔══╝░░██╔══██║██╔══██╗
    //      ╚█████╔╝███████╗██║███████╗██║░╚███║░░░██║░░░  ██████╦╝██║██║░░██║░░░██║░░░██║░░██║  ░░░██║░░░███████╗██║░░██║██║░░██║
    //      ░╚════╝░╚══════╝╚═╝╚══════╝╚═╝░░╚══╝░░░╚═╝░░░  ╚═════╝░╚═╝╚═╝░░╚═╝░░░╚═╝░░░╚═╝░░╚═╝  ░░░╚═╝░░░╚══════╝╚═╝░░╚═╝╚═╝░░╚═╝
    public static int clientBirthYear()
    {
        System.out.println(Lang.readClientBirthYear);
        try
        {
            int number = sc.nextInt();

            if (Functions.getCurrentYear() - number < Settings.minimumAge || Functions.getCurrentYear() - number > Settings.maximumAge)
            {
                errorReset(Lang.readWrongClientBirthYear);
                return clientBirthYear();
            }

            return number;
        }
        catch (Exception ignored)
        {
            errorReset(Lang.errorWrongDataType);
            return clientBirthYear();
        }
    }
    //      ███████╗██╗░░██╗██╗░██████╗████████╗██╗███╗░░██╗░██████╗░  ░█████╗░██╗░░░░░██╗███████╗███╗░░██╗████████╗  ██╗██████╗░
    //      ██╔════╝╚██╗██╔╝██║██╔════╝╚══██╔══╝██║████╗░██║██╔════╝░  ██╔══██╗██║░░░░░██║██╔════╝████╗░██║╚══██╔══╝  ██║██╔══██╗
    //      █████╗░░░╚███╔╝░██║╚█████╗░░░░██║░░░██║██╔██╗██║██║░░██╗░  ██║░░╚═╝██║░░░░░██║█████╗░░██╔██╗██║░░░██║░░░  ██║██║░░██║
    //      ██╔══╝░░░██╔██╗░██║░╚═══██╗░░░██║░░░██║██║╚████║██║░░╚██╗  ██║░░██╗██║░░░░░██║██╔══╝░░██║╚████║░░░██║░░░  ██║██║░░██║
    //      ███████╗██╔╝╚██╗██║██████╔╝░░░██║░░░██║██║░╚███║╚██████╔╝  ╚█████╔╝███████╗██║███████╗██║░╚███║░░░██║░░░  ██║██████╔╝
    //      ╚══════╝╚═╝░░╚═╝╚═╝╚═════╝░░░░╚═╝░░░╚═╝╚═╝░░╚══╝░╚═════╝░  ░╚════╝░╚══════╝╚═╝╚══════╝╚═╝░░╚══╝░░░╚═╝░░░  ╚═╝╚═════╝░
    public static int existingClientId()
    {
        System.out.println(Lang.existingClientId);
        try
        {
            int id = clientId(true);

            if (Data.clients.containsKey(id))
            {
                return id;
            }
            else
            {
                errorReset(Lang.errorNonexistentClientId);
                return existingClientId();
            }
        }
        catch (Exception ignored)
        {
            errorReset(Lang.errorWrongDataType);
            return existingClientId();
        }
    }
}

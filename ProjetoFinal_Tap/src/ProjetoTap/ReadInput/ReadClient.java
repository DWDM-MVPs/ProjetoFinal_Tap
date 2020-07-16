package ProjetoTap.ReadInput;

import ProjetoTap.Data.Data;
import ProjetoTap.Data.Lang;
import ProjetoTap.Data.Settings;
import ProjetoTap.Functions;

import java.text.MessageFormat;

import static ProjetoTap.Functions.errorReset;
import static ProjetoTap.Main.sc;

public class ReadClient
{
    //      ░█████╗░██╗░░░░░██╗███████╗███╗░░██╗████████╗  ██╗██████╗░
    //      ██╔══██╗██║░░░░░██║██╔════╝████╗░██║╚══██╔══╝  ██║██╔══██╗
    //      ██║░░╚═╝██║░░░░░██║█████╗░░██╔██╗██║░░░██║░░░  ██║██║░░██║
    //      ██║░░██╗██║░░░░░██║██╔══╝░░██║╚████║░░░██║░░░  ██║██║░░██║
    //      ╚█████╔╝███████╗██║███████╗██║░╚███║░░░██║░░░  ██║██████╔╝
    //      ░╚════╝░╚══════╝╚═╝╚══════╝╚═╝░░╚══╝░░░╚═╝░░░  ╚═╝╚═════╝░
    public static int clientId(boolean canAlreadyExist, String readMessage)
    {
        System.out.println(readMessage);
        try
        {
            int code = sc.nextInt();

            if (!canAlreadyExist && Data.clients.containsKey(code) || code <= 0)
            {
                errorReset(MessageFormat.format(Lang.readWrongClientId, code));
                return clientId(false, readMessage);
            }
            return code;
        }
        catch (Exception ignored)
        {
            errorReset(Lang.errorWrongDataType);
            return clientId(canAlreadyExist, readMessage);
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
            return Functions.readString();
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
            return Functions.readString();
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
        try
        {
            int id = clientId(true, Lang.readExistingClientId);

            if (Data.clients.containsKey(id))
            {
                return id;
            }
            else
            {
                errorReset(Lang.errorClientIdDoesNotExist);
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

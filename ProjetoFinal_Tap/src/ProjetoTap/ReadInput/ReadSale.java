package ProjetoTap.ReadInput;

import ProjetoTap.Data.Data;
import ProjetoTap.Data.Lang;

import static ProjetoTap.Functions.errorReset;
import static ProjetoTap.Main.sc;

public class ReadSale
{
    //      ███████╗██╗░░██╗██╗░██████╗████████╗██╗███╗░░██╗░██████╗░  ░██████╗░█████╗░██╗░░░░░███████╗  ██╗██████╗░
    //      ██╔════╝╚██╗██╔╝██║██╔════╝╚══██╔══╝██║████╗░██║██╔════╝░  ██╔════╝██╔══██╗██║░░░░░██╔════╝  ██║██╔══██╗
    //      █████╗░░░╚███╔╝░██║╚█████╗░░░░██║░░░██║██╔██╗██║██║░░██╗░  ╚█████╗░███████║██║░░░░░█████╗░░  ██║██║░░██║
    //      ██╔══╝░░░██╔██╗░██║░╚═══██╗░░░██║░░░██║██║╚████║██║░░╚██╗  ░╚═══██╗██╔══██║██║░░░░░██╔══╝░░  ██║██║░░██║
    //      ███████╗██╔╝╚██╗██║██████╔╝░░░██║░░░██║██║░╚███║╚██████╔╝  ██████╔╝██║░░██║███████╗███████╗  ██║██████╔╝
    //      ╚══════╝╚═╝░░╚═╝╚═╝╚═════╝░░░░╚═╝░░░╚═╝╚═╝░░╚══╝░╚═════╝░  ╚═════╝░╚═╝░░╚═╝╚══════╝╚══════╝  ╚═╝╚═════╝░
    public static int existingSaleId()
    {
        try
        {
            System.out.println(Lang.readExistingSaleId);
            int saleId = sc.nextInt();

            if (Data.sales.containsKey(saleId))
            {
                return saleId;
            }
            else
            {
                errorReset(Lang.errorSaleIdDoesNotExist);
                return existingSaleId();
            }
        }
        catch (Exception ignored)
        {
            errorReset(Lang.errorWrongDataType);
            return existingSaleId();
        }
    }
}

package ProjetoTap.Data;

public class Lang
{
    //      ░█████╗░░█████╗░██╗░░░░░░█████╗░██████╗░░██████╗
    //      ██╔══██╗██╔══██╗██║░░░░░██╔══██╗██╔══██╗██╔════╝
    //      ██║░░╚═╝██║░░██║██║░░░░░██║░░██║██████╔╝╚█████╗░
    //      ██║░░██╗██║░░██║██║░░░░░██║░░██║██╔══██╗░╚═══██╗
    //      ╚█████╔╝╚█████╔╝███████╗╚█████╔╝██║░░██║██████╔╝
    //      ░╚════╝░░╚════╝░╚══════╝░╚════╝░╚═╝░░╚═╝╚═════╝░
    public static final String colorReset = "\u001B[0m";

    public static final String colorBlack = "\u001B[30m";
    public static final String colorRed = "\u001B[31m";
    public static final String colorGreen = "\u001B[32m";
    public static final String colorYellow = "\u001B[33m";
    public static final String colorBlue = "\u001B[34m";
    public static final String colorPurple = "\u001B[35m";
    public static final String colorCyan = "\u001B[36m";
    public static final String colorWhite = "\u001B[37m";
    //      ███╗░░░███╗███████╗███╗░░██╗██╗░░░██╗░██████╗
    //      ████╗░████║██╔════╝████╗░██║██║░░░██║██╔════╝
    //      ██╔████╔██║█████╗░░██╔██╗██║██║░░░██║╚█████╗░
    //      ██║╚██╔╝██║██╔══╝░░██║╚████║██║░░░██║░╚═══██╗
    //      ██║░╚═╝░██║███████╗██║░╚███║╚██████╔╝██████╔╝
    //      ╚═╝░░░░░╚═╝╚══════╝╚═╝░░╚══╝░╚═════╝░╚═════╝░
    public static String mainMenu = "Menu Principal";
    public static String manageProductsMenu = "Gerir Produtos";
    public static String productsMenu = "Produtos";
    public static String manageClientsMenu = "Gerir Clientes";
    public static String manageSalesMenu = "Gerir Vendas";
    public static String oldestClientMenu = "Idade máxima dos Clientes";
    public static String averageClientAgeMenu = "Idade média dos Clientes";
    public static String clientViewPurchasesMenu = "Ver Compras de um Cliente";
    public static String mostSoldProductsMenu = "Produtos mais vendidos";
    public static String mostExpensiveProductMenu = "Produto mais caro";
    public static String categoriesWithMostSalesMenu = "Categorias com mais Vendas";
    public static String viewAgeModeMenu = "Moda da Idade dos Clientes";
    public static String viewClientsByCityMenu = "Ver Clientes por Cidade";
    public static String viewClientsByUpperAgeMenu = "Ver Clientes com Idade superior";
    public static String listOutOfStockMenu = "Produtos sem Stock";
    public static String clientsMenu = "Clientes";
    public static String listClientsMenu = "Listar Clientes";
    public static String viewIfExistsByNameMenu = "Ver se Cliente existe por Nome";
    public static String salesMenu = "Vendas";
    public static String makeSaleMenu = "Efetuar Venda";
    public static String createProductMenu = "Criar Produto";
    public static String createClientMenu = "Criar Cliente";
    public static String viewIfExistsByCodeMenu = "Ver se Cliente existe por Nome";
    public static String viewIfProductExistsByCodeMenu = "Ver se Produto existe por Código";
    public static String categoriesSizeMenu = "Produtos nas Categoria";
    public static String mostMoneySpentMenu = "Cliente com mais dinheiro gasto";
    public static String averagePricePerCategoryMenu = "Preço médio por Categoria";
    public static String addStockMenu = "Adicionar Stock";
    public static String editProductMenu = "Editar Produto";
    public static String editClientMenu = "Editar Cliente";
    public static String removeClientMenu = "Remover Cliente";
    public static String removeProductMenu = "Remover Produto";
    public static String removeStockMenu = "Remover Stock";
    public static String loadingData = "A carregar os dados...";
    public static String dataLoaded = colorGreen + "Dados carregados com sucesso!" + colorReset;
    public static String savingData = "A guardar os dados...";
    public static String dataSaved = colorGreen + "Dados guardados com sucesso!" + colorReset;
    public static String backupsMenu = "Gerir Backups";
    public static String makeBackupMenu = "Fazer Backup";
    public static String restoreBackupMenu = "Restaurar Backup";
    //      ░██████╗░███████╗███╗░░██╗███████╗██████╗░░█████╗░██╗░░░░░  ██╗░░░░░░█████╗░███╗░░██╗░██████╗░
    //      ██╔════╝░██╔════╝████╗░██║██╔════╝██╔══██╗██╔══██╗██║░░░░░  ██║░░░░░██╔══██╗████╗░██║██╔════╝░
    //      ██║░░██╗░█████╗░░██╔██╗██║█████╗░░██████╔╝███████║██║░░░░░  ██║░░░░░███████║██╔██╗██║██║░░██╗░
    //      ██║░░╚██╗██╔══╝░░██║╚████║██╔══╝░░██╔══██╗██╔══██║██║░░░░░  ██║░░░░░██╔══██║██║╚████║██║░░╚██╗
    //      ╚██████╔╝███████╗██║░╚███║███████╗██║░░██║██║░░██║███████╗  ███████╗██║░░██║██║░╚███║╚██████╔╝
    //      ░╚═════╝░╚══════╝╚═╝░░╚══╝╚══════╝╚═╝░░╚═╝╚═╝░░╚═╝╚══════╝  ╚══════╝╚═╝░░╚═╝╚═╝░░╚══╝░╚═════╝░
    public static String exit = "Sair";
    public static String cancel = "Cancelar";
    public static String buyProducts = "Efetuar venda de Produtos";
    public static String listProducts = "Lista de Produtos";
    public static String pick = "Escolha:";
    public static String productCreatedSuccessfully = colorGreen + "Produto criado com sucesso." + colorReset;
    public static String clientCreatedSuccessfully = colorGreen + "Cliente criado com sucesso." + colorReset;
    public static String saleCreated = colorGreen + "Venda criada com sucesso." + colorReset;
    public static String averagePricePerCategory = "Preço médio por Categoria:";
    public static String productUpdatedSuccessfully = colorGreen + "Produto atualizado com sucesso." + colorReset;
    public static String editProductName = "Editar Nome do Produto? (y/n):";
    public static String editProductCategory = "Editar Categoria do Produto? (y/n):";
    public static String editProductStock = "Editar Stock do Produto? (y/n):";
    public static String editProductPrice = "Editar Preço do Produto? (y/n):";
    public static String editClientName = "Editar Nome do Cliente? (y/n):";
    public static String editClientCity = "Editar Cidade do Cliente? (y/n):";
    public static String editClientBirthYear = "Editar Ano de Nascimento do Cliente? (y/n):";
    public static String clientUpdatedSuccessfully = colorGreen + "Cliente atualizado com sucesso." + colorReset;
    public static String clientDeletedSuccessfully = colorGreen + "Cliente apagado com sucesso." + colorReset;
    public static String productDeletedSuccessfully = colorGreen + "Produto apagado com sucesso." + colorReset;
    public static String pressAnyKeyToContinue = "Clique <ENTER> para continuar...";
    public static String makeBackupConfirmation = "Tem a certeza de que pretende fazer um novo Backup? (y/n):";
    public static String restoreBackupConfirmation = "Tem a certeza de que pretende restaurar esse Backup?" + colorRed + "\nTodos os dados atuais da categoria do Backup serão perdidos e os dados das outras categorias podem ficar inutilizáveis. (y/n):" + colorReset;
    public static String areYouReallySureYouWantToDoThis = "Tem mesmo a certeza de que pretende fazer isto?";
    public static String searchForAnotherBackupFile = "O ficheiro de Backup não foi encontrado ou é inválido. Deseja procurar novamente?";
    public static String insertBackupPath = "Insira o caminho do ficheiro de Backup a restaurar: ";
    public static String chooseBackupType = colorCyan + "Escolha o tipo de Backup:" + colorReset;
    public static String productsBackup = "Backup dos Produtos";
    public static String clientsBackup = "Backup dos Clientes";
    public static String salesBackup = "Backup das Vendas";
    public static String generalBackup = "Backup geral";
    //      ██████╗░███████╗░█████╗░██████╗░  ██╗░░░░░░█████╗░███╗░░██╗░██████╗░
    //      ██╔══██╗██╔════╝██╔══██╗██╔══██╗  ██║░░░░░██╔══██╗████╗░██║██╔════╝░
    //      ██████╔╝█████╗░░███████║██║░░██║  ██║░░░░░███████║██╔██╗██║██║░░██╗░
    //      ██╔══██╗██╔══╝░░██╔══██║██║░░██║  ██║░░░░░██╔══██║██║╚████║██║░░╚██╗
    //      ██║░░██║███████╗██║░░██║██████╔╝  ███████╗██║░░██║██║░╚███║╚██████╔╝
    //      ╚═╝░░╚═╝╚══════╝╚═╝░░╚═╝╚═════╝░  ╚══════╝╚═╝░░╚═╝╚═╝░░╚══╝░╚═════╝░
    public static String readProductCode = colorPurple + "Insira o Código do Produto (único):" + colorReset;
    public static String readWrongProductCode = colorRed + "Um Produto com o Código {0} já existe." + colorReset;
    public static String readProductName = colorPurple + "Insira o Nome do Produto:" + colorReset;
    public static String readProductCategory = colorPurple + "Insira a Categoria do Produto:" + colorReset;
    public static String readExistingClientId = colorPurple + "Insira o ID de um Cliente que já exista:" + colorReset;
    public static String readExistingProductCode = colorPurple + "Insira o Código de um Produto que já exista:" + colorReset;
    public static String readProductStock = colorPurple + "Insira a quantidade de Stock do Produto (igual a '0' ou maior):" + colorReset;
    public static String readProductPrice = colorPurple + "Insira o Preço do Produto (maior que 0):" + colorReset;
    public static String readWrongProductPrice = colorRed + "Um Preço menor ou igual a '0' não é válido." + colorReset;
    public static String readClientId = colorPurple + "Insira o ID do Cliente (único):" + colorReset;
    public static String readClientName = colorPurple + "Insira o Nome do Cliente:" + colorReset;
    public static String readClientCity = colorPurple + "Insira a Cidade do Cliente:" + colorReset;
    public static String readClientBirthYear = colorPurple + "Insira o Ano de Nascimento do Cliente:" + colorReset;
    public static String readWrongClientBirthYear = colorRed + "O Ano de Nascimento inserido não é valido." + colorReset;
    public static String addMoreProducts = colorPurple + "Adicionar mais produtos? (y/n):" + colorReset;
    //      ░██╗░░░░░░░██╗██╗████████╗██╗░░██╗  ██████╗░░█████╗░██████╗░░█████╗░███╗░░░███╗░██████╗
    //      ░██║░░██╗░░██║██║╚══██╔══╝██║░░██║  ██╔══██╗██╔══██╗██╔══██╗██╔══██╗████╗░████║██╔════╝
    //      ░╚██╗████╗██╔╝██║░░░██║░░░███████║  ██████╔╝███████║██████╔╝███████║██╔████╔██║╚█████╗░
    //      ░░████╔═████║░██║░░░██║░░░██╔══██║  ██╔═══╝░██╔══██║██╔══██╗██╔══██║██║╚██╔╝██║░╚═══██╗
    //      ░░╚██╔╝░╚██╔╝░██║░░░██║░░░██║░░██║  ██║░░░░░██║░░██║██║░░██║██║░░██║██║░╚═╝░██║██████╔╝
    //      ░░░╚═╝░░░╚═╝░░╚═╝░░░╚═╝░░░╚═╝░░╚═╝  ╚═╝░░░░░╚═╝░░╚═╝╚═╝░░╚═╝╚═╝░░╚═╝╚═╝░░░░░╚═╝╚═════╝░
    public static String readWrongClientId = "Um Cliente com o ID {0} já existe.";
    public static String oldestClientAge = "A Idade máxima dos Clientes é: {0}";
    public static String averageClientAge = "A Idade média dos Clientes é: {0}";
    public static String categoriesSizeList = "{0} - {1} produto/s";
    public static String outOfStock = "O Produto {0} ficou sem stock nesta venda.";
    public static String outOfStockProducts = "Produtos sem Stock: {0}";
    public static String clientsWithMoreAge = "Clientes com Idade superior a {0}:";
    public static String listedClient = " » ID: {0} | Nome: {1} | Cidade: {2} | Idade: {3}";
    public static String clientsInCity = "Cliente na cidade {0}:";
    public static String listedProductFoundByCode = "Produto com Código {0} encontrado: » Nome: {1} | Categoria: {2} | Stock: {3} | Preço: {4}";
    public static String listModeClientAge = "Moda da Idade dos Clientes: {0}";
    public static String mostSoldProducts = "Produtos mais vendidos ({0} vendas):";
    public static String viewIfExistsByName = "Clientes com o nome {0}:";
    public static String listedProductByMostSales = " » Código: {0} | Nome: {1} | Categoria: {2} | Stock: {3} | Preço: {4}";
    public static String listMostExpensiveProduct = "Primeiro Produto mais caro: Código: {0} | Nome: {1} | Categoria: {2} | Stock: {3} | Preço: {4}";
    public static String mostSoldCategories = "Categoria/s mais vendida/s ({0} vendas):";
    public static String listClientMostMoneySpent = "Cliente com mais dinheiro gasto ({0} €):\n » {1} (ID: {2}, Cidade: {3}, Idade: {4})";
    public static String confirmClientDelete = "Tem a certeza que pretende apagar o Cliente com ID {0}? Esta ação não pode ser revertida. (y/n):";
    public static String confirmProductDelete = "Tem a certeza que pretende apagar o Produto com Código {0}? Esta ação não pode ser revertida. (y/n):";
    public static String xProductsLoaded = colorGreen + "Produtos carregados com sucesso: " + colorWhite + "{0}" + colorGreen + "." + colorReset;
    public static String xClientsLoaded = colorGreen + "Clientes carregados com sucesso: " + colorWhite + "{0}" + colorGreen + "." + colorReset;
    public static String xSalesLoaded = colorGreen + "Vendas carregadas com sucesso: " + colorWhite + "{0}" + colorGreen + "." + colorReset;
    public static String xProductsSaved = colorGreen + "Produtos guardados com sucesso: " + colorWhite + " {0}" + colorGreen + "." + colorReset;
    public static String xClientsSaved = colorGreen + "Clientes guardados com sucesso: " + colorWhite + "{0}" + colorGreen + "." + colorReset;
    public static String xSalesSaved = colorGreen + "Vendas guardadas com sucesso: " + colorWhite + "{0}" + colorGreen + "." + colorReset;
    public static String salesOfClient = "Vendas para o Cliente: {0} (ID: {1})";
    public static String clientSaleListEntry = " » " + colorWhite + "{0}" + colorGreen + " de " + colorWhite + "{1}" + colorGreen + " por " + colorWhite + "{2}€" + colorReset;
    public static String backupRestoredSuccessfullyRestored = colorGreen + "Backup de " + colorWhite + "{0}" + colorWhite + " restaurado com sucesso! " + colorWhite + "{0}" + colorWhite + " restaurados: " + colorWhite + "{1}" + colorGreen + "." + colorReset;
    public static String xProductsBackedUp = colorGreen + "Efetuado o Backup a " + colorWhite + "{0}" + colorGreen + " Produtos com sucesso!";
    public static String xClientsBackedUp = colorGreen + "Efetuado o Backup a " + colorWhite + "{0}" + colorGreen + " Clientes com sucesso!";
    public static String xSalesBackedUp = colorGreen + "Efetuado o Backup a " + colorWhite + "{0}" + colorGreen + " Vendas com sucesso!";
    //      ███████╗██████╗░██████╗░░█████╗░██████╗░  ██╗░░░░░░█████╗░███╗░░██╗░██████╗░
    //      ██╔════╝██╔══██╗██╔══██╗██╔══██╗██╔══██╗  ██║░░░░░██╔══██╗████╗░██║██╔════╝░
    //      █████╗░░██████╔╝██████╔╝██║░░██║██████╔╝  ██║░░░░░███████║██╔██╗██║██║░░██╗░
    //      ██╔══╝░░██╔══██╗██╔══██╗██║░░██║██╔══██╗  ██║░░░░░██╔══██║██║╚████║██║░░╚██╗
    //      ███████╗██║░░██║██║░░██║╚█████╔╝██║░░██║  ███████╗██║░░██║██║░╚███║╚██████╔╝
    //      ╚══════╝╚═╝░░╚═╝╚═╝░░╚═╝░╚════╝░╚═╝░░╚═╝  ╚══════╝╚═╝░░╚═╝╚═╝░░╚══╝░╚═════╝░
    public static String errorUnknown = colorRed + "ERRO: Ocorreu um erro desconhecido." + colorReset;
    public static String errorWrongDataType = colorRed + "ERRO: Ocorreu um erro no tipo de dados recebido." + colorReset;
    public static String errorCreatingProduct =  colorRed + "ERRO: Ocorreu um erro ao criar o Produto." + colorReset;
    public static String errorCreatingClient = colorRed + "ERRO: Ocorreu um erro ao criar o Cliente." + colorReset;
    public static String errorNonexistentProductCode = colorRed + "ERRO: Esse Código de Produto não existe." + colorReset;
    public static String errorNonexistentClientId = colorRed + "ERRO: Esse ID de Cliente não existe." + colorReset;
    public static String errorInvalidMenuOption = colorRed + "ERRO: Essa opção não está no menu." + colorReset;
    public static String errorInvalidBooleanOption = colorRed + "ERRO: Escolha entre 'y' ou 'n'." + colorReset;
    public static String errorNotEnoughStock = colorRed + "ERRO: O Stock existente é menor que o Stock pedido." + colorReset;
    public static String errorClientHasNoSales = colorRed + "ERRO: O Cliente selecionado ainda não fez nenhuma Compra" + colorReset;
    public static String errorWrongClientAge = colorRed + "ERRO: A Idade introduzida não é válida." + colorReset;
    public static String errorLoadingProducts = colorRed + "ERRO: Ocorreu um problema ao carregar alguns Produtos." + colorReset;
    public static String errorLoadingClients = colorRed + "ERRO: Ocorreu um problema ao carregar alguns Clientes." + colorReset;
    public static String errorLoadingSales = colorRed + "ERRO: Ocorreu um problema ao carregar algumas vendas." + colorReset;
    public static String errorSavingProducts = colorRed + "ERRO: Ocorreu um problema ao guardar alguns Produtos." + colorReset;
    public static String errorSavingClients = colorRed + "ERRO: Ocorreu um problema ao guardar alguns Clientes." + colorReset;
    public static String errorSavingSales = colorRed + "ERRO: Ocorreu um problema ao guardar algumas vendas." + colorReset;
    public static String errorProductNotFound = colorRed + "ERRO: Produto não encontrado." + colorReset;
    public static String errorReadLowProductStock = colorRed + "ERRO: A quantidade em Stock tem de ser '0' ou maior." + colorReset;
    public static String errorReadLowOrNullProductStock = colorRed + "ERRO: A quantidade em Stock tem de ser maior que '0'." + colorReset;
    public static String errorInvalidRemoveStock = colorRed + "ERRO: A quantidade de Stock a remover não pode ser maior que a quantidade de Stock existente." + colorReset;
    public static String errorProductRefundDoesNotExist = colorRed + "ERRO: O Produto presente na venda não está registado. Este produto não será registado." + colorReset;
    public static String errorLoadingData = colorRed + "ERRO: Não foi possível carregar os dados." + colorReset;
    public static String errorSavingData = colorRed + "ERRO: Não foi possível guardar os dados." + colorReset;
    public static String errorReadingBackupFile = colorRed + "ERRO: Não foi possível ler o ficheiro de Backup. Os " + colorWhite + "{0}" + colorRed + " anteriores foram restaurados." + colorReset;
    public static String errorWhileReadingBackupFile = colorRed + "ERRO: Ocorreu um erro durante a leitura do ficheiro de Backup." + colorReset;
    public static String errorNoDataToBackup = colorRed + "ERRO: Não há dados para fazer Backup." + colorReset;
    public static String errorCreatingProductsBackup = colorRed + "ERRO: Ocorreu um erro ao fazer Backup dos Produtos." + colorReset;
    public static String errorCreatingClientsBackup = colorRed + "ERRO: Ocorreu um erro ao fazer Backup dos Clientes." + colorReset;
    public static String errorCreatingSalesBackup = colorRed + "ERRO: Ocorreu um erro ao fazer Backup das Vendas." + colorReset;
}

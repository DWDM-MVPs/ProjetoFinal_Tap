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
    //      ░██████╗░███████╗███╗░░██╗███████╗██████╗░░█████╗░██╗░░░░░  ██╗░░░░░░█████╗░███╗░░██╗░██████╗░
    //      ██╔════╝░██╔════╝████╗░██║██╔════╝██╔══██╗██╔══██╗██║░░░░░  ██║░░░░░██╔══██╗████╗░██║██╔════╝░
    //      ██║░░██╗░█████╗░░██╔██╗██║█████╗░░██████╔╝███████║██║░░░░░  ██║░░░░░███████║██╔██╗██║██║░░██╗░
    //      ██║░░╚██╗██╔══╝░░██║╚████║██╔══╝░░██╔══██╗██╔══██║██║░░░░░  ██║░░░░░██╔══██║██║╚████║██║░░╚██╗
    //      ╚██████╔╝███████╗██║░╚███║███████╗██║░░██║██║░░██║███████╗  ███████╗██║░░██║██║░╚███║╚██████╔╝
    //      ░╚═════╝░╚══════╝╚═╝░░╚══╝╚══════╝╚═╝░░╚═╝╚═╝░░╚═╝╚══════╝  ╚══════╝╚═╝░░╚═╝╚═╝░░╚══╝░╚═════╝░
    public static String exit = "Sair";
    public static String buyProducts = "Efetuar venda de Produtos";
    public static String viewIfExistsByName = "Clientes com o nome '{0}':";
    public static String existingProductCode = "Insira o Código de um Produto que já exista:";
    public static String existingClientId = "Insira o ID de um Cliente que já exista:";
    public static String listProducts = "Lista de Produtos";
    public static String pick = "Escolha:";
    public static String productCreatedSuccessfully = "Produto criado com sucesso.";
    public static String clientCreatedSuccessfully = "Cliente criado com sucesso.";
    public static String saleCreated = "Venda criada com sucesso.";
    public static String averagePricePerCategory = "Preço médio por Categoria:";
    public static String productUpdatedSuccessfully = "Produto atualizado com sucesso.";
    public static String editProductName = "Editar Nome do Produto? (y/n):";
    public static String editProductCategory = "Editar Categoria do Produto? (y/n):";
    public static String editProductStock = "Editar Stock do Produto? (y/n):";
    public static String editProductPrice = "Editar Preço do Produto? (y/n):";
    public static String editClientName = "Editar Nome do Cliente? (y/n):";
    public static String editClientCity = "Editar Cidade do Cliente? (y/n):";
    public static String editClientBirthYear = "Editar Ano de Nascimento do Cliente? (y/n):";
    public static String clientUpdatedSuccessfully = "Cliente atualizado com sucesso.";
    public static String clientDeletedSuccessfully = "Cliente apagado com sucesso.";
    public static String productDeletedSuccessfully = "Produto apagado com sucesso.";
    public static String pressAnyKeyToContinue = "Clique <ENTER> para continuar...";
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
    public static String mostSoldProductsMenu = "Produtos mais Vendidos";
    public static String mostExpensiveProductMenu = "Produto mais caro";
    public static String categoriesWithMostSalesMenu = "Categorias com mais Vendas";
    public static String viewAgeModeMenu = "Moda da Idade dos Clientes";
    public static String viewClientsByCityMenu = "Ver Clientes por Cidade";
    public static String viewClientsByUpperAgeMenu = "Ver Clientes com Idade superior";
    public static String listOutOfStockMenu = "Produtos sem Stock";
    public static String clientsMenu = "Clientes";
    public static String listClientsMenu = "Listar Clientes";
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
    //      ██████╗░███████╗░█████╗░██████╗░  ██╗░░░░░░█████╗░███╗░░██╗░██████╗░
    //      ██╔══██╗██╔════╝██╔══██╗██╔══██╗  ██║░░░░░██╔══██╗████╗░██║██╔════╝░
    //      ██████╔╝█████╗░░███████║██║░░██║  ██║░░░░░███████║██╔██╗██║██║░░██╗░
    //      ██╔══██╗██╔══╝░░██╔══██║██║░░██║  ██║░░░░░██╔══██║██║╚████║██║░░╚██╗
    //      ██║░░██║███████╗██║░░██║██████╔╝  ███████╗██║░░██║██║░╚███║╚██████╔╝
    //      ╚═╝░░╚═╝╚══════╝╚═╝░░╚═╝╚═════╝░  ╚══════╝╚═╝░░╚═╝╚═╝░░╚══╝░╚═════╝░
    public static String readProductCode = "Insira o Código do Produto (único):";
    public static String readWrongProductCode = "Um Produto com o Código '{0}' já existe.";
    public static String readProductName = "Insira o Nome do Produto:";
    public static String readProductCategory = "Insira a Categoria do Produto:";
    public static String readProductStock = "Insira a quantidade em Stock do Produto (igual a '0' ou maior):";
    public static String readProductPrice = "Insira o Preço do Produto (maior que 0):";
    public static String readWrongProductPrice = "Um Preço menor ou igual a '0' não é válido.";
    public static String readClientId = "Insira o ID do Cliente (único):";
    public static String readClientName = "Insira o Nome do Cliente:";
    public static String readClientCity = "Insira a Cidade do Cliente:";
    public static String readClientBirthYear = "Insira o Ano de Nascimento do Cliente:";
    public static String readWrongClientBirthYear = "O Ano de Nascimento inserido não é valido.";
    public static String addMoreProducts = "Adicionar mais produtos? (y/n):";
    //      ░██╗░░░░░░░██╗██╗████████╗██╗░░██╗  ██████╗░░█████╗░██████╗░░█████╗░███╗░░░███╗░██████╗
    //      ░██║░░██╗░░██║██║╚══██╔══╝██║░░██║  ██╔══██╗██╔══██╗██╔══██╗██╔══██╗████╗░████║██╔════╝
    //      ░╚██╗████╗██╔╝██║░░░██║░░░███████║  ██████╔╝███████║██████╔╝███████║██╔████╔██║╚█████╗░
    //      ░░████╔═████║░██║░░░██║░░░██╔══██║  ██╔═══╝░██╔══██║██╔══██╗██╔══██║██║╚██╔╝██║░╚═══██╗
    //      ░░╚██╔╝░╚██╔╝░██║░░░██║░░░██║░░██║  ██║░░░░░██║░░██║██║░░██║██║░░██║██║░╚═╝░██║██████╔╝
    //      ░░░╚═╝░░░╚═╝░░╚═╝░░░╚═╝░░░╚═╝░░╚═╝  ╚═╝░░░░░╚═╝░░╚═╝╚═╝░░╚═╝╚═╝░░╚═╝╚═╝░░░░░╚═╝╚═════╝░
    public static String readWrongClientId = "Um Cliente com o ID '{0}' já existe.";
    public static String oldestClientAge = "A Idade máxima dos Clientes é: {0}";
    public static String averageClientAge = "A Idade média dos Clientes é: {0}";
    public static String categoriesSizeList = "{0} - {1} produto/s";
    public static String outOfStock = "O Produto '{0}' ficou sem stock nesta venda.";
    public static String outOfStockProducts = "Produtos sem Stock: {0}";
    public static String listProductsForSaleForClient = "Produtos da Venda #{0} do Cliente com o ID '{1}'";
    public static String listedProductForSaleForClient = " » Código: {0} | Nome: {1} | Quantidade vendida: {2} | Lucro: {3}";
    public static String clientsWithMoreAge = "Clientes com Idade superior a '{0}':";
    public static String listedClient = " » ID: {0} | Nome: {1} | Cidade: {2} | Idade: {3}";
    public static String clientsInCity = "Cliente na cidade '{0}':";
    public static String listedProductFoundByCode = "Produto com Código '{0}' encontrado: » Nome: {1} | Categoria: {2} | Stock: {3} | Preço: {4}";
    public static String listModeClientAge = "Moda da Idade dos Clientes: {0}";
    public static String mostSoldProducts = "Produtos mais vendidos ({0} vendas):";
    public static String listedProductByMostSales = " » Código: {0} | Nome: {1} | Categoria: {2} | Stock: {3} | Preço: {4}";
    public static String listMostExpensiveProduct = "Primeiro Produto mais caro: Código: {0} | Nome: {1} | Categoria: {2} | Stock: {3} | Preço: {4}";
    public static String mostSoldCategories = "Categoria/s mais vendida/s ({0} vendas):";
    public static String listClientMostMoneySpent = "Cliente/s com mais dinheiro gasto ({0} €):";
    public static String listedClientMostMoneySpent = " » ID: {0} | Nome: {1} | Cidade: {2} | Idade: {3}";
    public static String confirmClientDelete = "Tem a certeza que pretende apagar o Cliente com ID '{0}'? Esta ação não pode ser revertida. (y/n):";
    public static String confirmProductDelete = "Tem a certeza que pretende apagar o Produto com Código '{0}'? Esta ação não pode ser revertida. (y/n):";
    public static String savedProductsAmount = "Produtos guardados com sucesso: {0}";
    public static String savedClientsAmount = "Clientes guardados com sucesso: {0}";
    public static String savedSalesAmount = "Vendas guardadas com sucesso: {0}";
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
    public static String errorNoProductsFound = colorReset + "ERRO: Nenhum Produto encontrado." + colorReset;
    public static String errorNoClientsFound = colorRed + "ERRO: Nenhum Cliente encontrado." + colorReset;
    public static String errorNoSalesFound = colorReset + "ERRO: Nenhuma Venda encontrada." + colorReset;
    public static String errorProductNotFound = colorRed + "ERRO: Produto não encontrado." + colorReset;
    public static String errorReadLowProductStock = colorRed + "ERRO: A quantidade em Stock tem de ser '0' ou maior." + colorReset;
    public static String errorReadLowOrNullProductStock = colorRed + "ERRO: A quantidade em Stock tem de ser maior que '0'." + colorReset;
    public static String errorInvalidRemoveStock = colorRed + "ERRO: A quantidade de Stock a remover não pode ser maior que a quantidade de Stock existente." + colorReset;
}

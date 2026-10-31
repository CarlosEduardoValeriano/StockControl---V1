import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner ler = new Scanner(System.in);

        int opcao = -1;

        double preco = 0;
        double valorBrutoEstoque = 0;
        double valorEstoque = 0;
        int codigoProduto;
        int quantidade;
        String nome;

        ArrayList<Produto> produtos = new ArrayList<>();

        while (opcao != 0) {

            System.out.println("==============================");
            System.out.println("    StockControl");
            System.out.println("Sistema de controle de estoque");
            System.out.println("===============================\n");
            System.out.println("1 - Cadastrar Produto");
            System.out.println("2 - Listar produtos");
            System.out.println("3 - Buscar produto");
            System.out.println("4 - Registrar entrada");
            System.out.println("5 - Registrar saida");
            System.out.println("6 - Consulta valor do estoque");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = ler.nextInt();

            ler.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("=== Cadastrar Produto ===");
                    System.out.println("Nome do produto: ");
                    nome = ler.nextLine().toLowerCase().trim();

                    System.out.println("Preço do produto: ");
                    preco = ler.nextDouble();

                    System.out.println("Codigo do produto: ");
                    codigoProduto = ler.nextInt();

                    System.out.println("Quantidade do produto: ");
                    quantidade = ler.nextInt();

                    Produto novoProduto = new Produto(codigoProduto, nome, preco, quantidade);
                    produtos.add(novoProduto);

                    break;
                case 2:
                    System.out.println("=== Listar Produtos ===");
                    if (produtos.size() <= 0) {
                        System.out.println("Nenhum Produto Cadastrado");
                    } else {
                        for (int index = 0; index < produtos.size(); index++) {

                            Produto produto = produtos.get(index);

                            System.out.printf("\nCodigo: %d | Nome: %s | Preço: %.2f | Quantidade: %d \n",
                                    produto.codigo,
                                    produto.nome, produto.preco, produto.quantidade);

                        }

                    }

                    break;
                case 3:
                    System.out.println("=== Buscar Produto ===");
                    if (produtos.size() <= 0) {
                        System.out.println("Nenhum Produto Cadastrado");
                    } else {
                        System.out.print("\n Insira o codigo do produto: ");
                        int codigoBusca = ler.nextInt();
                        for (int index = 0; index < produtos.size(); index++) {

                            Produto produto = produtos.get(index);

                            if (produto.codigo == codigoBusca) {
                                System.out.printf("\nCodigo: %d | Nome: %s | Preço: %.2f | Quantidade: %d \n",
                                        produto.codigo,
                                        produto.nome, produto.preco, produto.quantidade);

                            } else {
                                System.out.println("Codigo não encontrado");
                            }
                        }

                    }

                    break;
                case 4:
                    System.out.println("=== Adicionar estoque ===");
                    if (produtos.size() <= 0) {
                        System.out.println("Nenhum Produto Cadastrado");
                    } else {
                        System.out.print("\n Insira o codigo do produto: ");
                        int codigoBusca = ler.nextInt();
                        for (int index = 0; index < produtos.size(); index++) {

                            Produto produto = produtos.get(index);

                            if (produto.codigo == codigoBusca) {
                                System.out.printf("\nNome: %s| Quantidade: %d \n",
                                        produto.nome, produto.quantidade);

                                System.out.print("Adicionar Quanto ao estoque: ");
                                int entradaEstoque = ler.nextInt();

                                produto.quantidade += entradaEstoque;

                                System.out.println("Estoque Atualizado!");

                            } else {
                                System.out.println("Codigo não encontrado");
                            }
                        }

                    }
                    break;
                case 5:
                    System.out.println("=== Remover estoque ===");
                    if (produtos.size() <= 0) {
                        System.out.println("Nenhum Produto Cadastrado");
                    } else {
                        System.out.print("\n Insira o codigo do produto: ");
                        int codigoBusca = ler.nextInt();
                        for (int index = 0; index < produtos.size(); index++) {

                            Produto produto = produtos.get(index);

                            if (produto.codigo == codigoBusca) {
                                System.out.printf("\nNome: %s| Quantidade: %d \n",
                                        produto.nome, produto.quantidade);

                                System.out.print("Remover Quanto do estoque: ");
                                int saidaEstoque = ler.nextInt();

                                produto.quantidade -= saidaEstoque;

                                System.out.println("Estoque Atualizado!");

                            } else {
                                System.out.println("Codigo não encontrado");
                            }
                        }

                    }
                    break;
                case 6:
                    System.out.println("=== Valor Total do Estoque ===");
                    if (produtos.size() <= 0) {
                        System.out.println("Nenhum Produto Cadastrado");
                    } else {
                        for (int index = 0; index < produtos.size(); index++) {

                            Produto produto = produtos.get(index);

                            valorEstoque = produto.quantidade * produto.preco;
                            valorBrutoEstoque += valorEstoque;
                        }
                        System.out.println("Total: " + valorBrutoEstoque);
                        valorBrutoEstoque = 0;
                    }

                    break;
                case 0:
                    System.out.println("Finalizado!");
                    ler.close();
                    break;
                default:
                    System.out.println("Opção Invalida");
                    break;
            }

        }

    }
}

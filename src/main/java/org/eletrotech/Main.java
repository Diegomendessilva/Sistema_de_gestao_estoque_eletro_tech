package org.eletrotech;

import controller.FornecedorDAO;
import controller.FornecedorProdutoDAO;
import controller.MovimentacaoEstoqueDAO;
import controller.ProdutoDAO;
import model.Fornecedor;
import model.FornecedorProduto;
import model.MovimentacaoEstoque;
import model.Produto;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        ProdutoDAO produtoDao = new ProdutoDAO();
        FornecedorDAO fornecedorDao = new FornecedorDAO();
        FornecedorProdutoDAO fornecedorProdutoDao = new FornecedorProdutoDAO();
        MovimentacaoEstoqueDAO movimentacaoEstoqueDao = new MovimentacaoEstoqueDAO();

        boolean sair = false;
        while (!sair) {
            System.out.println("\u001B[33m" + "\nEscolha uma opção para operar:");
            System.out.println("\u001B[33m" + "\t\t1 - Produto");
            System.out.println("\u001B[33m" + "\t\t2 - Fornecedor");
            System.out.println("\u001B[33m" + "\t\t3 - FornecedorProduto");
            System.out.println("\u001B[33m" + "\t\t4 - MovimentacaoEstoque");
            System.out.println("\u001B[33m" + "\t\t0 - Sair");
            System.out.print("\u001B[33m" + "Opção: ");
            int opcao = scanner.nextInt();

            if (opcao == 0) {
                sair = true;
                break;
            }

            System.out.println("\u001B[32m" + "\nEscolha uma operação:");
            System.out.println("\u001B[32m" + "\t\t1 - Cadastrar");
            System.out.println("\u001B[32m" + "\t\t2 - Buscar Todos");
            System.out.println("\u001B[32m" + "\t\t3 - Buscar Um");
            System.out.println("\u001B[32m" + "\t\t4 - Atualizar");
            System.out.println("\u001B[32m" + "\t\t5 - Apagar");
            System.out.println("\u001B[32m" + "\t\t0 - Sair");
            System.out.print("\u001B[32m" + "Opção: ");
            int operacao = scanner.nextInt();

            if (opcao == 1) { // Produto
                if (operacao == 1) {
                    produtoDao.cadastrar();
                } else if (operacao == 2) {
                    System.out.println("+----------------------------------------------------------------------------------------------------------+");
                    System.out.println(String.format("| %-5s | %-20s | %-50s | %-20s |", "ID", "Nome".toUpperCase(), "Descrição".toUpperCase(), "Categoria".toUpperCase()));
                    System.out.println("+----------------------------------------------------------------------------------------------------------+");

                    for (Produto produto : produtoDao.buscarTodos()) {
                        System.out.println(produto);
                    }
                    System.out.println("+----------------------------------------------------------------------------------------------------------+");

                } else if (operacao == 3) {
                    System.out.print("Informe o ID do produto: ");
                    int id = scanner.nextInt();
                    System.out.println("+----------------------------------------------------------------------------------------------------------+");
                    System.out.println(String.format("| %-5s | %-20s | %-50s | %-20s |", "Id".toUpperCase(), "Nome".toUpperCase(), "Descrição".toUpperCase(), "Categoria".toUpperCase()));
                    System.out.println("+----------------------------------------------------------------------------------------------------------+");
                    System.out.println(produtoDao.buscarPorId(id));
                    System.out.println("+----------------------------------------------------------------------------------------------------------+");

                } else if (operacao == 4) {
                    System.out.print("Informe o ID do produto: ");
                    int id = scanner.nextInt();
                    System.out.print("[1] - Nome\n[2] - Descrição\n[3] - Categoria\nOpção: ");
                    opcao = scanner.nextInt();
                    String coluna = null;
                    if (opcao == 1) {
                        coluna = "Nome";
                    } else if (opcao == 2) {
                        coluna = "Descricao";

                    } else if (opcao == 3) {
                        coluna = "Categoria";
                    }
                    System.out.print("Informe a auteração: ");
                    scanner.nextLine();
                    String dado = scanner.nextLine();
                    produtoDao.atualizar(id, coluna, dado);
                    System.out.println("Produto alterado com sucesso!");
                }
            } else if (opcao == 2) { // Fornecedor
                if (operacao == 1) {
                    System.out.print("Informe o CNPJ ou CPF: ");
                    scanner.nextLine();
                    String cnpfCpf = scanner.nextLine();
                    System.out.print("Informe o nome do fornecedor: ");
                    String nome = scanner.nextLine();
                    System.out.print("Informe a Razao Social: ");
                    String razaoSocial = scanner.nextLine();

                    fornecedorDao.cadastrar(new Fornecedor(cnpfCpf, nome, razaoSocial));
                    System.out.println("\tFornecedor cadastrado com sucesso!");
                } else if (operacao == 2) {
                    System.out.println("\n+------------------------------------------------------------------------------------------------+");
                    System.out.println(String.format("| %-5s | %-20s | %-40s | %-20s |", "ID", "CNPJ CPF", "NOME", "RAZÃO SOCIAL"));
                    System.out.println("+------------------------------------------------------------------------------------------------+");

                    for (Fornecedor fornecedor : fornecedorDao.buscarTodos()) {
                        System.out.println(fornecedor);
                    }
                    System.out.println("+------------------------------------------------------------------------------------------------+\n");
                }


            } else if (opcao == 3) { // FornecedorProduto

                if (operacao == 1) { // Cadastrar fornecedor produto
                    System.out.print("Informe o ID do Produto: ");
                    int idProduto = scanner.nextInt();
                    System.out.print("Informe o ID do Fornecedor: ");
                    int idFornecedor = scanner.nextInt();

                    fornecedorProdutoDao.inserir(new FornecedorProduto(idProduto, idFornecedor));

                    System.out.println("Cadastrado com sucesso!");

                } else if (operacao == 2) { // Buscar todos
                    System.out.println("\n+--------------------------------------------------------------------------------------------------------+");
                    System.out.println(String.format("| %-5s | %-10s | %-30s | %-15s | %-30s |", "ID", "ID PRODUTO", "PRODUTO", "ID FORNECEDOR", "FORNECEDOR"));
                    System.out.println("+--------------------------------------------------------------------------------------------------------+");

                    for (FornecedorProduto fornecedorProduto : fornecedorProdutoDao.buscarTodos()) {
                        System.out.println(fornecedorProduto);
                    }
                    System.out.println("+--------------------------------------------------------------------------------------------------------+");

                } else if (operacao == 3) {
                    System.out.print("Informe o ID: ");
                    int id = scanner.nextInt();
                    System.out.println("\n+--------------------------------------------------------------------------------------------------------+");
                    System.out.println(String.format("| %-5s | %-10s | %-30s | %-15s | %-30s |", "ID", "ID PRODUTO", "PRODUTO", "ID FORNECEDOR", "FORNECEDOR"));
                    System.out.println("+--------------------------------------------------------------------------------------------------------+");
                    System.out.println(fornecedorProdutoDao.buscarPorId(id));
                    System.out.println("+--------------------------------------------------------------------------------------------------------+");
                }


            } else if (opcao == 4) { // MovimentacaoEstoque

                if (operacao == 2) {
                    System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------------------------------+");
                    System.out.println(String.format("| %-5s | %-30s | %-30s | %-10s | %-10s | %-20s |%-10s |%-10s |%-10s |", "ID","PRODUTO", "FORNECEDOR", "DATA", "QUANTIDADE", "TIPO MOVIMENTAÇÃO", "CUSTO", "LOTE", "VALIDADE"));
                    System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------------------------------+");

                    for (MovimentacaoEstoque movimentacaoEstoque : movimentacaoEstoqueDao.buscarTodos()) {
                        System.out.println(movimentacaoEstoque);
                    }
                    System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------------------------------+");

                }

                if (operacao == 3) {
                    System.out.print("Informe o ID: ");
                    int id = scanner.nextInt();
                    System.out.println("+---------------------------------------------------------------------------------------------------------+");
                    System.out.println(String.format("| %-5d | %-30s | %-30s |%-15s | %-15s | %-20s |%-15s |%-15s |%-15s |", "ID", "FORNECEDOR", "DATA", "QUANTIDADE", "TIPO MOVIMENTAÇÃO", "CUSTO", "LOTE", "VALIDADE"));
                    System.out.println("+---------------------------------------------------------------------------------------------------------+");
                    System.out.println(movimentacaoEstoqueDao.buscarPorId(id));
                    System.out.println("+---------------------------------------------------------------------------------------------------------+");
                }

            } else {
                System.out.println("Entidade inválida. Tente novamente.");
            }
        }

        scanner.close();
        System.out.println("Programa encerrado.");
    }
}

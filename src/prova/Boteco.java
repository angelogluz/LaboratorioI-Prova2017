/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prova;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author angeloluz
 */
public class Boteco {

    private List<Produto> produtos;
    private double caixa;
    private Scanner teclado;

    public Boteco() {
        produtos = new ArrayList();
        teclado = new Scanner(System.in);
        caixa = 1000.00;
    }

    public void init() {
        int var = 0;
        while (var != 9) {
            System.out.println("+===== Botequis do Mussum ======+");
            System.out.println("|1. Adicionar novo produto      |");
            System.out.println("|2. Pesquisar produto           |");
            System.out.println("|3. Realizar venda              |");
            System.out.println("|4. Listar produtos             |");
            System.out.println("|5. Verificar caixa             |");
            System.out.println("|9. Sair                        |");
            System.out.println("+===============================+");
            System.out.print("Escolha uma opção: ");
            var = teclado.nextInt();
            switch (var) {
                case 1:
                    adicionarProduto();
                    break;
                case 2:
                    teclado.nextLine();
                    System.out.print("Digite o nome do produto: ");
                    String nome = teclado.nextLine();
                    listarProdutosPorNome(nome);
                    break;
                case 3:
                    System.out.println("===== Cadastro de Venda ======");
                    listarProdutosCadastros();

                    while (true) {
                        System.out.println("Digite o código do produto: ");
                        int cod = teclado.nextInt();
                        Produto p = produtos.get(cod - 1);
                        System.out.println(p);
                        System.out.print("Digite a quantidade: ");
                        int quantidade = teclado.nextInt();
                        if (!p.baixarDoEstoque(quantidade)) {
                            System.out.println("Produto ou quantidade indisponível");
                        } else {
                            System.out.printf("%s - R$ %.2f x %d = %.2f\n", p.getNome(), p.getValorDeVenda(), quantidade,
                                    (quantidade * p.getValorDeVenda()));
                            caixa += quantidade * p.getValorDeVenda();
                        }
                        teclado.nextLine();
                        System.out.println("Tecle 'F' para finalizar ou <Enter> para continuar vendendo");
                        String cont = teclado.nextLine();
                        if (cont.equals("F")) {
                            break;
                        }
                    }
                    break;
                case 4:
                    listarProdutosCadastros();
                    break;
                case 5:
                    System.out.println("Valor em caixa: " + caixa);
                    break;
                case 9:
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }

    public void adicionarProduto() {
        String marca;
        String nome;
        int volume;
        int quantidade;
        double valorDeCompra;
        double valorDeVenda;
        Produto p = new Produto();
        Util.load("Buscando produtos já cadastrados", 3000);
        listarProdutosCadastros();
        System.out.println("<<Atenção>> Este cadastro é para novos produtos");
        System.out.println("===== Cadastro de Produto =====");
        teclado.nextLine();
        System.out.print("Marca........: ");
        marca = (teclado.nextLine());
        System.out.print("Nome.........: ");
        nome = (teclado.nextLine());
        System.out.print("Volume(ml)...: ");
        volume = (teclado.nextInt());
        System.out.print("Quantidade...: ");
        quantidade = (teclado.nextInt());
        if (isCadastrado(nome, marca, volume)) {
            System.out.println("Produto já está cadastrado no sistema");
            System.out.println("Cadastro cancelado");
        } else {
            System.out.print("Valor de compra.:");
            valorDeCompra = (teclado.nextDouble());
            System.out.printf("Valor de venda (Sugerido: %.2f): ", valorDeCompra * 1.30);
            valorDeVenda = (teclado.nextDouble());
            Util.load("Verificando valor em caixa", 4000);
            if (quantidade * valorDeCompra > caixa) {
                System.out.println("Compra cancelada por falta de recurso financeiro");
            } else {
                caixa -= quantidade * valorDeCompra;
                p.cadastrar(marca, nome, volume, valorDeCompra, valorDeVenda, quantidade);
                System.out.println("Compra registrada");
                produtos.add(p);
            }
        }
    }

    private void listarProdutosPorNome(String nome) {

        int codigo = 1;
        int reg = 0;
        for (Produto produto : produtos) {
            if (produto.getNome().equals(nome)) {
                System.out.println("<<" + codigo + ">> " + produto);
                reg++;
            }
            codigo++;
        }
        if (produtos.isEmpty() || reg == 0) {
            System.out.println("Ainda não há produtos cadastrados com esse nome");
        }
    }

    private void listarProdutosCadastros() {
        if (produtos.isEmpty()) {
            System.out.println("Ainda não há produtos cadastrados");
        }
        int contador = 1;
        for (Produto p : produtos) {
            System.out.printf("[%d] - %s %s - %dml\n", contador, p.getMarca(), p.getNome(),
                    p.getVolume());
            contador++;
        }
    }

    private boolean isCadastrado(String nome, String marca, int volume) {
        for (Produto produto : produtos) {
            if ((nome.equals(produto.getNome()))
                    && marca.equals(produto.getMarca())
                    && volume == produto.getVolume()) {
                return true;
            }
        }
        return false;
    }

    private Produto getProdutoCadastrado(String nome, String marca, int volume) {
        for (Produto produto : produtos) {
            if ((nome.equals(produto.getNome()))
                    && marca.equals(produto.getMarca())
                    && volume == produto.getVolume()) {
                return produto;
            }
        }
        return null;
    }

}

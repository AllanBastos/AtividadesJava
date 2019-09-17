package br.edu.ifpb.allan;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class UsaProcessadorProdutos
{
    public static void main(String[] args) {
        ArrayList<Produto> listaProdutos = new ArrayList<>(Arrays.asList(
            new Produto(1, "Feijão", 68),
            new Produto(2,"Arroz", 100),
            new Produto(3,"Balde", 78),
            new Produto(4,"Prego", 91),
            new Produto(5,"Luva", 87),
            new Produto(6,"Caixa", 94),
            new Produto(7,"Molho", 83),
            new Produto(8,"Sal", 85),
            new Produto(9,"Açúcar", 76),
            new Produto(10,"Farinha", 81)
        ));
       ProcessadorProdutos p = new ProcessadorProdutos(listaProdutos);
       p.mostrarGraficoDistribuicaoPrecos();
    }
}

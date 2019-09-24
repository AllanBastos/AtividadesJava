package br.edu.ifpb.allan;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class ProcessadorProdutos {
    private ArrayList<Produto> listaProdutos = null;

    public ProcessadorProdutos(ArrayList<Produto> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

    public double menorPreco(){
        double menor = 100000000;
        for(Produto ola : listaProdutos){
            if (ola.getPreco() < menor){
                menor = ola.getPreco();
            }
        }
        return menor;
    }

    public double maiorPreco(){
        double maior = 0;
        for(Produto eai : listaProdutos){
            if(eai.getPreco() > maior) maior = eai.getPreco();
        }
        return maior;
    }

    public double mediaPreco(){
        double soma = 0;
        double media = 0;

        for (Produto p: listaProdutos) {
            soma += p.getPreco();
        }

        media = soma / listaProdutos.size();

        return media;
    }

    public void mostrarGraficoDistribuicaoPrecos(){
        out.print(
                "Gráfico de Distribuição de Preços:\n" +
                "----------------------------------");
        for (int i = 0; i <= 9; i++) {
            out.printf("%n%1$d%2$d-%1$d%3$d:%4$s", i, 0, 9, asteristico(i*10, i*10 + 9));
        }
        out.printf("%n  100:%1$s", asteristico(100, 100));
        out.println("\n\nMenor Preço: " + menorPreco());
        out.println("Maior Preço: " + maiorPreco());
        out.println("Média dos Preços: " + mediaPreco());
    }

    private String asteristico(int i, int s){
        int contador = 0;

        for(Produto aux: listaProdutos) {
            if (aux.getPreco() >= i && aux.getPreco() <= s)
                contador++;
        }
        return "+".repeat(contador);
    }

}

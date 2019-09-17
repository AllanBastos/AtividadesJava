package br.edu.ifpb.allan;

import java.util.ArrayList;

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
        System.out.print(
                "Gráfico de Distribuição de Preços:\n" +
                "----------------------------------\n" +
                "00-09:");
        for (Produto aux : listaProdutos){
            if (aux.getPreco() < 9) System.out.print("+");
        }
        System.out.print("\n10-19:");
        for (Produto aux : listaProdutos){
            if (aux.getPreco() < 19 && aux.getPreco() > 10) System.out.print(" +");
        }
        System.out.print("\n20-29:");
        for (Produto aux : listaProdutos){
            if (aux.getPreco() < 29 && aux.getPreco() > 20) System.out.print(" +");
        }System.out.print("\n30-39:");
        for (Produto aux : listaProdutos){
            if (aux.getPreco() < 39 && aux.getPreco() > 30) System.out.print(" +");
        }
        System.out.print("\n40-49:");
        for (Produto aux : listaProdutos){
            if (aux.getPreco() < 49 && aux.getPreco() > 40) System.out.print(" +");
        }
        System.out.print("\n50-59:");
        for (Produto aux : listaProdutos){
            if (aux.getPreco() < 59 && aux.getPreco() > 50) System.out.print(" +");
        }System.out.print("\n60-69:");
        for (Produto aux : listaProdutos){
            if (aux.getPreco() < 69 && aux.getPreco() > 60) System.out.print(" +");
        }System.out.print("\n70-79:");
        for (Produto aux : listaProdutos){
            if (aux.getPreco() < 79 && aux.getPreco() > 70) System.out.print(" +");
        }System.out.print("\n80-89:");
        for (Produto aux : listaProdutos){
            if (aux.getPreco() < 89 && aux.getPreco() > 80) System.out.print(" +");
        }System.out.print("\n90-99:");
        for (Produto aux : listaProdutos){
            if (aux.getPreco() < 99 && aux.getPreco() > 90) System.out.print(" +");
        }System.out.print("\n  100:");
        for (Produto aux : listaProdutos){
            if (aux.getPreco() == 100) System.out.print(" +");
        }
        System.out.println("\n\nMenor Preço: " + menorPreco());
        System.out.println("Maior Preço: " + maiorPreco());
        System.out.println("Média dos Preços: " + mediaPreco());
    }

}

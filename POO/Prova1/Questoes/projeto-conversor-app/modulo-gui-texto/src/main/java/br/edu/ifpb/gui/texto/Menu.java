package br.edu.ifpb.gui.texto;

import br.edu.ifpb.conversor.Conversor;

import java.util.Scanner;

public class Menu {
    Scanner input = new Scanner(System.in);
    public void exibirMenu(Conversor c){
        while (true){
            System.out.print("Projeto Conversor\n" +
                    "-------------------\n" +
                    "1 - Decimal Binario\n" +
                    "2 - Decimal Hexadecimal\n" +
                    "3 - Sair\n" +
                    "selecione uma opção:_");

            int opcao = input.nextInt();

            switch (opcao){
                case 1:{
                    System.out.print("Digite um número: ");
                    int n = input.nextInt();
                    String convertido = c.decimalBinario(n);
                    System.out.println("O numero " + n + " em binario é: " + convertido);
                }break;
                case 2:{
                    System.out.print("Digite um número: ");
                    int n = input.nextInt();
                    String convertido = c.decimalHexadecimal(n);
                    System.out.println("O numero " + n + " em Hexadecimal é: " + convertido);
                }break;
                case 3: {
                    System.exit(0);
                }
                default:{
                    System.out.println("Opção Invalida tente novamente!");
                }
            }
        }
    }
}

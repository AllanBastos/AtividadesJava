package com.gmail.allanbastos.TUI;

import com.gmail.allanbastos.ContaCorrente;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class MENU {

    Locale locale = new Locale("pt", "BR");
    NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(locale);
    Scanner input = new Scanner(System.in);


    public void exibirmenu(ContaCorrente cc){
        while (true){
            System.out.print(
                    " ______________________________\n" +
                    "|    Projeto Conta Corrente    |\n" +
                    "|______________________________|\n" +
                    "|   1. Saque                   |\n" +
                    "|   2. Deposito                |\n" +
                    "|   3. Saldo na Tela           |\n" +
                    "|   4. Extrato na Tela         |\n" +
                    "|   5. Calcular CPMF           |\n" +
                    "|   6. Sair                    |\n" +
                    "|______________________________|\n" +
                    "   Digite uma opção:_");

            int opção = input.nextInt();

            switch (opção){
                case 1: {

                    System.out.print("Digite o Valor do Saque: ");
                    double valor = input.nextDouble();
                    if (valor == cc.getSaldo()) {
                        double juros = cc.calcularCPMF(valor);
                        double total = valor - juros;
                        System.out.println("O maximo que você pode sacar é " + formatoMoeda.format(total) + "\nTente Novamente!");
                        break;
                    }
                    else if (cc.Saque(valor)){
                        System.out.println("Sucesso!");
                    }
                    else System.out.println("Falha!");
                }break;

                case 2: {
                    System.out.print("Digite o valor do Deposito: R$");
                    double valor = input.nextDouble();
                    if (cc.Deposito(valor)){
                        System.out.println("Sucesso!");
                    }
                    else System.out.println("Falha!");
                }break;

                case 3: {
                    System.out.println("Seu Saldo é: " +  formatoMoeda.format(cc.saldo()));
                }break;

                case 4:{
                    System.out.println(cc);
                }break;

                case 5:{
                    System.out.print("Insira o valor: ");
                    double valor = input.nextDouble();
                    System.out.println("O taxa de CPMF é de: " + formatoMoeda.format(cc.calcularCPMF(valor)));
                }break;

                case 6:{
                    System.exit(0);
                }

                default:{
                    System.out.println("Opção Invalida!");
                }
            }
        }
    }

}

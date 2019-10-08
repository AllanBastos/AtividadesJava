package com.gmail.allanbastos.TUI;

import com.gmail.allanbastos.ContaCorrente;
import com.gmail.allanbastos.EntradaInválidaException;
import com.gmail.allanbastos.QuantiaNegativaException;
import com.gmail.allanbastos.SaldoInvalidoException;

import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
import static java.lang.System.*;

public class MENU {

    Locale locale = new Locale("pt", "BR");
    NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(locale);

    public void print(String msg) {
        out.print(msg);
    }

    public void println(String msg){
        out.println(msg);
    }

    public void exibirmenu(ContaCorrente cc){
        while (true){
            print(
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
            Scanner input = new Scanner(in);
            try{
                int opção = input.nextInt();
                switch (opção){
                    case 1: {
                        print("Digite o Valor do Saque: ");
                        try{
                            double valor = input.nextDouble();
                            if (valor < 0){
                                throw new QuantiaNegativaException();
                            }
                            try {
                                cc.Saque(valor);
                                println("Sucesso!");
                            }catch (SaldoInvalidoException sie) {
                                println("Erro " + sie.getMessage());
                                double juros = cc.calcularCPMF(cc.getSaldo());
                                double total = cc.getSaldo() - juros;
                                println("O maximo que você pode sacar é " + formatoMoeda.format(total) + "\nTente Novamente!");
                            }
                        }catch (QuantiaNegativaException | InputMismatchException qne){
                            println("Erro " + qne.getMessage());
                        }
                    }break;

                    case 2: {
                        out.print("Digite o valor do Deposito: R$");
                        try{
                            double valor = input.nextDouble();
                            cc.Deposito(valor);
                            println("Sucesso!");
                        }catch (QuantiaNegativaException | InputMismatchException qne){
                            println("Erro " + qne.getMessage());
                        }
                    }break;

                    case 3: {
                        out.println("Seu Saldo é: " +  formatoMoeda.format(cc.saldo()));
                    }break;

                    case 4:{
                        out.println(cc);
                    }break;

                    case 5:{
                        out.print("Insira o valor: ");
                        try {
                            double valor = input.nextDouble();
                            if (valor > 0) out.println("O taxa de CPMF é de: " + formatoMoeda.format(cc.calcularCPMF(valor)));
                            else throw new QuantiaNegativaException();
                        }catch (QuantiaNegativaException qne){
                            println("Erro " + qne.getMessage());
                        }
                    }break;

                    case 6:{
                        exit(0);
                    }

                    default:{
                        out.println("Opção Invalida!");
                    }
                }
            }catch (Exception e) {
                println("Erro entrada invalida!\nTente Novamente!");
            }
        }
    }
}

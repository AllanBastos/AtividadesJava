package com.gmail.allanbastos;

import java.util.Scanner;

public class MenuCalculadora {
    Scanner input = new Scanner(System.in);
    Calculadora c = new Calculadora();

    public void exibirMenu(){

     while (true) {
         System.out.printf("\n         CALCULADORA\n" +
                 "===============================\n" +
                 "   1. Somar\n" +
                 "   2. Subtrair\n" +
                 "   3. Multiplicar\n" +
                 "   4. Dividir\n" +
                 "   5. Sobre a Calculadora\n" +
                 "   6. Sair\n" +
                 "   Digite uma opção:_");

         Scanner input = new Scanner(System.in);

         int opção = input.nextInt();

         switch (opção) {
             case 1: {
                 double números[] = capturarNúmeros();

                 double resultado = c.somar(números[0], números[1]);

                 c.gravarMemória(resultado);

                 System.out.println("Resultado da Soma = " + resultado);
             }
             break;

             case 2: {
                 double números[] = capturarNúmeros();

                 double resultado = c.subitrair(números[0], números[1]);

                 c.gravarMemória(resultado);

                 System.out.println("Resultado da Subtração = " + resultado);
             }
             break;

             case 3: {
                 double números[] = capturarNúmeros();

                 double resultado = c.multiplicar(números[0], números[1]);

                 c.gravarMemória(resultado);

                 System.out.println("Resultado da Multiplicação = " + resultado);
             }
             break;

             case 4: {
                 double números[] = capturarNúmeros();

                 double resultado = c.dividir(números[0], números[1]);

                 c.gravarMemória(resultado);

                 System.out.println("Resultado da Divisão = " + resultado);
             }

             case 5: {
                 System.out.println(c.consultarDescrição());
             }
             break;

             case 6: {
                 System.exit(0);
             }
             default: {
                 System.out.print("Opção Inválida!");

             }

         }
     }

    }

    public double[] capturarNúmeros(){

        double lista[] = new double[2];

        System.out.print("Digite o Primeiro Número: ");
        double primeiroNúmero = input.nextDouble();

        System.out.print("Digite o Segundo Número: ");
        double segundoNúmero = input.nextDouble();

        lista[0] = primeiroNúmero;
        lista[1] = segundoNúmero;

        return lista;
    }
}

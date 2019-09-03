package com.google.allanbastos;


import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        System.out.print("Digite seu nome: ");

        Scanner input = new Scanner( System.in );

        String nome = input.nextLine();
        //System.out.printf( "O nome digitado foi: %s", nome );
        System.out.println( "O nome digitado foi: " + nome );
    }
}

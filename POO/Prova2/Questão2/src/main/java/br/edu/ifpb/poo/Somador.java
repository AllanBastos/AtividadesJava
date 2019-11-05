package br.edu.ifpb.poo;

public class Somador {
    public static void main(String[] args) {
        String[] NumerosPositivos;
        int soma = 0;

        for (int i = 0; i < args.length; i++) {
            int posição = Integer.parseInt(args[i]);
            if( posição < 0);
            else soma += posição;
        }

    }
}

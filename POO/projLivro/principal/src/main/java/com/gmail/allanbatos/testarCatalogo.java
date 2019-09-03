package com.gmail.allanbatos;

public class testarCatalogo {
    public static void main(String[] args) {
        catalogoLivros aventura = new catalogoLivros();
        catalogoLivros ficção = new catalogoLivros();
        catalogoLivros romance = new catalogoLivros();

        aventura.adcionar("A hora do pesadelo", "Wilian Bolkier", "RENASCER", 2005, 33508);
        aventura.adcionar("A hora do pesadelo 2", "Wilian Bolkier", "RENASCER", 2015, 33558);
        aventura.adcionar("Viagem ao centro da Terra", "Amanda Kusper", "PRAS", 1995, 25635);

        ficção.adcionar("Harry Potter e a pedra filosofal", "JK Rolings", "Abril", 1978, 554);

        System.out.println("Buscando...");

        System.out.println(aventura.buscar(33558));
        System.out.println(ficção.buscar(554));
        System.out.println(aventura.buscar(123));

        System.out.println("\nListando...");

        ficção.listarLivros();
        romance.listarLivros();
        aventura.listarLivros();

        System.out.println("\nRemovendo...");
        System.out.println(ficção.remover(554));

        System.out.println("\nListando novamente...");

        ficção.listarLivros();

        aventura.limparLista();

    }
}

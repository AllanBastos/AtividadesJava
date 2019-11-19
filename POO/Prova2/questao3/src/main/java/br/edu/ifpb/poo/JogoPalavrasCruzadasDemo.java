package br.edu.ifpb.poo;

import java.nio.file.Path;

public class JogoPalavrasCruzadasDemo {
    public static void main(String[] args) {
        JogoPalavrasCruzadas jogo = new JogoPalavrasCruzadas();
        jogo.lerPalavraDoArquivo(Path.of("/home/allan/JavaProject/AtividadesJava/POO/Prova2/questao3/src/main/java/br/edu/ifpb/poo/palavras.txt"));
        jogo.getMelhorPalavra();
        jogo.gravarMapaPalavras(Path.of("/home/allan/JavaProject/AtividadesJava/POO/Prova2/questao3/src/main/java/br/edu/ifpb/poo/mapa_palavras_crusadas.txt"));
//        System.out.println(jogo.mapPontosPorPalavra());
        System.out.println(jogo.getPontosDePalavra(jogo.getMelhorPalavra()));
        System.out.println(jogo.getPalavrasPorFaixa(35, 44));
    }
}

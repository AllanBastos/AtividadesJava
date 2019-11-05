package br.edu.ifpb.poo;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.function.ToIntFunction;

public class JogoPalavrasCruzadas {
    private Set<String> SetPalavras = new TreeSet<>();

    public Set<String> lerPalavraDoArquivo( Path pathOrigem ){
        TreeSet<String> palavrasTemp = new TreeSet<>();

        try{
            FileReader palavras = new FileReader(String.valueOf(pathOrigem));
            BufferedReader br  = new BufferedReader(palavras);
            String linha;
            while ((linha = br.readLine()) != null){
                palavrasTemp.add(linha);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        SetPalavras.addAll(palavrasTemp);
        return palavrasTemp;

    }

    public String getMelhorPalavra(){
        String melhor = null;
        int maior = 0;
        for (String palavra : SetPalavras) {
            int pontos = getPontosDePalavra(palavra);
            if (pontos > maior){
                maior = pontos;
                melhor = palavra;
            }
        }
        return melhor;
    }

    public int getPontosDePalavra(String umaPalavra ){
        final int[] tabelaPontos = {
                // a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p,  q, r, s, t, u, v, w, x, y, z
                1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10 };

        ToIntFunction<String> funcao =
                palavra -> palavra.chars()
                        .map( letra -> tabelaPontos[ letra - 'a' ] )
                        .sum();

        return funcao.applyAsInt( umaPalavra );
    }

    public Map<String, Integer> mapPontosPorPalavra(){
        Map<String, Integer> mapTemp = new HashMap<>();

        for (String palavras : SetPalavras){
            mapTemp.put(palavras, getPontosDePalavra(palavras));
        }
        return mapTemp;
    }

    public Set<String> getPalavrasPorFaixa(int faixaInicial, int faixaFinal){
        Set<String> StringsNaFaixa = new HashSet<>();

        for (String palavra : SetPalavras) {
            int ponto = getPontosDePalavra(palavra);
            if ((faixaInicial <= ponto && ponto <= faixaFinal)){
                StringsNaFaixa.add(palavra);
            }
        }
        return StringsNaFaixa;
    } 

    public void gravarMapaPalavras(Path pathdestino){
        Map<String, Integer> mapTemp = mapPontosPorPalavra();

        for ( var linha : mapTemp.entrySet()) {
            try {
                Files.write(pathdestino,
                        Collections.singleton(String.format(linha.getKey() + " ; " + linha.getValue())),
                        Charset.defaultCharset(),
                        StandardOpenOption.CREATE,
                        StandardOpenOption.APPEND,
                        StandardOpenOption.WRITE);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args )
    {
        // apenas uma demonstração de uso do método
        JogoPalavrasCruzadas jogo = new JogoPalavrasCruzadas();

        System.out.println( "pontos da palavra (ana)  = " + jogo.getPontosDePalavra( "ana" ) ); // 3 pontos
        System.out.println( "pontos da palavra (david) = " + jogo.getPontosDePalavra( "david" ) ); // 10 pontos
    }

}

package br.edu.ifpb.persistencia;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class persistencia {

    public static final String DESTINO = "Arquivos/mapasignos.txt";

    public void atualizarMapa(Map<String, List<String>> MapaSignos){
        try(FileReader fr = new FileReader(DESTINO);
            BufferedReader br = new BufferedReader(fr);
            ){
            MapaSignos.clear();
            String linhas = null;
            while ((linhas = br.readLine())!= null){
                String[] linha = linhas.split(":");
                String chave = linha[0];
                MapaSignos.get(chave).add(linha[1]);
            }

            System.out.println("Lista Atualizada! ");

        }catch (Exception e){
            System.out.println("Lista Vazia! " + e.getMessage());
        }
    }

    public void adicionarMsg(String signo, String mensagem){
        try{
            Files.write(Paths.get(DESTINO),
                    Collections.singleton(signo + " : " + mensagem),
                    Charset.defaultCharset(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND,
                    StandardOpenOption.WRITE);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void limparlista() {

        Path path = Paths.get(DESTINO);
        try{
            Files.delete(path);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    public boolean atualizaArquivo(Map<String, List<String>> mapaSignos) {

        for ( var chave : mapaSignos.entrySet()){
            for (String valor : chave.getValue()) {
                adicionarMsg(chave.getKey(), valor);
            }
        }

        return true;
    }
}

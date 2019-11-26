package br.edu.ifpb.persistencia;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class persistencia {

    public static final String DESTINO = "arquivos/mapasignos.txt";

    String[] signosvalidos = {"ESCORPIAO", "ARIES", "TOURO", "GEMEOS", "GEMEOS",
            "LEAO", "VIRGEM", "LIBRA", "SARGITARIO", "AQUARIO", "PEIXES"};

    public persistencia() {
        try {
            File file = new File("arquivos");
            if (!file.exists()){
                file.mkdir();
            }
            file = new File(DESTINO);

            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void atualizarMapa(Map<String, List<String>> MapaSignos){

            MapaSignos.clear();
            String linhas;
            List<String> list = new ArrayList<>();
            for(String chave : signosvalidos){
                MapaSignos.put(chave, list);
            }
            while ((linhas = br.readLine())!= null){
                String[] linha = linhas.split(" : ");
                String key = linha[0].replace(" ", "");
                List<String> temp = new ArrayList<>(MapaSignos.get(key));
                MapaSignos.put(key, temp);

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

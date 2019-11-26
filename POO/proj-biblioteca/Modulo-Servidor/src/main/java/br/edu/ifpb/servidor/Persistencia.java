package br.edu.ifpb.servidor;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Persistencia {
    public void atualizarTxt(Set<Livro> Livros, String Destino){
        Path pathDestino = Paths.get(Destino);
        List<String> linhas = new ArrayList<>();

        for(Livro atual : Livros){
            String linha = atual.getId()+";"+atual.getTitulo()+";"+atual.getAutor()+";"+atual.getTipo()+";"+atual.getPreço();
            assert false;
            linhas.add(linha);
        }
        try{

            Files.write( pathDestino,
                    linhas,
                    Charset.defaultCharset(),
                    StandardOpenOption.CREATE, // criar o arquivo, caso não exista
                    StandardOpenOption.TRUNCATE_EXISTING,
                    StandardOpenOption.WRITE );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

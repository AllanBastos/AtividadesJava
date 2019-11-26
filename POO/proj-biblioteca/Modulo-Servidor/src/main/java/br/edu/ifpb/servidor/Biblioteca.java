package br.edu.ifpb.servidor;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.ListResourceBundle;
import java.util.Set;


public class Biblioteca {
    private Set<Livro> Livros = new HashSet<>();

    private Persistencia arquivo = new Persistencia();


    public static final String DESTINO = "/home/allan/Documentos/ProjetosJava/AtividadesJava/POO/proj-biblioteca/Arquivos/books.txt";

    public Biblioteca() {
        try(FileReader fr = new FileReader(DESTINO);
            BufferedReader br = new BufferedReader(fr);){
            String linha;
            while ((linha = br.readLine()) != null){
                String[] split = linha.split(";");
                cadastrarLivro(split[0], split[1], split[2], split[3], split[4]);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String buscarLivro(String Id) {
        for (Livro atual : Livros){
            if(atual.getId().equals(Id)){
                return atual.toString();
            }
        }
        return "Livro não Encontrado";
    }

    public String cadastrarLivro(String Id, String Titulo, String autor, String tipo, String preço){
        Livro novo = new Livro(Id, Titulo, autor, tipo, preço);
        if(Livros.add(novo)){
            arquivo.atualizarTxt(Livros, DESTINO);
            return "Livro foi cadastrado com sucesso";
        }
        return "Erro - não foi possível cadastrar o livro!";
    }

    public String removerLivro(String Id){
        for (Livro atual : Livros){
            if (atual.getId().equals(Id)){
                if(Livros.remove(atual)){
                    arquivo.atualizarTxt(Livros, DESTINO);
                    return "Livro Removido com sucesso!";
                }else return "Erro não foi possivel remover o livro";
            }
        }
        return "Erro não foi possivel remover o livro; Livro Não encontrado!";
    }

}

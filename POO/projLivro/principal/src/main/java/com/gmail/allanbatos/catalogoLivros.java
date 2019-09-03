package com.gmail.allanbatos;

import java.util.LinkedList;
import java.util.List;

public class catalogoLivros {

    private List<Livro> listaLivros = null;

    catalogoLivros() {
        listaLivros = new LinkedList<>();
    }

    public boolean adcionar(String Titulo, String Autor, String Editora, int Ano, int Codigo){

        for (Livro l : listaLivros){
            if (l.getCodigo() == Codigo )
                return false;
        }

        Livro newlivro = new Livro(Titulo, Ano, Autor, Editora, Codigo);
        return listaLivros.add(newlivro);
    }

    public boolean remover(int codigo){
        Livro livro = buscar(codigo);
        return listaLivros.remove(livro);
    }

    public Livro buscar(int codigo){
        for (Livro livro : listaLivros) {
            if(livro.getCodigo() == codigo){
                return livro;
            }
        }
        return null;
    }

    public void listarLivros(){
        System.out.println("\nLista de livros");
        if (listaLivros.isEmpty())
            System.out.println("Vazio!");
        int n = 1;
        for (Livro livro : listaLivros) {
            System.out.printf("%d %s\n",n++,livro);
        }
    }

    public void limparLista(){
        listaLivros.clear();
        if (listaLivros.isEmpty())
            System.out.println("Lista Limpa");
    }

}

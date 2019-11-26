package br.edu.ifpb.servidor;

import java.util.Objects;

public class Livro {
    private String id;
    private String titulo;
    private String autor;
    private String tipo;
    private String preço;

    public String getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getTipo() {
        return tipo;
    }

    public String getPreço() {
        return preço;
    }

    public Livro(String Id, String Título, String Autor, String Tipo, String Preço) {
        this.id = Id;
        this.titulo = Título;
        this.autor = Autor;
        this.tipo = Tipo;
        this.preço = Preço;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return Objects.equals(id, livro.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {

        return ("Livro: " + titulo +
        ", ID: " + id +
        ", autor: " + autor +
        ", preço: " + preço);

    }
}

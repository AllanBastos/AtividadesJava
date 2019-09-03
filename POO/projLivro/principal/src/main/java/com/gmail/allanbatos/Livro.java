package com.gmail.allanbatos;

public class Livro {
    private String Titulo;
    private int ano;
    private String autor;
    private String editora;
    private int codigo;

     Livro(String titulo, int ano, String autor, String editora, int codigo) {
        setTitulo(titulo);
        setAno(ano);
        setAutor(autor);
        setCodigo(codigo);
        setEditora(editora);
    }


    public void setTitulo(String Nome) {
        if (Nome != null )
            Titulo = Nome;
    }

    public void setAno(int Ano) {
        if (Ano > 1000)
            ano = Ano;
    }

    public void setAutor(String autor) {
        if (autor != null && autor.length() > 3)
            this.autor = autor;
    }

    public void setCodigo(int codigo) {
        if (codigo > 0)
            this.codigo = codigo;
    }

    public void setEditora(String editora) {
        if (editora != null && editora.length() > 0)
            this.editora = editora;
    }

    public int getAno() {
        return ano;
    }

    public String getAutor() {
        return autor;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getEditora() {
        return editora;
    }

    public String getTitulo() {
        return Titulo;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "nome:' " + getTitulo() + '\'' +
                ", ano: " + getTitulo() +
                ", autor: '" + getAutor() + '\'' +
                ", editora: '" + getEditora() + '\'' +
                ", codigo: " + getCodigo() +
                '}';
    }
}

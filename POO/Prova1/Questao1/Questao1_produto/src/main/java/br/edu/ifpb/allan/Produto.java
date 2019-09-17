package br.edu.ifpb.allan;

public class Produto {
    private int cod;
    private String descricao;
    private double preco;

    public Produto(int c, String d, double p) {
        cod = c;
        descricao = d;
        preco = p;
    }

    public int getCod(){
        return cod;
    }

    public void setCod(int c){
        cod = c;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}

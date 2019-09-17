package br.edu.ifpb.allan;

public class Cartao {
    public String mensagem(){
        return "Cartão Pai";
    }

    public void enviarCartao(){
        System.out.println(mensagem());
    }
}

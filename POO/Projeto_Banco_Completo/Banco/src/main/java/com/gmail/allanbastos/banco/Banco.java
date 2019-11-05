package com.gmail.allanbastos.banco;



public class Banco {
    String Descrição;

    public Banco(String descrição) {
        Descrição = descrição;
    }

    public Banco(){
        this("Meu Banco");
    }
}

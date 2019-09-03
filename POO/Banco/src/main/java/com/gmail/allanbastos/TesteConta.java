package com.gmail.allanbastos;

public class TesteConta {
    public static void main(String[] args) {
        Conta c = new Conta(193, "Allan Bastos", 55.00);

        c.depositar(-4520);

        c.depositar(100);

        c.setTitular("Allan dos Santos Batista Bastos");

        c.depositar(1000000);

        if (! c.sacar(99))
            System.out.println("Saldo não disponivel");

        System.out.println(c);


    }
}

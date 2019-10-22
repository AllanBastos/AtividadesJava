package com.gmail.allanbastos;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Banco {
    private HashSet<Conta> listaContas = null;

    Banco(){
        listaContas = new HashSet<>();
    }

    public boolean cadastrarConta(int numero, String tiular, double saldo_inicial){

        // verificar se já tem a conta cadastrada
        if (buscarConta(numero)) return false;

        // se não existir devo criar uma nova, e adicionar a lista de contas

        Conta nova_conta = new Conta(numero, tiular, saldo_inicial);

        return listaContas.add(nova_conta);

    }

    public boolean buscarConta(int numero) {
        for (Conta listaConta : listaContas) {
            if (listaConta.getNumero() == numero)
                return true;
        }
        return false;
    }

    public int quantidadeContas(){
        return listaContas.size();
    }




}

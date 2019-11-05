package com.gmail.allanbastos.CLI;


import com.gmail.allanbastos.banco.Agencia;
import com.gmail.allanbastos.banco.Conta;
import com.gmail.allanbastos.banco.ContaCorrente;
import com.gmail.allanbastos.banco.ContaPoupança;

import java.io.*;
import java.nio.BufferUnderflowException;
import java.nio.charset.Charset;

public class TesteBanco {

    public static void main(String[] args) {

        Agencia agencia639 = new Agencia(639, "Rua Maria Ribeiro Machado, 253");

        Conta allan = new ContaCorrente(1002031, "Allan dos Santos", 55.000);
        Conta junior = new ContaCorrente(1002032, "Junior dos Santos", 55.000);
        Conta marcos = new ContaCorrente(1002033, "Marcos dos Santos", 55.000);
        Conta copiaallan = new ContaCorrente(1002031, "Allan dos Santos", 55.000);
        Conta allanPoupança = new ContaPoupança(1002031, "Allan dos Santos", 55.000);
        agencia639.addConta(allan);
        agencia639.addConta(junior);
        agencia639.addConta(marcos);
        agencia639.addConta(copiaallan);
        agencia639.addConta(allanPoupança);

        System.out.println(agencia639);
        System.out.println(agencia639.listar_contas());
        System.out.println(agencia639.getEndereço());


    }


}

package com.gmail.allanbastos.banco;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.StringJoiner;

public class Agencia {
    private int numero;
    private String Endereço;
    private Set<Conta> ListaContas = null;

    public Agencia(int numero, String endereço) {
        this.numero = numero;
        Endereço = endereço;
        ListaContas = new HashSet<>();
    }

    public Agencia(){
        this(000, "--- Sem Endereço ---");
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getEndereço() {
        return Endereço;
    }

    public void setEndereço(String endereço) {
        Endereço = endereço;
    }

    public boolean addConta(Conta conta){
        if (conta != null) return ListaContas.add(conta);
        return false;
    }

    public boolean removerConta(Conta conta){
        return ListaContas.remove(conta);
    }

    public int QuantidadeContas(){
        return ListaContas.size();
    }

    public String listar_contas(){
       return ListaContas.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Agencia agencia = (Agencia) o;
        return getNumero() == agencia.getNumero();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumero());
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Conta.class.getSimpleName() + "[", "]")
                .add("Agencia: " + getNumero())
                .add("Endereço: " + getEndereço())
                .add("Contas Cadastradas: " + QuantidadeContas())
                .toString();
    }
}

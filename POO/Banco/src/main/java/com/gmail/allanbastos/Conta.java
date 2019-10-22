package com.gmail.allanbastos;

import java.util.Objects;

// criando uma classe conta
public class Conta {
    private int Numero;
    private String Titular;
    private double saldo;



    public boolean sacar(double quantia){
        if( saldo >= quantia){
            saldo -= quantia;
            return  true;
        }
        return false;
    }

    void depositar(double quantia){
        if (quantia > 0)
            saldo += quantia;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getTitular() {
        return Titular;
    }

    public void setTitular(String titular) {
        if (titular != null)
            Titular = titular;
    }

    public int getNumero() {
        return Numero;
    }

    public void setNumero(int numero) {
        if (numero > 0)
            Numero = numero;
    }

    public Conta(int num, String tit, double s){
        setNumero(num);// definir o numero da conta
        setTitular(tit); // definir o titular da conta
        depositar(s); // deposito inicial
    }

    public Conta(){
        setNumero(0);
        setTitular("Sem Nome");
        depositar(0);
    }

    @Override
    public String toString() {

        return "Conta: " + getNumero() + "; Titular: " + getTitular() + "\nSaldo: " + getSaldo() + "\n" ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conta conta = (Conta) o;
        return Numero == conta.Numero;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Numero);
    }
}// fim da classe conta

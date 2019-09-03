package com.gmail.allanbastos;

import java.text.NumberFormat;
import java.util.Locale;

public class ContaCorrente {
    Locale locale = new Locale("pt", "BR");
    private int Número;
    private String Titular;
    private double Saldo;

    public ContaCorrente(int número, String titular, double deposito_Inicial){
        setNúmero(número);
        setTitular(titular);
        Deposito(deposito_Inicial);
    }

    public void setSaldo(double saldo) {
        if (saldo > 0)
            Saldo = saldo;
    }

    public void setTitular(String titular) {
        if (titular != null)
            Titular = titular;
    }

    public void setNúmero(int número) {
        if (número > 0)
            Número = número;
    }

    public int getNúmero() {
        return Número;
    }

    public String getTitular() {
        return Titular;
    }

    public double getSaldo() {
        return Saldo;
    }

    public boolean Saque(double quantia){
        double juros = calcularCPMF(quantia);
        double total_saq = juros + quantia;
        if (total_saq <= Saldo && quantia > 0 ){
            Saldo -= quantia;
            descontaCPMF(calcularCPMF(quantia));
            return true;
        }
        return false;
    }

    public boolean Deposito(double valor) {
        if (valor > 0){
            Saldo += valor;
            return true;
        }
        return false;
    }

    public double saldo(){
        return getSaldo();
    }

    public String Extrato(){
        return toString();
    }

    public double calcularCPMF(double valor){
        return (valor*0.01);
    }

    public void descontaCPMF(double CPMF){
        Saldo -= CPMF;
    }

    @Override
    public String toString() {
        NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(locale);
        return "ContaCorrente{" +
                "Número: " + getNúmero() +
                ", Titular: '" + getTitular() + '\'' +
                ", Saldo: " + formatoMoeda.format(getSaldo()) +
                '}';
    }
}

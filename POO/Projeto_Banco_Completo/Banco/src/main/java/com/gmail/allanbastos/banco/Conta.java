package com.gmail.allanbastos.banco;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Objects;

public class Conta {
    Locale locale = new Locale("pt", "BR");
    private static final double VALOR_JUROS = 0.01;
    private int Número;
    private String Titular;
    private double Saldo;

    public Conta(int número, String titular, double deposito_Inicial){
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
        throw new SaldoInvalidoException();
    }

    public boolean Deposito(double valor) {
        if (valor > 0){
            Saldo += valor;
            return true;
        }
        throw new QuantiaNegativaException();
    }

    public double saldo(){
        return getSaldo();
    }

    public String Extrato(){
        return toString();
    }

    public double calcularCPMF(double valor){
        return (valor * VALOR_JUROS);
    }

    public void descontaCPMF(double CPMF){
        Saldo -= CPMF;
    }

    @Override
    public String toString() {
        NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(locale);
        return String.format("%s{Número: %d, Titular: '%s', Saldo: %s}", this.getClass().getSimpleName(), getNúmero(), getTitular(), formatoMoeda.format(getSaldo()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conta conta = (Conta) o;
        return getNúmero() == conta.getNúmero();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNúmero());
    }
}

package com.gmail.allanbastos;

/*
    Classe calculadora
 */
public class Calculadora {
    private String descrição = "Calculadora Versão 1.0";
    private double memoria = 0;

    public double somar(double umNúmero, double outroNúmero){
        return umNúmero + outroNúmero;
    }

    public double subitrair(double umNúmero, double outroNúmero){
        return umNúmero - outroNúmero;
    }

    public double multiplicar(double umNúmero, double outroNúmero){
        return umNúmero * outroNúmero;
    }

    public double dividir(double umNúmero, double outroNúmero){
        return umNúmero / outroNúmero;
    }

    public void gravarMemória(double umNúmero){
        memoria = umNúmero;
    }

    public double lerMemória(){
        return memoria;
    }

    public void alterarDescrição(String Decrição){
        descrição = Decrição;
    }

    public String consultarDescrição(){
        return descrição;
    }


}

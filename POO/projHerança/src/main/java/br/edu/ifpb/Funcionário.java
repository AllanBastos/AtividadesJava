package br.edu.ifpb;

import java.util.StringJoiner;

public class Funcionário {
    // atributos
    private int matrícula;
    private String nome;
    private double SalárioBase;

    // construtores


    public Funcionário() {
        this(0, "-- sem nome --", 890.50);
    }

    public Funcionário(int matrícula, String nome, double salárioBase) {
        setMatrícula(matrícula);
        setNome(nome);
        setSalárioBase(salárioBase);
    }

    // metodos
    public int getMatrícula() {
        return matrícula;
    }

    public void setMatrícula(int matrícula) {
        this.matrícula = matrícula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalário() {
        return SalárioBase;
    }

    public void setSalárioBase(double salárioBase) {
        SalárioBase = salárioBase;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", "", "")
                .add("matrícula: " + matrícula)
                .add("nome: " + nome )
                .add("SalárioBase: R$" + SalárioBase)
                .toString();
    }
}

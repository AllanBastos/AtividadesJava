package br.edu.ifpb;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;
import java.util.StringJoiner;

public class Funcionário implements Comparable<Funcionário> {
    // atributos
    private int matrícula;
    private String nome;
    private double SalárioBase;

    private static final Comparator<Funcionário> COMPARADOR_POR_SALÁRIO = Comparator.comparingDouble(Funcionário::getSalário);

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

    @Override
    public int compareTo(Funcionário funcionário) {
        return Integer.compare(this.matrícula, funcionário.matrícula);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Funcionário that = (Funcionário) o;
        return matrícula == that.matrícula;
    }

    @Override
    public int hashCode() {
        return Objects.hash(matrícula);
    }
}

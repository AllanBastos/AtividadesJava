package br.edu.ifpb;

public class Gerente extends Funcionário {
    double comissão;

    public Gerente() {
        this.comissão = 100;
    }

    public Gerente(int matrícula, String nome, double salárioBase, double comissão) {
        super(matrícula, nome, salárioBase);
        this.comissão = comissão;
    }

    @Override
    public double getSalário() {
        return super.getSalário() + (comissão);
    }

    @Override
    public String toString() {
        return super.toString() +", " + "comissão: R$" + comissão + ", " + "Salário:  R$" + getSalário();
    }
}

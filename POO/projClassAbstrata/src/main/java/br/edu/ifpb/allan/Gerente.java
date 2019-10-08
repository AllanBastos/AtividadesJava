package br.edu.ifpb.allan;

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
    public String cálculoIRPF() {
        return "Gerente não possui periculosidade e alíquota de imposto será (68%)";
    }

    @Override
    public String toString() {
        return "Gerente= " + super.toString() +", " + "comissão: R$" + comissão + ", " + "Salário:  R$" + getSalário();
    }
}
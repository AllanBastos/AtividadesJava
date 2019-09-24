package br.edu.ifpb.allan;

public class Telefonista extends Funcionário {

    public Telefonista(int matrícula, String nome, double salárioBase) {
        super(matrícula, nome, salárioBase);
    }

    @Override
    public String cálculoIRPF() {
        return "Sem aliquota (0%)";
    }
}

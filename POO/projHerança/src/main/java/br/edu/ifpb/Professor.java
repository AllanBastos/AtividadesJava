package br.edu.ifpb;

public class Professor extends Funcionário{

    private int númeroHorasDisciplinas;

    public Professor() {
        númeroHorasDisciplinas = 8;
    }

    public Professor(int matrícula, String nome, double salárioBase, int númeroHorasDisciplinas) {
        super(matrícula, nome, salárioBase);
        this.númeroHorasDisciplinas = númeroHorasDisciplinas;
    }

    public int getNúmeroHorasDisciplinas() {
        return númeroHorasDisciplinas;
    }

    public void setNúmeroHorasDisciplinas(int númeroHorasDisciplinas) {
        this.númeroHorasDisciplinas = númeroHorasDisciplinas;
    }


    @Override
    public double getSalário() {
        return super.getSalário() + (getNúmeroHorasDisciplinas()*2);
    }

    @Override
    public String toString() {
        return "Professor= " + super.toString() +", " + "número de horas: " + getNúmeroHorasDisciplinas() + ", " +  "Salário: R$" + getSalário();
    }
}

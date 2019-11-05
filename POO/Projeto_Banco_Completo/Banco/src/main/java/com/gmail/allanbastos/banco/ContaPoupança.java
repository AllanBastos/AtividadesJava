package com.gmail.allanbastos.banco;

public class ContaPoupança extends Conta {
    private static final double JUROS_DE_RENDA = 0.03;
    private static int LIMITE_SAQUE_MES = 3;

    public ContaPoupança(int número, String titular, double deposito_Inicial) {
        super(número, titular, deposito_Inicial);
    }

    public double Renda(){
        return  getSaldo() + getSaldo() * JUROS_DE_RENDA;
    }

    @Override
    public boolean Saque(double quantia) {
        if (LIMITE_SAQUE_MES > 0){
            double juros = calcularCPMF(quantia);
            double total_saq = juros + quantia;
            if (total_saq <= getSaldo() && quantia > 0 ){
                setSaldo(saldo() - quantia);
                descontaCPMF(calcularCPMF(quantia));
                LIMITE_SAQUE_MES--;
                return true;
            }
            throw new SaldoInvalidoException();
        }
        System.out.println("Limite de Saque atingido");
        return false;

    }
}

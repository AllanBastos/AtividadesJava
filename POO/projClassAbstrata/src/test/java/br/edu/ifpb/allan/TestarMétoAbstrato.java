package br.edu.ifpb.allan;

import static java.lang.System.out;

public class TestarMétoAbstrato {
    public static void main(String[] args) {
        Funcionário f = new Professor(222, "Pedro", 1_200.99, 8);

        out.println(f.cálculoIRPF());

        f = new Gerente(555, "ana", 5_690.99, 100);

        out.println(f.cálculoIRPF());

        f = new Telefonista(999, "Bruno", 1200.00);

        out.println(f.cálculoIRPF());


    }

}

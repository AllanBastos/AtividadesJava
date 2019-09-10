package br.edu.ifpb;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Universidade {
    private List<Funcionário> listaFuncionarios = null;
    private String endereco;

    {
        listaFuncionarios = new ArrayList<>();
    }

    public Universidade(String endereco){

        this.endereco = endereco;
    }

    public Universidade(){
        this("-- Sem endereço --");
    }


    public boolean adicionarFuncionário(Funcionário func) {

        if(Objects.isNull(func)) return false;

        for ( Funcionário Temp : listaFuncionarios) {
            if (Temp.getMatrícula() == func.getMatrícula())
                return false;
        }
        return listaFuncionarios.add(func);
    }

    public Funcionário buscarFuncionário(int matricula) {
        for ( Funcionário Temp : listaFuncionarios) {
            if (Temp.getMatrícula() == matricula)
                return Temp;
        }
        return null;
    }
}

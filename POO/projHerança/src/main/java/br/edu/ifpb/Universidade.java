package br.edu.ifpb;

import java.util.*;

public class Universidade {
    private NavigableSet<Funcionário> listaFuncionarios = null;
    private String endereco;

    {
        listaFuncionarios = new TreeSet<>();
    }

    public Universidade(String endereco){

        this.endereco = endereco;
    }

    public Universidade(){
        this("-- Sem endereço --");
    }


    public boolean adicionarFuncionário(Funcionário func) {
        if (func == null) return false;

        return listaFuncionarios.add(func);
    }

    public Funcionário buscarFuncionário(int matricula) {
        for ( Funcionário Temp : listaFuncionarios) {
            if (Temp.getMatrícula() == matricula)
                return Temp;
        }
        return null;
    }

    public int getQuantidadeFuncionários() {
        return listaFuncionarios.size();
    }

    public boolean removerFuncionário(int matricula){
        for (Funcionário temp : listaFuncionarios)
            if (temp.getMatrícula() == matricula){
                return listaFuncionarios.remove(temp);
            }
        return false;
    }

    public String listarTodosFuncionários() {

        StringBuilder str = new StringBuilder();

        for (Funcionário temp : listaFuncionarios) {
            str.append(temp.toString());
            str.append("\n");
        }

        return str.toString();
//        return listaFuncionarios.toString();
    }
}

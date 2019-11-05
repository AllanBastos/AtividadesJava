package br.edu.ifpb;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;
import java.util.StringJoiner;

public class City implements Comparable<City>{
    private String Nome;
    private String Sigla;
    private String CEP;

    public City(String nome, String sigla, String CEP) {
        setNome(nome);
        setSigla(sigla);
        setCEP(CEP);
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getSigla() {
        return Sigla;
    }

    public void setSigla(String sigla) {
        Sigla = sigla;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return getNome().equals(city.getNome());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getNome());
    }


    @Override
    public int compareTo(City outra) {
        return getNome().compareTo(outra.getNome());
    }


}

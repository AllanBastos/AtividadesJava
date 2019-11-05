package br.edu.ifpb;

import javax.sound.midi.Patch;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class CitiesProcessor {
    private Set<City> citiesSet;
    {
        this.setCitiesSet(new TreeSet<>());
    }
    public Set<City> getCitiesSet() {
        return citiesSet;
    }

    public void setCitiesSet(Set<City> citiesSet) {
        this.citiesSet = citiesSet;
    }


    public Set<City> buildSetOfCities(Path filePatch){
        Set<City>  citySetTemp = new TreeSet<>();

        try(FileReader Fr = new FileReader( String.valueOf(filePatch));
            BufferedReader br = new BufferedReader(Fr)){
            String linha;
            while ((linha = br.readLine()) != null){
                String[] palavra = linha.split(", ");
                String nome = palavra[0], sigla = palavra[1], cep = palavra[2];
                citySetTemp.add(new City(nome, sigla, cep));
            }

        } catch (FileNotFoundException e) {
            System.out.println("Erro! " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Erro Arquivo não exitente");
            e.printStackTrace();
        }
        return citySetTemp;
    }

    public void writeSetOfCities(Path destino, Comparator<City> comparador)
    {
        Set<City> setCitiesOrdenado = new TreeSet<>( comparador );
        setCitiesOrdenado.addAll( getCitiesSet() );

        setCitiesOrdenado.forEach(city -> {
            try {
                Files.write (
                        destino,
                        Collections.singleton(String.format("%s, %s, %s", city.getNome(), city.getSigla(), city.getCEP())),
                        Charset.defaultCharset(),
                        StandardOpenOption.CREATE,
                        StandardOpenOption.APPEND,
                        StandardOpenOption.WRITE);
            } catch (IOException e) {
                System.out.println("Erro ao escrever arquivo!");;
            }
        });
    }

    public void printaSet() {
        this.getCitiesSet().forEach(city -> {
            System.out.println(city.getNome() + ", " + city.getSigla() + ", " + city.getCEP());
        });
    }



}

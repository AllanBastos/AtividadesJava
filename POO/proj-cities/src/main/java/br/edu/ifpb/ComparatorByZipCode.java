package br.edu.ifpb;

import java.util.Comparator;

public class ComparatorByZipCode implements Comparator<City> {

    @Override
    public int compare(City city1, City city2) {
        return city1.getCEP().compareTo(city2.getCEP());
    }
}

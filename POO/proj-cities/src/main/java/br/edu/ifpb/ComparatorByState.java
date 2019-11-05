package br.edu.ifpb;

import java.util.Comparator;

public class ComparatorByState implements Comparator<City> {
    @Override
    public int compare(City city1, City city2) {
        return city1.getSigla().compareTo(city2.getSigla());
    }
}

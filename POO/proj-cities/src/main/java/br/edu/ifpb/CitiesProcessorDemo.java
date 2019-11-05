package br.edu.ifpb;

import javax.sound.midi.Patch;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.Set;

public class CitiesProcessorDemo {
    public static void main( String[] args ) {
        CitiesProcessor cp = new CitiesProcessor(); // criar o processador de cidades

        // ler o arquivo texto e montar o set de objetos-cidades
        Set<City> set = cp.buildSetOfCities( Path.of( "/home/allan/JavaProject/AtividadesJava/POO/proj-cities/src/main/java/br/edu/ifpb/files/cities_duplicatas.txt" ) );
        cp.setCitiesSet( set ); // passar o set montado para o objeto CitiesProcessor

        // gerar e salvar um arquivo texto com as cidades ordenadas pelo nome (o default)
        cp.writeSetOfCities( Path.of( "/home/allan/JavaProject/AtividadesJava/POO/proj-cities/src/main/java/br/edu/ifpb/files/cities_ordered_by_name.txt" ), Comparator.naturalOrder() );
        // gerar e salvar um outro arquivo texto com as cidades ordenadas pelo zip code
        ComparatorByZipCode comparadorZip = new ComparatorByZipCode();
        cp.writeSetOfCities( Path.of( "/home/allan/JavaProject/AtividadesJava/POO/proj-cities/src/main/java/br/edu/ifpb/files/cities_ordered_by_zipcode.txt" ), comparadorZip );

        // gerar e salvar arquivo texto com as cidades agora ordenadas pelo estado
        ComparatorByState comparadorState = new ComparatorByState();
        cp.writeSetOfCities( Path.of( "/home/allan/JavaProject/AtividadesJava/POO/proj-cities/src/main/java/br/edu/ifpb/files/cities_ordered_by_state.txt" ), comparadorState );
    } // main
}

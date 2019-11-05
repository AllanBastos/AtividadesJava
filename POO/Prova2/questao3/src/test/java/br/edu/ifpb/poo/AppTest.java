package br.edu.ifpb.poo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

/**
 * Unit test for simple JogoPalavrasCruzadas.
 */
public class AppTest 
{   @Test
    public void testGetPalavrasPorFaixaPontos(){
        JogoPalavrasCruzadas jogo = new JogoPalavrasCruzadas();
        Set<String> palavras = new HashSet<>();
        palavras =  "[zyzzyva, quizzing, bezazz, zizzled, quizzed, zyzzyvas, pizazzy, zizzling, jazzily, pazazz, pazazzes, quizzers, jazzlike, bezazzes, pizazz, pizazzes]" ;

    jogo.lerPalavraDoArquivo(Path.of("/home/allan/JavaProject/AtividadesJava/POO/Prova2/questao3/src/main/java/br/edu/ifpb/poo/palavras.txt"));
        Assert.assertEquals(palavras ,jogo.getPalavrasPorFaixa(35,44));

    }
}

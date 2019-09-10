package br.edu.ifpb;

import org.junit.Assert;
import org.junit.Test;

public class UniversidadeTest
{
    @Test
    public void testCadastroFuncionárioDeveFuncionar()
    {
        // Dado que...
        Universidade u = new Universidade();

        // Quando....
        Professor p1 =
                new Professor(467, "ana",
                        1200, 20 );
        Gerente g1 =
                new Gerente(332, "pedro",
                        3000, 500.99 );
        boolean resultadoProf = u.adicionarFuncionário( p1 );
        boolean resultadoGer = u.adicionarFuncionário( g1 );

        // Então...
        // p1 e g1 foi cadastrado com sucesso
        Assert.assertTrue( resultadoProf );
        Assert.assertTrue( resultadoGer );
    }

    @Test
    public void testCadastroFuncionárioNãoDeveFuncionar()
    {
        // Dado que...
        Universidade u = new Universidade();

        // Quando....
        Professor p1 =
                new Professor(467, "ana",
                        1200, 20 );
        Professor cloneP1 =
                new Professor(467, "ana",
                        1200, 20 );

        Professor pNull = null;

        boolean resultadoProf = u.adicionarFuncionário( p1 );
        boolean resultadoClone = u.adicionarFuncionário( p1 );
        boolean resultadoPNull = u.adicionarFuncionário( pNull );

        // Então...
        Assert.assertTrue( resultadoProf );
        Assert.assertFalse( resultadoClone );
        Assert.assertFalse( resultadoPNull );
    }

    @Test
    public void testBuscarFuncionário(){
        // criando nova universidade
        Universidade IFPB = new Universidade("Av. vinte de maio, 127, Centro, Campina Grande PB");
        // cadastrando funcionarios
        Professor p1 = new Professor(666, "Ana Livia", 1526.50, 80);
        Professor p2 = new Professor(777, "Guilherme Oliveira", 35900.58, 25);
        Gerente g1 = new Gerente(555, "Guilherme Esdras", 1000000.00, 10.00);

        // add funcionarios
        IFPB.adicionarFuncionário(p1);
        IFPB.adicionarFuncionário(p2);
        IFPB.adicionarFuncionário(g1);

        // iniciando teste
        Assert.assertEquals(IFPB.buscarFuncionário(777), p2);
        Assert.assertEquals(IFPB.buscarFuncionário(127), null);
        Assert.assertEquals(IFPB.buscarFuncionário(666), p1);
        Assert.assertEquals(IFPB.buscarFuncionário(553), null);
        Assert.assertEquals(IFPB.buscarFuncionário(555), g1);
    }


}
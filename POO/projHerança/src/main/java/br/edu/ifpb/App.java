package br.edu.ifpb;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
     Professor p1 = new Professor();
     Professor p2 = new Professor(2500, "ana silva", 1200.98, 50);
     Gerente g1 = new Gerente();
     Gerente g2 = new Gerente(5000, "Adilson", 5000,1500);

//        System.out.println(p1);
//        System.out.println(p2);
//        System.out.println(g2)
        System.out.println(g1);

        Universidade monstros = new Universidade();

        monstros.adicionarFuncionário(p1);
        monstros.adicionarFuncionário(p2);
        monstros.adicionarFuncionário(g1);
        monstros.adicionarFuncionário(g2);
        System.out.println(monstros.listarTodosFuncionários());
    }
}

package br.edu.ifpb.allan;

public class EnviaCartao
{
    public void EnviarCartao(Cartao c){
        c.enviarCartao();
    }

    public static void main( String[] args )
    {
        EnviaCartao s = new EnviaCartao();
        s.EnviarCartao(new cartaoAniversario());
        s.EnviarCartao(new cartaoNatal());
        s.EnviarCartao(new cartaoPascoa());

    }
}

public class Gato extends animal implements animal_felinos {
    String Raça;
    String nome;


    @Override
    public String getRaca() {
        return this.Raça;
    }

    @Override
    public void setRaca(String raca) {
        Raça = raca;

    }

    @Override
    public int morreaos() {
        return 10;
    }

    @Override
    public String barulho() {
        return "Miau";
    }
}

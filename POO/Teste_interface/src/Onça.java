public class Onça extends animal implements animal_felinos {

    @Override
    public String barulho() {
        return "hUrags";
    }

    @Override
    public String getRaca() {
        return "Pintada";
    }

    @Override
    public void setRaca(String raca) {
    }

    @Override
    public int morreaos() {
        return 0;
    }
}

package br.edu.ifpb.gui.texto;

import br.edu.ifpb.conversor.Conversor;

public class testarMenu {
    public static void main(String[] args) {
        Conversor c = new Conversor();
        Menu MENU = new Menu();
        MENU.exibirMenu(c);
    }
}

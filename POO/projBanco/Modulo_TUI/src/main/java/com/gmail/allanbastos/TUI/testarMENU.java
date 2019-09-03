package com.gmail.allanbastos.TUI;

import com.gmail.allanbastos.ContaCorrente;

public class testarMENU {
    public static void main(String[] args) {
        ContaCorrente cc = new ContaCorrente(3520025, "Allan Bastos", 500.85);
        MENU menu = new MENU();

        menu.exibirmenu(cc);
    }
}

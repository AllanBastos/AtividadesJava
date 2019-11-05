package com.gmail.allanbastos.banco;

public class EntradaInválidaException extends RuntimeException{
    public EntradaInválidaException(String msg){
        super(msg);
    }

    public EntradaInválidaException(){
        this("Entrada Inválida!");
    }

}
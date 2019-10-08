package com.gmail.allanbastos;

public class EntradaInválidaException extends RuntimeException{
    public EntradaInválidaException(String msg){
        super(msg);
    }

    public EntradaInválidaException(){
        this("Entrada Inválida!");
    }

}
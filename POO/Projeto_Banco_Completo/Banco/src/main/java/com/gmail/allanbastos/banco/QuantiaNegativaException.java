package com.gmail.allanbastos.banco;

public class QuantiaNegativaException  extends RuntimeException{
    public QuantiaNegativaException(String Msg)
    {
        super(Msg);
    }

    public QuantiaNegativaException()
    {
        this("Quantia Negativa");
    }
}

package br.edu.ifpb.conversor;

public class Conversor {
    public String decimalBinario(int decimal){
        return Integer.toBinaryString(decimal);
    }

    public String decimalHexadecimal(int decimal){
        return Integer.toHexString(decimal);
    }

}

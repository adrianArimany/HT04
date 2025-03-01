package com.example.conversor;

public class ConversorFactory {
    public Conversor getConversor(int cond){
        return switch (cond) {
            case 1 -> new CoversorStack();
            case 2 -> new ConversorArrayList();
            case 3 -> new ConversorVector();
            case 4 -> new CoversorListaSimple();
            default -> new ConversorListaDoble();
        };
    }
}

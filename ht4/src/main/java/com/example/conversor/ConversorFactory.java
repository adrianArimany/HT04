package com.example.conversor;

public class ConversorFactory {
    public Conversor getConversor(String option) {
        return switch (option.toLowerCase()) {
            case "stack" -> new CoversorStack();
            case "arraylist" -> new ConversorArrayList();
            case "vector" -> new ConversorVector();
            case "listasimple" -> new CoversorListaSimple();
            case "listadouble" -> new ConversorListaDoble();
            default -> new CoversorStack();
        }; 
    }
    
    }


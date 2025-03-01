package com.example;

public class ConversorFactory {
    public Conversor getConversor(int cond){
        if(cond == 1) 
            return new CoversorStack();
        else if (cond == 2) 
            return new ConversorArrayList();
        else if (cond == 3)
            return new ConversorVector();
        else if (cond == 4)
            return new CoversorListaSimple();
        else 
            return new ConversorListaDoble();
    }
}

package com.example.conversor;

import java.util.Vector;

public class ConversorVector extends Conversor {
    
    public ConversorVector() {}
    
    @Override
    public String InfixToPostFix(String cadena) {
        String cadenapostfix = "";
        String[] Tokens = cadena.split("");
        Vector<String> vectorTokens = new Vector<>();
        
        for (String token : Tokens) {
            if (isNumber(token)) {
                cadenapostfix += token;
            } else if (token.equals("(")) {
                vectorTokens.add(token);
            } else if (token.equals(")")) {
                while (!vectorTokens.isEmpty() && !vectorTokens.lastElement().equals("(")) {
                    cadenapostfix += vectorTokens.lastElement();
                    vectorTokens.remove(vectorTokens.size() - 1);
                }
                vectorTokens.remove(vectorTokens.size() - 1);
            } else if (isValidOperator(token)) {
                while (!vectorTokens.isEmpty() && precedencia(token) <= precedencia(vectorTokens.lastElement())) {
                    cadenapostfix += vectorTokens.lastElement();
                    vectorTokens.remove(vectorTokens.size() - 1);
                }
                vectorTokens.add(token);
            }
        }
        
        for (String op : vectorTokens) {
            if (precedencia(op) == 1) {
                cadenapostfix += op;
            }
        }

        for (String op : vectorTokens) {
            if (precedencia(op) == 0) {
                cadenapostfix += op;
            }
        }
        
        setCadenaPostFix(cadenapostfix);
                return cadenapostfix;
    }
}

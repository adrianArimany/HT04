package com.example;

import java.util.ArrayList;

public class ConversorArrayList extends Conversor{

    public ConversorArrayList(){};
    
    @Override
    public void InfixToPostFix(String cadena){
        String cadenapostfix = "";
        String[] Tokens = cadena.split("");
        ArrayList<String> ArrayTokens = new ArrayList<>();
        for(String token : Tokens){
            if(isNumber(token)){
                cadenapostfix += token;
            } else if(token.equals("(")){
                ArrayTokens.add(token);
            } else if(token.equals(")")){
                while(!ArrayTokens.isEmpty() && !ArrayTokens.get(ArrayTokens.size() - 1).equals("(") ){
                    cadenapostfix += ArrayTokens.get(ArrayTokens.size() - 1);
                    ArrayTokens.remove(ArrayTokens.size() - 1);
                }
                ArrayTokens.remove(ArrayTokens.size() - 1);
            } else if(isValidOperator(token)){
                while(!ArrayTokens.isEmpty() && precedencia(token) <= precedencia(ArrayTokens.get(ArrayTokens.size() - 1))){
                    cadenapostfix += ArrayTokens.get(ArrayTokens.size() - 1);
                    ArrayTokens.remove(ArrayTokens.size() - 1);
                }
                ArrayTokens.add(token);
            }
        }

        for(String op: ArrayTokens){
            if(precedencia(op) == 1){
                cadenapostfix += op;
            }
        }

        for(String op: ArrayTokens){
            if(precedencia(op) == 0){
                cadenapostfix += op;
            }
        }

        setCadenaPostFix(cadenapostfix);

    }

}

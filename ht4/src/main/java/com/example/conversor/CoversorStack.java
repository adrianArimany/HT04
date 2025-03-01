package com.example.conversor;

import java.util.Stack;

public class CoversorStack extends Conversor {
    
    public CoversorStack(){
    }

    @Override
    public String InfixToPostFix(String cadena){
        String cadenapostfix = "";
        String[] Tokens = cadena.split("");
        Stack<String> pila = new Stack<>();
        for(String token : Tokens){
            if(isNumber(token)){
                cadenapostfix += token;
            }
            else if(token.equals("(")){
                pila.push(token);
            }
            else if(token.equals(")")){
                while(!pila.isEmpty() && !pila.peek().equals("(")){
                    cadenapostfix += pila.pop();
                }
                pila.pop();
            }else if(isValidOperator(token)){
                while(!pila.isEmpty() && precedencia(token) <= precedencia(pila.peek())){
                    cadenapostfix += pila.pop();
                }
                pila.push(token);
            }

        }
        
        for(String op: pila){
            if(precedencia(op) == 1){
                cadenapostfix += op;
            }
        }

        for(String op: pila){
            if(precedencia(op) == 0){
                cadenapostfix += op;
            }
        }

        setCadenaPostFix(cadenapostfix);
                return cadenapostfix;

    }

}

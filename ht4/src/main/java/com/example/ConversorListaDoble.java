package com.example;

public class ConversorListaDoble extends Conversor{
    public ConversorListaDoble(){};
    public void InfixToPostFix(String cadena){
        String cadenapostfix = "";
        String[] tokens = cadena.split("");
        ListaSimple<String> pila = new ListaSimple<>();
        
        for (String token : tokens) {
            if (isNumber(token)) {
                cadenapostfix += token;
            } else if (token.equals("(")) {
                pila.insertar(token);
            } else if (token.equals(")")) {
                while (!pila.estaVacia() && !pila.obtenerTope().equals("(")) {
                    cadenapostfix += pila.eliminar();
                }
                pila.eliminar();
            } else if (isValidOperator(token)) {
                while (!pila.estaVacia() && precedencia(token) <= precedencia(pila.obtenerTope())) {
                    cadenapostfix += pila.eliminar();
                }
                pila.insertar(token);
            }
        }
        
        while (!pila.estaVacia()) {
            cadenapostfix += pila.eliminar();
        }
        
        setCadenaPostFix(cadenapostfix);
    }
}

package com.example.conversor;

public abstract class Conversor implements IConversor{
    protected String Cadenapostfix;

    protected boolean isNumber(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }

    protected boolean isValidOperator(String str) {
        return str.matches("[+\\-*/]") || str.equals("mod");
    }

    protected int precedencia(String simbolo){
        int valor = -1;
        if(isValidOperator(simbolo)){
            if(simbolo.equals("+") || simbolo.equals("-")){
                valor = 0;
            }else{
                valor = 1;
            }
        }
        return valor;
    }

    public String getCadenaPostFix(){
        return Cadenapostfix;
    };

    protected void setCadenaPostFix(String nuevacadena){
        this.Cadenapostfix = nuevacadena;
    }
}

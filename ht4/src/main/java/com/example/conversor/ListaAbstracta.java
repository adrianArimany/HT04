package com.example.conversor;

abstract class ListaAbstracta<T> implements ILista<T> {
    protected int tamaño = 0;
    
    public int getTamaño() {
        return tamaño;
    }
}

package com.example;

public interface ILista<T> {
    void insertar(T dato);
    T eliminar();
    T obtenerTope();
    boolean estaVacia();
}
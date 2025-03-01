package com.example;

class ListaDoble<T> extends ListaAbstracta<T> {
    private class Nodo {
        T dato;
        Nodo siguiente, anterior;
        Nodo(T dato) {
            this.dato = dato;
        }
    }
    
    private Nodo cabeza;
    
    @Override
    public void insertar(T dato) {
        Nodo nuevo = new Nodo(dato);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            nuevo.siguiente = cabeza;
            cabeza.anterior = nuevo;
            cabeza = nuevo;
        }
        tamaño++;
    }
    
    @Override
    public T eliminar() {
        if (cabeza == null) return null;
        T dato = cabeza.dato;
        cabeza = cabeza.siguiente;
        if (cabeza != null) cabeza.anterior = null;
        tamaño--;
        return dato;
    }
    
    @Override
    public T obtenerTope() {
        return (cabeza != null) ? cabeza.dato : null;
    }
    
    @Override
    public boolean estaVacia() {
        return cabeza == null;
    }
}
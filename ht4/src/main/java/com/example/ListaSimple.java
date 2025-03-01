class ListaSimple<T> extends ListaAbstracta<T> {
    private class Nodo {
        T dato;
        Nodo siguiente;
        Nodo(T dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    private Nodo cabeza;
    
    @Override
    public void insertar(T dato) {
        Nodo nuevo = new Nodo(dato);
        nuevo.siguiente = cabeza;
        cabeza = nuevo;
        tamaño++;
    }

    @Override
    public T eliminar() {
        if (cabeza == null) return null;
        T dato = cabeza.dato;
        cabeza = cabeza.siguiente;
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

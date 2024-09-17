package unam.fesaragon.estructuradatos.adt.colaadtconprioridad;

import unam.fesaragon.estructuradatos.adt.colaadt.NodoDoble;

class NodoDobleCola<T> extends NodoDoble<T> {
    private int prioridad;

    public NodoDobleCola() {
    }

    public NodoDobleCola(T dato, int prioridad) {
        super(dato);
        this.prioridad = prioridad;
    }

    public NodoDobleCola(T dato, NodoDoble<T> anterior, NodoDoble<T> siguiente, int prioridad) {
        super(dato, anterior, siguiente);
        this.prioridad = prioridad;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }
}

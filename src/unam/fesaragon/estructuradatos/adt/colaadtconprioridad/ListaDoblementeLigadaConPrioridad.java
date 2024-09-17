package unam.fesaragon.estructuradatos.adt.colaadtconprioridad;

import unam.fesaragon.estructuradatos.adt.colaadt.ListaDoblementeLigada;

class ListaDoblementeLigadaConPrioridad<T> extends ListaDoblementeLigada<T> {

    public ListaDoblementeLigadaConPrioridad() {
        super();
    }

    public ListaDoblementeLigadaConPrioridad(NodoDobleCola<T> head, NodoDobleCola<T> tail) {
        super(head, tail);
    }

    public void agregarAlFinal(T valor, int prioridad) {
        NodoDobleCola<T> nodoAInsertar = new NodoDobleCola<>(valor, prioridad);

        if (this.estaVacia()) {
            this.setHead(nodoAInsertar);
            this.setTail(nodoAInsertar);
        } else {
            NodoDobleCola<T> nodoReferencia = obtenerNodoReferencia(prioridad);

            if (nodoReferencia == null) {
                insertarDespues((NodoDobleCola<T>) this.getTail(), nodoAInsertar);
            } else if (nodoReferencia.getPrioridad() < prioridad) {
                insertarDespues(nodoReferencia, nodoAInsertar);
            } else if (nodoReferencia.getPrioridad() == prioridad) {
                insertarDespues(obtUltimoNodoMismaPri(prioridad), nodoAInsertar);
            } else {
                insertarAntes(nodoReferencia, nodoAInsertar);
            }
        }

        this.setTamanio(this.getTamanio() + 1);
    }

    private NodoDobleCola<T> obtenerNodoReferencia(int prioridad) {
        if (exMismaPrioridad(prioridad)) {
            return obtUltimoNodoMismaPri(prioridad);
        } else if (exPrioAnterior(prioridad)) {
            return obtNodoPrioridadAnterior(prioridad);
        } else {
            return (NodoDobleCola<T>) this.getHead();
        }
    }

    private void insertarDespues(NodoDobleCola<T> nodoReferencia, NodoDobleCola<T> nodoAInsertar) {
        nodoAInsertar.setAnterior(nodoReferencia);
        nodoAInsertar.setSiguiente(nodoReferencia.getSiguiente());

        if (nodoReferencia.getSiguiente() != null) {
            nodoReferencia.getSiguiente().setAnterior(nodoAInsertar);
        }

        nodoReferencia.setSiguiente(nodoAInsertar);

        if (nodoReferencia == this.getTail()) {
            this.setTail(nodoAInsertar);
        }
    }

    private void insertarAntes(NodoDobleCola<T> nodoReferencia, NodoDobleCola<T> nodoAInsertar) {
        nodoAInsertar.setSiguiente(nodoReferencia);
        nodoAInsertar.setAnterior(nodoReferencia.getAnterior());

        if (nodoReferencia.getAnterior() != null) {
            nodoReferencia.getAnterior().setSiguiente(nodoAInsertar);
        }

        nodoReferencia.setAnterior(nodoAInsertar);

        if (nodoReferencia == this.getHead()) {
            this.setHead(nodoAInsertar);
        }
    }

    private boolean exMismaPrioridad(int prioridad) {
        NodoDobleCola<T> aux = (NodoDobleCola<T>) this.getHead();
        while (aux != null) {
            if (aux.getPrioridad() == prioridad) {
                return true;
            }
            aux = (NodoDobleCola<T>) aux.getSiguiente();
        }
        return false;
    }

    private boolean exPrioAnterior(int prioridad) {
        NodoDobleCola<T> aux = (NodoDobleCola<T>) this.getTail();
        while (aux.getAnterior() != null) {
            if (aux.getPrioridad() < prioridad) {
                return true;
            }
            aux = (NodoDobleCola<T>) aux.getAnterior();
        }
        return false;
    }

    private NodoDobleCola<T> obtUltimoNodoMismaPri(int prioridad) {
        NodoDobleCola<T> aux = (NodoDobleCola<T>) this.getHead();
        NodoDobleCola<T> ultimoConMismaPrioridad = null;

        while (aux != null) {
            if (aux.getPrioridad() == prioridad) {
                ultimoConMismaPrioridad = aux;
            }
            aux = (NodoDobleCola<T>) aux.getSiguiente();
        }

        return ultimoConMismaPrioridad;
    }

    private NodoDobleCola<T> obtNodoPrioridadAnterior(int prioridad) {
        NodoDobleCola<T> aux = (NodoDobleCola<T>) this.getTail();
        while (aux.getAnterior() != null) {
            if (aux.getPrioridad() < prioridad) {
                return aux;
            }
            aux = (NodoDobleCola<T>) aux.getAnterior();
        }
        return aux;
    }
}

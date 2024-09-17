package unam.fesaragon.estructuradatos.adt.colaadtconprioridad;

import unam.fesaragon.estructuradatos.adt.colaadt.ColaADT;

public class ColaConPrioridadADT<T> extends ColaADT<T> {

    protected ListaDoblementeLigadaConPrioridad<T> datos;

    //CONSTRUCTOR
    public ColaConPrioridadADT() {
        this.datos = new ListaDoblementeLigadaConPrioridad<>();
        setData(this.datos);
    }

    //METODOS

    @Override
    public int longitud() {
        return this.datos.getTamanio();
    }

    public void encolar(int prioridad, T valor) {
        // Algoritmo para encolar según su prioridad
        datos.agregarAlFinal(valor, prioridad);
    }


    @Override
    public T desEncolar() {
        //Obtener el primer elemento
        T dato = this.datos.obtener(1);
        //Despues eliminarlo
        this.datos.eliminar_el_primero();
        return dato;

    }

    @Override
    public String toString() {
        return datos.toString();
    }
}

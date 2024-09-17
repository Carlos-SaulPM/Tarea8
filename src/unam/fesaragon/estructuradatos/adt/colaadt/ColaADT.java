package unam.fesaragon.estructuradatos.adt.colaadt;

public class ColaADT<T> {
    private ListaDoblementeLigada<T> data;

    //CONSTRUTOR
    public ColaADT() {
        this.data = new ListaDoblementeLigada<>();
    }

    //METODOS
    public boolean estaVacia() {
        return this.data.estaVacia();
    }

    public int longitud() {
        return this.data.getTamanio();
    }

    public T frente() {
        return this.data.obtener(1);
    }

    public void encolar(T valor) { //enqueue
        this.data.agregarAlFinal(valor);
    }

    public T desEncolar() {
        //Obtener el primer elemento
        T dato = this.data.obtener(1);
        //Despues eliminarlo
        this.data.eliminar_el_primero();
        return dato;
    }

    public T siguiente() {
        return this.data.obtener(2);
    }

    public void setData(ListaDoblementeLigada<T> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return this.data.toString();
    }
}

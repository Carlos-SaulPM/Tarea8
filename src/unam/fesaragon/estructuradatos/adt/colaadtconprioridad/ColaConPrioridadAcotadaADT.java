package unam.fesaragon.estructuradatos.adt.colaadtconprioridad;

public class ColaConPrioridadAcotadaADT<T> extends ColaConPrioridadADT<T> {
    private int prioridadAcotada;

    public ColaConPrioridadAcotadaADT(int prioridadAcotadaMaxima) {
        super();
        this.prioridadAcotada = prioridadAcotadaMaxima;
    }

    @Override
    public void encolar(int prioridad, T valor) {
        if (prioridad > 0 && prioridad <= prioridadAcotada) {
            super.encolar(prioridad, valor);
        } else {
            System.out.println("No se puede ingresar por que la prioridad esta fuera del rango acotado: " + this.prioridadAcotada);
        }
    }

}

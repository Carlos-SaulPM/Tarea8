package unam.fesaragon.estructuradatos.banco;

public class ClienteBanco {
    private int edad;
    private String nombre;
    private String apellido;
    private String nombreCompleto;
    private int numeroDeCuenta;
    private float dineroEnCuenta;
    private int tipoDeClienteBanco;

    public ClienteBanco(String nombre, String apellido,  int edad, int numeroDeCuenta, float dineroEnCuenta, int tipoDeClienteBanco) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.edad = edad;
        this.nombreCompleto= nombre+" "+apellido;
        this.numeroDeCuenta = numeroDeCuenta;
        this.dineroEnCuenta = dineroEnCuenta;
        this.tipoDeClienteBanco = tipoDeClienteBanco;
    }

    public void retirarDinero(float dineroARetirar){
        if (getDineroEnCuenta()<dineroARetirar){
            System.out.println("No hay dinero suficiente para realizar tu retiro");
        }else {
            setDineroEnCuenta(getNumeroDeCuenta()-dineroARetirar);
        }
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setDineroEnCuenta(float dineroEnCuenta) {
        this.dineroEnCuenta = dineroEnCuenta;
    }

    public int getEdad() {
        return edad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public int getNumeroDeCuenta() {
        return numeroDeCuenta;
    }

    public float getDineroEnCuenta() {
        return dineroEnCuenta;
    }

    public int getTipoDeClienteBanco() {
        return tipoDeClienteBanco;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getNombreCompleto()).append(" "+getEdad()).append(" $"+getDineroEnCuenta()).append(" "+ getTipoDeClienteBanco());
        return sb.toString();
    }
}

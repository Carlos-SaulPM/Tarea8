package unam.fesaragon.estructuradatos;

import unam.fesaragon.estructuradatos.adt.colaadtconprioridad.ColaConPrioridadADT;
import unam.fesaragon.estructuradatos.adt.colaadtconprioridad.ColaConPrioridadAcotadaADT;
import unam.fesaragon.estructuradatos.banco.BancoTiposDeCliente;
import unam.fesaragon.estructuradatos.banco.ClienteBanco;

public class Main {
    public static void main(String[] args) {
        ColaConPrioridadADT<ClienteBanco> colaAcotada = new ColaConPrioridadAcotadaADT<>(5);
        imp("\n\nAGREGANDO 2 CLIENTES NUEVOS ");
        colaAcotada.encolar(new ClienteBanco("Carlos", "Paz", 18, 203423003, 20000f, BancoTiposDeCliente.CLIENTE_NUEVO));
        colaAcotada.encolar(new ClienteBanco("Armando", "Perez", 20, 203423004, 400f, BancoTiposDeCliente.CLIENTE_NUEVO));

        imp("AGREGANDO 3 PERSONAS QUE NO SON CLIENTES ");
        colaAcotada.encolar(new ClienteBanco("Alejandra", "Hernandez", 20, 203423005, 0f, BancoTiposDeCliente.NO_ES_CLIENTE));
        colaAcotada.encolar(new ClienteBanco("Ismael", "Castillo", 20, 203423006, 40f, BancoTiposDeCliente.NO_ES_CLIENTE));
        colaAcotada.encolar(new ClienteBanco("Ana", "Cervantes", 20, 203423007, 4000f, BancoTiposDeCliente.NO_ES_CLIENTE));

        imp("AGREGANDO A CELEBRIDAD ");
        colaAcotada.encolar(new ClienteBanco("Esmeralda", "Gutierrez", 20, 203423008, 100000f, BancoTiposDeCliente.CELEBRIDADES));

        imp("\n\nIMPRIMIENDO ESTADO DE LA COLA ACTUAL: ");
        imp("[Nombre Edad Dinero Tipo]");
        imp(colaAcotada.toString());

        imp("\nATENDIENDO SIGUIENTE CLIENTE, DONDE RETIRA $10,000: ");
        colaAcotada.desEncolar().retirarDinero(10000f);

        imp("\n\nLLEGAN DOS CLIENTES MAS ");
        imp("CLIENTE FRECUENTE ");
        colaAcotada.encolar(new ClienteBanco("Sebastian", "Espinoza", 30, 203423009, 10000f, BancoTiposDeCliente.CLIENTE_FRECUENTE));

        imp("CLIENTE PREMIUM ");
        colaAcotada.encolar(new ClienteBanco("Estefania", "Licea", 22, 203423010, 10000f, BancoTiposDeCliente.CLIENTE_PREMIUM));

        imp("ATENDIENDO SIGUIENTE CLIENTE: ");
        imp(colaAcotada.desEncolar().toString());

        imp("\n\nIMPRIMIENDO ESTADO DE LA COLA ACTUAL: ");
        imp("[Nombre Edad Dinero Tipo]");
        imp(colaAcotada.toString());
        imp("\n\n");
        while (!colaAcotada.estaVacia()) {
            imp("ATENDIENDO EL SIGUIENTE CLIENTE: ");
            imp(colaAcotada.desEncolar().toString());
        }

        imp("\n\nEstado de la cola actual:\n" + colaAcotada.toString());
    }

    private static void imp(String texto) {
        System.out.println(texto);
    }
}

package aplicacion;
import dominio.*;
import presentacion.Interfaz;
import java.io.*;

/**
 * Esta clase es aquella que da lugar a la ejecucion del programa
 */
public class Principal {
    /**
     * El metodo de ejecucion del programa
     *
     * @param args son los argumentos introducidos por el usuario mediante la terminal
     */
    //En Principal siempre vamos a tener el método main de ejecución
    public static void main(String[] args) {
        Interfaz interfaz = new Interfaz();
        String [] orden;
        System.out.print("\n\n\n ¡Bienvenido al catalogo de procesadores de Pablo Molina Garcia! \n\n\n");
        interfaz.ayuda();
        do {
            orden = interfaz.leerOrden();
        }while (interfaz.procesarOrden(orden));

    }
}

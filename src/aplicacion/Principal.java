package aplicacion;
import dominio.*;
import presentacion.Interfaz;
import java.io.*;

public class Principal {
    //En Principal siempre vamos a tener el método main de ejecución
    public static void main(String[] args) {
        Interfaz interfaz = new Interfaz();
        String [] orden;
        System.out.print("\n\n\n ¡Bienvenido al catálogo de procesadores de Pablo Molina García! \n\n\n");
        interfaz.ayuda();
        do {
            orden = interfaz.leerOrden();
        }while (interfaz.procesarOrden(orden));

    }
}

package aplicacion;
import dominio.*;
import presentacion.Interfaz;
import java.io.*;

public class Principal {
    //En Principal siempre vamos a tener el método main de ejecución
    public static void main(String[] args) {
        Interfaz interfaz = new Interfaz();
        String [] orden;
        interfaz.ayuda();
        do {
            orden = interfaz.leerOrden();
            System.out.println("comprobación Principal");
        }while (interfaz.procesarOrden(orden));

    }
}

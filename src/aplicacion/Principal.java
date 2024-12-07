package aplicacion;
import presentacion.Interfaz;
import excepciones.*;

/**
 * @author Pablo Molina García
 *
 * Esta clase es aquella que da lugar a la ejecución del programa.
 */
public class Principal {
    /**
     * El método de ejecución del programa.
     *
     * @param args son los argumentos introducidos por el usuario mediante la terminal.
     * @throws ComponenteNoEncontrado es la excepción para los componentes, ya sean memorias o procesadores, que pueden no haberse encontrado porque no existan en el catálogo.
     * @throws MarcaNoEncontrada es la excepción para las marcas, ya sean de memorias o de procesadores, que pueden no haberse encontrado porque no existan en el catálogo.
     * @throws ComponenteDuplicado es la excepción para los componentes, ya sean memorias o procesadores, que ya se encuentran en el catálogo.
     * @throws MarcaDuplicada es la excepción para los componentes, ya sean de memorias o de procesadores, que ya se encuentran en el catálogo.
     */
    public static void main(String[] args) throws ComponenteDuplicado, MarcaDuplicada, ComponenteNoEncontrado, MarcaNoEncontrada{
        Interfaz interfaz = new Interfaz();
        String [] orden;
        System.out.print("\n\n\n ¡Bienvenido al catalogo de procesadores de Pablo Molina Garcia! \n\n\n");
        interfaz.ayuda();
        do {
            orden = interfaz.leerOrden();
        }while (interfaz.procesarOrden(orden));

    }
}

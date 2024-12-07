package excepciones;
import dominio.Componente;
import java.io.*;

/**
 * Esta es la clase de la excepción que se busca un componente cuando no existe dicho componente en el catálogo.
 *
 */
public class ComponenteNoEncontrado extends Exception implements Serializable{
    /**
     * Definimos el parámetro componenteNoEncontrado.
     */
    private Componente componenteNoEncontrado;

    /**
     * Constructor vacío sin parámetros.
     */
    public ComponenteNoEncontrado(){}

    /**
     * El constructor del componente no encontrado, que le asigna un valor inicial.
     * @param componente el componente buscado por el usuario que no ha sido encontrado.
     */
    public ComponenteNoEncontrado (Componente componente){
        this.componenteNoEncontrado=componenteNoEncontrado;
    }

    /**
     * Método getter para obtener el procesador no encontrado.
     * @return El procesador no encontrado.
     */
    public Componente getComponenteNoEncontrado(){
        return componenteNoEncontrado;
    }
}

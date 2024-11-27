package excepciones;
import dominio.*;
import java.io.*;

/**
 * Esta es la clase de la excepción que se da al añadir un componente cuando ya existe dicho componente en el catálogo.
 *
 */
public class ComponenteDuplicado extends Exception implements Serializable{
    /**
     * Definimos el parámetro componenteDuplicado.
     */
    private Componente componenteDuplicado;

    /**
     * El constructor del componente duplicado, que le asigna un valor inicial.
     * @param componente El componente añadido por el usuario.
     */
    public ComponenteDuplicado(Componente componente){
        this.componenteDuplicado=componenteDuplicado;
    }

    /**
     * Constructor vacío sin parámetros.
     */
    public ComponenteDuplicado(){}

    /**
     * Método getter para obtener el componente duplicado.
     * @return El componente duplicado.
     */
    public Componente getComponenteDuplicado(){
        return componenteDuplicado;
    }
}

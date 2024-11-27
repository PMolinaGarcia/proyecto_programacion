package excepciones;
import dominio.Marca;
import java.io.*;

/**
 * Esta es la clase de la excepción que se busca un componente cuando no existe dicho componente en el catálogo.
 *
 */
public class MarcaNoEncontrada extends Exception implements Serializable{
    /**
     * Definimos el parámetro componenteNoEncontrado.
     */
    private Marca marcaNoEncontrada;

    /**
     * Constructor vacío sin parámetros.
     */
    public MarcaNoEncontrada(){}

    /**
     * El constructor del componente no encontrado, que le asigna un valor inicial.
     * @param marca el componente buscado por el usuario que no ha sido encontrado.
     */
    public MarcaNoEncontrada(Marca marca){
        this.marcaNoEncontrada=marcaNoEncontrada;
    }

    /**
     * Método getter para obtener el procesador no encontrado.
     * @return El procesador no encontrado.
     */
    public Marca getMarcaNoEncontrada(){
        return marcaNoEncontrada;
    }
}

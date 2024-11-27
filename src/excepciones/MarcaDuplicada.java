package excepciones;
import dominio.*;

/**
 * Esta es la clase de la excepción que se da al añadir una marca cuando ya existe dicha marca en el catálogo.
 *
 */
public class MarcaDuplicada extends Exception {
    /**
     * Definimos el parámetro marcaDuplicada.
     */
    private MarcaProcesador marcaDuplicada;

    /**
     * El constructor de la marca duplicada, que le asigna un valor inicial.
     * @param marca La marca añadida por el usuario.
     */
    public MarcaDuplicada(Marca marca){
        this.marcaDuplicada=marcaDuplicada;
    }

    /**
     * Constructor vacío sin parámetros.
     */
    public MarcaDuplicada(){}

    /**
     * Método getter para obtener la marca duplicada.
     * @return La marca duplicada.
     */
    public Marca getMarcaDuplicada(){
        return marcaDuplicada;
    }
}

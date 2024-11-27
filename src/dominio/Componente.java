package dominio;
import java.io.*;

/**
 * Esta clase representa aquello que queremos almacenar en el catálogo: componentes de ordenador.
 * Implementa Serializable para el toString final y de cara a la función de guardado.
 */
public class Componente implements Serializable {

    /**
     * Definición de los atributos nombre, precio y generación, que serán comunes a todas las subclases de Componente.
     */
    protected String nombre;
    protected int precio;
    protected String generacion;


    /**
     * El constructor que asigna los valores iniciales a los atributos.
     *
     * @param nombre El nombre del procesador.
     * @param precio El precio del procesador.
     * @param generacion La generación del procesador.
     */
    public Componente(String nombre, String generacion, int precio){
        this.nombre = nombre;
        this.precio = precio;
        this.generacion = generacion;
    }

    /**
     * Constructor con el atributo nombre para llamadas que sean solo por el nombre; por ejemplo, para borrar.
     * @param nombre El nombre del componente.
     */
    public Componente(String nombre){
        this.nombre=nombre;
    }

    /**
     * Constructor vacío para posibles llamadas sin parámetros.
     */
    public Componente(){}

    /**
     * Método setter para el nombre.
     *
     * @param nombre El nuevo nombre del componente.
     * @return El objeto componente con el nuevo nombre.
     */
    public Componente setNombre(String nombre){
        this.nombre = nombre;
        return this;
    }

    /**
     * Método setter para el precio.
     *
     * @param precio El nuevo precio del componente.
     * @return El objeto componente con el nuevo precio (en euros).
     */
    public Componente setPrecio(int precio){
        this.precio = precio;
        return this;
    }

    /**
     * Método setter para la generación.
     *
     * @param generacion La nueva generación del componente.
     * @return El objeto componente con la nueva generación.
     */
    public Componente setGeneracion(String generacion){
        this.generacion = generacion;
        return this;
    }

    /**
     * Método getter para el nombre.
     *
     * @return El nombre del componente.
     */
    public String getNombre(){
        return nombre;
    }

    /**
     * Método getter para el precio.
     *
     * @return El precio del componente.
     */
    public int getPrecio(){
        return precio;
    }

    /**
     * Método getter para la generación.
     *
     * @return La generación del componente.
     */
    public String getGeneracion(){
        return generacion;
    }

    /**
     * El método toString.
     * @return Los datos del componente.
     */
    public String toString(){
        StringBuilder datos = new StringBuilder();
        datos.append("Nombre: ")
                .append(nombre)
                .append(". ")
                .append("Precio: ")
                .append(precio)
                .append(" euros. ")
                .append("Generacion: ")
                .append(generacion)
                .append(". ");
        return datos.toString();
    }
}

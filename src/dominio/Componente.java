package dominio;
import java.io.*;

/**
 * Esta clase representa aquello que queremos almacenar en el catálogo: componentes de ordenador.
 * Implementa Serializable para el toString final y de cara a la función de guardado.
 */
public class Componente implements Serializable {

    /**
     * Definición del atributo nombre, que representa el nombre del componente.
     */
    protected String nombre;

    /**
     * Definición del atributo precio, que es un double que representa el precio del componente en euros. Es double para poder usar hasta dos decimales, como en un precio habitual.
     */
    protected double precio;

    /**
     * Definición del atributo generación, que representa la generación de creación o venta del componente. Es String por si alguien prefiere escribir, por ejemplo, undécima en vez de 11.
     */
    protected String generacion;


    /**
     * El constructor que asigna los valores iniciales a los atributos.
     *
     * @param nombre El nombre del componente.
     * @param precio El precio del componente.
     * @param generacion La generación del componente.
     */
    public Componente(String nombre, String generacion, double precio){
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
     */
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    /**
     * Método setter para el precio.
     *
     * @param precio El nuevo precio del componente.
     */
    public void setPrecio(double precio){
        this.precio = precio;
    }

    /**
     * Método setter para la generación.
     *
     * @param generacion La nueva generación del componente.
     */
    public void setGeneracion(String generacion){
        this.generacion = generacion;
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
    public double getPrecio(){
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

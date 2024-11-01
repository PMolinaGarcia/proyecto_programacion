package dominio;
import java.io.*;


/**
 * Esta clase representa aquello que queremos almacenar en el catálogo: procesadores de ordenador.
 * Implementa Serializable para el toString final.
 */
//Creamos la clase tras importar las librerías necesarias
public class Procesador implements Serializable{


    //Definimos los atributos necesarios. Nombre del procesador, precio y generación
    /**
     * Definición del atributo nombre.
     */
    private String nombre;
    /**
     * Definición del atributo generación.
     */
    private String generacion;
    /**
     * Definición del atributo precio.
     */
    private int precio;


    /**
     * El constructor que asigna los valores iniciales a los atributos.
     *
     * @param nombre El nombre del procesador.
     * @param generacion La generación de fabricación o salida al mercado del procesador.
     * @param precio El precio del procesador (en euros).
     */
    //Constructor para dar valores iniciales que modificar
    public Procesador(String nombre, String generacion, int precio){
        this.nombre = nombre;
        this.generacion = generacion;
        this.precio = precio;
    }

    /**
     * Método setter para el nombre.
     *
     * @param nombre El nuevo nombre del procesador.
     * @return El nombre del procesador.
     */
    //Métodos setter
    public Procesador setNombre(String nombre){
        this.nombre = nombre;
        return this;
    }

    /**
     * Método setter para el precio.
     *
     * @param precio El nuevo precio del procesador.
     * @return El precio del procesador (en euros).
     */
    public Procesador setPrecio(int precio){
        this.precio = precio;
        return this;
    }

    /**
     * Método setter para la generación.
     *
     * @param generacion La nueva generación del procesador.
     * @return La generación del procesador.
     */
    public Procesador setGeneracion(String generacion){
        this.generacion = generacion;
        return this;
    }

    /**
     * Método getter para el nombre.
     *
     * @return El nombre del procesador.
     */
    //Métodos getter

    public String getNombre(){
        return nombre;
    }

    /**
     * Método getter para el precio.
     *
     * @return El precio del procesador.
     */
    public int getPrecio(){
        return precio;
    }

    /**
     * Método getter para la generación.
     *
     * @return La generación del procesador.
     */
    public String getGeneracion(){
        return generacion;
    }

    /**
     * El método toString.
     *
     * @return Los datos del procesador.
     */
    //Añadimos un StringBuilder que tenga todos los datos
    public String toString(){
        StringBuilder datos = new StringBuilder();
        datos.append("Nombre: " + nombre + ". ")
                .append("Precio: " + precio + " euros. ")
                .append("Generacion: " + generacion +". \n");
        return datos.toString();
    }

}
package dominio;
import java.io.*;


/**
 * Esta clase representa aquello que queremos almacenar en el catalogo: procesadores de ordenador. Implementa Serializable para el toString final
 */
//Creamos la clase tras importar las librerías necesarias
public class Procesador implements Serializable{

    /**
     * Los atributos del procesador a introducir manualmente
     */
    //Definimos los atributos necesarios. Nombre del procesador, precio y generación
    private String nombre;
    private String generacion;
    private int precio;


    /**
     * El constructor que asigna los valores iniciales a los atributos:
     *
     * @param nombre el nombre del procesador
     * @param generacion la generacion de fabricacion o venta del procesador
     * @param precio el precio del procesador (en euros)
     */
    //Constructor para dar valores iniciales que modificar
    public Procesador(String nombre, String generacion, int precio){
        this.nombre = nombre;
        this.generacion = generacion;
        this.precio = precio;
    }

    /**
     * Metodo setter para el nombre
     *
     * @param nombre el nuevo nombre del procesador
     * @return nombre del procesador
     */
    //Métodos setter
    public Procesador setNombre(String nombre){
        this.nombre = nombre;
        return this;
    }

    /**
     * Metodo setter para el precio
     *
     * @param precio el nuevo precio del procesador
     * @return precio del procesador (en euros)
     */
    public Procesador setPrecio(int precio){
        this.precio = precio;
        return this;
    }

    /**
     * Metodo setter para la generacion
     *
     * @param generacion la nueva generacion del procesador
     * @return generacion del procesador
     */
    public Procesador setGeneracion(String generacion){
        this.generacion = generacion;
        return this;
    }

    /**
     * Metodo getter para el nombre
     *
     * @return el nombre del procesador
     */
    //Métodos getter

    public String getNombre(){
        return nombre;
    }

    /**
     * Metodo getter para el precio
     *
     * @return el precio del procesador
     */
    public int getPrecio(){
        return precio;
    }

    /**
     * Metodo getter para la generacion
     *
     * @return la generacion del procesador
     */
    public String getGeneracion(){
        return generacion;
    }

    /**
     * El metodo toString
     *
     * @return los datos del procesador
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
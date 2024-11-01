package dominio;
import java.io.*;

//Creamos la clase tras importar las librerías necesarias
public class Procesador implements Serializable{

    //Definimos los atributos necesarios. Nombre del procesador, precio y generación
    private String nombre;
    private String generacion;
    private int precio;


    //Constructor para dar valores iniciales que modificar
    public Procesador(String nombre, String generacion, int precio){
        this.nombre = nombre;
        this.generacion = generacion;
        this.precio = precio;
    }
    //Métodos setter
    public Procesador setNombre(String nombre){
        this.nombre = nombre;
        return this;
    }
    public Procesador setPrecio(int precio){
        this.precio = precio;
        return this;
    }
    public Procesador setGeneracion(String generacion){
        this.generacion = generacion;
        return this;
    }

    //Métodos getter
    public String getNombre(){
        return nombre;
    }
    public int getPrecio(){
        return precio;
    }
    public String getGeneracion(){
        return generacion;
    }

    //Añadimos un StringBuilder que tenga todos los datos
    public String toString(){
        StringBuilder datos = new StringBuilder();
        datos.append("Nombre: " + nombre + ". ")
                .append("Precio: " + precio + " euros. ")
                .append("Generacion: " + generacion +". \n");
        return datos.toString();
    }

}
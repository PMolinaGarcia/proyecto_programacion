package dominio;
import java.io.*;

//Creamos la clase tras importar las librerías necesarias
public class Procesador implements Serializable{

    //Definimos los atributos necesarios. Nombre del procesador y precio
    private String nombre;
    private int precio;

    //Constructor para dar valores iniciales que modificar
    public Procesador(String nombre, int precio){
        this.nombre = nombre;
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

    //Métodos getter
    public String getNombre(){
        return nombre;
    }
    public int getPrecio(){
        return precio;
    }

    //Añadimos un StringBuilder que tenga todos los datos
    public String toString(){
        StringBuilder datos = new StringBuilder();
        datos.append("Nombre: " + nombre + "\n")
                .append("Precio: " + precio + "\n");
        return datos.toString();
    }

}
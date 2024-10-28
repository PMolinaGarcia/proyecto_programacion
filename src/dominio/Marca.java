package dominio;
import java.util.ArrayList;
import java.io.*;

//Definimos la clase
public class Marca implements Serializable{
    private String nombre;

    //Creamos un ArrayList para añadir todos los procesadores a la marca y clasificarlos
    private ArrayList<Procesador> procesadores = new ArrayList();

    //Método para añadir procesadores de cada marca
    public Marca addProcesador(Procesador procesador) {
        procesadores.add(procesador);
        return this;
    }

    //Método para eliminar procesadores de cada marca
    public Marca elimProcesador(Procesador procesador){
        procesadores.remove(procesador);
        return this;
       }

    //Si quiero que me diga el procesador que se encuentra en la posición i del ArrayList (de la lista)
    public Procesador getProcesador(int i){
        return procesadores.get(i);
    }
    //Método para modificar los datos de los procesadores ¡EN PROCESO! ¡HAY QUE REVISAR!
    public Marca modProcesador(Procesador procesador){
        procesadores.remove(procesador);
        procesadores.add(procesador);
        return this;
    }
    //Añadimos el método setter
    public Marca setNombre(String nombre){
        this.nombre = nombre;
        return this;
    }
    //Añadimos el método getter
    public String getNombre(){
        return nombre;
    }

    //Para calcular el precio total de los procesadores de la marca
    public int getPrecio(){
        int precio = 0;
        for (Procesador procesador : procesadores){
            precio += procesador.getPrecio();
        }
        return precio;
    }

    //Queremos saber la cantidad de procesadores total en el ArrayList, por lo que pedimos al programa que nos diga el tamaño de este
    public int getProcesadores(){
        return procesadores.size();
    }


    //Añadimos un StringBuilder que tenga todos los datos
    public String toString(){
        StringBuilder datos = new StringBuilder();
        datos.append("Nombre de la marca: " + nombre + "\n")
                .append("Precio total de todos los procesadores de la marca: " + getPrecio() + "\n");
        return datos.toString();
    }
}

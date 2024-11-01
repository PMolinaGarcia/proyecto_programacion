package dominio;
import java.util.ArrayList;
import java.io.*;

/**
 * Esta clase representa las marcas en las que clasificamos a los procesadores. Implementa Serializable para el toString final.
 */
//Definimos la clase
public class Marca implements Serializable{
    /**
     * Definición del atributo nombre.
     */
    private String nombre;

    /**
     * El constructor que asigna el valor inicial al nombre.
     *
     * @param nombre El nombre de la marca.
     */
    //Constructor para asignar valores iniciales
    public Marca(String nombre){
        this.nombre = nombre;
    }


    /**
     * El ArrayList al añadir todos los procesadores a la marca y clasificarlos.
     */
    //Creamos un ArrayList para añadir todos los procesadores a la marca y clasificarlos
    private ArrayList<Procesador> procesadores = new ArrayList();

    /**
     * El método para añadir procesadores de cada marca.
     *
     * @param procesador El procesador que se va a añadir.
     * @return El nuevo procesador añadido.
     */
    //Método para añadir procesadores de cada marca
    public Marca addProcesador(Procesador procesador) {
        procesadores.add(procesador);
        return this;
    }

    /**
     * El método para eliminar procesadores de cada marca.
     *
     * @param procesador El procesador que se va a eliminar.
     * @return El procesador eliminado.
     */
    //Método para eliminar procesadores de cada marca
    public Marca elimProcesador(Procesador procesador){
        procesadores.remove(procesador);
        return this;
       }

    /**
     * El método para que se indique el procesador que se encuentra en la posición i del ArrayList.
     * @param i El índice que indica la posición en el ArrayList.
     * @return El procesador en la posición i del ArrayList.
     */
    //Si quiero que me diga el procesador que se encuentra en la posición i del ArrayList (de la lista)
    public Procesador getProcesador(int i){
        return procesadores.get(i);
    }

    /**
     * El método setter del nombre de la marca.
     *
     * @param nombre El nombre de la marca.
     * @return El nombre de la marca.
     */
    //Añadimos el método setter
    public Marca setNombre(String nombre){
        this.nombre = nombre;
        return this;
    }

    /**
     * El método getter del nombre de la marca.
     *
     * @return El nombre de la marca.
     */
    //Añadimos el método getter
    public String getNombre(){
        return nombre;
    }

    /**
     * El método para calcular el precio total de los procesadores de la marca.
     *
     * @return El precio total de todos los procesadores de la marca (en euros).
     */
    //Para calcular el precio total de los procesadores de la marca
    public int getPrecio(){
        int precio = 0;
        for (Procesador procesador : procesadores){
            precio += procesador.getPrecio();
        }
        return precio;
    }

    /**
     * El método para saber la cantidad de procesadores total en el ArrayList.
     *
     * @return Tamaño del ArrayList de procesadores; es decir, la cantidad que hay.
     */
    //Queremos saber la cantidad de procesadores total en el ArrayList, por lo que pedimos al programa que nos diga el tamaño de este
    public int getProcesadores(){
        return procesadores.size();
    }

    /**
     * El método toString en forma de StrinBuilder para devolver los datos de la marca.
     *
     * @return Los datos de la marca.
     */
    //Añadimos un StringBuilder que tenga todos los datos
    public String toString(){
        StringBuilder datos = new StringBuilder();
        datos.append("-"+nombre + ". ")
                .append("Precio total de todos los procesadores de la marca: " + getPrecio() + " euros\n")
                .append("\n")
                .append("Procesadores disponibles de esta marca: \n")
                .append(procesadores.toString())
                .append("\n\n");
        return datos.toString();
    }
}

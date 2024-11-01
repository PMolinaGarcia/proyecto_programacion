package dominio;
import java.util.ArrayList;
import java.io.*;

/**
 * Esta clase representa las marcas en las que clasificamos a los procesadores. Implementa Serializable para el toString final
 */
//Definimos la clase
public class Marca implements Serializable{
    /**
     * El unico atributo que tenemos de las marcas es el nombre
     */
    private String nombre;

    /**
     * El constructor que asigna el valor inicial al nombre:
     *
     * @param nombre el nombre de la marca
     */
    //Constructor para asignar valores iniciales
    public Marca(String nombre){
        this.nombre = nombre;
    }


    /**
     * El ArrayList para anniadir todos los procesadores a la marca y clasificarlos
     */
    //Creamos un ArrayList para añadir todos los procesadores a la marca y clasificarlos
    private ArrayList<Procesador> procesadores = new ArrayList();

    /**
     * El metodo para anniadir procesadores de cada marca
     *
     * @param procesador el procesador que se va a anniadir
     * @return el nuevo procesador anniadido
     */
    //Método para añadir procesadores de cada marca
    public Marca addProcesador(Procesador procesador) {
        procesadores.add(procesador);
        return this;
    }

    /**
     * El metodo para eliminar procesadores de cada marca
     *
     * @param procesador el procesador que se va a eliminar
     * @return
     */
    //Método para eliminar procesadores de cada marca
    public Marca elimProcesador(Procesador procesador){
        procesadores.remove(procesador);
        return this;
       }

    /**
     * El metodo para que se indique el procesador que se encuentra en la posicion i del ArrayList (de la lista)
     * @param i el indice que indica la posicion en el ArrayList
     * @return el procesador en la posicion i del ArrayList
     */
    //Si quiero que me diga el procesador que se encuentra en la posición i del ArrayList (de la lista)
    public Procesador getProcesador(int i){
        return procesadores.get(i);
    }

    /**
     * El metodo setter del nombre de la marca
     *
     * @param nombre el nomnre de la marca
     * @return el nombre de la marca
     */
    //Añadimos el método setter
    public Marca setNombre(String nombre){
        this.nombre = nombre;
        return this;
    }

    /**
     * El metodo getter del nombre de la marca
     *
     * @return el nombre de la marca
     */
    //Añadimos el método getter
    public String getNombre(){
        return nombre;
    }

    /**
     * El metodo para calcular el precio total de los procesadores de la marca
     *
     * @return el precio total de todos los procesadores de la marca (en euros)
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
     * El metodo para saber la cantidad de procesadores total en el ArrayList
     *
     * @return tamannio del ArrayList de procesadores. Es decir, la cantidad que hay
     */
    //Queremos saber la cantidad de procesadores total en el ArrayList, por lo que pedimos al programa que nos diga el tamaño de este
    public int getProcesadores(){
        return procesadores.size();
    }

    /**
     * El metodo toString en forma de StrinBuilder para
     * @return los datos de la marca
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

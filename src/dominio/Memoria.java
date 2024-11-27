package dominio;
import java.io.*;

/**
 * Esta clase representa aquello que queremos almacenar en el catálogo: memorias de ordenador.
 * Implementa Serializable para el toString final y de cara a la función de guardado.
 */
public class Memoria extends Componente implements Serializable{
    /**
     * Definición del atributo capacidad
     */
    private int capacidad;
    /**
     * El constructor que asigna los valores iniciales a los atributos.
     * Recibe parte de los atributos de la superclase, Componente.
     *
     * @param nombre El nombre de la memoria.
     * @param precio El precio de la memoria.
     * @param generacion La generación de la memoria.
     * @param capacidad La capacidad de la memoria.
     */
    public Memoria(String nombre, String generacion, int precio, int capacidad){
        super(nombre,generacion,precio);
        this.capacidad=capacidad;
    }

    /**
     * Constructor vacío para posibles llamadas sin parámetros.
     */
    public Memoria(){}

    /**
     * Constructor con el atributo nombre para llamadas que sean solo por el nombre; por ejemplo, para borrar.
     * @param nombre El nombre del procesador.
     */
    public Memoria(String nombre){
        super(nombre);
    }

    /**
     * Método setter de la capacidad de la memoria.
     * @param capacidad Capacidad de la memoria.
     * @return La memoria con la capacidad actualizada.
     */
    public Memoria setCapacidad(int capacidad){
        this.capacidad=capacidad;
        return this;
    }

    /**
     * Método getter de la capacidad de la memoria.
     * @return La capacidad de la memoria
     */
    public int getCapacidad(){
        return capacidad;
    }

    /**
     * El método toString.
     * Hereda los datos de la superclase para añadir los propios.
     * @return Los datos de la memoria.
     */
    public String toString(){
        StringBuilder datos = new StringBuilder(super.toString());
        datos.append("Capacidad: ")
                .append(capacidad)
                .append(" GB.");
        return datos.toString();
    }
}

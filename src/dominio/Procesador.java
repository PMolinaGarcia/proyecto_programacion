package dominio;
import java.io.*;

/**
 * Esta clase representa uno de los tipos de componentes que queremos almacenar en el catálogo: procesadores de ordenador.
 * Implementa Serializable para el toString final y de cara a la función de guardado.
 */
public class Procesador extends Componente implements Serializable{
    /**
     * Definición del atributo núcleos
      */
    private int nucleos;
    /**
     * El constructor que asigna los valores iniciales a los atributos.
     * Importa parámetros de la superclase, Componente.
     *
     * @param nombre El nombre del procesador.
     * @param precio El precio del procesador.
     * @param generacion La generación del procesador.
     * @param nucleos Los núcleos del procesador.
     */
    public Procesador(String nombre, String generacion, double precio, int nucleos){
        super(nombre, generacion, precio);
        this.nucleos= nucleos;
    }
    /**
     * Constructor vacío para posibles llamadas sin parámetros.
     */
    public Procesador(){}
    /**
     * Constructor con el atributo nombre para llamadas que sean solo por el nombre; por ejemplo, para borrar.
     * @param nombre El nombre del procesador.
     */
    public Procesador(String nombre){
        this.nombre=nombre;
    }

    /**
     * Método setter del número de núcleos.
     * @param nucleos Número de núcleos del procesador.
     */
    public void setNucleos(int nucleos){
        this.nucleos = nucleos;
    }

    /**
     * Método getter del número de núcleos del procesador.
     * @return Número de núcleos del procesador.
     */
    public int getNucleos(){
        return nucleos;
    }
    /**
     * El método toString.
     * Hereda los datos de la superclase para añadir los propios.
     *
     * @return Los datos del procesador.
     */
    //Añadimos un StringBuilder que tenga todos los datos
    public String toString(){
        StringBuilder datos = new StringBuilder(super.toString());
        datos.append("Nucleos: ")
                .append(nucleos)
                .append(". \n");
         return datos.toString();
    }

}
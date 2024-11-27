package dominio;
import java.io.*;


/**
 * Esta clase representa aquello que queremos almacenar en el catálogo: procesadores de ordenador.
 * Implementa Serializable para el toString final y de cara a la función de guardado.
 */
//Creamos la clase tras importar las librerías necesarias
public class Procesador extends Componente implements Serializable{

    /**
     * Definición del atributo núcleos
      */
    private int nucleos;


    /**
     * El constructor que asigna los valores iniciales a los atributos.
     *
     * @param nombre El nombre del procesador.
     * @param precio El precio del procesador.
     * @param generacion La generación del procesador.
     * @param nucleos Los núcleos del procesador.
     */
    //Constructor para dar valores iniciales que modificar
    public Procesador(String nombre, String generacion, int precio, int nucleos){
        super(nombre, generacion, precio);
        this.nucleos= nucleos;
    }

    public Procesador(){}

    public Procesador(String nombre){
        this.nombre=nombre;
    }

    public Procesador setNucleos(int nucleos){
        this.nucleos = nucleos;
        return this;
    }

    public int getNucleos(){
        return nucleos;
    }
    /**
     * El método toString.
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
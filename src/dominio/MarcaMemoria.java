package dominio;
import java.util.ArrayList;
import java.io.*;
import java.util.Objects;

import excepciones.*;

/**
 * Esta clase representa las marcas en las que clasificamos a las memorias.
 * Implementa Serializable para el toString final y de cara al guardadp.
 */
public class MarcaMemoria extends Marca implements Serializable{

    /**
     * El ArrayList al añadir todas los memorias a la marca y clasificarlas.
     */
   private ArrayList<Memoria> memorias = new ArrayList<>();

    /**
     * El constructor que asigna el valor inicial al nombre.
     *
     * @param nombre El nombre de la marca.
     */
    public MarcaMemoria(String nombre){
        super(nombre);
    }

    /**
     * El método para añadir procesadores de cada marca.
     * Incluye el lanzamiento de una excepción en caso de que el componente (en este caso, memoria) ya exista. Si existe, se lanza la excepción; si no, se añade.
     *
     * @param memoria La memoria que se va a añadir.
     * @return El objeto Marca con la nueva memoria añadida.
     */
    public MarcaMemoria addMemoria(Memoria memoria) throws ComponenteDuplicado {
        if (memorias.contains(memoria)) {
            throw new ComponenteDuplicado(memoria);
        }
        else {
            memorias.add(memoria);
            return this;
        }
    }

    /**
     * El método para eliminar memorias de cada marca.
     * Incluye el lanzamiento de una excepción en caso de que no exista el componente (en este caso, la memoria) que se vaya a eliminar. Si existe, se procede a su eliminación; si no, se lanza la excepción.
     *
     * @param memoria La memoria que se va a eliminar.
     * @return El objeto marca con la memoria eliminada.
     */
    public MarcaMemoria elimMemoria(Memoria memoria) throws ComponenteNoEncontrado{
        if (memorias.contains(memoria)){
            memorias.remove(memoria);
            return this;
        }
        else {
            throw new ComponenteNoEncontrado(memoria);
        }
    }

    /**
     * El método para que se indique la memoria que se encuentra en la posición i del ArrayList.
     * @param i El índice que indica la posición en el ArrayList.
     * @return La memoria en la posición i del ArrayList.
     */
    public Memoria getMemoria(int i){
        return memorias.get(i);
    }


    /**
     * El método para calcular el precio total de las memorias de la marca.
     *
     * @return El precio total de todas las memorias de la marca (en euros).
     */
    public double getPrecio(){
        int precio = 0;
        for (Memoria memoria : memorias){
            precio += memoria.getPrecio();
        }
        return precio;
    }

    /**
     * El método para saber la cantidad de memorias total en el ArrayList.
     *
     * @return Tamaño del ArrayList de memorias; es decir, la cantidad que hay.
     */
    public int getMemorias(){
        return memorias.size();
    }


    /**
     * Se sobreescribe el método equals para comparar únicamente mediante los nombres de los objetos, de tal forma que dos marcas se comparen por su nombre, no por ser MarcaProcesador de clase o MarcaMemoria
     * @param obj El objeto cualquiera.
     * @return Objeto igual a otro objeto.
     */

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (obj instanceof Marca) {
            Marca other = (Marca) obj;
            return Objects.equals(nombre, other.nombre);
        }
        return false;
    }

    /**
     * Se sobreescribe el método hashCode que venía por defecto.
     * @return Un nuevo entero que será utilizado para organizar los objetos.
     */

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), nombre);
    }


    /**
     * El método toString en forma de StringBuilder para devolver los datos de la marca.
     *
     * @return Los datos de la marca de memorias junto con los datos de la clase Marca (el nombre).
     */
    public String toString(){
        StringBuilder datos = new StringBuilder(super.toString());
        datos.append(". ")
                .append("Precio total de todas las memorias de la marca: ")
                .append(getPrecio())
                .append(" euros\n")
                .append("\n")
                .append("Memorias disponibles de esta marca: \n")
                .append(memorias.toString())
                .append("\n\n");
        return datos.toString();
    }
}

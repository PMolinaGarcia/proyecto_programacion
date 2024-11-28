package dominio;
import java.util.Objects;
import java.io.*;

/**
 * Esta es la clase Marca, de la que derivan los diferentes tipos de marcas en función del componente.
 */
public class Marca implements Serializable {

    /**
     * Definición del atributo nombre.
     */
    protected String nombre;

    /**
     * Constructor para dar un valor inicial al atributo nombre.
     * @param nombre El nombre de la marca.
     */
    public Marca(String nombre){
        this.nombre=nombre;
    }

    /**
     * Constructor vacío para posibles llamadas sin atributos.
     */
    public Marca (){}

    /**
     * El método setter del nombre de la marca.
     *
     * @param nombre El nombre de la marca.
     * @return El objeto Marca con el nombre de la marca.
     */
    public Marca setNombre(String nombre){
        this.nombre=nombre;
        return this;
    }

    /**
     * El método getter del nombre de la marca.
     *
     * @return El nombre de la marca.
     */
    public String getNombre(){
        return nombre;
    }

    /**
     * El método getter del nombre de la marca.
     *
     * @return Un valor inicial que será cambiado según el método.
     */
    public int getPrecio() {
        return 0;
    }

    /**
     * El método toString para serializar los datos.
     * @return El toString de la clase Marca con el nombre.
     */
    public String toString(){
        StringBuilder datos = new StringBuilder();
        datos.append("Nombre de la marca: ")
                .append(nombre);;
        return datos.toString();
    }

    /**
     * Se sobreescribe el método equals para comparar únicamente mediante los nombres de los objetos, de tal forma que dos marcas se comparen por su nombre, no por ser MarcaProcesador de clase o MarcaMemoria.
     * @param obj El objeto cualquiera.
     * @return Objeto igual a otro objeto según el nombre.
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
        return Objects.hash(nombre);
    }
}

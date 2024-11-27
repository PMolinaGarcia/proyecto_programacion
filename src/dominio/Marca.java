package dominio;
import java.util.Objects;

/**
 * Esta es la clase Marca, de la que derivan los diferentes tipos de marcas en función del componente.
 */
public class Marca {

    /**
     * Definición del atributo nombre.
     */
    protected String nombre;

    public Marca(String nombre){
        this.nombre=nombre;
    }

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
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Marca marca = (Marca) obj;
        return Objects.equals(nombre, marca.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }
}

package dominio;

public class Componente {

    protected String nombre;
    protected int precio;
    protected String generacion;

    public Componente(String nombre, String generacion, int precio){
        this.nombre = nombre;
        this.precio = precio;
        this.generacion = generacion;
    }

    public Componente(String nombre){
        this.nombre=nombre;
    }

    public Componente(){}

    /**
     * Método setter para el nombre.
     *
     * @param nombre El nuevo nombre del procesador.
     * @return El nombre del procesador.
     */
    public Componente setNombre(String nombre){
        this.nombre = nombre;
        return this;
    }

    /**
     * Método setter para el precio.
     *
     * @param precio El nuevo precio del procesador.
     * @return El precio del procesador (en euros).
     */
    public Componente setPrecio(int precio){
        this.precio = precio;
        return this;
    }

    /**
     * Método setter para la generación.
     *
     * @param generacion La nueva generación del procesador.
     * @return La generación del procesador.
     */
    public Componente setGeneracion(String generacion){
        this.generacion = generacion;
        return this;
    }

    /**
     * Método getter para el nombre.
     *
     * @return El nombre del procesador.
     */
    public String getNombre(){
        return nombre;
    }

    /**
     * Método getter para el precio.
     *
     * @return El precio del procesador.
     */
    public int getPrecio(){
        return precio;
    }

    /**
     * Método getter para la generación.
     *
     * @return La generación del procesador.
     */
    public String getGeneracion(){
        return generacion;
    }

    public String toString(){
        StringBuilder datos = new StringBuilder();
        datos.append("Nombre: ")
                .append(nombre)
                .append(". ")
                .append("Precio: ")
                .append(precio)
                .append(" euros. ")
                .append("Generacion: ")
                .append(generacion)
                .append(". ");
        return datos.toString();
    }
}

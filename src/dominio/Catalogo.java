package dominio;
import java.io.*;
import java.util.ArrayList;

/**
 * Esta clase representa el catalogo total de los productos ofrecidos. Implementa Serializable para el toString final
 */
//Creamos la clase Catalogo, que será la que contenga a todo
public class Catalogo implements Serializable{
    /**
     * EL unico atributo que tiene el catalogo es su nombre
     */
    private String nombre;

    /**
     * Se crea un ArrayList que contenga las marcas
     */
    //Creamos un ArrayList que contenga lo anterior
    private ArrayList<Marca> marcas = new ArrayList<Marca>();

    /**
     * Metodo para anniadir marcas al catalogo
     *
     * @param marca la marca que se va a anniadir al catalogo
     * @return la marca anniadida
     */
    //El método para añadir marcas al catálogo
    public Catalogo addMarca(Marca marca){
        marcas.add(marca);
        return this;
    }

    /**
     * Metodo para eliminar marcas del catalogo
     *
     * @param marca la marca que se va a eliminar
     * @return
     */
    //El método para eliminar marcas del catálogo
    public Catalogo elimMarca(Marca marca){
        marcas.remove(marca);
        return this;
    }

    /**
     * Metodo setter del nombre del catalogo
     *
     * @param nombre nuevo nombre del catalogo
     * @return nombre del catalogo
     */
    //Métodos setter y getter
    public Catalogo setNombre(String nombre){
        this.nombre = "Catalogo";
        return this;
    }

    /**
     * Metodo getter del nombre del catalogo
     *
     * @return nombre del catalogo
     */
    public String getNombre(){
        return nombre;
    }

    /**
     * Llamada al ArrayList
     *
     * @return las marcas que tiene el ArrayList
     */
    //Llamamos al ArrayList para que me devuelva todo lo que contiene
    public ArrayList<Marca> getMarcas(){
        return marcas;
    }

    /**
     * Metodo para saber la cantidad de marcas que hay
     *
     * @return el tamannio del ArrayList de marcas. Es decir, la cantidad de marcas presentes
     */
    //Queremos saber cuántas marcas hay
    public int cantidadMarcas(){
        return marcas.size();
    }

    /**
     * Metodo para obtener la marca correspondiente a la posicion i
     *
     * @param i el indice de posicion dentro del ArrayList
     * @return la marca que ocupa la posicion i
     */
    //Si queremos un valor de una posición concreta
    public Marca getMarca(int i){
        return marcas.get(i);
    }

    /**
     * Metodo para calcular el precio total de todo el catalogo
     *
     * @return precio total de todos los articulos del catalogo
     */
    //Ahora calcularemos el precio total de todo el catálogo
    public int getPrecio(){
        int precio = 0;
        for (Marca marca : marcas) {
            precio += marca.getPrecio();
            }
        return precio;
        }

    /**
     * Metodo para guardar los datos del programa en un archivo de extension dat
     */
    //El siguiente método sirve para guardar todos los datos en un archivo. Consideramos que pueden existir excepciones (por ejemplo, que alguien introduzca mal un dato), entonces, mediante try and catch reconducimos la excepción a donde nos interesa; en este caso, da un mensaje de error. Esto también ayuda al programador a saber si funciona el código y dónde falla.
    public void guardar_datos(){
        try {
            ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream("catalogo.dat"));
            oo.writeObject(this);
            oo.close();
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("La funcion de guardado no se ha ejecutado correctamente. Revise el analisis realizado por el programa y vuelva a intentarlo.");

        }
    }

    /**
     * El metodo para inspeccionar los datos
     *
      * @return un nuevo objeto de tipo Catalogo con los datos
     */
    //Ya tenemos el método para guardar, pero necesitamos uno para leer y ver el contenido que hay.
    public static Catalogo inspeccionar(){
        try {
            //Lo de dentro del archivo (fichero) se abre como fichero y se lee. Se crea un string de lo que hay dentro
            ObjectInputStream oi = new ObjectInputStream (new FileInputStream("catalogo.dat"));
            Catalogo c = (Catalogo) oi.readObject();
            oi.close();
            return c;
        } catch (Exception e){
            return new Catalogo();
        }
    }

    /**
     * EL metodo toString con todos los datos del catalogo. Se utiliza un StringBuilder
     *
     * @return todos los datos del catalogo
     */
    //El método to String
    public String toString(){
        StringBuilder datos = new StringBuilder();
        datos.append(nombre+" "+ "\n")
                .append("Precio total productos: ")
                .append(getPrecio())
                .append(" euros\n")
                .append("Marcas disponibles: \n")
                .append(marcas.toString());
        return datos.toString();
        }

}

package dominio;
import java.io.*;
import java.util.ArrayList;
import excepciones.*;

/**
 * Esta clase representa el catálogo total de los productos ofrecidos. Implementa Serializable para el toString final.
 */
//Creamos la clase Catalogo, que será la que contenga a todo
public class Catalogo implements Serializable{
    /**
     * Se define el nombre del catálogo.
     */
    private String nombre;

    /**
     * Se crea un ArrayList que contenga las marcas.
     */
    //Creamos un ArrayList que contenga lo anterior
    private ArrayList<Marca> marcas = new ArrayList<Marca>();

    /**
     * Método para añadir marcas al catálogo.
     *
     * @param marca La marca que se va a añadir al catálogo.
     * @return La marca añadida.
     */
    //El método para añadir marcas al catálogo
    public Catalogo addMarca(Marca marca) throws MarcaDuplicada {
        if (marcas.contains(marca))
            throw new MarcaDuplicada(marca);

        marcas.add(marca);
        return this;
    }

    /**
     * Método para eliminar marcas del catálogo.
     *
     * @param marca La marca que se va a eliminar.
     * @return El objeto catalogo con la marca eliminada.
     */
    //El método para eliminar marcas del catálogo
    public Catalogo elimMarca(Marca marca) throws MarcaNoEncontrada{
        if (marcas.contains(marca)){
            marcas.remove(marca);
        }else {
            System.out.print("ALGO FALLA EN CATALOGO");
            throw new MarcaNoEncontrada(marca);
        }
        return this;
    }

    /**
     * Método setter del nombre del catálogo para asignar un valor al atributo nombre.
     *
     * @param nombre Nuevo nombre del catálogo.
     * @return El nombre del catálogo.
     */
    //Métodos setter y getter
    public Catalogo setNombre(String nombre){
        this.nombre = "Catalogo";
        return this;
    }

    /**
     * Método getter del nombre del catálogo.
     *
     * @return El nombre del catálogo.
     */
    public String getNombre(){
        return nombre;
    }

    /**
     * Llamada al ArrayList.
     *
     * @return Las marcas que tiene el ArrayList.
     */
    //Llamamos al ArrayList para que me devuelva todo lo que contiene
    public ArrayList<Marca> getMarcas(){
        return marcas;
    }

    /**
     * Método para saber la cantidad de marcas que hay.
     *
     * @return El tamaño del ArrayList de marcas; es decir, la cantidad de marcas presentes.
     */
    //Queremos saber cuántas marcas hay
    public int cantidadMarcas(){
        return marcas.size();
    }

    /**
     * Método para obtener la marca correspondiente a la posición i.
     *
     * @param i El índice de posición dentro del ArrayList.
     * @return La marca que ocupa la posición i.
     */
    //Si queremos un valor de una posición concreta
    public Marca getMarca(int i){
        return marcas.get(i);
    }

    /**
     * Método para calcular el precio total de todo el catálogo.
     *
     * @return El precio total de todos los artículos del catálogo.
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
     * Método para guardar los datos del programa en un archivo de extension dat.
     * Se utiliza un try and catch para manejar las posibles excepciones que puedan darse y dar un mensaje de error.
     * Si no funciona correctamente el programa, se muestran los orígenes del error.
     * Esto puede ayudar a solucionar el problema.
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
     * El método para inspeccionar los datos.
     * Se utiliza un try and catch para manejar las posibles excepciones que puedan darse.
     *
      * @return Un nuevo objeto de tipo Catalogo con los datos.
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
     * El método toString con todos los datos del catálogo.
     * Se utiliza un StringBuilder.
     *
     * @return Todos los datos del catálogo.
     */
    //El método to String
    public String toString(){
        StringBuilder datos = new StringBuilder();
        datos.append(nombre)
                .append(" ")
                .append("\n")
                .append("Precio total productos: ")
                .append(getPrecio())
                .append(" euros\n")
                .append("Marcas disponibles: \n")
                .append(marcas.toString());
        return datos.toString();
        }

}

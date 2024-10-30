package dominio;
import java.io.*;
import java.util.ArrayList;

//Creamos la clase Catalogo, que será la que contenga a todo
public class Catalogo implements Serializable{
    private String nombre;

    //Creamos un ArrayList que contenga lo anterior
    private ArrayList<Marca> marcas = new ArrayList<Marca>();

    //El método para añadir marcas al catálogo
    public Catalogo addMarca(Marca marca){
        marcas.add(marca);
        return this;
    }
    //El método para eliminar marcas del catálogo
    public Catalogo elimMarca(Marca marca){
        marcas.remove(marca);
        return this;
    }

    //Métodos setter y getter
    public Catalogo setNombre(String nombre){
        this.nombre = "Catálogo";
        return this;
    }
    public String getNombre(){
        return nombre;
    }

    //Llamamos al ArrayList para que me devuelva todo lo que contiene
    public ArrayList<Marca> getMarcas(){
        return marcas;
    }

    //Queremos saber cuántas marcas hay
    public int cantidadMarcas(){
        return marcas.size();
    }

    //Si queremos un valor de una posición concreta
    public Marca getMarca(int i){
        return marcas.get(i);
    }

    //Ahora calcularemos el precio total de todo el catálogo
    public int getPrecio(){
        int precio = 0;
        for (Marca marca : marcas) {
            precio += marca.getPrecio();
            }
        return precio;
        }

    //El siguiente método sirve para guardar todos los datos en un archivo. Consideramos que pueden existir excepciones (por ejemplo, que alguien introduzca mal un dato), entonces, mediante try and catch reconducimos la excepción a donde nos interesa; en este caso, da un mensaje de error. Esto también ayuda al programador a saber si funciona el código y dónde falla.
    public void guardar_datos(){
        try {
            ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream("catalogo.jar"));
            oo.writeObject(this);
            oo.close();
            System.out.print("comprobación Catalogo");
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("La función de guardado no se ha ejecutado correctamente. Revise el análisis realizado por el programa y vuelva a intetarlo.");

        }
    }

    //Ya tenemos el método para guardar, pero necesitamos uno para leer y ver el contenido que hay.
    public static Catalogo inspeccionar(){
        try {
            //Lo de dentro del archivo (fichero) se abre como fichero y se lee. Se crea un string de lo que hay dentro
            ObjectInputStream oi = new ObjectInputStream (new FileInputStream("catalogo.jar"));
            Catalogo c = (Catalogo) oi.readObject();
            oi.close();
            return c;
        } catch (Exception e){
            return new Catalogo();
        }
    }

    //El método to String
    public String toString(){
        StringBuilder datos = new StringBuilder();
        datos.append(nombre+" "+ "\n")
                .append("Precio total productos: ")
                .append(getPrecio());
        return datos.toString();
        }

}

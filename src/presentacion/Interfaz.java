package presentacion;
import dominio.*;
import java.util.*;
import java.io.*;


public class Interfaz implements Serializable {

    private Catalogo c = new Catalogo();

    //Abreviación del método para escanear
    private Scanner sc = new Scanner (System.in);

    //Para leer todo lo del archivo y que se asigne a un objeto c de Catalogo
    public Interfaz(){
        c = Catalogo.inspeccionar();
    }
    //Para ejecutar el guardado de datos
    public void guardar_datos(){
        c.guardar_datos();
    }
    public static void ayuda(){
        System.out.println("Tiene las siguientes opciones disponibles: \n addProcesador: para añadir un procesador al catálogo. \n addMarca: para añadir una marca en el catálogo. \n leer: inspeccionar archivo de guardado. \n elimProcesador: elimina un procesador. \n elimMarca: elimina una marca. \n modProcesador: para modificar los datos de un procesador. \n exit: para salir y guardar datos en un archivo de creación automática. \n");
    }


}

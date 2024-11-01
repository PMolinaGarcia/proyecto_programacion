package presentacion;
import dominio.*;
import java.util.*;
import java.io.*;

/**
 * Esta clase representa el interfaz que interactúa con el usuario.
 * Implementa Serializable para utilizar los toString del resto de clases.
 */
public class Interfaz implements Serializable {

    /**
     * Definición de un atributo c de tipo Catalogo.
     */
    private Catalogo c = new Catalogo();

    /**
     * Abreviación del método para escanear mediante un atributo.
     */
    //Abreviación del método para escanear
    private Scanner sc = new Scanner(System.in);

    /**
     * Constructor de la clase Interfaz para asignar un valor inicial al atributo c.
     * El valor viene dado por la inspección realizada en la clase Catalogo.
     */
    //Para leer todo lo del archivo y que se asigne a un objeto c de Catalogo
    public Interfaz() {
        c = Catalogo.inspeccionar();
    }

    /**
     * Función que ejecuta el guardado de los datos.
     */
    //Para ejecutar el guardado de datos
    public void guardar_datos() {
        c.guardar_datos();
    }

    /**
     * Método de ayuda que imprime todas las opciones disponibles en el programa.
     */
    public static void ayuda() {
        System.out.println("Tiene las siguientes opciones disponibles: \n addProcesador: para anniadir un procesador al catalogo. \n addMarca: para anniadir una marca en el catalogo. \n guardar: para guardar los datos en un archivo de guardado. \n leer: lectura inicial. \n elimProcesador: elimina un procesador. \n elimMarca: elimina una marca. \n lista: para mostrar por pantalla las marcas, procesadores y precios disponibles antes de guardar. \n exit: para salir y guardar los datos en un archivo de creacion automatica. \n");
    }

    /**
     * Método para añadir marcas.
     * Se escribe un texto a continuación del cual podemos escribir el nombre de la marca.
     * El scanner lee el valor y se imprime por pantalla.
     */
    //Método para añadir marcas. Se escribe un texto a continuación del cual podemos escribir el nombre de la marca. El scanner lee el valor
    public void anniadirMarca() {
        System.out.print("Escriba el nombre de la marca para anniadirla al catalogo: ");
        String nombre = sc.nextLine();
        c.addMarca(new Marca(nombre));
        System.out.println("Se ha anniadido la marca: " + nombre);
    }

    /**
     * Método para eliminar marcas a partir de su posición.
     */
    public void elimMarca() {
        System.out.print("Las marcas son: \n");
        for (int i = 0; i < c.cantidadMarcas(); i++) {
            System.out.println(i + ".- " + c.getMarca(i).getNombre());
        }
        System.out.print("Escriba el numero de la marca que desea eliminar: ");
        int j = sc.nextInt();
        sc.nextLine();
        Marca m = c.getMarca(j);
        c.elimMarca(m);
        System.out.println("Se ha eliminado la marca: " + m.getNombre());
    }

    /**
     * Método para añadir procesadores a partir de los datos introducidos por el usuario.
     * Los datos son leídos por el escáner.
     * Hay que especificar la marca previamente.
     */
    public void anniadirProcesador() {
        System.out.println("Las marcas disponibles son: \n");
        for (int i = 0; i < c.cantidadMarcas(); i++) {
            System.out.println(i + ".- " + c.getMarca(i).getNombre());
        }
        System.out.print("Numero de marca a la que quieras anniadir el procesador: ");
        int i = sc.nextInt();
        sc.nextLine();
        Marca m = c.getMarca(i);
        System.out.print("Escriba el nombre o modelo del procesador que quiera anniadir: ");
        String nombre = sc.nextLine();
        System.out.print("Escriba el precio del procesador (en euros): ");
        int precio = sc.nextInt();
        sc.nextLine();
        System.out.print("Escriba la generacion de creacion del procesador: ");
        String generacion = sc.nextLine();
        m.addProcesador(new Procesador(nombre, generacion, precio));
        System.out.println("Se ha anniadido el procesador: " + nombre);

    }

    /**
     * Método para eliminar procesadores a partir de la posición de estos.
     * Hay que especificar la marca previamente.
     */
    public void elimProcesador() {
        System.out.println("Las marcas disponibles son: \n");
        for (int i = 0; i < c.cantidadMarcas(); i++)
            System.out.println(i + ".- " + c.getMarca(i).getNombre());
        System.out.print("Numero de marca de la que quieras eliminar el procesador: ");
        int i = sc.nextInt();
        sc.nextLine();
        Marca m = c.getMarca(i);
        System.out.println("Los procesadores disponibles para esta marca son: ");
        for (i = 0; i < m.getProcesadores(); i++) {
            System.out.println(i + ".- " + m.getProcesador(i).getNombre());
        }
        System.out.print("Escriba el numero en lista del procesador que quiera eliminar: ");
        int j = sc.nextInt();
        sc.nextLine();
        Procesador p = m.getProcesador(j);
        m.elimProcesador(p);
        System.out.println("Se ha eliminado el procesador: " + p.getNombre());
    }

    /**
     * Método para leer todos los datos del catálogo.
     */
    public void leer() {

        String nombreM, nombreP;
        c.setNombre("Catalogo");
        do {
            System.out.print("Introduce el nombre de la marca (<enter> para finalizar): ");
            nombreM = sc.nextLine();
            if (!nombreM.equals("")) {
                Marca marca = new Marca(nombreM);
                do {
                    System.out.print("Introduce el nombre del procesador (<enter> para finalizar): ");
                    nombreP = sc.nextLine();
                    if (!nombreP.equals("")) {
                        System.out.print("Introduce el precio del procesador (<enter> para finalizar): ");
                        int precio = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Introduce el numero de generacion del procesador (<enter> para finalizar): ");
                        String generacion = sc.nextLine();
                        sc.nextLine();
                        Procesador procesador = new Procesador(nombreP, generacion, precio);
                        marca.addProcesador(procesador);
                    }

                }
                while (!nombreP.equals(""));
                c.addMarca(marca);

            }
        } while (!nombreM.equals(""));
    }


    /**
     * Método para que el programa lea la orden que le pasa el usuario.
     *
     * @return La orden introducida por el usuario.
     */
    public String[] leerOrden() {
        System.out.print("?>");
        String cadena = sc.nextLine();
        return cadena.split(" ");
    }

    /**
     * Método booleano que indica al programa como responder según la instrucción introducida por el usuario.
     *
     * @param orden Orden introducida por el usuario mediante la terminal.
     * @return El valor de verdad. Si es falso, deja de ejecutarse el programa. Si es verdadero, se mantiene funcionando.
     */
//Ahora necesitamos un boolean que asegure la ejecución del programa

    public boolean procesarOrden(String[] orden) {
        if (orden.length==1){
            if (orden[0].equals("addMarca"))
                anniadirMarca();
            else if (orden[0].equals("elimMarca"))
                elimMarca();
            else if (orden[0].equals("addProcesador"))
                anniadirProcesador();
            else if (orden[0].equals("elimProcesador"))
                elimProcesador();
            else if (orden[0].equals("lista")){
                c.setNombre("Catálogo\n");
                System.out.println(this.c);
            }
            else if (orden[0].equals("leer"))
                leer();
            else if (orden[0].equals("ayuda"))
                ayuda();
            else if (orden[0].equals("guardar"))
                c.guardar_datos();
            else if (orden[0].equals("salir")) {
                guardar_datos();
                return false;
            }
            else {
                System.out.println("Peticion erronea. Las unicas opciones disponibles son las siguientes: ");
                ayuda();
            }
        }
        else {
            System.out.println("Peticion erronea. Las únicas opciones disponibles son las siguientes: ");
            ayuda();
        }

        return true;


    }
}

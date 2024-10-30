package presentacion;
import dominio.*;
import java.util.*;
import java.io.*;


public class Interfaz implements Serializable {

    private Catalogo c = new Catalogo();

    //Abreviación del método para escanear
    private Scanner sc = new Scanner(System.in);

    //Para leer todo lo del archivo y que se asigne a un objeto c de Catalogo
    public Interfaz() {
        c = Catalogo.inspeccionar();
    }

    //Para ejecutar el guardado de datos
    public void guardar_datos() {
        c.guardar_datos();
    }

    public static void ayuda() {
        System.out.println("Tiene las siguientes opciones disponibles: \n addProcesador: para añadir un procesador al catálogo. \n addMarca: para añadir una marca en el catálogo. \n leer: inspeccionar archivo de guardado. \n elimProcesador: elimina un procesador. \n elimMarca: elimina una marca. \n modProcesador: para modificar los datos de un procesador. \n exit: para salir y guardar datos en un archivo de creación automática. \n");
    }

    //Método para añadir marcas. Se escribe un texto a continuación del cual podemos escribir el nombre de la marca. El scanner lee el valor
    public void añadirMarca() {
        System.out.println("Escriba el nombre de la marca para añadirla al catálogo: ");
        String nombre = sc.nextLine();
        System.out.println("La marca es: " + nombre);
        c.addMarca(new Marca(nombre));//REVISAR ESTE MÉTODO
    }

    public void elimMarca() {
        System.out.println("Las marcas son: ");
        for (int i = 0; i < c.cantidadMarcas(); i++) {
            System.out.println(i + ".- " + c.getMarca(i).getNombre());
            System.out.println("Escriba el nombre de la marca que desea eliminar: ");
            String nombre = sc.nextLine();
            sc.nextLine();
            c.elimMarca(new Marca(nombre));
        }
    }

    public void añadirProcesador() {
        System.out.println("Las marcas disponibles son: ");
        for (int i = 0; i < c.cantidadMarcas(); i++) {
            System.out.println(i + ".- " + c.getMarca(i).getNombre());
        }
        System.out.println("Número de marca a la que quieras añadir el procesador: ");
        int i = sc.nextInt();
        sc.nextLine();
        Marca m = c.getMarca(i);
        System.out.println("Escribe el nombre o modelo del procesador que quieras añadir: ");
        String nombre = sc.nextLine();
        int precio = sc.nextInt();
        sc.nextLine();
        m.addProcesador(new Procesador(nombre, precio));

    }

    public void elimProcesador() {
        System.out.println("Las marcas disponibles son: ");
        for (int i = 0; i < c.cantidadMarcas(); i++) {
            System.out.println(i + ".- " + c.getMarca(i).getNombre());
        }
        System.out.println("Número de marca de la que quieras eliminar el procesador: ");
        int i = sc.nextInt();
        sc.nextLine();
        Marca m = c.getMarca(i);
        System.out.println("Los procesadores disponibles para esta marca son: ");
        for (i = 0; i < m.getProcesadores(); i++) {
            System.out.println(i + ".- " + m.getProcesador(i).getNombre());
            System.out.println("Escribe el nombre o modelo del procesador que quieras eliminar y, separado por una coma, su precio: ");
            String nombre = sc.nextLine();
            int precio = sc.nextInt();
            sc.nextLine();
            m.elimProcesador(new Procesador(nombre, precio));
        }
    }

    public void modProcesador() {
        System.out.println("Las marcas disponibles son: ");
        for (int i = 0; i < c.cantidadMarcas(); i++) {
            System.out.println(i + ".- " + c.getMarca(i).getNombre());
        }
        System.out.println("Número de marca de la que quieras modificar el procesador: ");
        int i = sc.nextInt();
        sc.nextLine();
        Marca m = c.getMarca(i);
        System.out.println("Los procesadores disponibles para esta marca son: ");
        for (i = 0; i < m.getProcesadores(); i++) {
            System.out.println(i + ".- " + m.getProcesador(i).getNombre());
            System.out.println("Escribe el nombre o modelo del procesador que quieras modificar y, separado por una coma, su precio: ");
            String nombre = sc.nextLine();
            int precio = sc.nextInt();
            sc.nextLine();
            m.modProcesador(new Procesador(nombre, precio));
        }
    }
    public void leer(){
        String nombreM, nombreP;
        c.setNombre("Catálogo");
        do{
            System.out.println("Escriba el nombre de la marca: ");
            nombreM = sc.nextLine();
            if (!nombreM.equals("")){
                Marca marca = new Marca(nombreM);
                do {
                    System.out.println("Escribe el nombre o modelo del procesador: ");
                    nombreP = sc.nextLine();
                    if (!nombreP.equals("")){
                        System.out.println("Escribe el precio del procesador: ");
                        int precio = sc.nextInt();
                        sc.nextLine();
                        Procesador procesador = new Procesador(nombreP, precio);
                        marca.addProcesador(procesador);
                    }
                }while (!nombreP.equals(""));
                c.addMarca(marca);
            }

        }while (!nombreM.equals(""));

    }

    public String [] leerOrden(){
        System.out.print("?>");
        String cadena = sc.nextLine();
        return cadena.split("");
    }

//Ahora necesitamos un boolean que asegure la ejecución del programa

    public boolean procesarOrden (String [] c){
        if (c.length == 1) {
            if (c[0].equals("addMarca"))
                añadirMarca();
            else if (c[0].equals("elimMarca"))
                elimMarca();
            else if (c[0].equals("addProcesador"))
                añadirProcesador();
            else if (c[0].equals("elimProcesador"))
                elimProcesador();
            else if (c[0].equals("modProcesador"))
                modProcesador();
            else if (c[0].equals("lista"))
                System.out.println(this.c);
            else if (c[0].equals("leer"))
                leer();
            else if (c[0].equals("ayuda"))
                ayuda();
            else if (c[0].equals("salir")) {
                guardar_datos();
                return false;
            } else {
                System.out.println("Petición errónea. Las únicas opciones dispoibles son las siguientes: ");
                ayuda();
            }
        }
        else {
            System.out.println("Petición errónea. Las únicas opciones dispoibles son las siguientes: ");
            ayuda();
        }
        return true;

    }

}

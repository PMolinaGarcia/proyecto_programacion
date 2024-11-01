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
        System.out.println("Tiene las siguientes opciones disponibles: \n addProcesador: para añadir un procesador al catálogo. \n addMarca: para añadir una marca en el catálogo. \n guardar: para guardar los datos en un archivo de guardado. \n leer: inspeccionar archivo de guardado. \n elimProcesador: elimina un procesador. \n elimMarca: elimina una marca. \n lista: para mostrar por pantalla las marcas, procesadores y precios disponibles antes de guardar. \n exit: para salir y guardar los datos en un archivo de creación automática. \n");
    }

    //Método para añadir marcas. Se escribe un texto a continuación del cual podemos escribir el nombre de la marca. El scanner lee el valor
    public void anniadirMarca() {
        System.out.print("Escriba el nombre de la marca para añadirla al catálogo: ");
        String nombre = sc.nextLine();
        c.addMarca(new Marca(nombre));
        System.out.println("Se ha añadido la marca: " + nombre);
    }

    public void elimMarca() {
        System.out.print("Las marcas son: \n");
        for (int i = 0; i < c.cantidadMarcas(); i++) {
            System.out.println(i + ".- " + c.getMarca(i).getNombre());
        }
        System.out.print("Escriba el número de la marca que desea eliminar: ");
        int j = sc.nextInt();
        sc.nextLine();
        Marca m = c.getMarca(j);
        c.elimMarca(m);
        System.out.println("Se ha eliminado la marca: " + m.getNombre());
    }

    public void anniadirProcesador() {
        System.out.println("Las marcas disponibles son: \n");
        for (int i = 0; i < c.cantidadMarcas(); i++) {
            System.out.println(i + ".- " + c.getMarca(i).getNombre());
        }
        System.out.print("Número de marca a la que quieras añadir el procesador: ");
        int i = sc.nextInt();
        sc.nextLine();
        Marca m = c.getMarca(i);
        System.out.print("Escriba el nombre o modelo del procesador que quiera añadir: ");
        String nombre = sc.nextLine();
        System.out.print("Escriba el precio del procesador (en euros): ");
        int precio = sc.nextInt();
        System.out.print("Escriba la generación de creación del procesador: ");
        String generacion = sc.nextLine();
        sc.nextLine();
        m.addProcesador(new Procesador(nombre, generacion, precio));
        System.out.println("Se ha añadido el procesador: " + nombre);

    }

    public void elimProcesador() {
        System.out.println("Las marcas disponibles son: \n");
        for (int i = 0; i < c.cantidadMarcas(); i++)
            System.out.println(i + ".- " + c.getMarca(i).getNombre());
        System.out.print("Número de marca de la que quieras eliminar el procesador: ");
        int i = sc.nextInt();
        sc.nextLine();
        Marca m = c.getMarca(i);
        System.out.println("Los procesadores disponibles para esta marca son: ");
        for (i = 0; i < m.getProcesadores(); i++) {
            System.out.println(i + ".- " + m.getProcesador(i).getNombre());
        }
        System.out.print("Escriba el número en lista del procesador que quiera eliminar: ");
        int j = sc.nextInt();
        sc.nextLine();
        Procesador p = m.getProcesador(j);
        m.elimProcesador(p);
        System.out.println("Se ha eliminado el procesador: " + p.getNombre());
    }

    public void leer() {

        String nombreM, nombreP;
        c.setNombre("Catálogo");
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
                        System.out.print("Introduce el número de generacion del procesador (<enter> para finalizar): ");
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


    public String[] leerOrden() {
        System.out.print("?>");
        String cadena = sc.nextLine();
        return cadena.split(" ");
    }

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

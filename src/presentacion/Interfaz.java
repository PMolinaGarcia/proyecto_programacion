package presentacion;
import dominio.*;
import java.util.*;
import java.io.*;
import excepciones.*;

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
        System.out.println("Tiene las siguientes opciones disponibles: " +
                "\n addProcesador: para anniadir un procesador al catalogo. " +
                "\n elimProcesador: elimina un procesador. " +
                "\n modProcesador: para modificar los atributos de un procesador. " +
                "\n addMemoria: para anniadir una memoria al catalogo. " +
                "\n elimMemoria: elimina una memoria. " +
                "\n modMemoria: para modificar los atributos de una memoria. " +
                "\n addMarcaP: para anniadir una marca de procesadores en el catalogo. " +
                "\n addMarcaM: para anniadir una marca de memorias en el catalogo. " +
                "\n elimMarca: elimina una marca. " +
                "\n modMarca: para modificar el nombre de una marca. " +
                "\n guardar: para guardar los datos en un archivo de guardado. " +
                "\n leer: lectura inicial. " +
                "\n lista: para mostrar por pantalla las marcas, procesadores y precios disponibles antes de guardar. " +
                "\n exit: para salir y guardar los datos en un archivo de creacion automatica. \n");
    }

    /**
     * Métodos para añadir marcas.
     * Se escribe un texto a continuación del cual podemos escribir el nombre de la marca.
     * El scanner lee el valor y se imprime por pantalla.
     */
    //Método para añadir marcas. Se escribe un texto a continuación del cual podemos escribir el nombre de la marca. El scanner lee el valor
    public void anniadirMarcaProcesador() throws MarcaDuplicada{
        System.out.print("Escriba el nombre de la marca para anniadirla al catalogo: ");
        String nombre = sc.nextLine();
        c.addMarca(new MarcaProcesador(nombre));
        System.out.println("Se ha anniadido la marca: " + nombre+", que es de procesadores.");
    }

    /**
     * Métodos para añadir marcas.
     * Se escribe un texto a continuación del cual podemos escribir el nombre de la marca.
     * El scanner lee el valor y se imprime por pantalla.
     */
    public void anniadirMarcaMemoria() throws MarcaDuplicada{
        System.out.print("Escriba el nombre de la marca para anniadirla al catalogo: ");
        String nombre = sc.nextLine();
        c.addMarca(new MarcaMemoria(nombre));
        System.out.println("Se ha anniadido la marca: " + nombre+", que es de memorias.");
    }

    /**
     * Método para eliminar marcas a partir de su posición.
     */
    public void elimMarca() throws MarcaNoEncontrada {
        System.out.print("Las marcas son: \n");
        for (int i = 0; i < c.cantidadMarcas(); i++) {
            System.out.println(" -" + c.getMarca(i).getNombre());
        }
        System.out.print("Escriba el nombre de la marca que desea eliminar: ");
        String nombre = sc.nextLine();
        c.elimMarca(new Marca(nombre));
        System.out.println("Se ha eliminado la marca: " + nombre);
    }

    /**
     * Método para modificar marcas a partir de su posición.
     * Se utilizan los métodos setter para que, a partir de la marca de una determinada posicion del ArrayLista, podamos cambiar su nombre sin modificar lo que contiene.
     */
    public void modMarca() throws MarcaNoEncontrada {
        System.out.print("Las marcas son: \n");
        for (int i = 0; i < c.cantidadMarcas(); i++) {
            System.out.println(i + ".- " + c.getMarca(i).getNombre());
        }
        System.out.print("Escriba el numero de la marca que desea modificar: ");
        int j = sc.nextInt();
        sc.nextLine();
        Marca m = c.getMarca(j);
        System.out.println("Escriba el nuevo nombre de la marca que desea modificar: ");
        String nuevoNombre = sc.nextLine();
        m.setNombre(nuevoNombre);
        System.out.println("La marca ha sido modificada. ");
    }



    /**
     * Método para añadir procesadores a partir de los datos introducidos por el usuario.
     * Los datos son leídos por el escáner.
     * Hay que especificar la marca previamente.
     */
    public void anniadirProcesador() throws ComponenteDuplicado{
        System.out.println("Las marcas disponibles son: \n");
        for (int i = 0; i < c.cantidadMarcas(); i++) {
            System.out.println(i + ".- " + c.getMarca(i).getNombre());
        }
        System.out.print("Numero de marca a la que quieras anniadir el procesador: ");
        int i = sc.nextInt();
        sc.nextLine();
        MarcaProcesador m = (MarcaProcesador) c.getMarca(i);
        System.out.print("Escriba el nombre o modelo del procesador que quiera anniadir: ");
        String nombre = sc.nextLine();
        System.out.print("Escriba el precio del procesador (en euros): ");
        int precio = sc.nextInt();
        sc.nextLine();
        System.out.print("Escriba la generacion de creacion del procesador: ");
        String generacion = sc.nextLine();
        System.out.print("Escriba el numero de nucleos del procesador: ");
        int nucleos = sc.nextInt();
        sc.nextLine();
        m.addProcesador(new Procesador(nombre, generacion, precio, nucleos));
        System.out.println("Se ha anniadido el procesador: " + nombre);

    }

    /**
     * Método para eliminar procesadores a partir de su nombre.
     * Hay que especificar la posición de la marca previamente.
     */
    public void elimProcesador() throws ComponenteNoEncontrado {
        System.out.println("Las marcas disponibles son: \n");
        for (int i = 0; i < c.cantidadMarcas(); i++)
            System.out.println(i + ".- " + c.getMarca(i).getNombre());
        System.out.print("Numero de marca de la que quieras eliminar el procesador: ");
        int i = sc.nextInt();
        sc.nextLine();
        MarcaProcesador m = (MarcaProcesador) c.getMarca(i);
        System.out.println("Escriba el nombre del procesador que quieras eliminar: ");
        String nombre = sc.nextLine();
        m.elimProcesador(new Procesador (nombre));
        System.out.println("Se ha eliminado el procesador: "+nombre);
    }


    /**
     * Método para modificar procesadores a partir de su posición.
     * Se utilizan los métodos setter para que, a partir de la marca de una determinada posicion del ArrayList, podamos cambiar sus atributos.
     */
    public void modProcesador() throws ComponenteNoEncontrado, ComponenteDuplicado {
        System.out.println("Las marcas disponibles son: \n");
        for (int i = 0; i < c.cantidadMarcas(); i++)
            System.out.println(i + ".- " + c.getMarca(i).getNombre());
        System.out.println("Numero de marca de la que quieras modificar el procesador: ");
        int i = sc.nextInt();
        sc.nextLine();
        MarcaProcesador m = (MarcaProcesador) c.getMarca(i);
        for (int j = 0; j < m.getProcesadores(); j++)
            System.out.println(j + ".- " + m.getProcesador(i).getNombre());
        System.out.println("Escriba el numero del procesador que quieras modificar: ");
        int j = sc.nextInt();
        sc.nextLine();
        Procesador p =m.getProcesador(j);
        System.out.println("Escriba el nuevo nombre del procesador: ");
        String nombreNuevo = sc.nextLine();
        p.setNombre(nombreNuevo);
        System.out.println("Escriba el nuevo precio del procesador: ");
        int precioNuevo = sc.nextInt();
        sc.nextLine();
        p.setPrecio(precioNuevo);
        System.out.println("Escriba la nueva generacion del procesador: ");
        String generacionNueva = sc.nextLine();
        p.setGeneracion(generacionNueva);
        System.out.println("Escriba el nuevo numero de nucleos del procesador: ");
        int nucleosNuevos = sc.nextInt();
        sc.nextLine();
        p.setNucleos(nucleosNuevos);
        System.out.println("El procesador " + m.getProcesador(j).getNombre() + " ha sido modificado. ");
    }
    /**
     * Método para añadir memorias a partir de los datos introducidos por el usuario.
     * Los datos son leídos por el escáner.
     * Hay que especificar la marca previamente.
     * Se añade la opción de lanzar la excepción de que el componente se encuentra duplicado; es decir, que ya existe en la lista: en caso de que exista, se lanza la excepción; si no, se añade la memoria.
     */
    public void anniadirMemoria() throws ComponenteDuplicado {
        System.out.println("Las marcas disponibles son: \n");
        for (int i=0; i < c.cantidadMarcas(); i++)
            System.out.println(i +".-" + c.getMarca(i).getNombre());
        System.out.print("Numero de marca a la que quieras annadir la memoria: ");
        int i = sc.nextInt();
        sc.nextLine();
        MarcaMemoria m = (MarcaMemoria) c.getMarca(i);
        System.out.println("Escriba el nombre o modelo de la memoria que quieras annadir: ");
        String nombre = sc.nextLine();
        System.out.println("Escriba el precio de la memoria que quieras annadir (en euros): ");
        int precio = sc.nextInt();
        sc.nextLine();
        System.out.println("Escriba la generacion de la memoria que quieras annadir: ");
        String generacion = sc.nextLine();
        System.out.println("Escriba la capacidad de la memoria que quieras annadir (en GB): ");
        int capacidad = sc.nextInt();
        sc.nextLine();
        m.addMemoria(new Memoria (nombre,generacion,precio,capacidad));
        System.out.println("Se ha anniadido la memoria: " + nombre);
    }

    /**
     * Método para eliminar memorias a partir del número de índice de la marca a la que pertenece y su nombre.
     * Los datos son leídos por el escáner.
     * Hay que especificar la marca previamente.
     * Se añade la opción de lanzar la excepción de que el componente no se encuentra.
     */
    public void elimMemoria() throws ComponenteNoEncontrado{
        System.out.println("Las marcas disponibles son: ");
        for (int i = 0; i<c.cantidadMarcas();i++)
            System.out.print(i+".-" + c.getMarca(i).getNombre());
        System.out.print("Numero de marca de la que quieras eliminar la memoria: ");
        int i = sc.nextInt();
        sc.nextLine();
        MarcaMemoria m = (MarcaMemoria) c.getMarca(i);
        System.out.println("Escriba el nombre o modelo de la memoria que quieras eliminar: ");
        String nombre = sc.nextLine();
        m.elimMemoria(new Memoria (nombre));
        System.out.println("Se ha eliminado la memoria: "+nombre);

    }

    /**
     * Método para modificar memorias a partir de su posición.
     * Se utilizan los métodos setter para que, a partir de la marca de una determinada posicion del ArrayList, podamos cambiar sus atributos.
     */
    public void modMemoria() throws ComponenteNoEncontrado, ComponenteDuplicado {
        System.out.println("Las marcas disponibles son: \n");
        for (int i = 0; i < c.cantidadMarcas(); i++)
            System.out.println(i + ".- " + c.getMarca(i).getNombre());
        System.out.println("Numero de marca de la que quieras modificar el procesador: ");
        int i = sc.nextInt();
        sc.nextLine();
        MarcaMemoria m = (MarcaMemoria) c.getMarca(i);
        for (int j = 0; j < m.getMemorias(); j++)
            System.out.println(j + ".- " + m.getMemoria(i).getNombre());
        System.out.println("Escriba el numero de la memoria que quieras modificar: ");
        int j = sc.nextInt();
        sc.nextLine();
        Memoria mem =m.getMemoria(j);
        System.out.println("Escriba el nuevo nombre de la memoria: ");
        String nombreNuevo = sc.nextLine();
        mem.setNombre(nombreNuevo);
        System.out.println("Escriba el nuevo precio de la memoria: ");
        int precioNuevo = sc.nextInt();
        sc.nextLine();
        mem.setPrecio(precioNuevo);
        System.out.println("Escriba la nueva generacion de la memoria: ");
        String generacionNueva = sc.nextLine();
        mem.setGeneracion(generacionNueva);
        System.out.println("Escriba la nueva capacidad de la memoria: ");
        int capacidadNueva = sc.nextInt();
        sc.nextLine();
        mem.setCapacidad(capacidadNueva);
        System.out.println("La memoria " + m.getMemoria(j).getNombre() + " ha sido modificada. ");
    }

    /**
     * Método para leer todos los datos del catálogo.
     */
    public void leer() throws ComponenteDuplicado, MarcaDuplicada {

        String nombreM, nombreP;
        c.setNombre("Catalogo");
        do {
            System.out.print("Introduce el nombre de la marca (<enter> para finalizar): ");
            nombreM = sc.nextLine();
            if (!nombreM.equals("")) {
                MarcaProcesador marca = new MarcaProcesador(nombreM);
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
                        int nucleos = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Introduce el numero de nucleos del procesador (<enter> para finalizar): ");
                        Procesador procesador = new Procesador(nombreP, generacion, precio, nucleos);
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
     * Se emplea un try and catch para el manejo de las excepciones, de tal forma que, según la que suceda, se responda de una forma detemrinada.
     *
     *
     * @param orden Orden introducida por el usuario mediante la terminal.
     * @return El valor de verdad. Si es falso, deja de ejecutarse el programa. Si es verdadero, se mantiene funcionando.
     */
//Ahora necesitamos un boolean que asegure la ejecución del programa

    public boolean procesarOrden(String[] orden) throws ComponenteDuplicado, ComponenteNoEncontrado, MarcaDuplicada, MarcaNoEncontrada {
        try {
            if (orden.length == 1) {
                if (orden[0].equals("addMarcaP"))
                    anniadirMarcaProcesador();
                else if (orden[0].equals("addMarcaM"))
                    anniadirMarcaMemoria();
                else if (orden[0].equals("elimMarca"))
                    elimMarca();
                else if (orden[0].equals("modMarca"))
                    modMarca();
                else if (orden[0].equals("addProcesador"))
                    anniadirProcesador();
                else if (orden[0].equals("elimProcesador"))
                    elimProcesador();
                else if (orden[0].equals("modProcesador"))
                    modProcesador();
                else if (orden[0].equals("addMemoria"))
                    anniadirMemoria();
                else if (orden[0].equals("elimMemoria"))
                    elimMemoria();
                else if (orden[0].equals("modMemoria"))
                    modMemoria();
                else if (orden[0].equals("lista")) {
                    c.setNombre("Catálogo\n");
                    System.out.println(this.c);
                } else if (orden[0].equals("leer"))
                    leer();
                else if (orden[0].equals("ayuda"))
                    ayuda();
                else if (orden[0].equals("guardar"))
                    c.guardar_datos();
                else if (orden[0].equals("salir")) {
                    guardar_datos();
                    return false;
                } else {
                    System.out.println("Peticion erronea. Las unicas opciones disponibles son las siguientes: ");
                    ayuda();
                }
            } else {
                System.out.println("Peticion erronea. Las únicas opciones disponibles son las siguientes: ");
                ayuda();
            }

            return true;

        }catch(ComponenteDuplicado e){
            System.out.println("Este componente ya existe. ");
        }catch(MarcaDuplicada e){
            System.out.println("Esta marca ya existe. ");
        } catch(ComponenteNoEncontrado e) {
            System.out.println("Este componente no existe. ");
        } catch(MarcaNoEncontrada e){
            System.out.println("Esta marca no existe. ");
        }

        return true;


    }
}

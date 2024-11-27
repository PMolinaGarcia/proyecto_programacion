package dominio;

public class Memoria extends Componente{

    private int capacidad;

    public Memoria(String nombre, String generacion, int precio, int capacidad){
        super(nombre,generacion,precio);
        this.capacidad=capacidad;
    }

    public Memoria(String nombre){
        super(nombre);
    }

    public Memoria setCapacidad(int capacidad){
        this.capacidad=capacidad;
        return this;
    }

    public int getCapacidad(){
        return capacidad;
    }

    public String toString(){
        StringBuilder datos = new StringBuilder(super.toString());
        datos.append("Capacidad: ")
                .append(capacidad)
                .append(" GB.");
        return datos.toString();
    }
}

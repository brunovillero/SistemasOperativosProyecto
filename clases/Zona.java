package clases;
import java.util.LinkedList;
public class Zona {
    private final String nombre;
    private LinkedList<Local> locales;
    private LinkedList<Repartidor> repartidores;
    public Zona(String nombreZona, LinkedList<Local> locales){
        this.nombre=nombreZona;
        this.locales=locales;
    }
}

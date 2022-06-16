package clases;
import java.util.LinkedList;
public class Zona {
    private final String nombre;
    private LinkedList<Local> locales;
    private LinkedList<Repartidor> repartidores;
    public Zona(String nombreZona) {
        this.nombre = nombreZona;
        this.locales = locales;
        this.repartidores = repartidores;
    }

    public String getNombre() {
        return nombre;
    }

    public void setLocales(LinkedList<Local> locales) {
        this.locales = locales;
    }

    public void setRepartidores(LinkedList<Repartidor> repartidores) {
        this.repartidores = repartidores;
    }

    public LinkedList<Repartidor> getRepartidores() {
        return repartidores;
    }

    public LinkedList<Local> getLocales() {
        return locales;
    }
}

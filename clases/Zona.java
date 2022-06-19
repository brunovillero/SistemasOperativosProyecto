package clases;
import manejadoresDeArchivos.ManejadorArchivosGenerico;

import java.util.LinkedList;
public class Zona {
    private final String nombre;
    private LinkedList<Local> locales=new LinkedList<>();
    private LinkedList<Repartidor> repartidores=new LinkedList<Repartidor>();


    public Zona(String nombreZona) {
        this.nombre = nombreZona.toLowerCase();
        this.locales = locales;
        this.repartidores = repartidores;
    }

    public String getNombre() {
        return nombre;
    }

    public void setLocal(Local local) {
        locales.add(local);
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

    public String imprimirListaLocales(){
        String localesString= "";
        for(Local local:locales){

            localesString+=local.getNombre();

        }
        return localesString;
    }

}

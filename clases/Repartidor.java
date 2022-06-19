package clases;

public class Repartidor {
    //Archivo con todos los repartidores. Formato: [¨nombre del repartidor¨,¨zona¨]
    private String Nombre;
    private Zona Zona;

    public Repartidor(String nombre,Zona zona){
        Nombre=nombre;
        Zona=zona;
    }

    public String getNombre(){
        return Nombre;
    }

    public Zona getZona(){
        return Zona;
    }
    
}

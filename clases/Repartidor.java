package clases;

public class Repartidor {
    //Archivo con todos los repartidores. Formato: [¨nombre del repartidor¨,¨zona¨]
    private String Nombre;
    private String Zona;

    public Repartidor(String nombre,String zona){
        Nombre=nombre;
        Zona=zona;
    }

    public String getNombre(){
        return Nombre;
    }

    public String getZona(){
        return Zona;
    }
    
}

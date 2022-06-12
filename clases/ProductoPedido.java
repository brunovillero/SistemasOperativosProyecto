package clases;

public class ProductoPedido {
    private String nombre;
    private int cantidad;

    public ProductoPedido(String nombre, int cantitad){
        this.nombre = nombre;
        this.cantidad = cantitad;
    }

    public String getNombre(){
        return nombre;
    }

    public int getCantidad(){
        return cantidad;
    }
}

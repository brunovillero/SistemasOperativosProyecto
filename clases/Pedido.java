package clases;

import java.util.LinkedList;

public class Pedido {
    //Archivo con los datos del pedido Formato:[¨nombre del cliente¨,¨local¨,¨zona¨,¨productos¨]
    private String nombre;
    private String local;
    private String zona;
    private LinkedList<ProductoPedido> productos;

    public Pedido(String nombre,String local,String zona,LinkedList<ProductoPedido> productos){
        this.nombre = nombre;
        this.local = local;
        this.zona = zona;
        this.productos = productos;
    }

    public String getNombre() {
        return nombre;
    }

    public String getLocal() {
        return local;
    }

    public String getZona() {
        return zona;
    }

    public LinkedList<ProductoPedido> getProductos() {
        return productos;
    }
}

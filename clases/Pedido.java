package clases;

import java.util.LinkedList;
import java.util.concurrent.Semaphore;

public class Pedido {
    //Archivo con los datos del pedido Formato:[¨nombre del cliente¨,¨local¨,¨zona¨,¨productos¨,"prioridad"]
    private String nombre;
    private String local;
    private String zona;
    private int prioridad;
    private Semaphore semaforoPedido = new Semaphore(1, true);
    private LinkedList<ProductoPedido> productos;
    private Boolean PedidoEnviado = false;

    public Pedido(String nombre,String local,String zona,LinkedList<ProductoPedido> productos, int prioridad){
        this.nombre = nombre;
        this.local = local;
        this.zona = zona;
        this.productos = productos;
        this.prioridad = prioridad;
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

    public int getPrioridad(){
        return prioridad;
    }

    public Semaphore getSemaforo(){
        return semaforoPedido;
    }

    public Boolean getPedidoEnviado(){
        return PedidoEnviado;
    }

    public void setPedidoEnviado(Boolean enviado){
        PedidoEnviado = enviado;
    }

    public LinkedList<ProductoPedido> getProductos() {
        return productos;
    }

    public String printPedido(){
        String productosPedidos = " ";
        for (ProductoPedido productoPedido : productos) {
            productosPedidos = productosPedidos + " Producto: " + productoPedido.getNombre() + " Cantidad: " + productoPedido.getCantidad();
        }

        return "Nombre: " + this.nombre + " Local: " + this.local +  " Zona: " + this.zona + " Prioridad: " + this.prioridad + " Productos: " + productosPedidos;
    }
}

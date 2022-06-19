package clases;

import java.util.LinkedList;

public class Pedido {
    //Archivo con los datos del pedido Formato:[¨nombre del cliente¨,¨local¨,¨zona¨,¨productos¨]
    Cliente cliente;
    private Local idlocal;
    private Zona zona;
    private LinkedList<ProductoPedido> productos;
    private Prioridad prioridad;

    public Pedido(Cliente cliente,LinkedList<ProductoPedido> productos){
        this.cliente = cliente;
        this.idlocal = idlocal;
        this.productos = productos;
        this.prioridad=prioridad;
        this.zona=zona;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public void setLoyaltyCliente(Cliente cliente){
        cliente.setLoyalty();
    }

    public Local getLocal() {return idlocal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setLocal(Local local) {
        this.idlocal = local;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }

    public Zona getZona() {
        return zona;
    }

    public LinkedList<ProductoPedido> getProductos() {
        return productos;
    }
}

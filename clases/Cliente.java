package clases;

import java.util.LinkedList;

public class Cliente {
    int clientId;
    String nombre;
    int loyalty;

    LinkedList<Pedido> listaPedidos;
    public Cliente(int clientId,String nombre){
        this.clientId=clientId;
        this.nombre=nombre;
        this.loyalty=loyalty;
    }

    public int getLoyalty() {
        return loyalty;
    }

    public void setLoyalty(int loyalty) {
        this.loyalty = loyalty;
    }

    public String getNombre() {
        return nombre;
    }

    public LinkedList<Pedido> getListaPedidos() {
        return listaPedidos;
    }

    public void setListaPedidos(LinkedList<Pedido> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }
}

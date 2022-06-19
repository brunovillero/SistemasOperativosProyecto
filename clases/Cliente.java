package clases;

import java.util.LinkedList;

public class Cliente {
    int clientId;
    String nombre;
    int loyalty=0;

    Prioridad prioridad;

    LinkedList<Pedido> listaPedidos;
    public Cliente(int clientId,String nombre){
        this.clientId=clientId;
        this.nombre=nombre;
        this.loyalty=loyalty;

    }

    public void setCriterio() {
        if(loyalty>=1){
            this.prioridad.setCriterio("cliente frecuente");
            this.prioridad.setPrioridad();;

        }else{
            this.prioridad.setCriterio("No hay prioridad");
            this.prioridad.setPrioridad();
        }

    }

    public int getClientId() {
        return clientId;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getLoyalty() {
        return loyalty;
    }

    public void setLoyalty() {

        loyalty ++; //cada vez que creamos un pedido le agregamos loyatly al cliente
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

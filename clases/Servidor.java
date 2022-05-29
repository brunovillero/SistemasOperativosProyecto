package clases;

import java.util.LinkedList;

public class Servidor {

    LinkedList<Local> listaLocales;
    LinkedList<Repartidor> listaRepartidores;
    LinkedList<Pedido> listaPedidos;
    public Servidor(){
        this.listaLocales=new LinkedList<Local>();
        this.listaRepartidores=new LinkedList<Repartidor>();
        this.listaPedidos=new LinkedList<Pedido>();

    }


    
}

package clases;

import java.util.LinkedList;
import java.util.concurrent.Semaphore;

public class Local extends Thread{
    //Archivo de locales Formato:[¨nombre¨,¨categoría¨,¨zona¨,¨número de pedidos a preparar simultáneamente¨]
    private LinkedList<Pedido> PedidosRecibidos;
    private LinkedList<Pedido> PedidosEnPreparacion;
    private LinkedList<Pedido> PedidosCompletados;
    private String[] catalogo;

    private String nombre;
    private String categoria;

    private Zona zonaLocal;
    private int limiteDePedidosEnPreparacion;
    private final int idLocal; //usamos id porque puede repetirse el nombre del local (franquicias)

    public Local(int id){
        this.nombre=nombre;
        this.categoria=categoria;
        this.limiteDePedidosEnPreparacion = limiteDePedidosEnPreparacion;
        this.catalogo = catalogo;
        this.idLocal=id;

    }

    public Zona getZonaLocal(){
        return zonaLocal;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setZonaLocal(Zona zonaLocal) {
        this.zonaLocal = zonaLocal;
    }

    public void setCatalogo(String[] catalogo) {
        this.catalogo = catalogo;
    }

    public void setPedidosCompletados(LinkedList<Pedido> pedidosCompletados) {
        PedidosCompletados = pedidosCompletados;
    }

    public void setLimiteDePedidosEnPreparacion(int limiteDePedidosEnPreparacion) {
        this.limiteDePedidosEnPreparacion = limiteDePedidosEnPreparacion;
    }

    public void setPedidosRecibidos(LinkedList<Pedido> pedidosRecibidos) {
        PedidosRecibidos = pedidosRecibidos;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }


    public String getNombre(){
        return nombre;
    }
    public int getIdLocal(){
        return idLocal;
    }

    public String getCategoria(){
        return categoria;
    }

    public String[] getCatalogo(){
        return catalogo;
    }

    public void RecibirPedido(Pedido pedido){
        PedidosRecibidos.add(pedido);
    }


}

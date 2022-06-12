package clases;

import java.util.LinkedList;

public class Local {
    //Archivo de locales Formato:[¨nombre¨,¨categoría¨,¨zona¨,¨número de pedidos a preparar simultáneamente¨]
    private LinkedList<Pedido> PedidosRecibidos;
    private LinkedList<Pedido> PedidosEnPreparacion;
    private LinkedList<Pedido> PedidosCompletados;
    private String[] Catalogo;
    private String nombre;
    private String categoria;
    private String zona;
    private int limiteDePedidosEnPreparacion;
    
    public Local(String nombre,String categoria,String zona, int limiteDePedidosEnPreparacion, String[] catalogo){
        this.nombre=nombre;
        this.categoria=categoria;
        this.zona=zona;
        this.limiteDePedidosEnPreparacion = limiteDePedidosEnPreparacion;
        this.Catalogo = catalogo;
    }

    public String getNombre(){
        return nombre;
    }

    public String getCategoria(){
        return categoria;
    }

    public String getZona() {
        return zona;
    }

    public String[] getCatalogo(){
        return Catalogo;
    }

    public void RecibirPedido(Pedido pedido){
        PedidosRecibidos.add(pedido);
    }
}

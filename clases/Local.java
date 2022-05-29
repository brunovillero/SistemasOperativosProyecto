package clases;

import java.util.LinkedList;

public class Local {
    //Archivo de locales Formato:[¨nombre¨,¨categoría¨,¨zona¨,¨número de pedidos a preparar simultáneamente¨]
    public LinkedList<Pedido> ColaPedidosRecibidos;
    private LinkedList ColaPedidosEnPreparacion;
    public LinkedList<Pedido> ColaPedidosCompletados;
    public String nombre;
    private String categoria;
    private String zona;
    private int numeroDePedidos;


    
    public Local(String nombre,String categoria,String zona,int numeroDePedidos){
        
    this.nombre=nombre;
    this.categoria=categoria;
    this.zona=zona;
    this.numeroDePedidos=numeroDePedidos;


    }

    public String getNombre(){
        return nombre;
    }
    public String getCategoria(){
        return categoria;
    }
    public int getNumeroDePedidos(){
        return numeroDePedidos;
    }
    public String imprimir(){
        String datosLocal=("nombre:"+ " "+ nombre+" "+ "categoria:"+ " "+categoria + "zona:" +" "+ zona +" "+ "numero de Pedidos:"+ numeroDePedidos);
        return datosLocal;
    }
    
}

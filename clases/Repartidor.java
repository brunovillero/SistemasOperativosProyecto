package clases;

import javax.swing.border.EmptyBorder;

public class Repartidor extends Thread{
    //Archivo con todos los repartidores. Formato: [¨nombre del repartidor¨,¨zona¨]
    private String Nombre;
    private String Zona;
    private Pedido PedidoAsignado;

    public Repartidor(String nombre,String zona){
        Nombre=nombre;
        Zona=zona;
        PedidoAsignado = null;
    }

    public String getNombre(){
        return Nombre;
    }

    public String getZona(){
        return Zona;
    }

    public void setPedidoAsignado(Pedido pedidoAsignado){
        PedidoAsignado = pedidoAsignado;
    }

    public Boolean getEnviandoPedido(){
        return PedidoAsignado == null;
    }

    @Override
    public void run(){
        try {
            System.out.println("Enviando pedido a: " + PedidoAsignado.getNombre());
        } catch (Exception e) {
            System.out.println("");

        }
    }
}

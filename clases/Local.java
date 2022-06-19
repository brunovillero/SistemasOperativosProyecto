package clases;

import java.util.LinkedList;

public class Local extends Thread{
    //Archivo de locales Formato:[¨nombre¨,¨categoría¨,¨zona¨]
    private LinkedList<Pedido> P1 = new LinkedList<>(); //prioridad 1
    private LinkedList<Pedido> P2 = new LinkedList<>(); //prioridad 2
    private LinkedList<Pedido> PedidosCompletados = new LinkedList<>();
    private String nombre;
    private String categoria;
    private String zona;
    
    public Local(String nombre,String categoria,String zona){
        this.nombre=nombre;
        this.categoria=categoria;
        this.zona=zona;
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

    public void RecibirPedido(Pedido pedido){
        System.out.println(pedido.getPrioridad());
        switch (pedido.getPrioridad()) {
            case 1:
                P1.add(pedido);
                break;
            default:
                P2.add(pedido);
                break;
        }
    }

    public LinkedList<Pedido> getPedidoCompletados(){
        return PedidosCompletados;
    }

    @Override
    public void run(){
        try {
            while (!P1.isEmpty() || !P2.isEmpty()) {
                System.out.println("Local: " + nombre + " Preparando Pedidos");
                if(!P1.isEmpty()){
                    Pedido head1 = P1.poll();
                    System.out.println("Preparando pedido: " + head1.printPedido());
                    PedidosCompletados.add(head1);
                }
                if(!P2.isEmpty()){
                    Pedido head2 = P2.poll();
                    System.out.println("Preparando pedido: " + head2.printPedido());
                    PedidosCompletados.add(head2);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        PlanificadorLocales.getSemaforo().release();
    }
}

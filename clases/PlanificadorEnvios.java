package clases;

import java.util.LinkedList;
import java.util.HashMap;
import java.util.concurrent.Semaphore;

public class PlanificadorEnvios {

    public static HashMap<String, LinkedList<Repartidor>> RepartidoresPorZona = new HashMap<String, LinkedList<Repartidor>>();
    private static Semaphore semaforoEnvios = new Semaphore(1, true);

    public static void cargarRepartidoresPorZona(LinkedList<Repartidor> repartidores){
        for (Repartidor repartidor : repartidores) {
            if(RepartidoresPorZona.containsKey(repartidor.getZona())){
                LinkedList<Repartidor> repartidoresDeLaZona = RepartidoresPorZona.get(repartidor.getZona());
                repartidoresDeLaZona.add(repartidor);
            }else{
                LinkedList<Repartidor> nuevaListaRepartidoresDeLaZona = new LinkedList<Repartidor>();
                nuevaListaRepartidoresDeLaZona.add(repartidor);
                RepartidoresPorZona.put(repartidor.getZona(), nuevaListaRepartidoresDeLaZona);
            }
        }
    }

    public static void obtenerPedidosCompletadosYEnviarlos(LinkedList<Local> locales){
        while (true) {
            LinkedList<Pedido> pedidosProntos = new LinkedList<>();
            for (Local local : locales) {
                for (Pedido pedido : local.getPedidoCompletados()) {
                    if(!pedidosProntos.contains(pedido)){
                        pedidosProntos.add(pedido);
                    }
                }
            }
            
            for (Pedido pedido : pedidosProntos) {
                try {
                    enviarPedido(pedido);
                } catch (Exception e) {
                    System.out.println("No se pudo enviar pedido: " + pedido.getProductos());
                }
            }
        }
    }

    public static void enviarPedido(Pedido pedidoAEnviar) throws InterruptedException{
        semaforoEnvios.acquire();
        LinkedList<Repartidor> repartidoresDeLaZona = RepartidoresPorZona.get(pedidoAEnviar.getZona());
        for (Repartidor repartidor : repartidoresDeLaZona) {
            if (!repartidor.getEnviandoPedido()) {
                repartidor.run();
                break;
            }
        }
    }
}

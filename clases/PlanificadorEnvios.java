package clases;

import java.util.LinkedList;
import java.util.HashMap;

public class PlanificadorEnvios {

    public static HashMap<String, LinkedList<Repartidor>> RepartidoresPorZona = new HashMap<String, LinkedList<Repartidor>>();

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
        LinkedList<Pedido> pedidosAEnviar = new LinkedList<>();
        while (true) {
            
            for (Local local : locales) {
                for (Pedido pedido : local.getPedidoCompletados()) {
                    if(!pedidosAEnviar.contains(pedido)){
                        pedidosAEnviar.add(pedido);
                    }
                }
            }

            while (!pedidosAEnviar.isEmpty()) {
                Pedido head = pedidosAEnviar.poll();
                if(!head.getPedidoEnviado()){
                    try {
                        enviarPedido(head);
                    } catch (Exception e) {
                        System.out.println("No se pudo enviar pedido: " + head.getProductos());
                    }
                }
            }
        }
    }

    public static void enviarPedido(Pedido pedidoAEnviar) throws InterruptedException{
        pedidoAEnviar.getSemaforo().acquire();
        LinkedList<Repartidor> repartidoresDeLaZona = RepartidoresPorZona.get(pedidoAEnviar.getZona());
        for (Repartidor repartidor : repartidoresDeLaZona) {
            if (!repartidor.getEnviandoPedido()) {
                repartidor.run();
                break;
            }
        }
    }
}

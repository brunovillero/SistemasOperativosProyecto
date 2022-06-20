package clases;

import java.util.LinkedList;
import java.util.concurrent.Semaphore;

public class PlanificadorLocales {
    private static LinkedList<Local> Locales;
    
    public static void asignarPedidosALocales(LinkedList<Local> locales, LinkedList<Pedido> pedidos){
        for (Local local : locales) {
            for (Pedido pedido : pedidos) {
                if(local.getNombre().equals(pedido.getLocal())){
                    local.RecibirPedido(pedido);
                }
            }
        }
        Locales = locales;
    }

    public static void PrepararPedidosEnSimultaneo() throws InterruptedException{
        for (Local local : Locales) {
            local.run();
        }
    }
}

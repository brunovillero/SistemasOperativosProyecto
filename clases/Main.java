package clases;
import clases.CargaDeDatosInicial;
import clases.PlanificadorEnvios;

public class Main {
    public static void main(String[] args){
        CargaDeDatosInicial nuevaCarga = new CargaDeDatosInicial(1);
        PlanificadorLocales.asignarPedidosALocales(nuevaCarga.getLocales(), nuevaCarga.getPedidos());
        PlanificadorEnvios.cargarRepartidoresPorZona(nuevaCarga.getRepartidores());
        
        try {
            PlanificadorLocales.PrepararPedidosEnSimultaneo();
        } catch (InterruptedException e) {
            System.out.println("Thread interrumpido al preparar pedidos");
        } catch (Exception e){
            System.out.println("No se pudo preparar pedidos en momento: 1");
        }

        
        for (Local local : nuevaCarga.getLocales()) {
            System.out.println("Nombre del local: " + local.getNombre() + ", Pedidos Completos: " + local.getPedidoCompletados().size());
        }

        PlanificadorEnvios.obtenerPedidosCompletadosYEnviarlos(nuevaCarga.getLocales());
    }

}

package clases;
import clases.CargaDeDatosInicial;

public class Main {
    public static void main(String[] args){
        CargaDeDatosInicial nuevaCarga = new CargaDeDatosInicial(1);
        PlanificadorLocales.asignarPedidosALocales(nuevaCarga.getLocales(), nuevaCarga.getPedido());
        
        try {
            PlanificadorLocales.PrepararPedidosEnSimultaneo();
        } catch (InterruptedException e) {
            System.out.println("No se pudo preparar pedidos en momento: 1");
        }

    }

}

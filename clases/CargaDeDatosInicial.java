package clases;

import manejadoresDeArchivos.ManejadorArchivosGenerico;
import java.util.LinkedList;

public class CargaDeDatosInicial {
    private LinkedList<Local> Locales = new LinkedList<Local>();
    private LinkedList<Pedido> Pedidos = new LinkedList<Pedido>();
    private LinkedList<Repartidor> Repartidores = new LinkedList<Repartidor>();

    public CargaDeDatosInicial(int momento) {
        cargaInicialLocales(momento);
        cargaInicialPedidos(momento);
        cargaInicialRepartidores(momento);
    }

    private void cargaInicialLocales(int momento) {

        String[] localesLineas = ManejadorArchivosGenerico.leerArchivo("archivos/ArchivoLocales.txt");
        for (String linea : localesLineas){
            String[] datosLocales = linea.split(",");
            if(Integer.parseInt(datosLocales[0]) == momento){
                Local nuevoLocal = new Local(datosLocales[1], datosLocales[2], datosLocales[3]);
                Locales.add(nuevoLocal);
            }
        }
    }

    private void cargaInicialPedidos(int momento) {
        String[] lineasPedidos = ManejadorArchivosGenerico.leerArchivo("archivos/ArchivoPedidos.txt");
        for (String linea : lineasPedidos){
            String[] datosPedidos = linea.split(",");
            if(Integer.parseInt(datosPedidos[0]) == momento){
                String[] datosProductosNombres = datosPedidos[4].split(";");
                String[] datosCantidadDeCadaProducto = datosPedidos[5].split(";");
                LinkedList<ProductoPedido> productosPedidos = crearProductosPedidos(datosProductosNombres, datosCantidadDeCadaProducto);
                Pedido pedido = new Pedido(datosPedidos[1], datosPedidos[2], datosPedidos[3], productosPedidos, Integer.parseInt(datosPedidos[6]));
                Pedidos.add(pedido);
            }
        }
    }

    private void cargaInicialRepartidores(int momento) {
        String[] lineasRepartidores = ManejadorArchivosGenerico.leerArchivo("archivos/ArchivoRepartidores.txt");
        for (String linea : lineasRepartidores){
            String[] datosRepartidor = linea.split(",");
            if(Integer.parseInt(datosRepartidor[0]) == momento){
                Repartidores.add(new Repartidor(datosRepartidor[1], datosRepartidor[2]));
            }
        }
    }

    private LinkedList<ProductoPedido> crearProductosPedidos(String[] nombres, String[] cantidades){
        //Asumiendo que son de tamaños iguales
        LinkedList<ProductoPedido> resultado = new LinkedList<ProductoPedido>();
        for (int i = 0; i < nombres.length; i++) {
            resultado.add(new ProductoPedido(nombres[i], Integer.parseInt(cantidades[i])));
        }

        return resultado;
    }

    public LinkedList<Local> getLocales(){
        return Locales;
    }

    public LinkedList<Pedido> getPedido(){
        return Pedidos;
    }
}

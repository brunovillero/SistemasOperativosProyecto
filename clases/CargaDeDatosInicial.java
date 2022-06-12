package clases;

import manejadoresDeArchivos.ManejadorArchivosGenerico;
import java.util.LinkedList;

public class CargaDeDatosInicial {
    private LinkedList<Local> Locales = new LinkedList<Local>();
    private LinkedList<Pedido> Pedidos = new LinkedList<Pedido>();
    private LinkedList<Repartidor> Repartidores = new LinkedList<Repartidor>();
    private String[] catalogoComidas = ManejadorArchivosGenerico.leerArchivo("archivos/ArchivoProductosComida.txt");
    private String[] catalogoProductosDeFarmacia = ManejadorArchivosGenerico.leerArchivo("archivos/ArchivoProductosFarmacia.txt");

    public CargaDeDatosInicial() {
        cargaInicialLocales();
        cargaInicialPedidos();
        cargaInicialRepartidores();
        for (Local local : Locales) {
            System.out.println(local.getNombre());
        }

        for (Pedido pedido : Pedidos) {
            System.out.println(pedido.getNombre());
        }

        for (Repartidor repartidor : Repartidores) {
            System.out.println(repartidor.getNombre());
        }
    }

    private void cargaInicialLocales() {

        String[] localesLineas = ManejadorArchivosGenerico.leerArchivo("archivos/ArchivoLocales.txt");
        for (String linea : localesLineas){
            String[] datosLocales = linea.split(",");
            Local nuevoLocal = new Local(datosLocales[0], datosLocales[1], datosLocales[2], Integer.parseInt(datosLocales[3]), getCatalogo(datosLocales[1]));
            Locales.add(nuevoLocal);
        }
    }

    private void cargaInicialPedidos() {
        String[] lineasPedidos = ManejadorArchivosGenerico.leerArchivo("archivos/ArchivoPedidos.txt");
        for (String linea : lineasPedidos){
            String[] datosPedidos = linea.split(",");
            String[] datosProductosNombres = datosPedidos[3].split(";");
            String[] datosCantidadDeCadaProducto = datosPedidos[4].split(";");
            LinkedList<ProductoPedido> productosPedidos = crearProductosPedido(datosProductosNombres, datosCantidadDeCadaProducto);
            Pedido pedido = new Pedido(datosPedidos[0], datosPedidos[1], datosPedidos[2], productosPedidos);
            Pedidos.add(pedido);
        }
    }

    private void cargaInicialRepartidores() {
        String[] lineasRepartidores = ManejadorArchivosGenerico.leerArchivo("archivos/ArchivoRepartidores.txt");
        for (String linea : lineasRepartidores){
            String[] datosRepartidor = linea.split(",");
            Repartidores.add(new Repartidor(datosRepartidor[0], datosRepartidor[1]));
        }
    }

    private String[] getCatalogo(String categoria) {
        String[] catalogo = null;
        if(categoria == "farmacia"){
            catalogo = catalogoProductosDeFarmacia;
        } else {
            catalogo = catalogoComidas;
        }
        return catalogo;
    }

    private Local getLocal(String nombre) {
        Local resultado = null;
        for (Local local : Locales) {
            if(local.getNombre() == nombre){
                resultado = local;
                break;
            }
        }

        return resultado;
    }

    private LinkedList<ProductoPedido> crearProductosPedido(String[] nombres, String[] cantidades){
        //Asumiendo que son de tamaños iguales
        LinkedList<ProductoPedido> resultado = new LinkedList<ProductoPedido>();
        for (int i = 0; i < nombres.length; i++) {
            resultado.add(new ProductoPedido(nombres[i], Integer.parseInt(cantidades[i])));
        }

        return resultado;
    }
}

package clases;

import manejadoresDeArchivos.ManejadorArchivosGenerico;
import java.util.LinkedList;

public class CargaDeDatosInicial {
    private LinkedList<Local> Locales = new LinkedList<Local>(); // no se usa por el momento
    private LinkedList<Zona> Zonas=new LinkedList<Zona>(); // no se usa por el momento, solo contiene las zonas creadas en la lista
    private LinkedList<Pedido> Pedidos = new LinkedList<Pedido>();
    private LinkedList<Repartidor> Repartidores = new LinkedList<Repartidor>();
    private String[] catalogoComidas = ManejadorArchivosGenerico.leerArchivo("archivos/ArchivoProductosComida.txt");
    private String[] catalogoProductosDeFarmacia = ManejadorArchivosGenerico.leerArchivo("archivos/ArchivoProductosFarmacia.txt");

    public CargaDeDatosInicial() {
        cargaInicialLocales();
        cargaInicialPedidos();
        cargaInicialRepartidores();


        for (Pedido pedido : Pedidos) {
            System.out.println("Pedido:"+ " " + pedido.getNombre());
        }

        for (Repartidor repartidor : Repartidores) {
            System.out.println("Repartidor:"+ " " + repartidor.getNombre());
        }
        for(Zona zona:Zonas) {

            if (zona.getLocales() != null) {
                for (Local local : zona.getLocales()) {
                    System.out.println("zona: " + zona.getNombre() +" " + "Local: " +local.getNombre());

                }
            }
        }
    }


    private void cargaInicialLocales() {

        String[] localesLineas = ManejadorArchivosGenerico.leerArchivo("archivos/ArchivoLocales.txt");
        for (String linea : localesLineas){
            String[] datosLocales = linea.split(",");
            Zona zonaLocal= new Zona(datosLocales[1]); //creamos la zona del local
            Local nuevoLocal = new Local(Integer.parseInt(datosLocales[0]), zonaLocal); //creamos el local y cargamos sus datos
            nuevoLocal.setCatalogo(getCatalogo(datosLocales[1]));
            nuevoLocal.setNombre(datosLocales[2]);
            nuevoLocal.setCategoria(datosLocales[3]);
            nuevoLocal.setLimiteDePedidosEnPreparacion(Integer.parseInt(datosLocales[4]));
            if(zonaLocal.getLocales()==null){
                LinkedList<Local> localZona= new LinkedList<>();
                zonaLocal.setLocales(localZona);
                localZona.add(nuevoLocal);//agregamos el local a la lista de locales de la zona
            }else {
                zonaLocal.getLocales().add(nuevoLocal);
            }
            if( !Zonas.contains(zonaLocal)){ //agregamos la zona a la lista de zonas
                Zonas.add(zonaLocal);
            }
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

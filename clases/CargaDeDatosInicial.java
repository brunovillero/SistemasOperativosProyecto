package clases;

import manejadoresDeArchivos.ManejadorArchivosGenerico;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Locale;

public class CargaDeDatosInicial {
   private LinkedList<Local> Locales = new LinkedList<Local>();// agregamos locales creados
   private LinkedList<Pedido> Pedidos = new LinkedList<Pedido>();// agregamos pedidos creados
   private LinkedList<Repartidor> Repartidores = new LinkedList<Repartidor>();// agregamos repartidores creados
    //private LinkedList<Cliente> Clientes=new LinkedList<>();// agregamos clientes creados

    private LinkedList<Zona> Zonas = new LinkedList<Zona>();// agregamos zonas creados
    private HashMap<Integer,Cliente> Clientes=new HashMap<>();

   private String[] catalogoComidas = ManejadorArchivosGenerico.leerArchivo("archivos/ArchivoProductosComida.txt");
   private String[] catalogoProductosDeFarmacia = ManejadorArchivosGenerico.leerArchivo("archivos/ArchivoProductosFarmacia.txt");


    public CargaDeDatosInicial() {
        cargarZonas();
        cargaClientes();
        cargaInicialLocales();
        cargaInicialPedidos();
        cargaInicialRepartidores();



        for (Pedido pedido : Pedidos) {
            System.out.println("Cliente:"+ " " + pedido.getCliente().getNombre()+ " " + "loyalty: " +pedido.getCliente().getLoyalty()+ " " + "Local: "+ pedido.getLocal().getNombre() );
        }

        for (Repartidor repartidor : Repartidores) {
            System.out.println("Repartidor:"+ " " + repartidor.getNombre() + " Zona :"+ repartidor.getZona().getNombre());
        }
        for (Local local:Locales){
            System.out.println("Local:"+ " " + local.getNombre()+ " " + "Zona:"+ local.getZonaLocal().getNombre());
        }
        for (Zona zona:Zonas){

        System.out.println("Zona:"+ " " + zona.getNombre()+ " " + "NombreLocal"+ " " + zona.imprimirListaLocales());


        }

    }
    public void cargarZonas(){
        String[] zonas=ManejadorArchivosGenerico.leerArchivo(("archivos/ArchivoZonas.txt"));
        for(String linea: zonas) {
            String[] datosZonas = linea.split("\n");
            Zona zona = new Zona(datosZonas[0].toLowerCase());
            Zonas.add(zona);
        }

    }


    private void cargaInicialLocales() {

        String[] localesLineas = ManejadorArchivosGenerico.leerArchivo("archivos/ArchivoLocales.txt");
        for (String linea : localesLineas){
            String[] datosLocales = linea.split(",");


            Local nuevoLocal = new Local(Integer.parseInt(datosLocales[0])); //creamos el local y cargamos sus datos


            nuevoLocal.setCatalogo(getCatalogo(datosLocales[1]));
            nuevoLocal.setNombre(datosLocales[2]);
            nuevoLocal.setCategoria(datosLocales[3]);
            nuevoLocal.setLimiteDePedidosEnPreparacion(Integer.parseInt(datosLocales[4]));
            Zona zona=findZona(datosLocales[1].toLowerCase());
            nuevoLocal.setZonaLocal(zona);
            zona.setLocal(nuevoLocal);// se agrega local a la lista de locales de la zona
            Locales.add(nuevoLocal);

        }
    }
    public Zona findZona(String nombre){
        for(Zona zona:Zonas){
            if(zona.getNombre().equals(nombre)){
                return zona;
            }
        }return null;
    }

    public Local findLocal(int id){
        for(Local local:Locales){
            if(local.getIdLocal()==(id)){
                return local;
            }
        }return null;
    }

    public void cargaClientes(){
        String[] lineasClientes = ManejadorArchivosGenerico.leerArchivo("archivos/ArchivoClientes.txt");
        for (String linea : lineasClientes) {
            String[] datosClientes = linea.split(",");
            Cliente clienteNuevo = new Cliente(Integer.parseInt(datosClientes[0]), datosClientes[1]);
            Clientes.put(Integer.parseInt(datosClientes[0]), clienteNuevo);
        }


        }

    private void cargaInicialPedidos() {
        String[] lineasPedidos = ManejadorArchivosGenerico.leerArchivo("archivos/ArchivoPedidos.txt");
        for (String linea : lineasPedidos) {
            String[] datosPedidos = linea.split(",");
            String[] datosProductosNombres = datosPedidos[3].split(";");
            String[] datosCantidadDeCadaProducto = datosPedidos[4].split(";");
            LinkedList<ProductoPedido> productosPedidos = crearProductosPedido(datosProductosNombres, datosCantidadDeCadaProducto);
            Cliente cliente=Clientes.get(Integer.parseInt(datosPedidos[0]));
            Pedido pedido = new Pedido(cliente, productosPedidos);
            pedido.setCliente(cliente);
            pedido.setLoyaltyCliente(cliente);


            Zona zona=findZona(datosPedidos[3].toLowerCase());
            pedido.setZona(zona);
            Local localPedido=findLocal(Integer.parseInt(datosPedidos[2]));
            pedido.setLocal(localPedido);
            Pedidos.add(pedido);

        }
    }

    private void cargaInicialRepartidores() {
        String[] lineasRepartidores = ManejadorArchivosGenerico.leerArchivo("archivos/ArchivoRepartidores.txt");
        for (String linea : lineasRepartidores){
            String[] datosRepartidor = linea.split(",");
            Zona zona=findZona(datosRepartidor[0].toLowerCase());
            Repartidores.add(new Repartidor(datosRepartidor[1], zona));
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



    private LinkedList<ProductoPedido> crearProductosPedido(String[] nombres, String[] cantidades){
        //Asumiendo que son de tamaños iguales
        LinkedList<ProductoPedido> resultado = new LinkedList<ProductoPedido>();
        for (int i = 0; i < nombres.length; i++) {
            resultado.add(new ProductoPedido(nombres[i], Integer.parseInt(cantidades[i])));
        }

        return resultado;
    }



}

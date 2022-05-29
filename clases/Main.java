package clases;

public class Main {
    public static void main(String[] args){
        Servidor servidor=new Servidor();

        String[] lineasLocales=ManejadorArchivosGenerico.leerArchivo("archivos/ArchivoLocales.txt");
        for (String linea:lineasLocales){
            String[] datosLocales=linea.split(",");
            Local local= new Local(datosLocales[0],datosLocales[1],datosLocales[2],Integer.parseInt(datosLocales[3]));
            servidor.listaLocales.add(local);
        }

        String[] lineasPedidos=ManejadorArchivosGenerico.leerArchivo("archivos/ArchivoPedidos.txt");
        for (String linea:lineasPedidos){
            String[] datosPedidos=linea.split(",");
            Pedido pedido= new Pedido(datosPedidos[0],datosPedidos[1],datosPedidos[2],datosPedidos[3]);
            servidor.listaPedidos.add(pedido);
        }

        String[] lineasRepartidores=ManejadorArchivosGenerico.leerArchivo("archivos/ArchivoRepartidores.txt");
        for (String linea:lineasRepartidores){
            String[] datosRepartidores=linea.split(",");
            Repartidor repartidor= new Repartidor(datosRepartidores[0],datosRepartidores[1]);
            servidor.listaRepartidores.add(repartidor);
        }

        for(Local local: servidor.listaLocales){
            System.out.println(local.imprimir());
        }


    }

}

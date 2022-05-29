package clases;

import java.util.concurrent.Semaphore;

public class Reloj {
    private int contador;
    private int suma;
    public Semaphore semaforo;

    public void setContador(int contador){
        this.contador=contador;
        this.semaforo= new Semaphore(1);
    }
    public int getSuma(){return suma;}
    public int getContador(){return contador;}

    public Reloj(){
        this.contador=0;
        this.suma=0;
    }

    public void agregarSuma(long num){
        this.suma+=num;
        this.contador++;
    }
    public long promedio(){return(this.suma/this.contador);}
}

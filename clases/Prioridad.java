package clases;

public class Prioridad {
    private String criterio;
    private int prioridad;

    public Prioridad(String criterio,int prioridad){
        this.criterio=criterio;
        this.prioridad=prioridad;
    }

    public int getPrioridad() {
        return prioridad;
    }
    public void setCriterio(String criterio){
        this.criterio=criterio;
    }
    public void setPrioridad() {
        if (this.criterio == "farmacia") {
            this.prioridad = 1;
        }
        if (this.criterio == "cliente frecuente") {
            this.prioridad = 2;
        } else {
            this.prioridad = 0;
        }
    }
}


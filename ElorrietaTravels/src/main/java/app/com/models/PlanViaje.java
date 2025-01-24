package main.java.app.com.models;

public class PlanViaje {
    private String idPlan;
    private String trayecto;

    private Evento evento;
    private Vuelo vueloIda;
    private Vuelo vueloVuelta;

    public PlanViaje(String idPlan, String trayecto, Evento evento, Vuelo vueloIda, Vuelo vueloVuelta) {
        this.idPlan = idPlan;
        this.trayecto = trayecto;
        this.evento = evento;
        this.vueloIda = vueloIda;
        this.vueloVuelta = vueloVuelta;
    }

    public String getIdPlan() { return idPlan; }
    public void setIdPlan(String idPlan) { this.idPlan = idPlan; }

    public String getTrayecto() { return trayecto; }
    public void setTrayecto(String trayecto) { this.trayecto = trayecto; }

    public Evento getEvento() { return evento; }
    public void setEvento(Evento evento) { this.evento = evento; }

    public Vuelo getVueloIda() { return vueloIda; }
    public void setVueloIda(Vuelo vueloIda) { this.vueloIda = vueloIda; }

    public Vuelo getVueloVuelta() { return vueloVuelta; }
    public void setVueloVuelta(Vuelo vueloVuelta) { this.vueloVuelta = vueloVuelta; }

    @Override
    public String toString() {
        return "PlanViaje{" +
                "idPlan='" + idPlan + '\'' +
                ", trayecto='" + trayecto + '\'' +
                ", evento=" + (evento != null ? evento.getIdEvento() : "null") +
                ", vueloIda=" + (vueloIda != null ? vueloIda.getIdVuelo() : "null") +
                ", vueloVuelta=" + (vueloVuelta != null ? vueloVuelta.getIdVuelo() : "null") +
                '}';
    }
}


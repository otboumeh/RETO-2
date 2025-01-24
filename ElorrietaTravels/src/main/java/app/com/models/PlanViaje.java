package main.java.app.com.models;

public class PlanViaje {
    private String idPlan;
    private String trayecto;
    private String idVueloIda;
    private String idVueloVuelta;

    public PlanViaje() {}

    public PlanViaje(String idPlan, String trayecto, String idVueloIda, String idVueloVuelta) {
        this.idPlan = idPlan;
        this.trayecto = trayecto;
        this.idVueloIda = idVueloIda;
        this.idVueloVuelta = idVueloVuelta;
    }

    public String getIdPlan() {
        return idPlan;
    }

    public void setIdPlan(String idPlan) {
        this.idPlan = idPlan;
    }

    public String getTrayecto() {
        return trayecto;
    }

    public void setTrayecto(String trayecto) {
        this.trayecto = trayecto;
    }

    public String getIdVueloIda() {
        return idVueloIda;
    }

    public void setIdVueloIda(String idVueloIda) {
        this.idVueloIda = idVueloIda;
    }

    public String getIdVueloVuelta() {
        return idVueloVuelta;
    }

    public void setIdVueloVuelta(String idVueloVuelta) {
        this.idVueloVuelta = idVueloVuelta;
    }

    @Override
    public String toString() {
        return "PlanViaje{" +
                "idPlan='" + idPlan + '\'' +
                ", trayecto='" + trayecto + '\'' +
                ", idVueloIda='" + idVueloIda + '\'' +
                ", idVueloVuelta='" + idVueloVuelta + '\'' +
                '}';
    }
}


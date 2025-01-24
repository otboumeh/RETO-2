package main.java.app.com.models;

public class Evento {
    private String idEvento;
    private String nomEvento;
    private String tipoEvento;
    private String idViaje;

    public Evento() {}

    public Evento(String idEvento, String nomEvento, String tipoEvento, String idViaje) {
        this.idEvento = idEvento;
        this.nomEvento = nomEvento;
        this.tipoEvento = tipoEvento;
        this.idViaje = idViaje;
    }

    public String getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(String idEvento) {
        this.idEvento = idEvento;
    }

    public String getNomEvento() {
        return nomEvento;
    }

    public void setNomEvento(String nomEvento) {
        this.nomEvento = nomEvento;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public String getIdViaje() {
        return idViaje;
    }

    public void setIdViaje(String idViaje) {
        this.idViaje = idViaje;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "idEvento='" + idEvento + '\'' +
                ", nomEvento='" + nomEvento + '\'' +
                ", tipoEvento='" + tipoEvento + '\'' +
                ", idViaje='" + idViaje + '\'' +
                '}';
    }
}

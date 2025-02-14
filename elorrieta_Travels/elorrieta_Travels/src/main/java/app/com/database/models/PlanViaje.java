package main.java.app.com.database.models;

import java.util.Objects;

/**
 * La clase del modelo PlanViaje
 * 
 * @author Grupo_01
 */
public class PlanViaje {
    
    private String idEvento =  null;
    private String nomEvento = null;
    private String tipoEvento = null;
    private String trayecto = null;
    private Vuelo ida = null;
    private Vuelo vuelta = null;
    
    /**
     * Obtiene el ID del evento asociado al plan de viaje.
     *
     * @return El ID del evento.
     */
    public String getIdEvento() {
        return idEvento;
    }

    /**
     * Establece el ID del evento asociado al plan de viaje.
     *
     * @param idEvento El ID del evento a establecer.
     */
    public void setIdEvento(String idEvento) {
        this.idEvento = idEvento;
    }

    /**
     * Obtiene el nombre del evento asociado al plan de viaje.
     *
     * @return El nombre del evento.
     */
    public String getNomEvento() {
        return nomEvento;
    }

    /**
     * Establece el nombre del evento asociado al plan de viaje.
     *
     * @param nomEvento El nombre del evento a establecer.
     */
    public void setNomEvento(String nomEvento) {
        this.nomEvento = nomEvento;
    }

    /**
     * Obtiene el tipo de evento asociado al plan de viaje.
     *
     * @return El tipo de evento.
     */
    public String getTipoEvento() {
        return tipoEvento;
    }

    /**
     * Establece el tipo de evento asociado al plan de viaje.
     *
     * @param tipoEvento El tipo de evento a establecer.
     */
    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    /**
     * Obtiene el trayecto del viaje.
     *
     * @return El trayecto del viaje.
     */
    public String getTrayecto() {
        return trayecto;
    }

    /**
     * Establece el trayecto del viaje.
     *
     * @param trayecto El trayecto a establecer.
     */
    public void setTrayecto(String trayecto) {
        this.trayecto = trayecto;
    }

    /**
     * Obtiene el vuelo de ida asociado al plan de viaje.
     *
     * @return El vuelo de ida.
     */
    public Vuelo getIda() {
        return ida;
    }

    /**
     * Establece el vuelo de ida asociado al plan de viaje.
     *
     * @param ida El vuelo de ida a establecer.
     */
    public void setIda(Vuelo ida) {
        this.ida = ida;
    }

    /**
     * Obtiene el vuelo de vuelta asociado al plan de viaje.
     *
     * @return El vuelo de vuelta.
     */
    public Vuelo getVuelta() {
        return vuelta;
    }

    /**
     * Establece el vuelo de vuelta asociado al plan de viaje.
     *
     * @param vuelta El vuelo de vuelta a establecer.
     */
    public void setVuelta(Vuelo vuelta) {
        this.vuelta = vuelta;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEvento, ida, nomEvento, tipoEvento, trayecto, vuelta);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PlanViaje other = (PlanViaje) obj;
        return Objects.equals(idEvento, other.idEvento) && Objects.equals(ida, other.ida)
                && Objects.equals(nomEvento, other.nomEvento) && Objects.equals(tipoEvento, other.tipoEvento)
                && Objects.equals(trayecto, other.trayecto) && Objects.equals(vuelta, other.vuelta);
    }

    @Override
    public String toString() {
        return "PlanViaje [idEvento=" + idEvento + ", nomEvento=" + nomEvento + ", tipoEvento=" + tipoEvento
                + ", trayecto=" + trayecto + ", ida=" + ida + ", vuelta=" + vuelta + "]";
    }
}

package main.java.app.com.database.models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Objects;

/**
 * La clase del modelo Viaje
 * 
 * @author Grupo_01
 */
public class Viaje {
    
    private String idViaje = null;
    private String nomViaje = null; 
    private String tipoViaje = null;
    private Date fechInicio = null;
    private Date fechFin = null;
    private long numDias = 0;
    private String pais = null;
    private String descripcion = null;
    private String serviciosnoIncl = null;
    private String idAgencia = null;
    private ArrayList<PlanViaje> planViajes = null;
    private ArrayList<Alojamiento> alojamientos = null;
    private ArrayList<Actividad> actividades = null;
    
    /**
     * Obtiene el ID del viaje.
     *
     * @return El ID del viaje.
     */
    public String getIdViaje() {
        return idViaje;
    }

    /**
     * Establece el ID del viaje.
     *
     * @param idViaje El ID del viaje a establecer.
     */
    public void setIdViaje(String idViaje) {
        this.idViaje = idViaje;
    }

    /**
     * Obtiene el nombre del viaje.
     *
     * @return El nombre del viaje.
     */
    public String getNomViaje() {
        return nomViaje;
    }

    /**
     * Establece el nombre del viaje.
     *
     * @param nomViaje El nombre del viaje a establecer.
     */
    public void setNomViaje(String nomViaje) {
        this.nomViaje = nomViaje;
    }

    /**
     * Obtiene el tipo de viaje.
     *
     * @return El tipo de viaje.
     */
    public String getTipoViaje() {
        return tipoViaje;
    }

    /**
     * Establece el tipo de viaje.
     *
     * @param tipoViaje El tipo de viaje a establecer.
     */
    public void setTipoViaje(String tipoViaje) {
        this.tipoViaje = tipoViaje;
    }

    /**
     * Obtiene la fecha de inicio del viaje.
     *
     * @return La fecha de inicio del viaje.
     */
    public Date getFechInicio() {
        return fechInicio;
    }

    /**
     * Establece la fecha de inicio del viaje.
     *
     * @param fechInicio La fecha de inicio del viaje a establecer.
     */
    public void setFechInicio(Date fechInicio) {
        this.fechInicio = fechInicio;
    }

    /**
     * Obtiene la fecha de fin del viaje.
     *
     * @return La fecha de fin del viaje.
     */
    public Date getFechFin() {
        return fechFin;
    }

    /**
     * Establece la fecha de fin del viaje.
     *
     * @param fechFin La fecha de fin del viaje a establecer.
     */
    public void setFechFin(Date fechFin) {
        this.fechFin = fechFin;
    }

    /**
     * Obtiene el número de días del viaje.
     *
     * @return El número de días del viaje.
     */
    public long getNumDias() {
        return numDias;
    }

    /**
     * Establece el número de días del viaje.
     *
     * @param numDias El número de días del viaje a establecer.
     */
    public void setNumDias(long numDias) {
        this.numDias = numDias;
    }

    /**
     * Obtiene el país al que se realiza el viaje.
     *
     * @return El país del viaje.
     */
    public String getPais() {
        return pais;
    }

    /**
     * Establece el país al que se realiza el viaje.
     *
     * @param pais El país del viaje a establecer.
     */
    public void setPais(String pais) {
        this.pais = pais;
    }

    /**
     * Obtiene la descripción del viaje.
     *
     * @return La descripción del viaje.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción del viaje.
     *
     * @param descripcion La descripción del viaje a establecer.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene los servicios no incluidos en el viaje.
     *
     * @return Los servicios no incluidos en el viaje.
     */
    public String getServiciosnoIncl() {
        return serviciosnoIncl;
    }

    /**
     * Establece los servicios no incluidos en el viaje.
     *
     * @param serviciosnoIncl Los servicios no incluidos en el viaje a establecer.
     */
    public void setServiciosnoIncl(String serviciosnoIncl) {
        this.serviciosnoIncl = serviciosnoIncl;
    }

    /**
     * Obtiene el ID de la agencia que organiza el viaje.
     *
     * @return El ID de la agencia del viaje.
     */
    public String getIdAgencia() {
        return idAgencia;
    }

    /**
     * Establece el ID de la agencia que organiza el viaje.
     *
     * @param idAgencia El ID de la agencia a establecer.
     */
    public void setIdAgencia(String idAgencia) {
        this.idAgencia = idAgencia;
    }

    /**
     * Obtiene los planes de viaje asociados a este viaje.
     *
     * @return La lista de planes de viaje.
     */
    public ArrayList<PlanViaje> getPlanViajes() {
        return planViajes;
    }

    /**
     * Establece los planes de viaje asociados a este viaje.
     *
     * @param planViajes La lista de planes de viaje a establecer.
     */
    public void setPlanViajes(ArrayList<PlanViaje> planViajes) {
        this.planViajes = planViajes;
    }

    /**
     * Obtiene los alojamientos asociados a este viaje.
     *
     * @return La lista de alojamientos.
     */
    public ArrayList<Alojamiento> getAlojamientos() {
        return alojamientos;
    }

    /**
     * Establece los alojamientos asociados a este viaje.
     *
     * @param alojamientos La lista de alojamientos a establecer.
     */
    public void setAlojamientos(ArrayList<Alojamiento> alojamientos) {
        this.alojamientos = alojamientos;
    }

    /**
     * Obtiene las actividades asociadas a este viaje.
     *
     * @return La lista de actividades.
     */
    public ArrayList<Actividad> getActividades() {
        return actividades;
    }

    /**
     * Establece las actividades asociadas a este viaje.
     *
     * @param actividades La lista de actividades a establecer.
     */
    public void setActividades(ArrayList<Actividad> actividades) {
        this.actividades = actividades;
    }

    @Override
    public int hashCode() {
        return Objects.hash(actividades, alojamientos, descripcion, fechFin, fechInicio, idAgencia, idViaje, nomViaje,
                numDias, pais, planViajes, serviciosnoIncl, tipoViaje);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Viaje other = (Viaje) obj;
        return Objects.equals(actividades, other.actividades) && Objects.equals(alojamientos, other.alojamientos)
                && Objects.equals(descripcion, other.descripcion) && Objects.equals(fechFin, other.fechFin)
                && Objects.equals(fechInicio, other.fechInicio) && Objects.equals(idAgencia, other.idAgencia)
                && Objects.equals(idViaje, other.idViaje) && Objects.equals(nomViaje, other.nomViaje)
                && numDias == other.numDias && Objects.equals(pais, other.pais)
                && Objects.equals(planViajes, other.planViajes)
                && Objects.equals(serviciosnoIncl, other.serviciosnoIncl) && Objects.equals(tipoViaje, other.tipoViaje);
    }

    @Override
    public String toString() {
        return "Viaje [idViaje=" + idViaje + ", nomViaje=" + nomViaje + ", tipoViaje=" + tipoViaje + ", fechInicio="
                + fechInicio + ", fechFin=" + fechFin + ", numDias=" + numDias + ", pais=" + pais + ", descripcion="
                + descripcion + ", serviciosnoIncl=" + serviciosnoIncl + ", idAgencia=" + idAgencia + ", planViajes="
                + planViajes + ", alojamientos=" + alojamientos + ", actividades=" + actividades + "]";
    }
}

package main.java.app.com.database.models;

import java.sql.Date;
import java.util.Objects;

/**
 * La clase del modelo Alojamiento
 * 
 * @author Grupo_01
 */
public class Alojamiento {

    private String idEvento = null;
    private String nomEvento = null;
    private String tipoEvento = null;
    private String nomHotel = null;
    private String tipoHab = null;
    private String ciudad = null;
    private int precio = 0;
    private Date fechaEnt = null;
    private Date fechaSal = null;

    /**
     * Obtiene el ID del evento
     */
    public String getIdEvento() {
        return idEvento;
    }

    /**
     * Establece el ID del evento
     */
    public void setIdEvento(String idEvento) {
        this.idEvento = idEvento;
    }

    /**
     * Obtiene el nombre del evento
     */
    public String getNomEvento() {
        return nomEvento;
    }

    /**
     * Establece el nombre del evento
     */
    public void setNomEvento(String nomEvento) {
        this.nomEvento = nomEvento;
    }

    /**
     * Obtiene el tipo del evento
     */
    public String getTipoEvento() {
        return tipoEvento;
    }

    /**
     * Establece el tipo del evento
     */
    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    /**
     * Obtiene el nombre del hotel
     */
    public String getNomHotel() {
        return nomHotel;
    }

    /**
     * Establece el nombre del hotel
     */
    public void setNomHotel(String nomHotel) {
        this.nomHotel = nomHotel;
    }

    /**
     * Obtiene el tipo de habitación
     */
    public String getTipoHab() {
        return tipoHab;
    }

    /**
     * Establece el tipo de habitación
     */
    public void setTipoHab(String tipoHab) {
        this.tipoHab = tipoHab;
    }

    /**
     * Obtiene la ciudad donde se encuentra el alojamiento
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * Establece la ciudad donde se encuentra el alojamiento
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * Obtiene el precio del alojamiento
     */
    public int getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del alojamiento
     */
    public void setPrecio(int precio) {
        this.precio = precio;
    }

    /**
     * Obtiene la fecha de entrada del alojamiento
     */
    public Date getFechaEnt() {
        return fechaEnt;
    }

    /**
     * Establece la fecha de entrada del alojamiento
     */
    public void setFechaEnt(Date fechaEnt) {
        this.fechaEnt = fechaEnt;
    }

    /**
     * Obtiene la fecha de salida del alojamiento
     */
    public Date getFechaSal() {
        return fechaSal;
    }

    /**
     * Establece la fecha de salida del alojamiento
     */
    public void setFechaSal(Date fechaSal) {
        this.fechaSal = fechaSal;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ciudad, fechaEnt, fechaSal, idEvento, nomEvento, nomHotel, precio, tipoEvento, tipoHab);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Alojamiento other = (Alojamiento) obj;
        return Objects.equals(ciudad, other.ciudad) && Objects.equals(fechaEnt, other.fechaEnt)
                && Objects.equals(fechaSal, other.fechaSal) && Objects.equals(idEvento, other.idEvento)
                && Objects.equals(nomEvento, other.nomEvento) && Objects.equals(nomHotel, other.nomHotel)
                && precio == other.precio && Objects.equals(tipoEvento, other.tipoEvento)
                && Objects.equals(tipoHab, other.tipoHab);
    }

    @Override
    public String toString() {
        return "Alojamiento [idEvento=" + idEvento + ", nomEvento=" + nomEvento + ", tipoEvento=" + tipoEvento
                + ", nomHotel=" + nomHotel + ", tipoHab=" + tipoHab + ", ciudad=" + ciudad + ", precio=" + precio
                + ", fechaEnt=" + fechaEnt + ", fechaSal=" + fechaSal + "]";
    }
}

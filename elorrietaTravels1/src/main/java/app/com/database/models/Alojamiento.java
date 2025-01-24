package main.java.app.com.database.models;

import java.util.Objects;

public class Alojamiento {
	
	private Evento event = null;
    private String nomHotel = null;
    private String tipoHab = null;
    private String ciudad = null;
    private int precio = 0;
    private String fechaEnt = null;
    private String fechaSal = null;
    
	public Evento getEvent() {
		return event;
	}
	public void setEvent(Evento event) {
		this.event = event;
	}
	public String getNomHotel() {
		return nomHotel;
	}
	public void setNomHotel(String nomHotel) {
		this.nomHotel = nomHotel;
	}
	public String getTipoHab() {
		return tipoHab;
	}
	public void setTipoHab(String tipoHab) {
		this.tipoHab = tipoHab;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public String getFechaEnt() {
		return fechaEnt;
	}
	public void setFechaEnt(String fechaEnt) {
		this.fechaEnt = fechaEnt;
	}
	public String getFechaSal() {
		return fechaSal;
	}
	public void setFechaSal(String fechaSal) {
		this.fechaSal = fechaSal;
	}
	@Override
	public int hashCode() {
		return Objects.hash(ciudad, event, fechaEnt, fechaSal, nomHotel, precio, tipoHab);
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
		return Objects.equals(ciudad, other.ciudad) && Objects.equals(event, other.event)
				&& Objects.equals(fechaEnt, other.fechaEnt) && Objects.equals(fechaSal, other.fechaSal)
				&& Objects.equals(nomHotel, other.nomHotel) && precio == other.precio
				&& Objects.equals(tipoHab, other.tipoHab);
	}
	@Override
	public String toString() {
		return "Alojamiento [event=" + event + ", nomHotel=" + nomHotel + ", tipoHab=" + tipoHab + ", ciudad=" + ciudad
				+ ", precio=" + precio + ", fechaEnt=" + fechaEnt + ", fechaSal=" + fechaSal + "]";
	}
    
}

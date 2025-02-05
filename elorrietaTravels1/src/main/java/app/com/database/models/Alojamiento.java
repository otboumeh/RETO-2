package main.java.app.com.database.models;

import java.sql.Date;
import java.util.Objects;

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
	public Date getFechaEnt() {
		return fechaEnt;
	}
	public void setFechaEnt(Date fechaEnt) {
		this.fechaEnt = fechaEnt;
	}
	public Date getFechaSal() {
		return fechaSal;
	}
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

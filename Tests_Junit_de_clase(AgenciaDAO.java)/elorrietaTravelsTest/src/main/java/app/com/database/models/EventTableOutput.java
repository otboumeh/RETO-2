package main.java.app.com.database.models;

import java.sql.Date;
import java.util.Objects;

public class EventTableOutput {

	private String nomEvento = null;
	private String tipoEvento = null;
	private Date fechaEvento = null;
	private int precio = 0;
	
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
	public Date getFechaEvento() {
		return fechaEvento;
	}
	public void setFechaEvento(Date fechaEvento) {
		this.fechaEvento = fechaEvento;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	@Override
	public int hashCode() {
		return Objects.hash(fechaEvento, nomEvento, precio, tipoEvento);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EventTableOutput other = (EventTableOutput) obj;
		return Objects.equals(fechaEvento, other.fechaEvento) && Objects.equals(nomEvento, other.nomEvento)
				&& precio == other.precio && Objects.equals(tipoEvento, other.tipoEvento);
	}
	@Override
	public String toString() {
		return "EventTableOutput [nomEvento=" + nomEvento + ", tipoEvento=" + tipoEvento + ", fechaEvento="
				+ fechaEvento + ", precio=" + precio + "]";
	}
	
	
}

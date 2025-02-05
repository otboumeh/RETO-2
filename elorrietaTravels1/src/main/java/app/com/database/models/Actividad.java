package main.java.app.com.database.models;

import java.sql.Date;
import java.util.Objects;

public class Actividad {
	
    private String idEvento;
    private String nomEvento;
    private String tipoEvento;
    private String descripcion = null;
    private Date fecha = null;
    private int precio = 0;
    
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
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	@Override
	public int hashCode() {
		return Objects.hash(descripcion, fecha, idEvento, nomEvento, precio, tipoEvento);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Actividad other = (Actividad) obj;
		return Objects.equals(descripcion, other.descripcion) && Objects.equals(fecha, other.fecha)
				&& Objects.equals(idEvento, other.idEvento) && Objects.equals(nomEvento, other.nomEvento)
				&& precio == other.precio && Objects.equals(tipoEvento, other.tipoEvento);
	}
	@Override
	public String toString() {
		return "Actividad [idEvento=" + idEvento + ", nomEvento=" + nomEvento + ", tipoEvento=" + tipoEvento
				+ ", descripcion=" + descripcion + ", fecha=" + fecha + ", precio=" + precio + "]";
	}
  
    
}
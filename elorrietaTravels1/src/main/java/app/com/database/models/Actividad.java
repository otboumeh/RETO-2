package main.java.app.com.database.models;

import java.util.Objects;

public class Actividad {
	
    private Evento evento = null;
    private String descripcion = null;
    private String fecha = null;
    private int precio = 0;
    
	public Evento getEvento() {
		return evento;
	}
	public void setEvento(Evento evento) {
		this.evento = evento;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
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
		return Objects.hash(descripcion, evento, fecha, precio);
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
		return Objects.equals(descripcion, other.descripcion) && Objects.equals(evento, other.evento)
				&& Objects.equals(fecha, other.fecha) && precio == other.precio;
	}
	@Override
	public String toString() {
		return "Actividad [evento=" + evento + ", descripcion=" + descripcion + ", fecha=" + fecha + ", precio="
				+ precio + "]";
	}

}

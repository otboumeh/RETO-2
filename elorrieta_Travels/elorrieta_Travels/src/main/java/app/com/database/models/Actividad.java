package main.java.app.com.database.models;

import java.sql.Date;
import java.util.Objects;

/**
 * La clase del modelo Actividad
 * 
 * @author Grupo_01
 */
public class Actividad {

	private String idEvento;
	private String nomEvento;
	private String tipoEvento;
	private String descripcion = null;
	private Date fecha = null;
	private int precio = 0;

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
	 * Obtiene el tipo de evento
	 */
	public String getTipoEvento() {
		return tipoEvento;
	}

	/**
	 * Establece el tipo de evento
	 */
	public void setTipoEvento(String tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	/**
	 * Obtiene la descripcion del evento
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Establece la descripcion del evento
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Obtiene la fecha del evento
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * Establece la fecha del evento
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * Obtiene el precio del evento
	 */
	public int getPrecio() {
		return precio;
	}

	/**
	 * Establece el precio del evento
	 */
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

package main.java.app.com.database.models;

import java.sql.Date;
import java.sql.Time;
import java.util.Objects;

/**
 * La clase del modelo Vuelo
 * 
 * @author Grupo_01
 */
public class Vuelo {

	private String idVuelo = null;
	private Date fechaIda = null;
	private String aerolinea = null;
	private Time horarioSalida = null;
	private Time duracion = null;
	private String idAeroOrigen = null;
	private String idAeroDestino = null;
	private int precio = 0;

	/**
	 * Obtiene el ID del vuelo.
	 *
	 * @return El ID del vuelo.
	 */
	public String getIdVuelo() {
		return idVuelo;
	}

	/**
	 * Establece el ID del vuelo.
	 *
	 * @param idVuelo El ID del vuelo a establecer.
	 */
	public void setIdVuelo(String idVuelo) {
		this.idVuelo = idVuelo;
	}

	/**
	 * Obtiene la fecha de salida del vuelo.
	 *
	 * @return La fecha de salida del vuelo.
	 */
	public Date getFechaIda() {
		return fechaIda;
	}

	/**
	 * Establece la fecha de salida del vuelo.
	 *
	 * @param fechaIda La fecha de salida del vuelo a establecer.
	 */
	public void setFechaIda(Date fechaIda) {
		this.fechaIda = fechaIda;
	}

	/**
	 * Obtiene la aerolínea que opera el vuelo.
	 *
	 * @return El nombre de la aerolínea.
	 */
	public String getAerolinea() {
		return aerolinea;
	}

	/**
	 * Establece la aerolínea que opera el vuelo.
	 *
	 * @param aerolinea El nombre de la aerolínea a establecer.
	 */
	public void setAerolinea(String aerolinea) {
		this.aerolinea = aerolinea;
	}

	/**
	 * Obtiene la hora de salida del vuelo.
	 *
	 * @return La hora de salida del vuelo.
	 */
	public Time getHorarioSalida() {
		return horarioSalida;
	}

	/**
	 * Establece la hora de salida del vuelo.
	 *
	 * @param horarioSalida La hora de salida a establecer.
	 */
	public void setHorarioSalida(Time horarioSalida) {
		this.horarioSalida = horarioSalida;
	}

	/**
	 * Obtiene la duración del vuelo.
	 *
	 * @return La duración del vuelo.
	 */
	public Time getDuracion() {
		return duracion;
	}

	/**
	 * Establece la duración del vuelo.
	 *
	 * @param duracion La duración del vuelo a establecer.
	 */
	public void setDuracion(Time duracion) {
		this.duracion = duracion;
	}

	/**
	 * Obtiene el ID del aeropuerto de origen.
	 *
	 * @return El ID del aeropuerto de origen.
	 */
	public String getIdAeroOrigen() {
		return idAeroOrigen;
	}

	/**
	 * Establece el ID del aeropuerto de origen.
	 *
	 * @param idAeroOrigen El ID del aeropuerto de origen a establecer.
	 */
	public void setIdAeroOrigen(String idAeroOrigen) {
		this.idAeroOrigen = idAeroOrigen;
	}

	/**
	 * Obtiene el ID del aeropuerto de destino.
	 *
	 * @return El ID del aeropuerto de destino.
	 */
	public String getIdAeroDestino() {
		return idAeroDestino;
	}

	/**
	 * Establece el ID del aeropuerto de destino.
	 *
	 * @param idAeroDestino El ID del aeropuerto de destino a establecer.
	 */
	public void setIdAeroDestino(String idAeroDestino) {
		this.idAeroDestino = idAeroDestino;
	}

	/**
	 * Obtiene el precio del vuelo.
	 *
	 * @return El precio del vuelo.
	 */
	public int getPrecio() {
		return precio;
	}

	/**
	 * Establece el precio del vuelo.
	 *
	 * @param precio El precio del vuelo a establecer.
	 */
	public void setPrecio(int precio) {
		this.precio = precio;
	}

	@Override
	public int hashCode() {
		return Objects.hash(aerolinea, duracion, fechaIda, horarioSalida, idAeroDestino, idAeroOrigen, idVuelo, precio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vuelo other = (Vuelo) obj;
		return Objects.equals(aerolinea, other.aerolinea) && Objects.equals(duracion, other.duracion)
				&& Objects.equals(fechaIda, other.fechaIda) && Objects.equals(horarioSalida, other.horarioSalida)
				&& Objects.equals(idAeroDestino, other.idAeroDestino)
				&& Objects.equals(idAeroOrigen, other.idAeroOrigen) && Objects.equals(idVuelo, other.idVuelo)
				&& precio == other.precio;
	}

	@Override
	public String toString() {
		return "Vuelo [idVuelo=" + idVuelo + ", fechaIda=" + fechaIda + ", aerolinea=" + aerolinea + ", horarioSalida="
				+ horarioSalida + ", duracion=" + duracion + ", idAeroOrigen=" + idAeroOrigen + ", idAeroDestino="
				+ idAeroDestino + ", precio=" + precio + "]";
	}
}

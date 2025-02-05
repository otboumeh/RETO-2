package main.java.app.com.database.models;

import java.sql.Date;
import java.sql.Time;
import java.util.Objects;

public class Vuelo {
	
	 	private String idVuelo = null;
	    private Date fechaIda = null;
	    private String aerolinea = null;
	    private Time horarioSalida = null;
	    private int duracion = 0; 
	    private Aeropuerto aeropuertoOrigen = null;
	    private Aeropuerto aeropuertoDestino = null;
	    private int precio = 0;
		public String getIdVuelo() {
			return idVuelo;
		}
		public void setIdVuelo(String idVuelo) {
			this.idVuelo = idVuelo;
		}
		public Date getFechaIda() {
			return fechaIda;
		}
		public void setFechaIda(Date fechaIda) {
			this.fechaIda = fechaIda;
		}
		public String getAerolinea() {
			return aerolinea;
		}
		public void setAerolinea(String aerolinea) {
			this.aerolinea = aerolinea;
		}
		public Time getHorarioSalida() {
			return horarioSalida;
		}
		public void setHorarioSalida(Time horarioSalida) {
			this.horarioSalida = horarioSalida;
		}
		public int getDuracion() {
			return duracion;
		}
		public void setDuracion(int duracion) {
			this.duracion = duracion;
		}
		public Aeropuerto getAeropuertoOrigen() {
			return aeropuertoOrigen;
		}
		public void setAeropuertoOrigen(Aeropuerto aeropuertoOrigen) {
			this.aeropuertoOrigen = aeropuertoOrigen;
		}
		public Aeropuerto getAeropuertoDestino() {
			return aeropuertoDestino;
		}
		public void setAeropuertoDestino(Aeropuerto aeropuertoDestino) {
			this.aeropuertoDestino = aeropuertoDestino;
		}
		public int getPrecio() {
			return precio;
		}
		public void setPrecio(int precio) {
			this.precio = precio;
		}
		@Override
		public int hashCode() {
			return Objects.hash(aerolinea, aeropuertoDestino, aeropuertoOrigen, duracion, fechaIda, horarioSalida,
					idVuelo, precio);
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
			return Objects.equals(aerolinea, other.aerolinea)
					&& Objects.equals(aeropuertoDestino, other.aeropuertoDestino)
					&& Objects.equals(aeropuertoOrigen, other.aeropuertoOrigen) && duracion == other.duracion
					&& Objects.equals(fechaIda, other.fechaIda) && Objects.equals(horarioSalida, other.horarioSalida)
					&& Objects.equals(idVuelo, other.idVuelo) && precio == other.precio;
		}
		@Override
		public String toString() {
			return "Vuelo [idVuelo=" + idVuelo + ", fechaIda=" + fechaIda + ", aerolinea=" + aerolinea
					+ ", horarioSalida=" + horarioSalida + ", duracion=" + duracion + ", aeropuertoOrigen="
					+ aeropuertoOrigen + ", aeropuertoDestino=" + aeropuertoDestino + ", precio=" + precio + "]";
		}

	    
}
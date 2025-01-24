package main.java.app.com.database.models;

import java.sql.Date;
import java.sql.Time;
import java.util.Objects;

public class Vuelo {
	
	 	private String idVuelo;
	    private Date fechaIda;
	    private String aerolinea;
	    private Time horarioSalida;
	    private int duracion; 
	    private Aeropuerto idAeropuertoOrigen;
	    private Aeropuerto idAeropuertoDestino;
	    
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

		public Aeropuerto getIdAeropuertoOrigen() {
			return idAeropuertoOrigen;
		}

		public void setIdAeropuertoOrigen(Aeropuerto idAeropuertoOrigen) {
			this.idAeropuertoOrigen = idAeropuertoOrigen;
		}

		public Aeropuerto getIdAeropuertoDestino() {
			return idAeropuertoDestino;
		}

		public void setIdAeropuertoDestino(Aeropuerto idAeropuertoDestino) {
			this.idAeropuertoDestino = idAeropuertoDestino;
		}

		@Override
		public int hashCode() {
			return Objects.hash(aerolinea, duracion, fechaIda, horarioSalida, idAeropuertoDestino, idAeropuertoOrigen,
					idVuelo);
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
			return Objects.equals(aerolinea, other.aerolinea) && duracion == other.duracion
					&& Objects.equals(fechaIda, other.fechaIda) && Objects.equals(horarioSalida, other.horarioSalida)
					&& Objects.equals(idAeropuertoDestino, other.idAeropuertoDestino)
					&& Objects.equals(idAeropuertoOrigen, other.idAeropuertoOrigen)
					&& Objects.equals(idVuelo, other.idVuelo);
		}

		
		@Override
		public String toString() {
			return "Vuelo [idVuelo=" + idVuelo + ", fechaIda=" + fechaIda + ", aerolinea=" + aerolinea
					+ ", horarioSalida=" + horarioSalida + ", duracion=" + duracion + ", idAeropuertoOrigen="
					+ idAeropuertoOrigen + ", idAeropuertoDestino=" + idAeropuertoDestino + "]";
		}

}

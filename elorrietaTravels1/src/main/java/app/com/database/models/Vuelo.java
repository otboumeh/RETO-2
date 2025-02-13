package main.java.app.com.database.models;

import java.sql.Date;
import java.sql.Time;
import java.util.Objects;

public class Vuelo {
	
	 	private String idVuelo = null;
	    private Date fechaIda = null;
	    private String aerolinea = null;
	    private Time horarioSalida = null;
	    private Time duracion = null; 
	    private String idAeroOrigen = null;
	    private String idAeroDestino = null;
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
		public Time getDuracion() {
			return duracion;
		}
		public void setDuracion(Time duracion) {
			this.duracion = duracion;
		}
		public String getIdAeroOrigen() {
			return idAeroOrigen;
		}
		public void setIdAeroOrigen(String idAeroOrigen) {
			this.idAeroOrigen = idAeroOrigen;
		}
		public String getIdAeroDestino() {
			return idAeroDestino;
		}
		public void setIdAeroDestino(String idAeroDestino) {
			this.idAeroDestino = idAeroDestino;
		}
		public int getPrecio() {
			return precio;
		}
		public void setPrecio(int precio) {
			this.precio = precio;
		}
		@Override
		public int hashCode() {
			return Objects.hash(aerolinea, duracion, fechaIda, horarioSalida, idAeroDestino, idAeroOrigen, idVuelo,
					precio);
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
			return "Vuelo [idVuelo=" + idVuelo + ", fechaIda=" + fechaIda + ", aerolinea=" + aerolinea
					+ ", horarioSalida=" + horarioSalida + ", duracion=" + duracion + ", idAeroOrigen=" + idAeroOrigen
					+ ", idAeroDestino=" + idAeroDestino + ", precio=" + precio + "]";
		}

	   
}
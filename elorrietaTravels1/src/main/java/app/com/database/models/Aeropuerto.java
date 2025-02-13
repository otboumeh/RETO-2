package main.java.app.com.database.models;

import java.util.Objects;

public class Aeropuerto {
	
	  	private String idAeropuerto;
	    private String ciudad;

		public String getIdAeropuerto() {
			return idAeropuerto;
		}

		public void setIdAeropuerto(String idAeropuerto) {
			this.idAeropuerto = idAeropuerto;
		}


		public String getCiudad() {
			return ciudad;
		}

		public void setCiudad(String ciudad) {
			this.ciudad = ciudad;
		}

		@Override
		public int hashCode() {
			return Objects.hash(ciudad, idAeropuerto);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Aeropuerto other = (Aeropuerto) obj;
			return Objects.equals(ciudad, other.ciudad) && Objects.equals(idAeropuerto, other.idAeropuerto);
		}

		@Override
		public String toString() {
			return "Aeropuerto [idAeropuerto=" + idAeropuerto + ", ciudad=" + ciudad + "]";
		}

}

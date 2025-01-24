package main.java.app.com.database.models;

import java.util.Objects;

public class Aeropuerto {
	
	  	private String idAeropuerto;
	    private String nomAero;
	    private String ciudad;
	    private Pais pais;

		public String getIdAeropuerto() {
			return idAeropuerto;
		}

		public void setIdAeropuerto(String idAeropuerto) {
			this.idAeropuerto = idAeropuerto;
		}

		public String getNomAero() {
			return nomAero;
		}

		public void setNomAero(String nomAero) {
			this.nomAero = nomAero;
		}

		public String getCiudad() {
			return ciudad;
		}

		public void setCiudad(String ciudad) {
			this.ciudad = ciudad;
		}

		public Pais getPais() {
			return pais;
		}

		public void setPais(Pais pais) {
			this.pais = pais;
		}

		@Override
		public int hashCode() {
			return Objects.hash(ciudad, idAeropuerto, nomAero, pais);
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
			return Objects.equals(ciudad, other.ciudad) && Objects.equals(idAeropuerto, other.idAeropuerto)
					&& Objects.equals(nomAero, other.nomAero) && Objects.equals(pais, other.pais);
		}

		
		@Override
		public String toString() {
			return "Aeropuerto [idAeropuerto=" + idAeropuerto + ", nomAero=" + nomAero + ", ciudad=" + ciudad
					+ ", pais=" + pais + "]";
		}

}

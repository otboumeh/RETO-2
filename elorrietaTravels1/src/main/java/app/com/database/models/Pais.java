package main.java.app.com.database.models;

import java.util.Objects;

public class Pais {
	
	 	private String idPais;
	    private String nomPais;

		public String getIdPais() {
			return idPais;
		}

		public void setIdPais(String idPais) {
			this.idPais = idPais;
		}

		public String getNomPais() {
			return nomPais;
		}

		public void setNomPais(String nomPais) {
			this.nomPais = nomPais;
		}

				@Override
		public int hashCode() {
			return Objects.hash(idPais, nomPais);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Pais other = (Pais) obj;
			return Objects.equals(idPais, other.idPais) && Objects.equals(nomPais, other.nomPais);
		}

		@Override
		public String toString() {
			return "Pais [idPais=" + idPais + ", nomPais=" + nomPais + "]";
		}

}

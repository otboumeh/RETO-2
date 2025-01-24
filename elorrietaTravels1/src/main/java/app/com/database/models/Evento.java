package main.java.app.com.database.models;

import java.util.Objects;

public class Evento {
	
    private String idEvento;
    private String nomEvento;
    private String tipoEvento;
    
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
	@Override
	public int hashCode() {
		return Objects.hash(idEvento, nomEvento, tipoEvento);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Evento other = (Evento) obj;
		return Objects.equals(idEvento, other.idEvento) && Objects.equals(nomEvento, other.nomEvento)
				&& Objects.equals(tipoEvento, other.tipoEvento);
	}
	@Override
	public String toString() {
		return "Evento [idEvento=" + idEvento + ", nomEvento=" + nomEvento + ", tipoEvento=" + tipoEvento + "]";
	}

}
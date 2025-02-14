package main.java.app.com.database.models;

import java.util.Objects;

public class PlanViaje {
	
    private String idEvento =  null;
    private String nomEvento = null;
    private String tipoEvento = null;
    private String trayecto = null;
    private Vuelo ida = null;
    private Vuelo vuelta = null;
    
    
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
	public String getTrayecto() {
		return trayecto;
	}
	public void setTrayecto(String trayecto) {
		this.trayecto = trayecto;
	}
	public Vuelo getIda() {
		return ida;
	}
	public void setIda(Vuelo ida) {
		this.ida = ida;
	}
	public Vuelo getVuelta() {
		return vuelta;
	}
	public void setVuelta(Vuelo vuelta) {
		this.vuelta = vuelta;
	}
	@Override
	public int hashCode() {
		return Objects.hash(idEvento, ida, nomEvento, tipoEvento, trayecto, vuelta);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlanViaje other = (PlanViaje) obj;
		return Objects.equals(idEvento, other.idEvento) && Objects.equals(ida, other.ida)
				&& Objects.equals(nomEvento, other.nomEvento) && Objects.equals(tipoEvento, other.tipoEvento)
				&& Objects.equals(trayecto, other.trayecto) && Objects.equals(vuelta, other.vuelta);
	}
	@Override
	public String toString() {
		return "PlanViaje [idEvento=" + idEvento + ", nomEvento=" + nomEvento + ", tipoEvento=" + tipoEvento
				+ ", trayecto=" + trayecto + ", ida=" + ida + ", vuelta=" + vuelta + "]";
	}
    
    
}
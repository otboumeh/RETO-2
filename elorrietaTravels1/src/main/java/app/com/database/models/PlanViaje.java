package main.java.app.com.database.models;

import java.util.Objects;

public class PlanViaje {
	
    private Evento evento = null;
    private String trayecto = null;
    private Vuelo ida = null;
    private Vuelo vuelta = null;
    
	public Evento getEvento() {
		return evento;
	}
	public void setEvento(Evento evento) {
		this.evento = evento;
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
		return Objects.hash(evento, ida, trayecto, vuelta);
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
		return Objects.equals(evento, other.evento) && Objects.equals(ida, other.ida)
				&& Objects.equals(trayecto, other.trayecto) && Objects.equals(vuelta, other.vuelta);
	}
	@Override
	public String toString() {
		return "PlanViaje [evento=" + evento + ", trayecto=" + trayecto + ", ida=" + ida + ", vuelta=" + vuelta + "]";
	}
    
    


}
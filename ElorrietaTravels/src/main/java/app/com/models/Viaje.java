package main.java.app.com.models;

import java.sql.Date;
import java.util.Objects;

public class Viaje {
	
	String idViaje = null;
	String nomViaje = null; 
	String tipoViaje = null;
	Date fechInicio = null;
	Date fechFin = null;
	int numDias = 0;
	String paisDestino = null;
	String descripcion = null;
	String serviciosnoIncl = null;
	String idAgencia = null;
	
	public String getIdViaje() {
		return idViaje;
	}
	public void setIdViaje(String idViaje) {
		this.idViaje = idViaje;
	}
	public String getNomViaje() {
		return nomViaje;
	}
	public void setNomViaje(String nomViaje) {
		this.nomViaje = nomViaje;
	}
	public String getTipoViaje() {
		return tipoViaje;
	}
	public void setTipoViaje(String tipoViaje) {
		this.tipoViaje = tipoViaje;
	}
	public Date getFechInicio() {
		return fechInicio;
	}
	public void setFechInicio(Date fechInicio) {
		this.fechInicio = fechInicio;
	}
	public Date getFechFin() {
		return fechFin;
	}
	public void setFechFin(Date fechFin) {
		this.fechFin = fechFin;
	}
	public int getNumDias() {
		return numDias;
	}
	public void setNumDias(int numDias) {
		this.numDias = numDias;
	}
	public String getPaisDestino() {
		return paisDestino;
	}
	public void setPaisDestino(String paisDestino) {
		this.paisDestino = paisDestino;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getServiciosnoIncl() {
		return serviciosnoIncl;
	}
	public void setServiciosnoIncl(String serviciosnoIncl) {
		this.serviciosnoIncl = serviciosnoIncl;
	}
	public String getIdAgencia() {
		return idAgencia;
	}
	public void setIdAgencia(String idAgencia) {
		this.idAgencia = idAgencia;
	}
	@Override
	public int hashCode() {
		return Objects.hash(descripcion, fechFin, fechInicio, idAgencia, idViaje, nomViaje, numDias, paisDestino,
				serviciosnoIncl, tipoViaje);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Viaje other = (Viaje) obj;
		return Objects.equals(descripcion, other.descripcion) && Objects.equals(fechFin, other.fechFin)
				&& Objects.equals(fechInicio, other.fechInicio) && Objects.equals(idAgencia, other.idAgencia)
				&& Objects.equals(idViaje, other.idViaje) && Objects.equals(nomViaje, other.nomViaje)
				&& numDias == other.numDias && Objects.equals(paisDestino, other.paisDestino)
				&& Objects.equals(serviciosnoIncl, other.serviciosnoIncl) && Objects.equals(tipoViaje, other.tipoViaje);
	}
	@Override
	public String toString() {
		return "Viaje [idViaje=" + idViaje + ", nomViaje=" + nomViaje + ", tipoViaje=" + tipoViaje + ", fechInicio="
				+ fechInicio + ", fechFin=" + fechFin + ", numDias=" + numDias + ", paisDestino=" + paisDestino
				+ ", descripcion=" + descripcion + ", serviciosnoIncl=" + serviciosnoIncl + ", idAgencia=" + idAgencia
				+ "]";
	}

	
	
}

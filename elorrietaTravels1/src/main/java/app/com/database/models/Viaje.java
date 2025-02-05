package main.java.app.com.database.models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Objects;

public class Viaje {
	
	private String idViaje = null;
	private String nomViaje = null; 
	private String tipoViaje = null;
	private Date fechInicio = null;
	private Date fechFin = null;
	private long numDias = 0;
	private String pais = null;
	private String descripcion = null;
	private String serviciosnoIncl = null;
	private String idAgencia = null;
	private ArrayList<PlanViaje> planViajes = null;
	private ArrayList<Alojamiento> alojamientos = null;
	private ArrayList<Actividad> actividades = null;
	
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
	public long getNumDias() {
		return numDias;
	}
	public void setNumDias(long numDias) {
		this.numDias = numDias;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
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
	public ArrayList<PlanViaje> getPlanViajes() {
		return planViajes;
	}
	public void setPlanViajes(ArrayList<PlanViaje> planViajes) {
		this.planViajes = planViajes;
	}
	public ArrayList<Alojamiento> getAlojamientos() {
		return alojamientos;
	}
	public void setAlojamientos(ArrayList<Alojamiento> alojamientos) {
		this.alojamientos = alojamientos;
	}
	public ArrayList<Actividad> getActividades() {
		return actividades;
	}
	public void setActividades(ArrayList<Actividad> actividades) {
		this.actividades = actividades;
	}
	@Override
	public int hashCode() {
		return Objects.hash(actividades, alojamientos, descripcion, fechFin, fechInicio, idAgencia, idViaje, nomViaje,
				numDias, pais, planViajes, serviciosnoIncl, tipoViaje);
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
		return Objects.equals(actividades, other.actividades) && Objects.equals(alojamientos, other.alojamientos)
				&& Objects.equals(descripcion, other.descripcion) && Objects.equals(fechFin, other.fechFin)
				&& Objects.equals(fechInicio, other.fechInicio) && Objects.equals(idAgencia, other.idAgencia)
				&& Objects.equals(idViaje, other.idViaje) && Objects.equals(nomViaje, other.nomViaje)
				&& numDias == other.numDias && Objects.equals(pais, other.pais)
				&& Objects.equals(planViajes, other.planViajes)
				&& Objects.equals(serviciosnoIncl, other.serviciosnoIncl) && Objects.equals(tipoViaje, other.tipoViaje);
	}
	@Override
	public String toString() {
		return "Viaje [idViaje=" + idViaje + ", nomViaje=" + nomViaje + ", tipoViaje=" + tipoViaje + ", fechInicio="
				+ fechInicio + ", fechFin=" + fechFin + ", numDias=" + numDias + ", pais=" + pais + ", descripcion="
				+ descripcion + ", serviciosnoIncl=" + serviciosnoIncl + ", idAgencia=" + idAgencia + ", planViajes="
				+ planViajes + ", alojamientos=" + alojamientos + ", actividades=" + actividades + "]";
	}
	
}
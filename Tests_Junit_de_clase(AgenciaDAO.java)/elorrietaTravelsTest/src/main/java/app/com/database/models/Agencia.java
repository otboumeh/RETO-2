package main.java.app.com.database.models;

import java.util.ArrayList;
import java.util.Objects;

public class Agencia {

	private String idAgencia = null;
	private String nomAgencia = null;
	private String tipoAgencia = null;
	private String colorAgencia = null;
	private String NumEmp = null;
	private String logo = null;
	private String pass = null;
	private ArrayList<Viaje> viajes = new ArrayList<Viaje>();
	
	
	public String getIdAgencia() {
		return idAgencia;
	}
	public void setIdAgencia(String idAgencia) {
		this.idAgencia = idAgencia;
	}
	public String getNomAgencia() {
		return nomAgencia;
	}
	public void setNomAgencia(String nomAgencia) {
		this.nomAgencia = nomAgencia;
	}
	public String getTipoAgencia() {
		return tipoAgencia;
	}
	public void setTipoAgencia(String tipoAgencia) {
		this.tipoAgencia = tipoAgencia;
	}
	public String getColorAgencia() {
		return colorAgencia;
	}
	public void setColorAgencia(String colorAgencia) {
		this.colorAgencia = colorAgencia;
	}
	public String getNumEmp() {
		return NumEmp;
	}
	public void setNumEmp(String numEmp) {
		NumEmp = numEmp;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public ArrayList<Viaje> getViajes() {
		return viajes;
	}
	public void setViajes(ArrayList<Viaje> viajes) {
		this.viajes = viajes;
	}
	@Override
	public int hashCode() {
		return Objects.hash(NumEmp, colorAgencia, idAgencia, logo, nomAgencia, pass, tipoAgencia, viajes);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agencia other = (Agencia) obj;
		return Objects.equals(NumEmp, other.NumEmp) && Objects.equals(colorAgencia, other.colorAgencia)
				&& Objects.equals(idAgencia, other.idAgencia) && Objects.equals(logo, other.logo)
				&& Objects.equals(nomAgencia, other.nomAgencia) && Objects.equals(pass, other.pass)
				&& Objects.equals(tipoAgencia, other.tipoAgencia) && Objects.equals(viajes, other.viajes);
	}
	@Override
	public String toString() {
		return "Agencia [idAgencia=" + idAgencia + ", nomAgencia=" + nomAgencia + ", tipoAgencia=" + tipoAgencia
				+ ", colorAgencia=" + colorAgencia + ", NumEmp=" + NumEmp + ", logo=" + logo + ", pass=" + pass
				+ ", viajes=" + viajes + "]";
	}


}
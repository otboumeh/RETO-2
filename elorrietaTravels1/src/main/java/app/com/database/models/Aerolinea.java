package main.java.app.com.database.models;

import java.util.Objects;

public class Aerolinea {
	
	private String codAirline = null;
	private String nameAirline = null;
	
	public String getCodAirline() {
		return codAirline;
	}
	public void setCodAirline(String codAirline) {
		this.codAirline = codAirline;
	}
	public String getNameAirline() {
		return nameAirline;
	}
	public void setNameAirline(String nameAirline) {
		this.nameAirline = nameAirline;
	}
	@Override
	public int hashCode() {
		return Objects.hash(codAirline, nameAirline);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aerolinea other = (Aerolinea) obj;
		return Objects.equals(codAirline, other.codAirline) && Objects.equals(nameAirline, other.nameAirline);
	}
	@Override
	public String toString() {
		return "Aerolinea [codAirline=" + codAirline + ", nameAirline=" + nameAirline + "]";
	}
	
}

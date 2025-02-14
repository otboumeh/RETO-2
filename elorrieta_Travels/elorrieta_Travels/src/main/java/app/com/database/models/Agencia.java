package main.java.app.com.database.models;

import java.util.ArrayList;
import java.util.Objects;

/**
 * La clase del modelo Agencia
 * 
 * @author Grupo_01
 */
public class Agencia {

    private String idAgencia = null;
    private String nomAgencia = null;
    private String tipoAgencia = null;
    private String colorAgencia = null;
    private String NumEmp = null;
    private String logo = null;
    private String pass = null;
    private ArrayList<Viaje> viajes = new ArrayList<Viaje>();

    /**
     * Obtiene el ID de la agencia
     */
    public String getIdAgencia() {
        return idAgencia;
    }

    /**
     * Establece el ID de la agencia
     */
    public void setIdAgencia(String idAgencia) {
        this.idAgencia = idAgencia;
    }

    /**
     * Obtiene el nombre de la agencia
     */
    public String getNomAgencia() {
        return nomAgencia;
    }

    /**
     * Establece el nombre de la agencia
     */
    public void setNomAgencia(String nomAgencia) {
        this.nomAgencia = nomAgencia;
    }

    /**
     * Obtiene el tipo de agencia
     */
    public String getTipoAgencia() {
        return tipoAgencia;
    }

    /**
     * Establece el tipo de agencia
     */
    public void setTipoAgencia(String tipoAgencia) {
        this.tipoAgencia = tipoAgencia;
    }

    /**
     * Obtiene el color de la agencia
     */
    public String getColorAgencia() {
        return colorAgencia;
    }

    /**
     * Establece el color de la agencia
     */
    public void setColorAgencia(String colorAgencia) {
        this.colorAgencia = colorAgencia;
    }

    /**
     * Obtiene el número de empleados de la agencia
     */
    public String getNumEmp() {
        return NumEmp;
    }

    /**
     * Establece el número de empleados de la agencia
     */
    public void setNumEmp(String numEmp) {
        NumEmp = numEmp;
    }

    /**
     * Obtiene el logo de la agencia
     */
    public String getLogo() {
        return logo;
    }

    /**
     * Establece el logo de la agencia
     */
    public void setLogo(String logo) {
        this.logo = logo;
    }

    /**
     * Obtiene la contraseña de la agencia
     */
    public String getPass() {
        return pass;
    }

    /**
     * Establece la contraseña de la agencia
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    /**
     * Obtiene la lista de viajes de la agencia
     */
    public ArrayList<Viaje> getViajes() {
        return viajes;
    }

    /**
     * Establece la lista de viajes de la agencia
     */
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

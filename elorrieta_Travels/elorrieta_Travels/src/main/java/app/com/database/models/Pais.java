package main.java.app.com.database.models;

import java.util.Objects;

/**
 * La clase del modelo Pais
 * 
 * @author Grupo_01
 */
public class Pais {

    private String idPais;
    private String nomPais;

    /**
     * Obtiene el ID del país.
     *
     * @return El ID del país.
     */
    public String getIdPais() {
        return idPais;
    }

    /**
     * Establece el ID del país.
     *
     * @param idPais El ID del país a establecer.
     */
    public void setIdPais(String idPais) {
        this.idPais = idPais;
    }

    /**
     * Obtiene el nombre del país.
     *
     * @return El nombre del país.
     */
    public String getNomPais() {
        return nomPais;
    }

    /**
     * Establece el nombre del país.
     *
     * @param nomPais El nombre del país a establecer.
     */
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

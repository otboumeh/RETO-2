package main.java.app.com.models;

public class Alojamiento {
    private String idAlojamiento;
    private String nomHotel;
    private String tipoHab;
    private String ciudad;
    private int precio;
    private String fechaEnt;
    private String fechaSal;

    public Alojamiento() {}

    public Alojamiento(String idAlojamiento, String nomHotel, String tipoHab, String ciudad, int precio, String fechaEnt, String fechaSal) {
        this.idAlojamiento = idAlojamiento;
        this.nomHotel = nomHotel;
        this.tipoHab = tipoHab;
        this.ciudad = ciudad;
        this.precio = precio;
        this.fechaEnt = fechaEnt;
        this.fechaSal = fechaSal;
    }

    public String getIdAlojamiento() {
        return idAlojamiento;
    }

    public void setIdAlojamiento(String idAlojamiento) {
        this.idAlojamiento = idAlojamiento;
    }

    public String getNomHotel() {
        return nomHotel;
    }

    public void setNomHotel(String nomHotel) {
        this.nomHotel = nomHotel;
    }

    public String getTipoHab() {
        return tipoHab;
    }

    public void setTipoHab(String tipoHab) {
        this.tipoHab = tipoHab;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getFechaEnt() {
        return fechaEnt;
    }

    public void setFechaEnt(String fechaEnt) {
        this.fechaEnt = fechaEnt;
    }

    public String getFechaSal() {
        return fechaSal;
    }

    public void setFechaSal(String fechaSal) {
        this.fechaSal = fechaSal;
    }

    @Override
    public String toString() {
        return "Alojamiento{" +
                "idAlojamiento='" + idAlojamiento + '\'' +
                ", nomHotel='" + nomHotel + '\'' +
                ", tipoHab='" + tipoHab + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", precio=" + precio +
                ", fechaEnt='" + fechaEnt + '\'' +
                ", fechaSal='" + fechaSal + '\'' +
                '}';
    }
}

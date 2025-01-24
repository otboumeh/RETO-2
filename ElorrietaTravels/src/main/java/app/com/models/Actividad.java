package main.java.app.com.models;

public class Actividad {
    private String idActividad;
    private String descripcion;
    private String fecha;
    private int precio;

    private Evento evento;

    public Actividad(String idActividad, String descripcion, String fecha, int precio, Evento evento) {
        this.idActividad = idActividad;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.precio = precio;
        this.evento = evento;
    }

    public String getIdActividad() { return idActividad; }
    public void setIdActividad(String idActividad) { this.idActividad = idActividad; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }

    public int getPrecio() { return precio; }
    public void setPrecio(int precio) { this.precio = precio; }

    public Evento getEvento() { return evento; }
    public void setEvento(Evento evento) { this.evento = evento; }

    @Override
    public String toString() {
        return "Actividad{" +
                "idActividad='" + idActividad + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fecha='" + fecha + '\'' +
                ", precio=" + precio +
                ", evento=" + (evento != null ? evento.getIdEvento() : "null") +
                '}';
    }
}

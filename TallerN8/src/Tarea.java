public class Tarea {
    private String descripcion;
    private String responsable;
    private String estado; // "Pendiente", "En curso", "Terminada"

    public Tarea(String descripcion, String responsable, String estado) {
        this.descripcion = descripcion;
        this.responsable = responsable;
        this.estado = estado;
    }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getResponsable() { return responsable; }
    public void setResponsable(String responsable) { this.responsable = responsable; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado= estado; }
}


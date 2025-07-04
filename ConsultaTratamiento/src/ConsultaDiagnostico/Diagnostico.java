package ConsultaDiagnostico;

public class Diagnostico {
    private String descripcion;
    private String tratamiento;

    public Diagnostico(String descripcion, String tratamiento) {
        this.descripcion = descripcion;
        this.tratamiento = tratamiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public boolean esTratamientoLargo() {
        return tratamiento.length()> 30;
    }
}

package Modelo;
import Excepciones.DatoInvalido;

public class Huesped {
    private String nombre;
    private String cedula;
    private String correo;

    public Huesped(String nombre, String cedula, String correo) {
        if (nombre == null || nombre.isEmpty())
            throw new DatoInvalido("El nombre no puede estar vacío");
        this.nombre = nombre;
        this.cedula = cedula;
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }
    public String getCedula() {
        return cedula;
    }
    public String getCorreo() {
        return correo;
    }

    @Override
    public String toString() {
        return nombre + " (" + cedula + ")";
    }
}
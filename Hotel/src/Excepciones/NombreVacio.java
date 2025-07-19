package Excepciones;

public class NombreVacio extends RuntimeException  {
    public NombreVacio(String mensaje) {
        super(mensaje);
    }
}

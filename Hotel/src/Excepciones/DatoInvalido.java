package Excepciones;

public class DatoInvalido extends RuntimeException {
    public DatoInvalido(String mensaje) {
        super(mensaje);
    }
}

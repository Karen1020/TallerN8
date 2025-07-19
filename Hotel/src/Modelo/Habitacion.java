package Modelo;

public class Habitacion {
    private int numero;
    private String tipo;
    private double precio;

    public Habitacion (int numero, String tipo, double precio) {
        this.numero = numero;
        this.tipo = tipo;
        this.precio = precio;
    }

    public int getNumero() {
        return numero;
    }
    public String getTipo() {
        return tipo;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return tipo + " # " + numero + " -$ " + precio;
    }
}

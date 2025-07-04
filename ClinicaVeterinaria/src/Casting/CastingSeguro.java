package Casting;
import Instance.Gato;
import Instance.Mascota;
import Instance.Perro;

public class CastingSeguro {
    public static void main(String[] args) {
    Mascota m = new Gato("Michi");

    if (m instanceof Perro) {
        Perro perro = (Perro) m;
        perro.ladrar();
    } else {
        System.out.println("No es un perro, no se puede ladrar.");
    }
}
}

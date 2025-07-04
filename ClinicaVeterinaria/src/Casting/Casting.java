package Casting;
import Instance.Gato;
import Instance.Perro;
import Instance.Mascota;

public class Casting {
    public static void main(String[] args) {
        Mascota m = new Gato("Michi");
        if (m instanceof Gato) {

            // ¿Qué pasa aquí? -
            if (m instanceof Perro) {
                Perro perro = (Perro) m;  // Esto lanza ClassCastException
                perro.ladrar();
            } else {
                System.out.println("No es un perro, no se puede ladrar");
            }
        }
    }
}

package Instance;

public class Mascota {

    protected String nombre;

    public Mascota(String nombre) {
        this.nombre = nombre;
    }

    public void saludar() {
        System.out.println("Hola, soy " + nombre);
    }
}

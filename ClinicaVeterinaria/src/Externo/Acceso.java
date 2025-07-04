package Externo;
import ModificadoresAcceso.Mascota;

public class Acceso {
    public static void main(String[] args) {
        Mascota mascota = new Mascota();

        // System.out.println(m.nombrePrivado);   // Error
        // System.out.println(m.nombreDefault);   // Error
        // System.out.println(m.nombreProtegido); // Error
        System.out.println(m.nombrePublico);      // OK

        m.metodoPublico(); // OK
    }
}

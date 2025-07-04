package ModificadoresAcceso;

public class AccesoPaquete {
    public static void main(String[] args) {
        Mascota m = new Mascota();
        // System.out.println(m.nombrePrivado); // Error
        System.out.println(m.nombreDefault);     // OK
        System.out.println(m.nombreProtegido);   // OK
        System.out.println(m.nombrePublico);     // OK

        // m.metodoPrivado(); // Error
        m.metodoDefault();     // OK
        m.metodoProtegido();   // OK
        m.metodoPublico();     // OK
    }
}


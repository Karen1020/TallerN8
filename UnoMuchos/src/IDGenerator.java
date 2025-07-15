public class IDGenerator {
    private static int contadorConsulta = 1;
    private static int contadorPaciente = 1;

    public static String generarCodigoConsulta() {
        return "C" + (contadorConsulta++);
    }

    public static String generarCodigoPaciente() {
        return "P" + (contadorPaciente++);
    }
}

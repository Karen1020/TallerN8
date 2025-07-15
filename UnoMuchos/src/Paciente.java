public class Paciente {

    private String nombre;
    private String especie;
    private int edad;
    private String id;
    private Historial historial; //Historial agregado

    public Paciente(String nombre, String especie, int edad, String id) {
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
        this.id = id;
        this.historial = new Historial(); // Inicia el historial
    }

    public String getNombre() { return nombre; }
    public String getEspecie() { return especie; }
    public int getEdad() { return edad; }
    public String getId() { return id; }

    public Historial getHistorial() {
        return historial; //Devuelve historial real
    }

    public void agregarConsulta(Consulta consulta) {
        historial.agregarConsulta(consulta); //Usa historial interno
    }
}

/* import java.util.ArrayList;
public class Mascota {

    private String nombre;
    private String especie;
    private int edad;
    private ArrayList<Consulta> consultas = new ArrayList<>();

    public Mascota(String nombre, String especie, int edad) {
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public ArrayList<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(ArrayList<Consulta> consultas) {
        this.consultas = consultas;
    }

    public void agregarConsulta(Consulta consulta){
        consultas.add(consulta);
    }

    public void mostrarHistorial(){
        System.out.println("Mascota: " + nombre);
        System.out.println("Especie: " + especie);
        System.out.println("Edad: " + edad);
        for (Consulta consu : consultas) {
            consu.mostrarDetallesConsulta();
        }
    }
} */

import java.util.ArrayList;
public class Mascota {
    private String nombre;
    private String especie;
    private int edad;
    // private ArrayList<Consulta> consultas;
    //Refactor: delegar a clase Historial
    private Historial historial;

    public Mascota(String nombre, String especie, int edad) {
        /*this.nombre = nombre;
        this.especie = especie;         //adiós consultas, hola historial más limpio
        this.edad = edad;
        this.consultas = new ArrayList<>();*/
        //Refactor: usar setters + historial
        setNombre(nombre);
        setEspecie(especie);
        setEdad(edad);
        this.historial = new Historial();
    }

    public void agregarConsulta(Consulta consulta) {
        // consultas.add(consulta); // adiós lista directa, diseño limpio y claro
        historial.agregarConsulta(consulta); // delegar responsabilidad
    }

    public void mostrarHistorial() {
        System.out.println("Mascota: " + nombre + " | Especie: " + especie + " | Edad: " + edad + " años");
        System.out.println("Historial de consultas:"); //menos código, más orden
        /*if (consultas.isEmpty()) {
            System.out.println("Sin consultas registradas.");
        } else {
            for (Consulta c : consultas) {
                c.mostrarConsulta();
                System.out.println("--------------------------");
            }
        }*/
        historial.mostrarConsultas(); //nuevo método
    }

    //Nuevos setters con validación
    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("Nombre inválido.");
        }
        this.nombre = nombre;
    }

    public void setEspecie(String especie) {
        if (especie == null || especie.isBlank()) {
            throw new IllegalArgumentException("Especie inválida.");
        }
        this.especie = especie;
    }

    public void setEdad(int edad) {
        if (edad < 0) {
            throw new IllegalArgumentException("Edad no puede ser negativa.");
        }
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public int getEdad() {
        return edad;
    }

    //Se evita exponer el historial directamente
}


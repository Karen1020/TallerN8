import java.util.ArrayList;
public class Historial {
    private ArrayList<Consulta> consultas;

    public Historial() {
        this.consultas = new ArrayList<>();
    } //Inicializa la lista vacía al crear un nuevo historial

    public void agregarConsulta(Consulta consulta) {
        if (consulta != null) {
            consultas.add(consulta);
        }
    }

    public void mostrarConsultas() {
        if (consultas.isEmpty()) {
            System.out.println("Sin consultas registradas");
        } else {
            for (Consulta c : consultas) {
                c.mostrarConsulta();
                System.out.println("---------------");
            }
        }
    }

    public ArrayList<Consulta> getConsultas() {
        return new ArrayList<>(consultas);
    }
}

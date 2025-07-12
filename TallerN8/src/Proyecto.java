import java.util.ArrayList;

public class Proyecto {
    private String nombre;
    private String codigo;
    private ArrayList<Tarea> tareas;

    public Proyecto(String nombre, String codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.tareas = new ArrayList<>();
    }

    public void agregarTarea(Tarea tarea) {
        tareas.add(tarea);
    }

    public void eliminarTarea(String descripcion) {
        tareas.removeIf(t -> t.getDescripcion().equalsIgnoreCase(descripcion));
    }

    public String getNombre() { return nombre; }
    public String getCodigo() { return codigo; }
    public ArrayList<Tarea> getTareas() { return tareas; }
}

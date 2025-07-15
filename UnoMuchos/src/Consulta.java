/* public class Consulta {

    private String codigo;
    private String fecha;
    private Veterinario veterinario;

    public Consulta(String codigo, String fecha, Veterinario veterinario) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.veterinario = veterinario;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }

    public void mostrarDetallesConsulta() {
        System.out.println("Codigo: " + codigo);
        System.out.println("Fecha: " + fecha);
        System.out.println("Nombre: " + veterinario.getNombre());
        System.out.println("Veterinario: " + veterinario.getEspecialidad());

    }
} */
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Consulta {
    private String codigo;
    // private String fecha;
    //Refactor:
    private LocalDate fecha; //Datos más estructurados
    private Veterinario veterinario;

    public Consulta(String codigo, String fecha, Veterinario veterinario) {  //Constructor
        /*this.codigo = codigo;
        this.fecha = fecha;
       /this.veterinario = veterinario;*/   //Más flexible y seguro
        // Validación y conversión de fecha
        setCodigo(codigo);
        setFecha(fecha);
        setVeterinario(veterinario);
    }

    public void mostrarConsulta() {
        System.out.println("Consulta Código: " + codigo);
        System.out.println("Fecha: " + fecha);
        if (veterinario != null) {
            veterinario.mostrarPerfil();
        } else {
            System.out.println("Sin veterinario asignado.");
        }
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        if (codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException("Código inválido.");
        }
        this.codigo = codigo;
    }

    // public String getFecha() { return fecha; }
    public LocalDate getFecha() { return fecha; }

    public void setFecha(String fechaTexto) {
        try {
            this.fecha = LocalDate.parse(fechaTexto); // Formato Año-Mes-Dia
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Formato de fecha inválido.");
        }
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        if (veterinario == null) {
            throw new IllegalArgumentException("Veterinario requerido.");
        }
        this.veterinario = veterinario;
    }
}



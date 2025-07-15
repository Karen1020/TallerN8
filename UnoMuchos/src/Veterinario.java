/* public class Veterinario {

    private String Nombre;
    private String Especialidad;

    public Veterinario(String Nombre, String Epecialidad){
        this.Nombre = Nombre;
        this.Especialidad = Especialidad;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getEspecialidad() {
        return Especialidad;
    }

    public void setEspecialidad(String especialidad) {
        Especialidad = especialidad;
    }
}*/
public class Veterinario {
    private String nombre;
    private String especialidad;

    public Veterinario(String nombre, String especialidad) {
        /*this.nombre = nombre;
        this.especialidad = especialidad;*/  //Datos limpios desde el constructor
        setNombre(nombre);
        setEspecialidad(especialidad);
    }

    public void mostrarPerfil() {
        System.out.println("Veterinario: " + nombre + " | Especialidad: " + especialidad);
    }

    public String getNombre() {
        return nombre;
    }

    /*public void setNombre(String nombre) {
        this.nombre = nombre;
    }*/
    public void setNombre(String nombre) {  //Datos sin campos vacios
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre del veterinario no puede estar vacío.");
        }
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    /*public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }*/
    public void setEspecialidad(String especialidad) {
        if (especialidad == null || especialidad.isBlank()) { //Especialidad no puede estar vacia
            throw new IllegalArgumentException("La especialidad no puede estar vacía.");
        }
        this.especialidad = especialidad;
    }
}


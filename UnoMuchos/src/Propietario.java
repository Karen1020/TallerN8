/* import java.util.ArrayList;
public class Propietario {

    private String nombre;
    private String documento;
    private String telefono;
    private ArrayList<Mascota> mascotas = new ArrayList<>();

    public Propietario(String nombre, String documento, String telefono) {
        this.nombre = nombre;
        this.documento = documento;
        this.telefono = telefono;
    }

    public void agregarMascota(Mascota mascota) {
        mascotas.add(mascota);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public ArrayList<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(ArrayList<Mascota> mascotas) {
        this.mascotas = mascotas;
    }

    public void mostrarInformación() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Documento: " + documento);
        System.out.println("Telefono: " + telefono);
        for (Mascota m : mascotas) {
            m.mostrarHistorial();
        }


    }
}*/
import java.util.ArrayList;

public class Propietario {
    private String nombre;
    private String documento;
    private String telefono;
    private ArrayList<Mascota> mascotas;

    public Propietario(String nombre, String documento, String telefono) {
        /*this.nombre = nombre;
        this.documento = documento;
        this.telefono = telefono;*/ //Dueño bien creado
        setNombre(nombre);
        setDocumento(documento);
        setTelefono(telefono);
        this.mascotas = new ArrayList<>();
    }

    public void agregarMascota(Mascota mascota) {
        mascotas.add(mascota);
    }

    public void mostrarInformacion() {
        System.out.println("Propietario: " + nombre);
        System.out.println("Documento: " + documento);
        System.out.println("Teléfono: " + telefono);
    }

    public void mostrarMascotas() {
        for (Mascota m : mascotas) {
            System.out.println();
            m.mostrarHistorial();
        }
    }

    public String getNombre() {
        return nombre;
    }

    /*public void setNombre(String nombre) {
        this.nombre = nombre;
    }*/
    //Validación del nombre
    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    /*public void setDocumento(String documento) {
        this.documento = documento;
    }*/                                                  //Sin identificar
    //Validación del documento
    public void setDocumento(String documento) {
        if (documento == null || documento.length() < 5) {
            throw new IllegalArgumentException("Documento inválido.");
        }
        this.documento = documento;
    }

    public String getTelefono() {
        return telefono;
    }

    /*public void setTelefono(String telefono) {
        this.telefono = telefono;
    }*/
    //Validación del teléfono
    public void setTelefono(String telefono) {
        if (telefono == null || telefono.length() < 7) {
            throw new IllegalArgumentException("Teléfono inválido.");
        }
        this.telefono = telefono;
    }

    public ArrayList<Mascota> getMascotas() {
        // return mascotas;
        // copia defensiva
        return new ArrayList<>(mascotas);//Protege datos internos
    }

    /*public void setMascotas(ArrayList<Mascota> mascotas) {
        this.mascotas = mascotas;
    }*/
    //Eliminar setter de lista para proteger la colección interna
}




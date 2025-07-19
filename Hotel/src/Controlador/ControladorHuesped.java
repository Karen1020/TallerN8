package Controlador;
import Excepciones.DatoInvalido;
import Modelo.Huesped;
import Modelo.ListaHuespedes;
import java.util.ArrayList;
import java.util.Optional;

public class ControladorHuesped {

    public ControladorHuesped() {
        ListaHuespedes = new ArrayList<>();
    }
    public void AgregarHuesped(String nombre, String cedula, String correo) {
        if (nombre == null || nombre.trim().isEmpty())
            throw new DatoInvalido("El nombre no puede estar vacío.");

        if (cedula == null || cedula.trim().isEmpty())
            throw new DatoInvalido("La cédula no puede estar vacía.");

        if (correo == null || !correo.contains("@"))
            throw new DatoInvalido("El correo no es válido.");

        ListaHuespedes.add(new Huesped(nombre, cedula, correo));
    }

    public ArrayList<Huesped> obtenerTodos() {
        return ListaHuespedes;
    }

    public boolean eliminarHuesped(String cedula) {
        return ListaHuespedes.removeIf(h -> h.getCedula().equals(cedula));
    }

    public Optional<Huesped> buscarPorCedula(String cedula) {
        return ListaHuespedes.stream().filter(h -> h.getCedula().equals(cedula)).findFirst();
    }

    public void actualizarHuesped(String cedulaOriginal, String nuevoNombre, String nuevoCorreo) {
        Optional<Huesped> encontrado = buscarPorCedula(cedulaOriginal);

        if (encontrado.isEmpty()) {
            throw new DatoInvalido("No se encontró el huésped a actualizar.");
        }

        eliminarHuesped(cedulaOriginal);
        AgregarHuesped(nuevoNombre, cedulaOriginal, nuevoCorreo);
    }
}

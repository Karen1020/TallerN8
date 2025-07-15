import java.util.ArrayList;
import java.util.Scanner;

public class CrudVeterinario {
    private static final ArrayList<Veterinario> veterinarios = new ArrayList<>();
    private static final Scanner sc = new Scanner(System.in);

    public static void mostrarMenu() {
        int opcion;

        do {
            System.out.println("\n CRUD DE VETERINARIOS ");
            System.out.println("1. Agregar Veterinario");
            System.out.println("2. Listar Veterinarios");
            System.out.println("3. Actualizar Veterinario");
            System.out.println("4. Eliminar Veterinario");
            System.out.println("5. Volver al menú principal");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                opcion = -1;
            }

            switch (opcion) {
                case 1 -> agregarVeterinario();
                case 2 -> listarVeterinarios();
                case 3 -> actualizarVeterinario();
                case 4 -> eliminarVeterinario();
                case 5 -> System.out.println("Regresando al menú principal");
                default -> System.out.println("Opción inválida");
            }

        } while (opcion != 5);
    }

    private static void agregarVeterinario() {
        try {
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Especialidad: ");
            String especialidad = sc.nextLine();
            veterinarios.add(new Veterinario(nombre, especialidad));
            System.out.println("Veterinario registrado correctamente");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void listarVeterinarios() {
        if (veterinarios.isEmpty()) {
            System.out.println("No hay veterinarios registrados");
        } else {
            System.out.println("\n Lista de Veterinarios ");
            for (Veterinario v : veterinarios) {
                v.mostrarPerfil();
            }
        }
    }

    private static void actualizarVeterinario() {
        System.out.print("Nombre del veterinario a actualizar: ");
        String nombreBuscar = sc.nextLine();

        for (Veterinario v : veterinarios) {
            if (v.getNombre().equalsIgnoreCase(nombreBuscar)) {
                try {
                    System.out.print("Nuevo nombre: ");
                    v.setNombre(sc.nextLine());
                    System.out.print("Nueva especialidad: ");
                    v.setEspecialidad(sc.nextLine());
                    System.out.println("Veterinario actualizado correctamente");
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }
                return;
            }
        }

        System.out.println("Veterinario no encontrado");
    }

    private static void eliminarVeterinario() {
        System.out.print("Nombre del veterinario a eliminar: ");
        String nombreEliminar = sc.nextLine();
        boolean eliminado = veterinarios.removeIf(v -> v.getNombre().equalsIgnoreCase(nombreEliminar));
        System.out.println(eliminado ? "Veterinario eliminado." : "Veterinario no encontrado.");
    }
}

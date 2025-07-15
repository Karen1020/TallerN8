import java.util.ArrayList;
import java.util.Scanner;

public class CrudMascota {
    private static final ArrayList<Mascota> mascotas = new ArrayList<>();
    private static final Scanner sc = new Scanner(System.in);

    public static void mostrarMenu() {
        int opcion;

        do {
            System.out.println("\n CRUD DE MASCOTAS ");
            System.out.println("1. Agregar Mascota");
            System.out.println("2. Listar Mascotas");
            System.out.println("3. Actualizar Mascota");
            System.out.println("4. Eliminar Mascota");
            System.out.println("5. Volver al menú principal");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) { //si se digita algo que no sea un numero
                opcion = -1;
            }

            switch (opcion) {
                case 1 -> agregarMascota();
                case 2 -> listarMascotas();
                case 3 -> actualizarMascota();
                case 4 -> eliminarMascota();
                case 5 -> System.out.println("Regresando al menú principal");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 5);
    }

    private static void agregarMascota() {
        try {
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Especie: ");
            String especie = sc.nextLine();
            System.out.print("Edad: ");
            int edad = Integer.parseInt(sc.nextLine());

            mascotas.add(new Mascota(nombre, especie, edad));
            System.out.println("Mascota agregada correctamente.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void listarMascotas() {
        if (mascotas.isEmpty()) {
            System.out.println("No hay mascotas registradas.");
        } else {
            System.out.println("\n Lista de Mascotas ");
            for (Mascota m : mascotas) {
                m.mostrarHistorial();  // Muestra datos de la mascota
                System.out.println();
            }
        }
    }

    private static void actualizarMascota() {
        System.out.print("Nombre de la mascota a actualizar: ");
        String nombreBuscar = sc.nextLine();

        for (Mascota m : mascotas) {
            if (m.getNombre().equalsIgnoreCase(nombreBuscar)) {
                try {
                    System.out.print("Nuevo nombre: ");
                    m.setNombre(sc.nextLine());
                    System.out.print("Nueva especie: ");
                    m.setEspecie(sc.nextLine());
                    System.out.print("Nueva edad: ");
                    m.setEdad(Integer.parseInt(sc.nextLine()));
                    System.out.println("Mascota actualizada con éxito.");
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
                return;
            }
        }

        System.out.println("Mascota no encontrada.");
    }

    private static void eliminarMascota() {
        System.out.print("Nombre de la mascota a eliminar: ");
        String nombreEliminar = sc.nextLine();
        boolean eliminado = mascotas.removeIf(m -> m.getNombre().equalsIgnoreCase(nombreEliminar));
        System.out.println(eliminado ? "Mascota eliminada." : "Mascota no encontrada.");
    }
}


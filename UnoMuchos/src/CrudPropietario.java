import java.util.ArrayList;
import java.util.Scanner;

public class CrudPropietario {
    private static final ArrayList<Propietario> propietarios = new ArrayList<>();
    private static final Scanner sc = new Scanner(System.in);

    public static void mostrarMenu() {
        int opcion;

        do {
            System.out.println("\n CRUD PROPIETARIOS ");
            System.out.println("1. Agregar Propietario");
            System.out.println("2. Listar Propietarios");
            System.out.println("3. Agregar Mascota a Propietario");
            System.out.println("4. Ver Mascotas de un Propietario");
            System.out.println("5. Eliminar Propietario");
            System.out.println("6. Volver al menú principal");
            System.out.print("Opción: ");

            try {
                opcion = Integer.parseInt(sc.nextLine()); //Se protege con try-catch para que no crashee si escriben letras
            } catch (NumberFormatException e) {
                opcion = -1;
            }

            switch (opcion) {
                case 1 -> agregarPropietario();
                case 2 -> listarPropietarios();
                case 3 -> agregarMascotaAPropietario();
                case 4 -> mostrarMascotasDePropietario();
                case 5 -> eliminarPropietario();
                case 6 -> System.out.println("Regresando al menú principal...");
                default -> {
                    if (opcion != 6) {
                        System.out.println("Opción inválida.");
                    }
                }
            }
        } while (opcion != 6);
    }

    private static void agregarPropietario() {
        try {
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Documento: ");
            String documento = sc.nextLine();
            System.out.print("Teléfono: ");
            String telefono = sc.nextLine();
            propietarios.add(new Propietario(nombre, documento, telefono));
            System.out.println("Propietario registrado");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void listarPropietarios() {
        if (propietarios.isEmpty()) {
            System.out.println("No hay propietarios registrados");
        } else {
            for (Propietario p : propietarios) {
                p.mostrarInformacion();
                System.out.println();
            }
        }
    }

    private static void agregarMascotaAPropietario() {
        System.out.print("Documento del propietario: ");
        String doc = sc.nextLine();
        Propietario encontrado = buscarPropietarioPorDocumento(doc);
        if (encontrado != null) {
            try {
                System.out.print("Nombre de la mascota: ");
                String nombreMascota = sc.nextLine();
                System.out.print("Especie: ");
                String especie = sc.nextLine();
                System.out.print("Edad: ");
                int edad = Integer.parseInt(sc.nextLine());

                Mascota nuevaMascota = new Mascota(nombreMascota, especie, edad);
                encontrado.agregarMascota(nuevaMascota);
                System.out.println("Mascota agregada");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } else {
            System.out.println("Propietario no encontrado");
        }
    }

    private static void mostrarMascotasDePropietario() {
        System.out.print("Documento del propietario: ");
        String doc = sc.nextLine();
        Propietario encontrado = buscarPropietarioPorDocumento(doc);
        if (encontrado != null) {
            encontrado.mostrarInformacion();
            encontrado.mostrarMascotas();
        } else {
            System.out.println("Propietario no encontrado");
        }
    }

    private static void eliminarPropietario() {
        System.out.print("Documento del propietario a eliminar: ");
        String doc = sc.nextLine();
        boolean eliminado = propietarios.removeIf(p -> p.getDocumento().equalsIgnoreCase(doc));
        System.out.println(eliminado ? "Propietario eliminado" : "Propietario no encontrado");
    }

    private static Propietario buscarPropietarioPorDocumento(String doc) {
        for (Propietario p : propietarios) {
            if (p.getDocumento().equalsIgnoreCase(doc)) {
                return p;
            }
        }
        return null;
    }
}



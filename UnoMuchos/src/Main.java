/* import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 1. Registrar propietario
        System.out.print("Ingrese el nombre del propietario: ");
        String nombreProp = sc.nextLine();

        System.out.print("Ingrese el documento del propietario: ");
        String documento = sc.nextLine();

        System.out.print("Ingrese el teléfono del propietario: ");
        String telefono = sc.nextLine();

        Propietario propietario = new Propietario(nombreProp, documento, telefono);

        // 2. Registrar mascotas
        System.out.print("¿Cuántas mascotas desea registrar?: ");
        int cantidadMascotas = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < cantidadMascotas; i++) {
            System.out.println("\n--- Mascota #" + (i + 1) + " ---");
            System.out.print("Nombre: ");
            String nombreMascota = sc.nextLine();

            System.out.print("Especie: ");
            String especie = sc.nextLine();

            System.out.print("Edad: ");
            int edad = Integer.parseInt(sc.nextLine());

            Mascota mascota = new Mascota(nombreMascota, especie, edad);

            // 3. Registrar consultas
            System.out.print("¿Cuántas consultas tiene esta mascota?: ");
            int cantidadConsultas = Integer.parseInt(sc.nextLine());

            for (int j = 0; j < cantidadConsultas; j++) {
                System.out.println("   > Consulta #" + (j + 1));
                System.out.print("   Código: ");
                String codigo = sc.nextLine();

                System.out.print("   Fecha: ");
                String fecha = sc.nextLine();

                System.out.print("   Nombre del veterinario: ");
                String nombreVet = sc.nextLine();

                System.out.print("   Especialidad: ");
                String especialidad = sc.nextLine();

                Veterinario vet = new Veterinario(nombreVet, especialidad);
                Consulta consulta = new Consulta(codigo, fecha, vet);
                mascota.agregarConsulta(consulta);
            }

            propietario.agregarMascota(mascota);
        }

        // 4. Mostrar resultado
        System.out.println("\n===== FICHA CLÍNICA =====");
        System.out.println(" Propietario: " + propietario.getNombre());
        System.out.println(" Documento: " + propietario.getDocumento());
        System.out.println(" Teléfono: " + propietario.getTelefono());

        for (Mascota m : propietario.getMascotas()) {
            System.out.println("\n Mascota: " + m.getNombre() + " | Especie: " + m.getEspecie() + " | Edad: " + m.getEdad() + " años");
            System.out.println("Historial de consultas:");
            for (Consulta c : m.getConsultas()) {
                System.out.println("Consulta Código: " + c.getCodigo());
                System.out.println("Fecha: " + c.getFecha());
                System.out.println("Veterinario: " + c.getVeterinario().getNombre() + " | Especialidad: " + c.getVeterinario().getEspecialidad());

            }
        }

        sc.close();
    }
} */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // === Registro del Propietario ===
        System.out.println("=== Registro del Propietario ===");
        System.out.print("Nombre: ");
        String nombreProp = sc.nextLine();

        System.out.print("Documento: ");
        String documento = sc.nextLine();

        System.out.print("Teléfono: ");
        String telefono = sc.nextLine();

        Propietario propietario = new Propietario(nombreProp, documento, telefono);

        // === Registro de Mascotas ===
        System.out.print("\n¿Cuántas mascotas desea registrar?: ");
        int numMascotas = Integer.parseInt(sc.nextLine());

        for (int i = 1; i <= numMascotas; i++) {
            System.out.println("\n--- Mascota #" + i + " ---");

            System.out.print("Nombre de la mascota: ");
            String nombreMascota = sc.nextLine();

            System.out.print("Especie: ");
            String especie = sc.nextLine();

            System.out.print("Edad: ");
            int edad = Integer.parseInt(sc.nextLine());

            // Usar código automático para la mascota (no almacenado aún)
            Mascota mascota = new Mascota(nombreMascota, especie, edad);
            propietario.agregarMascota(mascota);

            // === Registro de Consultas ===
            System.out.print("¿Cuántas consultas desea agregar a esta mascota?: ");
            int numConsultas = Integer.parseInt(sc.nextLine());

            for (int j = 1; j <= numConsultas; j++) {
                System.out.println("-> Consulta #" + j);

                // Código automático con IDGenerator
                String codigo = IDGenerator.generarCodigoConsulta();

                System.out.print("Fecha (Año-Mes-Dia): ");
                String fecha = sc.nextLine();

                System.out.println("Información del veterinario:");
                System.out.print("Nombre: ");
                String nombreVet = sc.nextLine();

                System.out.print("Especialidad: ");
                String especialidad = sc.nextLine();

                Veterinario vet = new Veterinario(nombreVet, especialidad);
                Consulta consulta = new Consulta(codigo, fecha, vet);

                mascota.agregarConsulta(consulta);
            }
        }

        // Mostrar resultados
        System.out.println("\n===== FICHA CLÍNICA COMPLETA =====");
        propietario.mostrarInformacion();
        propietario.mostrarMascotas();

        sc.close();
    }

    /*
    public static void main(String[] args) {
        // Este bloque de código fue reemplazado por una version más segura
        // generación de códigos únicos y uso de LocalDate
    }
    */
}
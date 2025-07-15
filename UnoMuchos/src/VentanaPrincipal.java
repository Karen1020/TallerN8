import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class VentanaPrincipal extends JFrame {

    private JDesktopPane escritorio;
    private ArrayList<Paciente> pacientes = new ArrayList<>(); //Lista principal donde se almacenan todos los pacientes registrados en tiempo de ejecución

    public VentanaPrincipal() {
        setTitle("Sistema de Gestión Clínica Veterinaria");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Inicializar escritorio antes de pasarlo al árbol
        escritorio = new JDesktopPane();
        add(escritorio, BorderLayout.CENTER);

        // Panel izquierdo con el árbol
        add(new ArbolServicios(escritorio, pacientes), BorderLayout.WEST);

        // Menú superior
        JMenuBar menuBar = new JMenuBar();

        // Menú "Archivo"
        JMenu menuArchivo = new JMenu("Archivo"); //Nuevo paciente, registrar consulta, salir
        JMenuItem nuevo = new JMenuItem("Nuevo registro");
        JMenuItem registrarConsulta = new JMenuItem("Registrar Consulta");
        JMenuItem salir = new JMenuItem("Salir");

        nuevo.addActionListener(e -> abrirFormularioPaciente());
        registrarConsulta.addActionListener(e -> abrirFormularioConsulta());
        salir.addActionListener(e -> System.exit(0));

        menuArchivo.add(nuevo);
        menuArchivo.add(registrarConsulta);
        menuArchivo.add(salir);

        // Menú "Vista"
        JMenu menuVista = new JMenu("Vista"); //Lista de paciente, lista de consultas
        JMenuItem pacientesItem = new JMenuItem("Pacientes");
        JMenuItem consultasItem = new JMenuItem("Consultas");

        pacientesItem.addActionListener(e -> mostrarListaPacientes());
        consultasItem.addActionListener(e -> mostrarConsultas());

        menuVista.add(pacientesItem);
        menuVista.add(consultasItem);

        // Agregar a barra de menú
        menuBar.add(menuArchivo);
        menuBar.add(menuVista);
        setJMenuBar(menuBar);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void abrirFormularioPaciente() {
        FormularioPaciente formulario = new FormularioPaciente(pacientes); //Crea un formulario interno para registrar un nuevo paciente
        escritorio.add(formulario);
        formulario.setVisible(true);
    }

    private void abrirFormularioConsulta() {
        if (pacientes.isEmpty()) { //Permite registrar una consulta de vacunación antes verifica que exista al menos un paciente registrado
            JOptionPane.showMessageDialog(this, "Debe registrar al menos un paciente primero.", "Atención", JOptionPane.WARNING_MESSAGE);
            return;
        }

        FormularioConsulta formulario = new FormularioConsulta(pacientes);
        escritorio.add(formulario);
        formulario.setVisible(true);
    }

    private void mostrarListaPacientes() {
        ListaPacientes lista = new ListaPacientes(pacientes); //Abre una ventana interna que muestra la lista de pacientes registrados incluye botones para eliminar y actualizar la lista
        escritorio.add(lista);
        lista.setVisible(true);
    }

    private void mostrarConsultas() {
        ListaConsultas lista = new ListaConsultas(pacientes); // solo muestra vacunación
        escritorio.add(lista);
        lista.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(VentanaPrincipal::new);//Lanza la interfaz en el hilo correcto para aplicaciones Swing crea e inicia toda la interfaz gráfica de forma segura
    }
}

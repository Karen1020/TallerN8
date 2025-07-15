import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class ListaPacientes extends JInternalFrame {

    private ArrayList<Paciente> pacientes;
    private DefaultTableModel modelo;
    private JTable tabla;

    public ListaPacientes(ArrayList<Paciente> pacientes) {
        super("Lista de pacientes", true, true, true, true);
        this.pacientes = pacientes;

        setSize(600, 350);
        setLayout(new BorderLayout());

        // Columnas de la tabla
        String[] columnas = {"Nombre", "Especie", "Edad", "ID"};
        modelo = new DefaultTableModel(columnas, 0);
        tabla = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabla);
        add(scroll, BorderLayout.CENTER);

        // Panel inferior
        JPanel panelSur = new JPanel(new FlowLayout(FlowLayout.LEFT));

        // Botón actualizar
        JButton btnActualizar = new JButton("Actualizar");
        btnActualizar.addActionListener(e -> cargarPacientes());
        panelSur.add(btnActualizar);

        // Botón eliminar
        JButton btnEliminar = new JButton("Eliminar paciente");
        btnEliminar.addActionListener(e -> eliminarPaciente());
        panelSur.add(btnEliminar);

        // Barra
        JProgressBar barra = new JProgressBar(0, 100);
        barra.setStringPainted(true);
        panelSur.add(barra);

        add(panelSur, BorderLayout.SOUTH);

        // Cargar pacientes al inicio
        cargarPacientes();

        // Autorefrescar cada 10 segundos
        new Timer(10000, e -> cargarPacientes()).start();
        setVisible(true);
    }

    private void cargarPacientes() {
        modelo.setRowCount(0); // limpiar tabla

        for (Paciente p : pacientes) {
            Object[] fila = {
                    p.getNombre(),
                    p.getEspecie(),
                    p.getEdad(),
                    p.getId()
            };
            modelo.addRow(fila);
        }

        if (pacientes.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay pacientes registrados aún", "Lista vacía", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void eliminarPaciente() {
        int filaSeleccionada = tabla.getSelectedRow();
        if (filaSeleccionada >= 0) {
            String id = (String) modelo.getValueAt(filaSeleccionada, 3); // columna ID
            // Buscar y eliminar
            pacientes.removeIf(p -> p.getId().equalsIgnoreCase(id));
            JOptionPane.showMessageDialog(this, "Paciente eliminado" + id);
            cargarPacientes(); // actualizar tabla
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un paciente para eliminar", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }
}


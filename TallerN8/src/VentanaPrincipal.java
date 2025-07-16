import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

    public class VentanaPrincipal extends JFrame {
        private Proyecto proyectoActual;
        private JTable tabla;
        private DefaultTableModel modelo;

        public VentanaPrincipal() {
            setTitle("Gestión de Proyectos y Tareas");
            setSize(600, 400);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setLayout(new BorderLayout());

            //Crear un proyecto
            proyectoActual = new Proyecto("Proyecto A", "001");

            //Tabla
            modelo = new DefaultTableModel(new String[]{"Descripción", "Responsable", "Estado"}, 0);
            tabla = new JTable(modelo);
            add(new JScrollPane(tabla), BorderLayout.CENTER);

            //Botones
            JPanel panelBotones = new JPanel();

            JButton btnAgregar = new JButton("Agregar Tarea");
            JButton btnEliminar = new JButton("Eliminar Tarea");
            JButton btnCambiarEstado = new JButton("Cambiar Estado");

            panelBotones.add(btnAgregar);
            panelBotones.add(btnEliminar);
            panelBotones.add(btnCambiarEstado);
            add(panelBotones, BorderLayout.SOUTH);
            btnAgregar.addActionListener(e -> agregarTarea());
            btnEliminar.addActionListener(e -> eliminarTarea());
            btnCambiarEstado.addActionListener(e -> cambiarEstado());

            setVisible(true);
        }
        private void agregarTarea() {
            String descripcion = JOptionPane.showInputDialog(this, "Descripción de la tarea:");
            String responsable = JOptionPane.showInputDialog(this, "Responsable:");
            String estado = "Pendiente";

            if (descripcion != null && responsable != null) {
                Tarea t = new Tarea(descripcion, responsable, estado);
                proyectoActual.agregarTarea(t);
                modelo.addRow(new Object[]{descripcion, responsable, estado});
            }
        }

        private void eliminarTarea() {
            int fila = tabla.getSelectedRow();
            if (fila != -1) {
                String descripcion = (String) modelo.getValueAt(fila, 0);
                proyectoActual.eliminarTarea(descripcion);
                modelo.removeRow(fila);
            } else {
                JOptionPane.showMessageDialog(this, "Selecciona una tarea para eliminar.");
            }
        }

        private void cambiarEstado() {
            int fila = tabla.getSelectedRow();
            if (fila != -1) {
                String[] opciones = {"Pendiente", "En curso", "Terminada"};
                String nuevoEstado = (String) JOptionPane.showInputDialog(
                        this, "Selecciona nuevo estado:",
                        "Cambiar estado", JOptionPane.QUESTION_MESSAGE,
                        null, opciones, opciones[0]
                );

                if (nuevoEstado != null) {
                    modelo.setValueAt(nuevoEstado, fila, 2);
                    proyectoActual.getTareas().get(fila).setEstado(nuevoEstado);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Selecciona una tarea para cambiar su estado.");
            }
        }

        public static void main(String[] args) {
            SwingUtilities.invokeLater(VentanaPrincipal::new);
        }
    }


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class FormularioConsulta extends JInternalFrame {

    public FormularioConsulta(ArrayList<Paciente> pacientes) {
        super("Registrar Consulta de Vacunación", true, true, true, true);
        setSize(450, 300);
        setLayout(null);

        JLabel lblPaciente = new JLabel("Seleccionar Paciente:");
        JComboBox<String> cbPacientes = new JComboBox<>(); //Llena el combo box con cada paciente registrado

        for (Paciente p : pacientes) {
            cbPacientes.addItem(p.getId() + " - " + p.getNombre());
        }

        JLabel lblVeterinario = new JLabel("Nombre del Veterinario:");
        JTextField txtVetNombre = new JTextField();

        JLabel lblEspecialidad = new JLabel("Especialidad:");
        JTextField txtEspecialidad = new JTextField("Vacunación");
        txtEspecialidad.setEditable(false);

        JLabel lblFecha = new JLabel("Fecha (Año-Mes-Dia):");
        JTextField txtFecha = new JTextField();

        JButton btnRegistrar = new JButton("Registrar Consulta");

        // Posiciones
        lblPaciente.setBounds(20, 20, 180, 25);
        cbPacientes.setBounds(200, 20, 200, 25);
        lblVeterinario.setBounds(20, 60, 180, 25);
        txtVetNombre.setBounds(200, 60, 200, 25);
        lblEspecialidad.setBounds(20, 100, 180, 25);
        txtEspecialidad.setBounds(200, 100, 200, 25);
        lblFecha.setBounds(20, 140, 180, 25);
        txtFecha.setBounds(200, 140, 200, 25);
        btnRegistrar.setBounds(150, 190, 160, 30);

        add(lblPaciente);
        add(cbPacientes);
        add(lblVeterinario);
        add(txtVetNombre);
        add(lblEspecialidad);
        add(txtEspecialidad);
        add(lblFecha);
        add(txtFecha);
        add(btnRegistrar);

        btnRegistrar.addActionListener(e -> {
            if (cbPacientes.getSelectedIndex() == -1) { //Asegura que se haya seleccionado un paciente
                JOptionPane.showMessageDialog(this, "Selecciona un paciente", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String vetNombre = txtVetNombre.getText().trim();
            String fecha = txtFecha.getText().trim();

            if (vetNombre.isEmpty() || fecha.isEmpty()) { //Verifica que los campos obligatorios no estén vacíos
                JOptionPane.showMessageDialog(this, "Completa todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Veterinario vet = new Veterinario(vetNombre, "Vacunación");
            String codigo = IDGenerator.generarCodigoConsulta();
            Consulta consulta = new Consulta(codigo, fecha, vet);

            Paciente paciente = pacientes.get(cbPacientes.getSelectedIndex());
            paciente.agregarConsulta(consulta);

            JOptionPane.showMessageDialog(this, "Consulta registrada correctamente"); //Muestra un mensaje y cierra la ventana al finalizar el registro
            dispose();
        });

        setVisible(true);
    }
}

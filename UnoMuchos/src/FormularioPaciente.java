import javax.swing.*;
import java.util.ArrayList;

public class FormularioPaciente extends JInternalFrame {

    private ArrayList<Paciente> pacientes;

    public FormularioPaciente(ArrayList<Paciente> pacientes) {
        super("Formulario de paciente", true, true, true, true);
        this.pacientes = pacientes;

        setSize(400, 300);
        setLayout(null);

        JLabel lblNombre = new JLabel("Nombre:");
        JTextField txtNombre = new JTextField();
        JLabel lblClave = new JLabel("Clave historial:");
        JPasswordField txtClave = new JPasswordField(); // solo decorativo
        JLabel lblEspecie = new JLabel("Especie:");
        JComboBox<String> cbEspecie = new JComboBox<>(new String[]{"Perro", "Gato"});
        JLabel lblEdad = new JLabel("Edad:");
        JSpinner spEdad = new JSpinner(new SpinnerNumberModel(1, 0, 50, 1));
        JButton btnRegistrar = new JButton("Registrar");

        lblNombre.setBounds(20, 20, 120, 25);
        txtNombre.setBounds(140, 20, 200, 25);
        lblClave.setBounds(20, 60, 120, 25);
        txtClave.setBounds(140, 60, 200, 25);
        lblEspecie.setBounds(20, 100, 120, 25);
        cbEspecie.setBounds(140, 100, 200, 25);
        lblEdad.setBounds(20, 140, 120, 25);
        spEdad.setBounds(140, 140, 80, 25);
        btnRegistrar.setBounds(140, 190, 100, 30);

        add(lblNombre);
        add(txtNombre);
        add(lblClave);
        add(txtClave);
        add(lblEspecie);
        add(cbEspecie);
        add(lblEdad);
        add(spEdad);
        add(btnRegistrar);

        btnRegistrar.addActionListener(e -> { //Captura la información ingresada por el usuario
            String nombre = txtNombre.getText();
            String especie = (String) cbEspecie.getSelectedItem();
            int edad = (int) spEdad.getValue();

            String id = "P" + (pacientes.size() + 1);//Genera un ID único para el paciente usando el tamaño actual de la lista
            Paciente nuevo = new Paciente(nombre, especie, edad, id); //Crea una nueva instancia de Paciente y la agrega a la lista compartida
            pacientes.add(nuevo);

            JOptionPane.showMessageDialog(this,
                    "Paciente registrado:\nNombre: " + nombre +
                            "\nEspecie: " + especie +
                            "\nEdad: " + edad +
                            "\nID: " + id,
                    "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
        });

        setVisible(true);
    }
}

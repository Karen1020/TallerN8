import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class ListaConsultasVacunacion extends JInternalFrame {

    public ListaConsultasVacunacion(ArrayList<Paciente> pacientes) {
        super("Consultas de Vacunación", true, true, true, true);
        setSize(600, 300);
        setLayout(new BorderLayout());

        String[] columnas = {"ID Paciente", "Nombre", "Veterinario", "Especialidad", "Fecha"}; //Se define la estructura de la tabla (encabezados)
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

        for (Paciente p : pacientes) { //Se recorren todos los pacientes, para cada paciente, se accede a su historial y cada consulta que tenga el historial se agrega como fila en la tabla
            for (Consulta c : p.getHistorial().getConsultas()) {
                modelo.addRow(new Object[]{
                        p.getId(),
                        p.getNombre(),
                        c.getVeterinario().getNombre(),
                        c.getVeterinario().getEspecialidad(),
                        c.getFecha()
                });
            }
        }

        JTable tabla = new JTable(modelo);
        add(new JScrollPane(tabla), BorderLayout.CENTER);
        setVisible(true); //Muestra la ventana al usuario una vez cargada
    }
}


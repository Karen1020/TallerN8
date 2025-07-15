import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class ListaConsultas extends JInternalFrame {

    public ListaConsultas(ArrayList<Paciente> pacientes) {
        super("Consultas de Vacunación", true, true, true, true);
        setSize(600, 300);
        setLayout(new BorderLayout());

        String[] columnas = {"ID Paciente", "Nombre", "Veterinario", "Especialidad", "Fecha"}; //Define las columnas visibles en la tabla
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

        for (Paciente p : pacientes) { //Se recorre cada paciente, y dentro de él, su historial clínico
            for (Consulta c : p.getHistorial().getConsultas()) {
                //  Filtra solo Vacunación
                if ("Vacunación".equalsIgnoreCase(c.getVeterinario().getEspecialidad())) {
                    modelo.addRow(new Object[]{
                            p.getId(),
                            p.getNombre(),
                            c.getVeterinario().getNombre(),
                            c.getVeterinario().getEspecialidad(),
                            c.getFecha()
                    });
                }
            }
        }

        JTable tabla = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabla); //Se agrega un JScrollPane para permitir desplazamiento
        add(scroll, BorderLayout.CENTER);

        setVisible(true);
    }
}


import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import java.util.ArrayList;

public class ArbolServicios extends JPanel {

    public ArbolServicios(JDesktopPane escritorio, ArrayList<Paciente> pacientes) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        DefaultMutableTreeNode raiz = new DefaultMutableTreeNode("Servicios");

        DefaultMutableTreeNode medicina = new DefaultMutableTreeNode("Medicina general");
        DefaultMutableTreeNode cirugia = new DefaultMutableTreeNode("Cirugía");
        DefaultMutableTreeNode vacunacion = new DefaultMutableTreeNode("Vacunación");
        DefaultMutableTreeNode peluqueria = new DefaultMutableTreeNode("Peluquería");
        DefaultMutableTreeNode urgencias = new DefaultMutableTreeNode("Urgencias");

        raiz.add(medicina);
        raiz.add(cirugia);
        raiz.add(vacunacion);
        raiz.add(peluqueria);
        raiz.add(urgencias);

        JTree tree = new JTree(raiz);

        tree.addTreeSelectionListener(new TreeSelectionListener() {
            public void valueChanged(TreeSelectionEvent e) {
                TreePath path = e.getPath();
                Object selected = path.getLastPathComponent();  //se ejecuta cuando el usuario selecciona un nodo en el árbol

                if (selected.toString().equals("Vacunación")) {
                    ListaConsultas formulario = new ListaConsultas(pacientes);
                    escritorio.add(formulario);
                    formulario.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Esta sección aún no está disponible.");
                }
            }
        });

        add(new JScrollPane(tree));
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame {
private JTabbedPane pestanas;
    private JPanel panelBienvenida;
    private JPanel panelInfo;

    public VentanaPrincipal() {
        setTitle("Sistema de practica");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); //Centrar ventana

        pestanas = new JTabbedPane();

        //Pestaña de bienvenida
        panelBienvenida = new JPanel();
        panelBienvenida.setLayout(new BorderLayout());

        JLabel etiqueta = new JLabel("Bienvenido al sistema de practica!", JLabel.CENTER);
        panelBienvenida.add(etiqueta, BorderLayout.CENTER);

        //Cambiar el fondo de la pestaña
        JButton botonColor = new JButton("Cambiar color de fondo");
        botonColor.addActionListener( e -> {
            Color color = JColorChooser.showDialog(null,"Seleccione un color", Color.pink);
            if (color != null){
                panelBienvenida.setBackground(color);
            }
        });
        panelBienvenida.add(botonColor, BorderLayout.SOUTH);
        pestanas.addTab("Bienvenida", panelBienvenida);

        //Pestaña 2
        JPanel panelInfo = new JPanel();
        panelInfo.setLayout(new BorderLayout());

        JTextArea textAreaInfo = new JTextArea();
        textAreaInfo.setText("Bienvenido a tu perfil");
        JScrollPane scrollPane = new JScrollPane(textAreaInfo);
        panelInfo.add(scrollPane, BorderLayout.CENTER);

        //Agregar un boton para abrir la ventana secundaria
        JButton botonVentana = new JButton("Abrir ventana secundaria");
        botonVentana.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new VentanaSecundaria();
            }
        });
            panelInfo.add(botonVentana, BorderLayout.SOUTH);
            pestanas.addTab("Información", panelInfo);
        //Mostrar pestañas
        add(pestanas);
        setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VentanaPrincipal());
    }
}
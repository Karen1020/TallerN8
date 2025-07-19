package Vistas;
import Modelo.EcoHotel;
import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {
    private EcoHotel hotel;

    public VentanaPrincipal() {
        hotel = new EcoHotel();
        setTitle("Gestión EcoHotel");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JMenuBar barra = new JMenuBar();
        JMenu menu = new JMenu("Opciones");
        JMenuItem itemHuesped = new JMenuItem("Registrar Huésped");
        JMenuItem itemReserva = new JMenuItem("Nueva Reserva");
        JMenuItem itemVer = new JMenuItem("Ver Reservas");

        itemHuesped.addActionListener(e -> new VentanaHuesped(this, hotel));

        menu.add(itemHuesped);
        menu.add(itemReserva);
        menu.add(itemVer);
        barra.add(menu);
        setJMenuBar(barra);

        setVisible(true);
    }
}
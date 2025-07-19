package Modelo;
import java.util.ArrayList;

public class EcoHotel {
    private ArrayList<Huesped> huespedes = new ArrayList<>();
    private ArrayList<Habitacion> habitaciones = new ArrayList<>();
    private ArrayList<Reserva> reservas = new ArrayList<>();

    public void agregarHuesped(Huesped h) {
        huespedes.add(h);
    }

    public void agregarHabitacion(Habitacion h) {
        habitaciones.add(h);
    }

    public void registrarReserva(Reserva r) {
        reservas.add(r);
    }

    public ArrayList<Huesped> getHuespedes() { return huespedes; }
    public ArrayList<Habitacion> getHabitaciones() { return habitaciones; }
    public ArrayList<Reserva> getReservas() { return reservas; }
}
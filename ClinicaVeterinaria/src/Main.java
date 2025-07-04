import Instance.ClinicaVeterinaria;
import Instance.Gato;
import Instance.Mascota;
import Instance.Perro;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
        public static void main(String[] args) {
            ClinicaVeterinaria c = new ClinicaVeterinaria();

            Mascota m1 = new Perro("Cash");
            Mascota m2 = new Gato("Dante");

            c.recibirMascota(m1);
            c.recibirMascota(m2);
        }
    }
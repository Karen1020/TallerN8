import ConsultaDiagnostico.Consulta;
import ConsultaDiagnostico.Diagnostico;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

        Diagnostico diagnostico = new Diagnostico("Insuficiencia cardiaca", "Diureticos y reposo 25 dias");

        Consulta consulta = new Consulta ("C008", "03-07-2025", diagnostico);

        consulta.mostrarConsulta();
    }
}
import java.time.LocalDate;
import java.util.logging.Logger;


import co.edu.uniquindio.*;
import co.edu.uniquindio.poo.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;





public class CamionTest {
    private static final Logger LOG = Logger.getLogger(CamionTest.class.getName());

    Conductor conductor = new Conductor("9012", "Carlos", "Rodríguez",
            LocalDate.of(1988, 3, 10));;
    Camion camion = new Camion("DEF456", (byte) 6, (byte) 60);;
    Peaje peaje = new Peaje("P002", "Circasia", "Quindío");
    Ticket ticket;
    Recaudador recaudador = new Recaudador("1234", "Juan", "Pérez",
            LocalDate.of(1990, 5, 15), 2000000);


    @Test
    public void testInfo(){
        LOG.info("Iniciando pruebas del metodo getInfo de la clase Camion");

        String info = "";
        info += "Tipo de vehiculo: Camion\n";
        info += "Placa de vehiculo: " + camion.getPlaca() + "\n";
        info += "Ejes del vehiculo: " + camion.getEje() + "\n";
        info += "Capacidad del vehiculo: " + camion.getCapacidad() + "\n";
        assertEquals(info,camion.getInfo());
    }

    @Test
    public void testCalcularPasaje(){
        LOG.info("Iniciando pruebas del metodo calcularPasaje de la clase Camion");
        ticket = recaudador.Cobrar(camion,peaje);
        assertEquals(46200,camion.calcularPasaje(peaje));
    }

    @Test
    public void testCalcularPasajeString(){
        LOG.info("Iniciando pruebas del metodo calcularPasajeString de la clase Camion");


        String info = peaje.calcularPasajeString( camion);
        ticket = recaudador.Cobrar(camion,peaje);

        assertEquals(info,camion.calcularPasajeString(peaje));
    }
}

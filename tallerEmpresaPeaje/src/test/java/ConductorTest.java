import java.time.LocalDate;
import java.util.LinkedList;
import java.util.logging.Logger;

import co.edu.uniquindio.*;
import co.edu.uniquindio.poo.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConductorTest {
    private static final Logger LOG = Logger.getLogger(ConductorTest.class.getName());

    Conductor conductor = new Conductor("9012", "Carlos", "Rodríguez",
            LocalDate.of(1988, 3, 10));;
    Peaje peaje = new Peaje("P002", "Circasia", "Quindío");
    Ticket ticket1;
    Ticket ticket2;
    Recaudador recaudador = new Recaudador("1234", "Juan", "Pérez",
            LocalDate.of(1990, 5, 15), 2000000);
    Moto moto = new Moto("ABC123", 250);
    Carro carro = new Carro("XYZ789", true, false);
    @BeforeEach
    public void init(){
        conductor.addVehiculo(moto);
        conductor.addVehiculo(carro);
        ticket1 = recaudador.Cobrar(moto,peaje);
        ticket2 = recaudador.Cobrar(carro,peaje);
    }

    @Test
    public void testTotalizar(){
        LOG.info("Iniciando pruebas del metodo totalizar de la clase Conductor");
        String info = "";
        double total = 0;
        for (Vehiculo v : conductor.getListaVehiculo()) {
            info += "Vehiculo placa: " + v.getPlaca() + "\n";
            LinkedList<Ticket> tickets = v.getListTicket();
            for (Ticket t : tickets) {
                info += v.calcularPasajeString(t.getThePeaje());
                total += v.calcularPasaje(t.getThePeaje());
            }
            info += "\n";
        }
        info += "Total del conductor: " + total + "\n";
        LOG.info("Finalizando pruebas del metodo totalizar de la clase Conductor");
        assertEquals(info, conductor.totalizar());
    }
    @Test
    public void testRetornarListaVehiculo(){
        LOG.info("Iniciando pruebas del metodo retornarListaVehiculo de la clase Conductor");

        assertEquals(moto, conductor.retornarListaVehiculo("Moto").get(0));
    }
}
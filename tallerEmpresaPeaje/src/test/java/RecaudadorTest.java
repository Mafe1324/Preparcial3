import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.logging.Logger;
import static org.junit.jupiter.api.Assertions.assertEquals;
import co.edu.uniquindio.*;
import co.edu.uniquindio.poo.Camion;
import co.edu.uniquindio.poo.Peaje;
import co.edu.uniquindio.poo.Recaudador;
import co.edu.uniquindio.poo.Ticket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RecaudadorTest {
    private static final Logger LOG = Logger.getLogger(RecaudadorTest.class.getName());
    Peaje peaje = new Peaje("P001", "La Paila", "Valle");
    Camion camion = new Camion("DEF456", (byte) 6, (byte) 60);
    Recaudador recaudador = new Recaudador("1234", "Juan", "Pérez",
            LocalDate.of(1990, 5, 15), 2000000);
    Ticket ticket;

    @BeforeEach
    public void init(){

    }
    @Test
    public void cobrarTest(){
        LOG.info("Iniciando pruebas del metodo cobrar de la clase Recaudador");
        ticket = recaudador.Cobrar(camion,peaje);
        assertNotNull(ticket);
        assertNotNull(ticket.getThePeaje());
        assertNotNull(ticket.getTheVehiculo());
        assertNotNull(ticket.getFecha());
        assertNotNull(ticket.getId());
    }
}

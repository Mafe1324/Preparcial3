import java.time.LocalDate;
import java.util.logging.Logger;

import co.edu.uniquindio.*;
import co.edu.uniquindio.poo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MotoTest {
    private static final Logger LOG = Logger.getLogger(CamionTest.class.getName());

    Conductor conductor = new Conductor("9012", "Carlos", "Rodríguez",
            LocalDate.of(1988, 3, 10));;
    Peaje peaje = new Peaje("P002", "Circasia", "Quindío");
    Ticket ticket;
    Recaudador recaudador = new Recaudador("1234", "Juan", "Pérez",
            LocalDate.of(1990, 5, 15), 2000000);
    Moto moto = new Moto("ABC123", 250);

    @Test
    public void infoTest(){
        LOG.info("Iniciando pruebas del metodo getInfo de la clase Carro");
        String info = "";

        info += "Tipo de vehiculo: Moto\n";
        info += "Placa de vehiculo: " + moto.getPlaca() + "\n";
        info += "Cilindraje del vehiculo: " + moto.getCilindraje() + "\n";

        assertEquals(info, moto.getInfo());
    }

    @Test
    public void testCalcularPasaje(){
        LOG.info("Iniciando pruebas del metodo calcularPasaje de la clase Carro");
        ticket = recaudador.Cobrar(moto,peaje);
        assertEquals(7000, moto.calcularPasaje(peaje));
    }

    @Test
    public void testCalcularPasajeString(){
        LOG.info("Iniciando pruebas del metodo calcularPasajeString de la clase Carro");

        String info = peaje.calcularPasajeString( moto);
        ticket = recaudador.Cobrar(moto,peaje);

        assertEquals(info, moto.calcularPasajeString(peaje));
    }
}
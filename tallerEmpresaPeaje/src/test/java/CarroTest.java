import java.time.LocalDate;
import java.util.logging.Logger;

import co.edu.uniquindio.*;
import co.edu.uniquindio.poo.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;



public class CarroTest {
    private static final Logger LOG = Logger.getLogger(CamionTest.class.getName());

    Conductor conductor = new Conductor("9012", "Carlos", "Rodríguez",
            LocalDate.of(1988, 3, 10));;
    Peaje peaje = new Peaje("P002", "Circasia", "Quindío");
    Ticket ticket;
    Recaudador recaudador = new Recaudador("1234", "Juan", "Pérez",
            LocalDate.of(1990, 5, 15), 2000000);
    Carro carro = new Carro("XYZ789", true, false);

    @Test
    public void infoTest(){
        LOG.info("Iniciando pruebas del metodo getInfo de la clase Carro");

        String info = "";

        info +="Tipo de vehiculo: Carro\n";
        info +="Placa de vehiculo: " + carro.getPlaca() + "\n";
        info +="Es electrico?" + carro.getIselectrico() + "\n";
        info+="Es publico?" + carro.getIspublico() + "\n";
        assertEquals(info,carro.getInfo());
    }

    @Test
    public void testCalcularPasaje(){
        LOG.info("Iniciando pruebas del metodo calcularPasaje de la clase Carro");
        ticket = recaudador.Cobrar(carro,peaje);
        assertEquals(8000,carro.calcularPasaje(peaje));
    }

    @Test
    public void testCalcularPasajeString(){
        LOG.info("Iniciando pruebas del metodo calcularPasajeString de la clase Carro");


        String info = peaje.calcularPasajeString( carro);
        ticket = recaudador.Cobrar(carro,peaje);

        assertEquals(info,carro.calcularPasajeString(peaje));
    }
}

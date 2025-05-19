import java.time.LocalDate;
import java.util.logging.Logger;

import co.edu.uniquindio.*;
import co.edu.uniquindio.poo.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PeajeTest {
    private static final Logger LOG = Logger.getLogger(PeajeTest.class.getName());
    Peaje peaje = new Peaje("P001", "La Paila", "Valle");
    Moto moto = new Moto("ABC123", 250);
    Carro carro = new Carro("XYZ789", true, false);
    Camion camion = new Camion("DEF456", (byte) 6, (byte) 60);
    Recaudador recaudador = new Recaudador("5678", "María", "González",
            LocalDate.of(1985, 8, 22), 2100000);
    Ticket ticket_camion;
    Ticket ticket_carro;
    Ticket ticket_moto;

    @BeforeEach
    public void init() {
        ticket_moto = recaudador.Cobrar(moto,peaje);
        ticket_camion = recaudador.Cobrar(camion,peaje);
        ticket_carro = recaudador.Cobrar(carro,peaje);
    }

    @Test
    public void totalTest(){
        LOG.info("Iniciando pruebas del metodo agregarTotal de la clase Peaje");
        peaje.agregarTotal(25000);
        assertEquals(86200,peaje.getTotalRecaudado());
    }

    @Test
    public void calcularPasajeTest_Moto(){
        LOG.info("Iniciando pruebas del metodo calcularPasaje en moto de la clase Peaje");
        assertEquals(7000,peaje.calcularPasaje(moto));
    }

    @Test
    public void calcularPasajeTest_Carro(){
        LOG.info("Iniciando pruebas del metodo calcularPasaje en carro de la clase Peaje");
        assertEquals(8000,peaje.calcularPasaje(carro));
    }
    @Test
    public void calcularPasajeTest_Camion(){
        LOG.info("Iniciando pruebas del metodo calcularPasaje en camion de la clase Peaje");
        assertEquals(46200,peaje.calcularPasaje(camion));
    }

    @Test
    public void calcularPasajeStringTest_Moto(){
        LOG.info("Iniciando pruebas del metodo calcularPasajeString en moto de la clase Peaje");
        String info =  "Costo inicial: 5000.0 \n" +
                "Costo adicional: 2000.0\n" +
                "Total: 7000.0\n";
        assertEquals( info,peaje.calcularPasajeString(moto));
    }

    @Test
    public void calcularPasajeStringTest_Carro(){
        LOG.info("\"Iniciando pruebas del metodo calcularPasajeString en Carro de la clase Peaje\"");
        String info = "Costo inicial: 10000.0 \n" +
                "Descuento: 2000.0\n" +
                "Total: 8000.0\n";
        assertEquals( info,peaje.calcularPasajeString(carro));
    }

    @Test
    public void calcularPasajeStringTest_Camion(){
        LOG.info("Iniciando pruebas del metodo calcularPasajeString en camion de la clase Peaje");
        String info = "Costo inicial: 42000.0 \n" +
                "Recargo adicional: 4200.0\n" +
                "Total: 46200.0\n";
        assertEquals( info,peaje.calcularPasajeString(camion));
    }

    @Test
    public void TotalizarTest(){
        LOG.info("Iniciando pruebas del metodo Totalizar de la clase Peaje");
        String info = "Tipo vehiculo: Moto\n" +
                "Costo inicial: 5000.0 \n" +
                "Costo adicional: 2000.0\n" +
                "Total: 7000.0\n" +
                "\n" +
                "Tipo vehiculo: Camion\n" +
                "Costo inicial: 42000.0 \n" +
                "Recargo adicional: 4200.0\n" +
                "Total: 46200.0\n" +
                "\n" +
                "Tipo vehiculo: Carro\n" +
                "Costo inicial: 10000.0 \n" +
                "Descuento: 2000.0\n" +
                "Total: 8000.0\n" +
                "\n" +
                "Total del peaje: 61200.0\n";
        assertEquals(info, peaje.totalizar());
    }

}

import java.time.LocalDate;
import java.util.logging.Logger;

import co.edu.uniquindio.*;
import co.edu.uniquindio.poo.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmpresaTest {
    private static final Logger LOG = Logger.getLogger(EmpresaTest.class.getName());

    Empresa empresa = new Empresa("AutoPistas del Café");
    Peaje peaje1 = new Peaje("P001", "La Paila", "Valle");
    Peaje peaje2 = new Peaje("P002", "Circasia", "Quindío");
    Recaudador recaudador1 = new Recaudador("1234", "Juan", "Pérez",
            LocalDate.of(1990, 5, 15), 2000000);
    Recaudador recaudador2 = new Recaudador("5678", "María", "González",
            LocalDate.of(1985, 8, 22), 2100000);
    Conductor conductor1 = new Conductor("9012", "Carlos", "Rodríguez",
            LocalDate.of(1988, 3, 10));
    Conductor conductor2 = new Conductor("3456", "Ana", "Martínez",
            LocalDate.of(1992, 7, 25));
    Moto moto = new Moto("ABC123", 250);
    Carro carro = new Carro("XYZ789", true, false);
    Camion camion = new Camion("DEF456", (byte) 6, (byte) 60);
    Ticket ticket1;
    Ticket ticket2;
    Ticket ticket3;

    @BeforeEach
    public void init(){
        empresa.addPeaje(peaje1);
        empresa.addPeaje(peaje2);
        empresa.addRecaudador(recaudador1);
        empresa.addRecaudador(recaudador2);
        conductor1.addVehiculo(moto);
        conductor1.addVehiculo(carro);
        conductor2.addVehiculo(camion);
        moto.setTheConductor(conductor1);
        carro.setTheConductor(conductor1);
        camion.setTheConductor(conductor2);
        ticket1 = recaudador1.Cobrar(moto, peaje1);
        ticket2 = recaudador1.Cobrar(carro, peaje1);
        ticket3 = recaudador2.Cobrar(camion, peaje2);
    }

    @Test
    public void testTotal(){
        LOG.info("Iniciando pruebas del metodo Totalizar de la clase Empresa");

        assertEquals(61200, empresa.getTotal());
    }

    @Test
    public void testBuscarRecaudador(){
        LOG.info("Iniciando pruebas del metodo buscarRecaudador de la clase Empresa");
        assertEquals(recaudador1,empresa.buscarRecaudador("Juan","Pérez"));
    }

    @Test
    public void testListarCamioneros(){
        LOG.info("Iniciando pruebas del metodo getCamioneros de la clase Empresa");
        assertEquals(conductor2,empresa.getCamioneros().get(0));
    }
}

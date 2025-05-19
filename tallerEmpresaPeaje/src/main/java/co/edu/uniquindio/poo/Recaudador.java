package co.edu.uniquindio.poo;

import java.time.LocalDate;
import java.util.UUID;

public class Recaudador extends Persona {

    private int sueldo;

    public Recaudador(String cedula, String nombre, String apellido, LocalDate fechanacimiento, int sueldo) {
        super(cedula, nombre, apellido, fechanacimiento);
        this.sueldo = sueldo;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    public Ticket Cobrar(Vehiculo vehiculo,Peaje peaje){
        double total = vehiculo.calcularPasaje(peaje);
        String id = UUID.randomUUID().toString();
        Ticket ticket = new Ticket(id,LocalDate.now(),vehiculo,peaje);
        vehiculo.addNumeroPeaje();
        vehiculo.addTicket(ticket);
        peaje.agregarTotal(total);
        peaje.addTicket(ticket);
        return ticket;
    }
}

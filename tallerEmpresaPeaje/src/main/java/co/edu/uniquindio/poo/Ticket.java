package co.edu.uniquindio.poo;

import java.time.LocalDate;

public class Ticket {
    private String id;
    private LocalDate fecha;
    private Vehiculo theVehiculo;
    private Peaje thePeaje;

    public Ticket(String id, LocalDate fecha, Vehiculo theVehiculo, Peaje thePeaje) {
        this.id = id;
        this.fecha = fecha;
        this.theVehiculo = theVehiculo;
        this.thePeaje = thePeaje;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Vehiculo getTheVehiculo() {
        return theVehiculo;
    }

    public void setTheVehiculo(Vehiculo theVehiculo) {
        this.theVehiculo = theVehiculo;
    }

    public Peaje getThePeaje() {
        return thePeaje;
    }

    public void setThePeaje(Peaje thePeaje) {
        this.thePeaje = thePeaje;
    }



}

package co.edu.uniquindio.poo;

import co.edu.uniquindio.poo.interfaces.ITotalizable;

import java.time.LocalDate;
import java.util.LinkedList;

public class Conductor extends Persona implements ITotalizable {

    private LinkedList<Vehiculo> listaVehiculo;

    public Conductor(String cedula, String nombre, String apellido, LocalDate fechanacimiento) {
        super(cedula, nombre, apellido, fechanacimiento);
        this.listaVehiculo = new LinkedList<>();
    }

    public void setListaVehiculo(LinkedList<Vehiculo> listaVehiculo) {
        this.listaVehiculo = listaVehiculo;
    }

    public LinkedList<Vehiculo> getListaVehiculo() {
        return listaVehiculo;
    }

    public boolean addVehiculo(Vehiculo vehiculo){
        String placa = vehiculo.getPlaca();
        for (Vehiculo v : listaVehiculo) {
            if (v.getPlaca().equals(placa)) {
                return false;
            }
        }
        this.listaVehiculo.add(vehiculo);
        return true;
    }

    public boolean removeVehiculo(Vehiculo vehiculo){
        String placa = vehiculo.getPlaca();
        for (Vehiculo v : listaVehiculo) {
            if (v.getPlaca().equals(placa)) {
                this.listaVehiculo.remove(v);
                return true;
            }
        }
        return false;
    }

    public Vehiculo getVehiculo(String placa){
        for (Vehiculo v : listaVehiculo) {
            if (v.getPlaca().equals(placa)) {
                return v;
            }
        }
        return null;
    }

    public boolean modificarVehiculo(Vehiculo vehiculo){
        String placa = vehiculo.getPlaca();
        for (Vehiculo v : listaVehiculo) {
            if (v.getPlaca().equals(placa)) {
                listaVehiculo.remove(v);
                listaVehiculo.add(vehiculo);
                return true;
            }
        }
        return false;
    }

    public String totalizar() {
        String info = "";
        double total = 0;
        for (Vehiculo v : listaVehiculo) {
            info += "Vehiculo placa: " + v.getPlaca() + "\n";
            LinkedList<Ticket> tickets = v.getListTicket();
            for (Ticket t : tickets) {
                info += v.calcularPasajeString(t.getThePeaje());
                total += v.calcularPasaje(t.getThePeaje());
            }
            info += "\n";
        }
        info += "Total del conductor: " + total + "\n";
        return info;
    }

    public LinkedList<Vehiculo> retornarListaVehiculo(String tipo){
        LinkedList<Vehiculo> listaVehiculos = new LinkedList<>();
        for (Vehiculo v : listaVehiculo) {
            if (v.getClass().getSimpleName().equalsIgnoreCase(tipo)) {
                listaVehiculos.add(v);
            }
        }
        return listaVehiculos;
    }
}

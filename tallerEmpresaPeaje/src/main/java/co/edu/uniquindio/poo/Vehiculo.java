package co.edu.uniquindio.poo;

import java.util.LinkedList;

public abstract class Vehiculo {

    private String placa;
    private int numeroPeaje;
    private LinkedList<Ticket> listTicket;
    private Conductor theConductor;
    public Vehiculo(String placa) {
        this.placa = placa;
        this.numeroPeaje = 0;
        this.listTicket = new LinkedList<>();  // Inicializar la lista
    }

    public Vehiculo(String placa,int numeroPeaje) {
        this.placa = placa;
        this.numeroPeaje = numeroPeaje;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getNumeroPeaje() {
        return numeroPeaje;
    }

    public void setNumeroPeaje(int numeroPeaje) {
        this.numeroPeaje = numeroPeaje;
    }

    public void addNumeroPeaje(){
        this.numeroPeaje++;
    }

    public LinkedList<Ticket> getListTicket() {
        return listTicket;
    }

    public void setListTicket(LinkedList<Ticket> listTicket) {
        this.listTicket = listTicket;
    }

    public Conductor getTheConductor() {
        return theConductor;
    }
    public void setTheConductor(Conductor theConductor) {
        this.theConductor = theConductor;
    }
    public abstract String getInfo();

    public boolean addTicket(Ticket ticket){
        String id = ticket.getId();
        for (Ticket t : listTicket) {
            if (t.getId().equals(id)) {
                return false;
            }
        }
        this.listTicket.add(ticket);
        return true;
    }

    public boolean removeTicket(Ticket ticket){
        String id = ticket.getId();
        for (Ticket t : listTicket) {
            if (t.getId().equals(id)) {
                this.listTicket.remove(t);
                return true;
            }
        }
        return false;
    }

    public Ticket getTicket(String id){
        for (Ticket t : listTicket) {
            if (t.getId().equals(id)) {
                return t;
            }
        }
        return null;
    }

    public boolean modificarTicker(Ticket ticket){
        String idTicket = ticket.getId();
        for (Ticket t : listTicket) {
            if (t.getId().equals(idTicket)) {
                listTicket.remove(t);
                listTicket.add(ticket);
                return true;
            }
        }
        return false;
    }
    public abstract double calcularPasaje(Peaje peaje);

    public abstract String calcularPasajeString(Peaje peaje);
}
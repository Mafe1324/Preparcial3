package co.edu.uniquindio.poo;

import co.edu.uniquindio.poo.interfaces.ITotalizable;

import java.util.LinkedList;

public class Peaje implements ITotalizable {

    private String id;
    private String nombre;
    private String departamento;
    private double totalRecaudado;
    private LinkedList<Ticket> listaTicket;

    public Peaje(String id, String nombre, String departamento) {
        this.id = id;
        this.nombre = nombre;
        this.departamento = departamento;
        this.listaTicket = new LinkedList<>();
        this.totalRecaudado = 0;
    }
    public Peaje(String id, String nombre, String departamento, double totalRecaudado) {
        this.id = id;
        this.nombre = nombre;
        this.departamento = departamento;
        this.totalRecaudado = totalRecaudado;
    }
    //Getters setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public double getTotalRecaudado() {
        return totalRecaudado;
    }

    public void setTotalRecaudado(double totalRecaudado) {
        this.totalRecaudado = totalRecaudado;
    }

    public LinkedList<Ticket> getListaTicket() {
        return listaTicket;
    }

    public void setListaTicket(LinkedList<Ticket> listaTicket) {
        this.listaTicket = listaTicket;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean addTicket(Ticket ticket){
        String id = ticket.getId();
        for (Ticket t : listaTicket) {
            if (t.getId().equals(id)) {
                return false;
            }
        }
        this.listaTicket.add(ticket);
        return true;
    }

    public boolean removeTicket(Ticket ticket){
        String id = ticket.getId();
        for (Ticket t : listaTicket) {
            if (t.getId().equals(id)) {
                this.listaTicket.remove(t);
                return true;
            }
        }
        return false;
    }

    public Ticket getTicket(String id){
        for (Ticket t : listaTicket) {
            if (t.getId().equals(id)) {
                return t;
            }
        }
        return null;
    }

    public boolean modificarTicker(Ticket ticket){
        String idTicket = ticket.getId();
        for (Ticket t : listaTicket) {
            if (t.getId().equals(idTicket)) {
                listaTicket.remove(t);
                listaTicket.add(ticket);
                return true;
            }
        }
        return false;
    }

    //metodos

    public void agregarTotal(double total){
        this.totalRecaudado += total;
    }

    public double calcularPasaje(Vehiculo vehiculo){
        return 0;
    }

    public double calcularPasaje(Moto moto){
        double costo = 5000;
        if (moto.getCilindraje() > 200) {
            costo += 2000;
        }
        return costo;
    }

    public double calcularPasaje(Camion camion){
        double costo = 7000 * camion.getEje();
        if (camion.getCapacidad() > 10){
            costo += costo * 0.1;
        }
        return costo;
    }

    public double calcularPasaje(Carro carro){
        double costo = 10000;
        double costo_descuento1 = 0;
        double costo_descuento2 = 0;
        if (carro.getIselectrico()){
            costo_descuento1 = costo * 0.2;
        }
        if (carro.getIspublico()){
            costo_descuento2 = costo * 0.15;
        }
        return costo - costo_descuento1 + costo_descuento2;
    }

    public String calcularPasajeString(Moto moto){
        double costo = 5000;
        String info = "Costo inicial: " + costo + " \n";
        if (moto.getCilindraje() > 200) {
            double costo_adicional = 2000;
            info += "Costo adicional: " + costo_adicional + "\n";
            costo += costo_adicional;
        }
        info += "Total: " + costo + "\n";

        return info;
    }

    public String calcularPasajeString(Camion camion){
        double costo = 7000 * camion.getEje();
        String info = "Costo inicial: " + costo + " \n";
        if (camion.getCapacidad() > 10){
            double costo_adicional = costo * 0.1;
            info += "Recargo adicional: " + costo_adicional + "\n";
            costo += costo_adicional;
        }
        return info += "Total: " + costo + "\n";
    }

    public String calcularPasajeString(Carro carro){
        double costo = 10000;
        String info = "Costo inicial: " + costo + " \n";
        double costo_descuento1 = 0;
        double costo_descuento2 = 0;
        if (carro.getIselectrico()){
            costo_descuento1 = costo * 0.2;
            info += "Descuento: " + costo_descuento1 + "\n";
        }
        if (carro.getIspublico()){
            costo_descuento2 = costo * 0.15;
            info += "Recargo adicional: " + costo_descuento2 + "\n";
        }
        return info += "Total: " + (costo - costo_descuento1 + costo_descuento2) + "\n";
    }

    public String calcularPasajeString(Vehiculo vehiculo){
        return "-";
    }

    public String totalizar() {
        String info = "";
        for (Ticket t: listaTicket){
            info+= "Tipo vehiculo: " + t.getTheVehiculo().getClass().getSimpleName()+ "\n";
            info+= t.getTheVehiculo().calcularPasajeString(t.getThePeaje());
            info+="\n";
        }
        info += "Total del peaje: " + totalRecaudado + "\n";
        return info;
    }


}

package co.edu.uniquindio.poo;

import java.util.LinkedList;

public class Empresa {

    public String nombre;
    public LinkedList<Peaje> listPeaje;
    public LinkedList<Recaudador> listRecaudador;
    public Empresa(String nombre) {
        this.nombre = nombre;
        listPeaje = new LinkedList<>();
        listRecaudador = new LinkedList<>();
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setListPeaje(LinkedList<Peaje> listPeaje){
        this.listPeaje = listPeaje;
    }

    public LinkedList<Peaje> getListPeaje() {
        return listPeaje;
    }

    public LinkedList<Recaudador> getListRecaudador() {
        return listRecaudador;
    }

    public void setListRecaudador(LinkedList<Recaudador> listRecaudador) {
        this.listRecaudador = listRecaudador;
    }

    public boolean addPeaje(Peaje peaje){
        String id = peaje.getId();
        for (Peaje p : listPeaje) {
            if (p.getId().equals(id)) {
                return false;
            }
        }
        this.listPeaje.add(peaje);
        return true;
    }

    public boolean removePeaje(Peaje peaje){
        String id = peaje.getId();
        for (Peaje p : listPeaje) {
            if (p.getId().equals(id)) {
                this.listPeaje.remove(p);
                return true;
            }
        }
        return false;
    }

    public Peaje getPeaje(String id){
        for (Peaje p : listPeaje) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }
    public boolean modificarPeaje(Peaje peaje){
        String idPeaje = peaje.getId();
        for (Peaje p : listPeaje) {
            if (p.getId().equals(idPeaje)) {
                listPeaje.remove(p);
                listPeaje.add(peaje);
                return true;
            }
        }
        return false;
    }

    public boolean addRecaudador(Recaudador recaudador){
        String cedula = recaudador.getCedula();
        for (Recaudador r : listRecaudador) {
            if (r.getCedula().equals(cedula)) {
                return false;
            }
        }
        listRecaudador.add(recaudador);
        return true;
    }

    public boolean removeRecaudador(Recaudador recaudador){
        String cedula = recaudador.getCedula();
        for (Recaudador r : listRecaudador) {
            if (r.getCedula().equals(cedula)) {
                listRecaudador.remove(r);
                return true;
            }
        }
        return false;
    }

    public Recaudador getRecaudador(String cedula){
        for (Recaudador r : listRecaudador) {
            if (r.getCedula().equals(cedula)) {
                return r;
            }
        }
        return null;
    }

    public boolean modificarRecaudador(Recaudador recaudador){
        String cedula = recaudador.getCedula();
        for (Recaudador r : listRecaudador) {
            if (r.getCedula().equals(cedula)) {
                listRecaudador.remove(r);
                listRecaudador.add(recaudador);
                return true;
            }
        }
        return false;
    }

    public double getTotal() {
        double total = 0;
        for (Peaje peaje : listPeaje) {
            total += peaje.getTotalRecaudado();
        }
        return total;
    }

    public Recaudador buscarRecaudador(String nombre,String apellido){
        for (Recaudador recaudador : listRecaudador) {
            if (recaudador.getNombre().equalsIgnoreCase(nombre) && recaudador.getApellido().equalsIgnoreCase(apellido)) {
                return recaudador;
            }
        }
        return null;
    }

    public LinkedList<Conductor> getCamioneros(){
        LinkedList<Conductor> ListaConductor = new LinkedList<>();
        for (Peaje p: listPeaje){
            for (Ticket t: p.getListaTicket()){
                if (t.getTheVehiculo() instanceof Camion) {
                    if (((Camion) t.getTheVehiculo()).getCapacidad() >= 50){
                        ListaConductor.add(t.getTheVehiculo().getTheConductor());
                    }
                }
            }
        }
        return ListaConductor;
    }
}

package co.edu.uniquindio.poo;

public class Moto extends Vehiculo {

    private int cilindraje;

    public Moto(String placa,int cilindraje) {
        super(placa);
        this.cilindraje = cilindraje;
    }

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }

    public int getCilindraje() {
        return cilindraje;
    }

    @Override
    public String getInfo() {
        String info = "";

        info += "Tipo de vehiculo: Moto\n";
        info += "Placa de vehiculo: " + this.getPlaca() + "\n";
        info += "Cilindraje del vehiculo: " + this.getCilindraje() + "\n";

        return info;
    }

    @Override
    public double calcularPasaje(Peaje peaje) {
        return peaje.calcularPasaje(this);
    }

    @Override
    public String calcularPasajeString(Peaje peaje){
       return peaje.calcularPasajeString(this);
    }
}

package co.edu.uniquindio.poo;

public class Camion extends Vehiculo {

    private byte eje;
    private byte capacidad;

    public Camion(String placa, byte eje, byte capacidad) {
        super(placa);
        this.eje = eje;
        this.capacidad = capacidad;
    }

    public byte getEje() {
        return eje;
    }

    public void setEje(byte eje) {
        this.eje = eje;
    }

    public byte getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(byte capacidad) {
        this.capacidad = capacidad;
    }

    @Override
    public String getInfo() {
        String info = "";

        info += "Tipo de vehiculo: Camion\n";
        info += "Placa de vehiculo: " + this.getPlaca() + "\n";
        info += "Ejes del vehiculo: " + this.getEje() + "\n";
        info += "Capacidad del vehiculo: " + this.getCapacidad() + "\n";

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


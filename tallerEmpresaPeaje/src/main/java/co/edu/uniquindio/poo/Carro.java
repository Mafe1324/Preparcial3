package co.edu.uniquindio.poo;

public class Carro extends Vehiculo {

    private boolean iselectrico;
    private boolean ispublico;

    public Carro(String placa,boolean iselectrico,boolean ispublico) {
        super(placa);
        this.iselectrico = iselectrico;
        this.ispublico = ispublico;
    }

    public void setIselectrico(boolean iselectrico) {
        this.iselectrico = iselectrico;
    }

    public void setIspublico(boolean ispublico) {
        this.ispublico = ispublico;
    }

    public boolean getIselectrico() {
        return iselectrico;
    }

    public boolean getIspublico() {
        return ispublico;
    }

    @Override
    public String getInfo() {
        String info = "";

        info +="Tipo de vehiculo: Carro\n";
        info +="Placa de vehiculo: " + this.getPlaca() + "\n";
        info +="Es electrico?" + this.getIselectrico() + "\n";
        info+="Es publico?" + this.getIspublico() + "\n";

        return info;

    }

    @Override
    public double calcularPasaje(Peaje peaje) {
        return  peaje.calcularPasaje(this);
    }

    @Override
    public String calcularPasajeString(Peaje peaje){
        return peaje.calcularPasajeString(this);
    }
}

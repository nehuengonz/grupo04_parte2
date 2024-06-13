package modelo;

import java.util.Random;

/**
 * clase abstracta del viaje esta deriva en las clases concretas de los diferentes tipos de zona que puede realizar el chofer
 * y hay un costo adicional distinto dependiendo la zona
 * Se puede decorar con un ViajeDecorator (ViajeConBaul, ViajeConMascota)
 */
public abstract class ViajeAbstract implements IViaje, Comparable<ViajeAbstract> {
    protected double costoBase = 1000;
    protected double distanciaRecorridaEnKm;

    protected Pedido pedido;
    protected Chofer chofer;
    protected Vehiculo vehiculo;

    /*
     * El pedido se inicializa en el constructor y después no se vuelve a modificar.
     */
    public ViajeAbstract(Pedido pedido, Vehiculo vehiculo, Chofer chofer) {
        this.pedido = pedido;
        this.chofer = chofer;
        this.vehiculo = vehiculo;
        Random random = new Random();
        distanciaRecorridaEnKm = random.nextInt(40);
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setChofer(Chofer chofer) {
        this.chofer = chofer;
        chofer.setOcupado(true);
    }

    public Chofer getChofer() {
        return chofer;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public double getDistanciaRecorridaEnKm(){
        return distanciaRecorridaEnKm;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        ViajeAbstract clon = (ViajeAbstract)super.clone();
        clon.pedido = (Pedido)pedido.clone();
        return clon;
    }

    @Override
    public String toString() {
        return "ViajeAbstract [costo_base=" + costoBase + ", pedido=" + pedido + ", chofer="
                + chofer + ", vehiculo=" + vehiculo + "]";
    }

    @Override
    public int compareTo(ViajeAbstract o) {
        return Double.compare(getCosto(), o.getCosto());
    }
}

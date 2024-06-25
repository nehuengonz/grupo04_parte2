package modelo;

public abstract class ViajeDecorator extends ViajeAbstract {
    protected ViajeAbstract viajeWrapee;

    public ViajeDecorator(ViajeAbstract viaje) {
        super(viaje.getPedido(), viaje.getVehiculo(), viaje.getChofer());
        viajeWrapee = viaje;
    }
}

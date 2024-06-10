package negocio;

public class ViajeConBaul extends ViajeDecorator {
    private static final double aumento_por_pasajero=0.1;
    private static final double aumento_por_km=0.05;
    private IViaje viaje;

    public ViajeConBaul(ViajeAbstract viaje) {
        super(viaje);
    }

    @Override
    public double getCantPasajeros() {
        return viajeWrapee.getCantPasajeros();
    }

    @Override
    public double getDistanciaRecorridaEnKm() {
        return viajeWrapee.getDistanciaRecorridaEnKm();
    }

    @Override
    public double getCosto() {
        return viajeWrapee.getCosto() + costoBase * (0.1 * getCantPasajeros() + 0.05 * getDistanciaRecorridaEnKm());
    }
}

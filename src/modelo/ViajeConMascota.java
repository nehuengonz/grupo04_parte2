package modelo;

public class ViajeConMascota extends ViajeDecorator {
    private static final double aumento_por_pasajero=0.1;
    private static final double aumento_por_km=0.2;

    public ViajeConMascota(ViajeAbstract viaje){
        super(viaje);
    }

    public double getCosto() {
        return viajeWrapee.getCosto() +
        aumento_por_pasajero * viajeWrapee.getCantPasajeros() +
        (aumento_por_km) * viajeWrapee.getDistanciaRecorridaEnKm();
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
	public String toString() {
		return viajeWrapee.toString();
	}
}

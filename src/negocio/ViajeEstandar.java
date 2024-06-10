package negocio;

public class ViajeEstandar extends ViajeAbstract {
    private static final double aumento_por_pasajero=0.1;
    private static final double aumento_por_km=0.1;

    public ViajeEstandar(Pedido pedido, Vehiculo vehiculo, Chofer chofer) {
        super(pedido, vehiculo, chofer);
    }
    @Override
    public double getCantPasajeros() {
        return pedido.getCantPasajeros();
    }

    @Override
    public double getCosto() {
        return costoBase * (1 + aumento_por_pasajero * getCantPasajeros() + aumento_por_km * getDistanciaRecorridaEnKm());
    }
    public double getDistanciaRecorridaEnKm() {
        // TODO Implement this method
        return super.getDistanciaRecorridaEnKm();
    }
}
package negocio;

public class ViajeCalleSinAsfaltar extends ViajeAbstract {
    private static final double aumento_por_pasajero=0.2;
    private static final double aumento_por_km=0.15;
    public ViajeCalleSinAsfaltar(Pedido pedido, Vehiculo vehiculo, Chofer chofer) {
        super(pedido, vehiculo, chofer);
    }
    @Override
    public double getCantPasajeros() {
        return pedido.getCantPasajeros();
    }
    @Override
    public double getDistanciaRecorridaEnKm() {
        return super.getDistanciaRecorridaEnKm();
    }

    @Override
    public double getCosto() {
        return costoBase * (1 + aumento_por_pasajero * pedido.getCantPasajeros() + aumento_por_km * getDistanciaRecorridaEnKm());
    }
}
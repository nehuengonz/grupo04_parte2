package negocio;

/**
 * interfaz utilizada para los metodos del viaje
 */
public interface IViaje extends Cloneable {
    double getCantPasajeros();
    double getDistanciaRecorridaEnKm();
    double getCosto();
}

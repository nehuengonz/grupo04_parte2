package excepciones;

public class SinVehiculosDisponiblesException extends Exception {
  public SinVehiculosDisponiblesException() {
    super("No hay vehículos disponibles para este pedido.");
  }
}

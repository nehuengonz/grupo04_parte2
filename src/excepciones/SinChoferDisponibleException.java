package excepciones;

public class SinChoferDisponibleException extends Exception {
  public SinChoferDisponibleException() {
    super("No hay choferes disponibles.");
  }
}

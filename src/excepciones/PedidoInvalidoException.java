package excepciones;

public class PedidoInvalidoException extends Exception {
  public PedidoInvalidoException() {
    super("No es posible satisfacer el pedido.");
  }
}

package excepciones;

public class UsuarioRepetidoException extends Exception {

  public UsuarioRepetidoException() {
    super("Este nombre de usuario ya existe");
  }
}

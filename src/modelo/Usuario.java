package modelo;

/**
 * clase astracta usuario que tiene los atributos comunes de Administrador y Cliente
 * @Invariantes:
 * nombreUs, contrasenia y nombreReal != null
 */
public abstract class Usuario {
  protected String nombreUs;
  protected String contrasenia;
  protected String nombreReal;

  public Usuario(String nombreUs, String contrasenia, String nombreReal) {
    this.nombreUs = nombreUs;
    this.contrasenia = contrasenia;
    this.nombreReal = nombreReal;
  }

  public String getNombreUs() { return nombreUs; }

  public String getContrasenia() { return contrasenia; }

  public String getNombreReal() { return nombreReal; }

  /**
   * @Precondiciones:
   * nombreUs != null
   * @param nombreUs
   */
  public void setNombreUs(String nombreUs) {
    assert nombreUs != null;
    this.nombreUs = nombreUs;
  }

  /**
   * @Precondiciones:
   * contrasenia != null
   * @param contrasenia
   */
  public void setContrasenia(String contrasenia) {
    assert contrasenia != null;
    this.contrasenia = contrasenia;
  }

  /**
   * @Precondiciones:
   * nombreReal != null
   * @param nombreReal
   */
  public void setNombreReal(String nombreReal) {
    assert nombreReal != null;
    this.nombreReal = nombreReal;
  }

  @Override
  public String toString() {
    return "{ nombre de usuario: " + nombreUs + ", contraseña: " + contrasenia + ", nombre real:" + nombreReal + " }";
  }
}

package modelo;

/**
 * clase abstracta de los choferes de la empresa
 * @Invariantes:
 * dni y nombre != null
 */
public abstract class Chofer {
  protected String dni;
  protected String nombre;
  protected boolean ocupado;

  public Chofer(String dni, String nombre) {
    super();
    this.dni = dni;
    this.nombre = nombre;
    ocupado = false;
  }

  public Chofer() { super(); }

  /**
   * @Precondiciones:
   * dni != null
   * @param dni
   */
  public void setDni(String dni) {
    assert dni != null;
    this.dni = dni; }

  public String getDni() { return dni; }

  /**
   * @Precondiciones:
   * nombre != null
   * @param nombre
   */
  public void setNombre(String nombre) {
    assert nombre != null;
    this.nombre = nombre; }

  public String getNombre() { return nombre; }
  public boolean getOcupado() { return ocupado; }
  public void setOcupado(boolean value) { ocupado = value; }


  public abstract double getSueldoBruto();
  public abstract double getSueldoNeto();
  @Override
  public String toString() {
    return "Chofer [dni=" + dni + ", nombre=" + nombre + "]";
  }
}

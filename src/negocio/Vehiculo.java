package negocio;

/**
 * clase abstracta vehiculo que obtiene los atributos comunes de todoslos tipos de vehiculos de la empresa
 * @Invariantes:
 * nroPatente != null
 */
public abstract class Vehiculo {
  protected String nropatente;
  protected double cant_max_pasajeros;
  protected boolean PF;
  protected boolean baul;
  protected boolean disponible;

  /**
   * @Precondiciones
   * nropatente != null
   * @param nropatente
   * @param cant_max_pasajeros
   * @param PF
   * @param baul
   */
  public Vehiculo(String nropatente, double cant_max_pasajeros, boolean PF,
                  boolean baul) {
    assert nropatente != null;
    this.nropatente = nropatente;
    this.cant_max_pasajeros = cant_max_pasajeros;
    this.PF = PF;
    this.baul = baul;
    this.disponible=true;
  }
  /*
   * Devuelve un Integer indicando el valor de prioridad para el pedido en
   * cuestión. Si el vehículo no es apto para el pedido retorna null.
   */
  public Integer getPrioridad(Pedido pedido) {
    if (!verificarCantPasajeros(pedido.getCantPasajeros()) ||
        !verificarBaul(pedido.getUsaBaul()) || !verificarPF(pedido.isSPF()))
      return null;
    return calculoPrioridad(pedido);
  }
  abstract protected boolean verificarCantPasajeros(Integer cantPasajeros);
  abstract protected boolean verificarBaul(boolean usaBaul);
  abstract protected boolean verificarPF(boolean PF);
  abstract protected Integer calculoPrioridad(Pedido pedido);

  /**
   * @Precondiciones:
   * nropatente != null
   * @param nropatente
   */
  public void setNropatente(String nropatente) {
    assert nropatente != null;
    this.nropatente = nropatente; }

  public String getNropatente() { return nropatente; }

  public void setCant_max_pasajeros(double cant_max_pasajeros) {
    this.cant_max_pasajeros = cant_max_pasajeros;
  }

  public double getCant_max_pasajeros() { return cant_max_pasajeros; }

  public void setPF(boolean PF) { this.PF = PF; }

  public boolean isPF() { return PF; }

  public void setBaul(boolean baul) { this.baul = baul; }

  public boolean isBaul() { return baul; }
  @Override
  public String toString() {
    return "Vehiculo [nropatente=" + nropatente +
        ", cant_pasajeros=" + cant_max_pasajeros + ", PF=" + PF +
        ", baul=" + baul + "]";
  }
  public boolean isDisponible() { return disponible; }
  public void setDisponible(boolean disponible) {
    this.disponible = disponible;
  }
}

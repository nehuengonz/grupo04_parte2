package negocio;

/**
 * clase concreta de moto que extiende de vehiculo
 */
public class Moto extends Vehiculo {
  private static final double cant_max_pasajeros = 1;
  public Moto(String nropatente) {
    super(nropatente, cant_max_pasajeros, false, false);
  }

  protected boolean verificarCantPasajeros(Integer cantPasajeros) {
    return cantPasajeros < 2;
  }
  protected boolean verificarBaul(boolean usaBaul) { return !usaBaul; }
  protected boolean verificarPF(boolean PF) { return !PF; }
  protected Integer calculoPrioridad(Pedido pedido) { return 1000; }

  @Override
  public String toString() {
    return "Moto [toString()=" + super.toString() + "]";
  }
}

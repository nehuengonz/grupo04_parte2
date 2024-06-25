package modelo;

/**
 * clase concreta de vehiculo generada por el factory
 */
public class Automovil extends Vehiculo {
  private static final double cant_max_pasajeros = 4;

  public Automovil(String nropatente) {
    super(nropatente, cant_max_pasajeros, true, true);
  }

  /**
   * @param cantPasajeros la cantidad de pasajeros del pedido
   * @return verifica la cantidad de pasajeros sea menor o igual a 4
   */
  protected boolean verificarCantPasajeros(Integer cantPasajeros) {
  return cantPasajeros <= 4;
}

  /**
   * @param usaBaul verdadero o falso dependiendo del pedido si tiene baul o no
   * @return verifica si el valor de baul es verdadero
   */
  protected boolean verificarBaul(boolean usaBaul) { return true; }

  /**
   * @Postcondiciones:
   * Siempre retorna verdadero porque en ambos casos un Automovil es capaz de satisfacer el pedido.
   * @param PF verdadero o falso dependiendo del pedido si tiene mascocota o no
   * @return verifica si el valor de mascota es verdadero
   */
  protected boolean verificarPF(boolean PF) { return true; }

  /**
   * @param pedido el pedido realziado por el cliente
   * @return devuelve la prioridad del pedido
   */
  protected Integer calculoPrioridad(Pedido pedido) {
    if (pedido.getUsaBaul()) {
      return 40 * pedido.getCantPasajeros();
    }
    return 30 * pedido.getCantPasajeros();
  }

  @Override
  public String toString() {
    return "Automovil [toString()=" + super.toString() + "]";
  }
}

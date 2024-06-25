package modelo;

/**
 * clase concreta combi, extendida de vehiculo
 */
public class Combi extends Vehiculo {
  private static final double cant_max_pasajeros = 10;

  public Combi(String nropatente) {
    super(nropatente, cant_max_pasajeros, false, true);
  }

  protected boolean verificarCantPasajeros(Integer cantPasajeros) {
    return cantPasajeros <= 10;
  }
  protected boolean verificarBaul(boolean usaBaul) {
	 return true; 
	}
  protected boolean verificarPF(boolean PF) { 
	return !PF;
 }
 //devuelve 10* cant de pasajeros solicitados +100 si usa baul

    /**
     * @param pedido
     * @return la prioridad de la combi
     */
    protected Integer calculoPrioridad(Pedido pedido) {
    return 10 * pedido.getCantPasajeros() + (pedido.getUsaBaul() ? 100 : 0);
  }

  @Override
  public String toString() {
    return "Combi [toString()=" + super.toString() + "]";
  }
}

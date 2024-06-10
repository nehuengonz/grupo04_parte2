package negocio;

import excepciones.*;

import java.util.ArrayList;

/**
 * clase concreta de cliente extendida de usuario se encarga de la gestion y accesibilidad del cliente 
 * en sus viajes  realizados por la empresa
 */
public class Cliente extends Usuario {
  private Sistema sistema;

  public Cliente(String nombreUs, String contrasenia, String nombreReal) {
    super(nombreUs, contrasenia, nombreReal);
    sistema = Sistema.getInstance();
  }
  // SPF service pet friendly
  // TE tipo Equipaje
  public void solicitaViaje(Pedido pedido)
      throws Exception {
    sistema.procesarPedido(pedido);
    pedido.setCliente(this);
  }
  public void pagaViaje(ViajeAbstract viaje) {
    sistema.procesarPago(viaje.getCosto());
  }
  public void calificaChofer() {
    sistema.guardarCalificacionChofer();
  }
  public ArrayList<ViajeAbstract> historialViajes() {
    return sistema.getViajesCliente(this);
  }
}

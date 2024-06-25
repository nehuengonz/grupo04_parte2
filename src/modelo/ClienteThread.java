package modelo;

import excepciones.PedidoInvalidoException;
import excepciones.SinChoferDisponibleException;
import excepciones.SinVehiculosDisponiblesException;
import util.Util;
public class ClienteThread extends Thread{
	
	private Cliente cliente;
	private RecursoCompartido rc;
	private int CantViajes;
	
	public ClienteThread(Cliente cliente, RecursoCompartido rc) {
		super();
		this.cliente = cliente;
		this.rc = rc;
		this.CantViajes = rc.getCantMaxSoli_por_Cliente();
		
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public RecursoCompartido getrc() {
		return rc;
	}

	public void setRecursocompartido(RecursoCompartido rc) {
		this.rc = rc;
	}
	
	public void run() {
		while (rc.getCantMaxSoli_por_Cliente()>0 ) {
			Util.espera();
			Pedido ped= rc.getViaje().getPedido();
			try {
				rc.ViajeSolicitado(ped);
			} catch (PedidoInvalidoException | SinVehiculosDisponiblesException | SinChoferDisponibleException e) {
				e.printStackTrace();
			}
			Util.espera();
			rc.ViajePagado(cliente);
			this.CantViajes--;
			
		}
		
	}
}

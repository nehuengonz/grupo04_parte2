package modelo;

import java.util.Observable;

import excepciones.PedidoInvalidoException;
import excepciones.SinChoferDisponibleException;
import excepciones.SinVehiculosDisponiblesException;

@SuppressWarnings("deprecation")
public class RecursoCompartido extends Observable{

	private int CantClientes;
	private int CantMaxSoli_por_Cliente;
	private int CantChofDeCadaTipo;
	private int CantMaxViajesPorChofer;
	private FlotaVehiculos flota;
	
	private ViajeAbstract viaje;
	
	private Sistema sis=Sistema.getInstance();
	
	public RecursoCompartido(int cantClientes, int cantMaxSoli_por_Cliente, int cantChofDeCadaTipo,
			int cantMaxViajesPorChofer, FlotaVehiculos flota) {
		super();
		CantClientes = cantClientes;
		CantMaxSoli_por_Cliente = cantMaxSoli_por_Cliente;
		CantChofDeCadaTipo = cantChofDeCadaTipo;
		CantMaxViajesPorChofer = cantMaxViajesPorChofer;
		this.flota = flota;
	}
	public RecursoCompartido() {
		super();
	}
	public int getCantClientes() {
		return CantClientes;
	}
	public ViajeAbstract getViaje() {
		return viaje;
	}
	public void setViaje(ViajeAbstract viaje) {
		this.viaje = viaje;
	}
	public void setCantClientes(int cantClientes) {
		CantClientes = cantClientes;
	}
	public int getCantMaxSoli_por_Cliente() {
		return CantMaxSoli_por_Cliente;
	}
	public void setCantMaxSoli_por_Cliente(int cantMaxSoli_por_Cliente) {
		CantMaxSoli_por_Cliente = cantMaxSoli_por_Cliente;
	}
	public int getCantChofDeCadaTipo() {
		return CantChofDeCadaTipo;
	}
	public void setCantChofDeCadaTipo(int cantChofDeCadaTipo) {
		CantChofDeCadaTipo = cantChofDeCadaTipo;
	}
	public int getCantMaxViajesPorChofer() {
		return CantMaxViajesPorChofer;
	}
	public void setCantMaxViajesPorChofer(int cantMaxViajesPorChofer) {
		CantMaxViajesPorChofer = cantMaxViajesPorChofer;
	}
	public FlotaVehiculos getFlota() {
		return flota;
	}
	public void setFlota(FlotaVehiculos flota) {
		this.flota = flota;
	}
	
	public boolean simulacionActiva() {
				if(this.CantChofDeCadaTipo> 0 && this.CantClientes >0 ) 
					return true;
				else
					return false;
				
	}
	
	//situacion del viaje
	
	public synchronized void ViajeSolicitado(Pedido pedido) throws PedidoInvalidoException, SinVehiculosDisponiblesException, SinChoferDisponibleException {
		this.viaje.setPedido(pedido);
		String cartelito = null;
		if (this.CantChofDeCadaTipo >0) {
			sis.procesarPedido(pedido);
			cartelito="viaje solicitadoexitosamente por "+ pedido.getCliente().getNombreUs();
		}
		else {
			cartelito="viaje no pudo procesarse, cantidad de choferes nula";
			
		}
		
		setChanged();
		notifyObservers(cartelito);
		notifyAll();
	}
	public synchronized void ViajeConVehiculo() throws InterruptedException, PedidoInvalidoException, SinVehiculosDisponiblesException {
		String cartelito = null;
		ViajeAbstract viaje = this.viaje;
		while(this.simulacionActiva() && viaje != null) {
			cartelito= "sistema intendo asignar un vehiculo al cliente";
			setChanged();
			notifyObservers(cartelito);
			wait();
			viaje.setVehiculo(Sistema.getInstance().asignarVehiculo(viaje.pedido));
			cartelito= "vehiculo '"+viaje.getVehiculo().getNropatente()+"' asignado exitosamente";
		}
		setChanged();
		notifyObservers(cartelito);
		notifyAll();
	}
	public synchronized void ViajeIniciado() {
		String cartelito = null;
		while (this.CantClientes > 0 && this.CantChofDeCadaTipo> 0 && this.CantMaxViajesPorChofer >0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if (this.getCantMaxViajesPorChofer()>0 ) {
			try {
				viaje.setChofer(Sistema.getInstance().asignarChofer());
			} catch (SinChoferDisponibleException e) {
				e.printStackTrace();
			}
			cartelito= "chofer '"+ viaje.getChofer().nombre+"' asignado exitosamente";
			setChanged();
			notifyObservers(cartelito);
		}
		notifyAll();
	}
	public synchronized void ViajePagado(Cliente cliente) {
		String cartelito;
		if (this.getCantChofDeCadaTipo() > 0) {
				while(this.simulacionActiva()) {
				Sistema.getInstance().procesarPago(viaje.getPedido().getCliente());
				cartelito="viaje pagado exitosamente";
				setChanged();
				notifyObservers(cartelito);
			}
		}
		notifyAll();
	}
	public synchronized void ViajeFinalizado() {
		String cartelito;
		while (this.simulacionActiva()) {
			Sistema.getInstance().registrarViajeFinalizado(viaje);
			cartelito="viaje finalizado exitosamente";
			setChanged();
			notifyObservers(cartelito);
		}
		notifyAll();
	}
	
}

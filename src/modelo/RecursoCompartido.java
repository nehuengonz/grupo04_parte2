package modelo;

public class RecursoCompartido {

	private int CantClientes;
	private int CantMaxSoli_por_Cliente;
	private int CantChofDeCadaTipo;
	private int CantMaxViajesPorChofer;
	private FlotaVehiculos flota;
	
	private Pedido pedido;
	
	
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
	
	
	
}

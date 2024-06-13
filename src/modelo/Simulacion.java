package modelo;

public class Simulacion {
	private ClienteThread cliente;
	private ChoferThread chofer;
	private SistemaThread sistema;
	private RecursoCompartido rc;
	public Simulacion(ClienteThread cliente, ChoferThread chofer, SistemaThread sistema, RecursoCompartido rc) {
		super();
		this.cliente = cliente;
		this.chofer = chofer;
		this.sistema = sistema;
		this.rc = rc;
	}
	
	public Simulacion() {
		super();
	}

	public ClienteThread getCliente() {
		return cliente;
	}
	public void setCliente(ClienteThread cliente) {
		this.cliente = cliente;
	}
	public ChoferThread getChofer() {
		return chofer;
	}
	public void setChofer(ChoferThread chofer) {
		this.chofer = chofer;
	}
	public SistemaThread getSistema() {
		return sistema;
	}
	public void setSistema(SistemaThread sistema) {
		this.sistema = sistema;
	}
	public RecursoCompartido getRc() {
		return rc;
	}
	public void setRc(RecursoCompartido rc) {
		this.rc = rc;
	}
	
	
}

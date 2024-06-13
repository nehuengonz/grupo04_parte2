package modelo;

public class ClienteThread extends Thread{
	
	private Cliente cliente;
	private RecursoCompartido rc;
	
	public ClienteThread(Cliente cliente, RecursoCompartido rc) {
		super();
		this.cliente = cliente;
		this.rc = rc;
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
		
	}
}

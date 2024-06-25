package modelo;

import util.Util;

public class ChoferThread extends Thread{

	private RecursoCompartido rc;
	private int CantViajes;
	private Chofer chofer;
	
	public ChoferThread(RecursoCompartido rc, int cantViajes, Chofer chofer) {
		super();
		this.rc = rc;
		CantViajes = cantViajes;
		this.chofer = chofer;
	}
	

	public void run() {
		while(CantViajes>0 && rc.getCantClientes()>0) {
			Util.espera();
			rc.ViajeIniciado();
			Util.espera();
			rc.ViajeFinalizado();
		}
	}
}

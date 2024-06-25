package modelo;

import java.util.Observable;
import java.util.Observer;

import excepciones.PedidoInvalidoException;
import excepciones.SinVehiculosDisponiblesException;
import util.Util;

public class SistemaThread extends Thread{

	private RecursoCompartido rc;
	
	 public SistemaThread(RecursoCompartido rc) {
		 this.rc = rc;
	 }

	 public void run() {
		 while(rc.simulacionActiva()) {
			 Util.espera();
			 try {
				rc.ViajeConVehiculo();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (PedidoInvalidoException e) {
				e.printStackTrace();
			} catch (SinVehiculosDisponiblesException e) {
				e.printStackTrace();
			}
		 }
	 }
}

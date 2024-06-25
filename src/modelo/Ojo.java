package modelo;

import java.util.Observable;
import java.util.Observer;

import presentacion.Ventana_mensaje;

public class Ojo implements Observer{
	protected Observable observable;
	
	private Ventana_mensaje ventana;
	
	public void Ojo(Observable observable,Ventana_mensaje ventana) {
		
		this.observable = observable;
		this.ventana = ventana;
		this.observable.addObserver(this);
	}
	@Override
	public void update(Observable o, Object arg) {
		
		if(o == this.observable) {
			String cartelito = (String)arg;
			this.ventana.appendText(cartelito);
		}
		else throw new IllegalArgumentException();
	}

}

package modelo;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * clase concreta de los choferes contratados extiende de la clase chofer 
 */
public class ChoferContratado extends Chofer implements Serializable{
	Sistema sistema=Sistema.getInstance();
    protected double ganancia_viaje;
    

    
    public ChoferContratado(String dni, String nombre, double ganancia_viaje) {
		super(dni, nombre);
		this.ganancia_viaje = ganancia_viaje;
	}
	public ChoferContratado() {
        super();
    }

    public void setGanancia_viaje(double ganancia_viaje) {
        this.ganancia_viaje = ganancia_viaje;
    }

    public double getGanancia_viaje() {
        return ganancia_viaje;
    }

    
    public double getSueldoBruto(LocalDate date) {
    	double sueldo=0;
       for(ViajeAbstract act:sistema.getViajes() ) {
    	   //comparo si es el mismo chofer y el mismo mes y anio
    	   if (this== act.getChofer() 
    			   && date.getMonthValue()== act.getPedido().getFecha().getMonthValue() 
    			   && date.getYear() == act.getPedido().getFecha().getYear()) {
    		  
    		   sueldo+=act.getCosto()*(ganancia_viaje/100);
    	   }
       }
        return sueldo;
    }

    @Override
	public double getSueldoNeto() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getSueldoBruto() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String toString() {
		return "ChoferContratado [ganancia_viaje=" + ganancia_viaje + ", dni=" + dni + ", nombre=" + nombre + "]";
	}
	
    
}
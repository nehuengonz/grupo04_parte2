package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.Date;

import modelo.Cliente;
import modelo.Pedido;
import modelo.Sistema;
import modelo.Zona;
import presentacion.IVentanaCliente;

public class Controlador_ventana_cliente implements ActionListener{

	IVentanaCliente vc;
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equalsIgnoreCase("Realizar pedido"))
		{
			try {
				this.pulsoRealizarPedido();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} 
	}
	
	public void pulsoRealizarPedido() throws Exception {
		boolean mascota=this.vc.getMascota();
		boolean baul=this.vc.getBaul();
		Zona zona=this.vc.getTipo();
		LocalDateTime fecha=this.vc.getfecha();
		int cantPasajeros=this.vc.getCantPasajeros();
		Cliente cliente=this.vc.getcliente();
		//falta los datos del cliente que se logeo
		Pedido pedido=new Pedido(zona, mascota, baul, fecha, cantPasajeros,cliente);
		//aca pondria el pedido en el sistema
		Sistema.getInstance().agregaCliente(cliente);
		cliente.solicitaViaje(pedido);
	}

}

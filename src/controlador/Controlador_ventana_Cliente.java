package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import excepciones.UsuarioRepetidoException;
import modelo.Cliente;
import modelo.Sistema;
import presentacion.ILoginController;
import presentacion.IVentanaLogin;
import presentacion.Ventana_Cliente;

public class Controlador_ventana_Cliente implements ActionListener,ILoginController{

	IVentanaLogin vL;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand().equalsIgnoreCase("Login"))
		{
			this.PulsoLogin();
		} 
		else if (e.getActionCommand().equalsIgnoreCase("Register")) {
			this.PulsoRegister();
		}
			
	}
	public void PulsoRegister() {
		String Us=this.vL.gettextoRLogin();
		String pass=this.vL.gettextoRPass();
		String name=this.vL.gettextoRname();
		if(Us != null && pass!= null && name!= null)
			Sistema.getInstance().agregaCliente(new Cliente(Us,pass,name));
	}
	public void PulsoLogin() {
		String Us=this.vL.gettextoLogin();
		String pass=this.vL.gettextoPass();
		Cliente b=(Cliente) Sistema.getInstance().getCliente(Us, pass);
		new Ventana_Cliente();
		if(b != null)
		{
			
		}
			
		
	}
	public IVentanaLogin getvL() {
		return vL;
	}
	public void setvL(IVentanaLogin vL) {
		this.vL = vL;
		this.vL.setActionListener(this);
	}
	@Override
	public void login(String username, String password) {
		Cliente b=(Cliente) Sistema.getInstance().getCliente(username, password);
		new Ventana_Cliente();
	} 

}

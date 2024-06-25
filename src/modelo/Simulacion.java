package modelo;

import java.util.ArrayList;
import presentacion.VentanaSim_General;
import presentacion.Ventana_mensaje;
import util.Util;
import modelo.*;
public class Simulacion {
	private ArrayList<ClienteThread> Rclientes;
	private ArrayList<ChoferThread> Rchoferes;
	private SistemaThread Threadsis;
	private RecursoCompartido rc;
	public Simulacion(ClienteThread cliente, ChoferThread chofer, SistemaThread sistema, RecursoCompartido rc) {
		super();
		this.Rclientes.add(cliente);
		this.Rchoferes.add(chofer);
		this.Threadsis = sistema;
		this.rc = rc;
	}
	
	public Simulacion() {
		super();
	}

	
	public ArrayList<ClienteThread> getRclientes() {
		return Rclientes;
	}

	public void setRclientes(ArrayList<ClienteThread> rclientes) {
		Rclientes = rclientes;
	}

	public ArrayList<ChoferThread> getRchoferes() {
		return Rchoferes;
	}

	public void setRchoferes(ArrayList<ChoferThread> rchoferes) {
		Rchoferes = rchoferes;
	}

	public SistemaThread getSistema() {
		return Threadsis;
	}
	public void setSistema(SistemaThread sistema) {
		this.Threadsis = sistema;
	}
	public RecursoCompartido getRc() {
		return rc;
	}
	public void setRc(RecursoCompartido rc) {
		this.rc = rc;
	}
	public void simular() {
		VentanaSim_General ventanagen= new VentanaSim_General();
		Ventana_mensaje ventanamsj= new Ventana_mensaje();
		Ojo ojo=new Ojo(this.rc,ventanamsj);
		
		for (ClienteThread cli:Rclientes) {
			cli.start();
		}
		SistemaThread sis= new SistemaThread(rc);
		Threadsis.start();
		for(ChoferThread chof:Rchoferes) {
			chof.start();
		}
	}
	
	public void iniciaSimulacion(RecursoCompartido rc) {
		iniciaClientes(4,rc);
		iniciaChoferes(3,4,5,rc);
		iniciaVehiculos(rc.getFlota());
		this.simular();
		
	}
	public void iniciaClientes(int cantClientes,RecursoCompartido rc) {
		String nombresC[] = { "juan","maria","jesus", "noel"};
		int i=0;
		while(i<cantClientes) {
			Cliente newcli= new Cliente(nombresC[Util.rand(3)],"root","root");
			Sistema.getInstance().agregaCliente(newcli);
			Rclientes.add(new ClienteThread(newcli,rc));
			i++;
		}
	}
	public void iniciaChoferes(int cantChofT,int cantChofP,int cantChofC,RecursoCompartido rc) {
		String nombresCh[] = { "chofer1","chofer2","chofer3", "chofer4"};
		
		int i=0;
		while (i<cantChofT) {
			ChoferTemporario chofT=new ChoferTemporario("000"+i,nombresCh[Util.rand(i)],1000,2000);
			Sistema.getInstance().agregaChofer(chofT);
			Rchoferes.add(new ChoferThread(rc,Util.rand(rc.getCantMaxViajesPorChofer()),(Chofer)chofT));
		}
		
	}
	public void iniciaVehiculos(FlotaVehiculos fv) {
		int i=0;
		while(i<fv.getCantAutos()) {
			Sistema.getInstance().agregarVehiculo(new Automovil(" 00"+i));
			i++;
		}
	}
}

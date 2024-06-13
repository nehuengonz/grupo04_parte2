package serializacion;

import java.util.ArrayList;

import modelo.Chofer;
import modelo.Cliente;
import modelo.Sistema;
import modelo.Vehiculo;
import modelo.ViajeAbstract;

public class SistemaDTO {
	private ArrayList<Chofer> choferes = new ArrayList<>();
	private ArrayList<Vehiculo> vehiculos = new ArrayList<>();
	private ArrayList<Cliente> clientes = new ArrayList<>();
	private ArrayList<ViajeAbstract> viajes = new ArrayList<>();
	
	public SistemaDTO(ArrayList<Chofer> choferes, ArrayList<Vehiculo> vehiculos, ArrayList<Cliente> clientes,
			ArrayList<ViajeAbstract> viajes) {
		super();
		this.choferes = choferes;
		this.vehiculos = vehiculos;
		this.clientes = clientes;
		this.viajes = viajes;
	}

	public ArrayList<Vehiculo> getVehiculos() {
		return vehiculos;
	}

	public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}

	public ArrayList<ViajeAbstract> getViajes() {
		return viajes;
	}

	public void setViajes(ArrayList<ViajeAbstract> viajes) {
		this.viajes = viajes;
	}

	public SistemaDTO(ArrayList<Chofer> choferes) {
		super();
		this.choferes = choferes;
	}

	public SistemaDTO() {
		super();
	}

	public ArrayList<Chofer> getChoferes() {
		return choferes;
	}

	public void setChoferes(ArrayList<Chofer> choferes) {
		this.choferes = choferes;
	}

	public String toStringVehiculos() {
		return Sistema.getInstance().toStringVehiculos();
	}
	public String toStringClientes() {
		return Sistema.getInstance().toStringClientes();
	}
	public String toStringViajes() {
		return Sistema.getInstance().toStringViajes();
	}
	public String toStringChoferes() {
		return Sistema.getInstance().toStringChoferes();
	}
}

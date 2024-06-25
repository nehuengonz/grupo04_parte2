package modelo;

import excepciones.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Clase que se encarga de todas las funcionalidades de la empresa,
 * ademas e almacenar la informacion de todos los Choferes,vehiculos,clientes y viajes
 * es la clase principal del proyecto
 * @Invariantes:
 * choferes, vehiculos, clientes y viajes siempre distintos de null.
 */
public class Sistema {

  private static Sistema instance;
  private ArrayList<Chofer> choferes = new ArrayList<>();
  private ArrayList<Vehiculo> vehiculos = new ArrayList<>();
  private ArrayList<Cliente> clientes = new ArrayList<>();
  private ArrayList<ViajeAbstract> viajes = new ArrayList<>();

  private Sistema() {
    // privado por el patron Singleton
  }

  /**
   * Siempre retorna la misma instancia o crea una si todavía no hay.
   * @invariant instancia devuelta.
   */
  public static Sistema getInstance() {
    if (instance == null) {
      instance = new Sistema(); // inizializa el sistema
    }
    return instance;
  }
  // getters
  public ArrayList<Chofer> getChoferes() { return choferes; }

  public ArrayList<Vehiculo> getVehiculos() { return vehiculos; }

  public ArrayList<Cliente> getClientes() { return clientes; }

  public ArrayList<ViajeAbstract> getViajes() { return viajes; }

  public void setChoferes(ArrayList<Chofer> choferes) { this.choferes = choferes; }
  
  public void setVehiculos(ArrayList<Vehiculo> vehiculos) { this.vehiculos = vehiculos; }
  
  public void setClientes(ArrayList<Cliente> clientes) { this.clientes = clientes; }
  
  public void setViajes(ArrayList<ViajeAbstract> viajes) { this.viajes = viajes; }

// metodos del sistema
  /**
   * Lanza PedidoInvalidoException si no es posible asignar un vehículo (aunque
   * haya vehículos de todos los tipos). Por ejemplo si el pedido tiene más de
   * 10 pasajeros (ningún vehículo puede llevar más de 10). Lanza
   * SinVehiculosDisponiblesException si la razón de rechazar el pedido es que
   * no hay vehículos del tipo necesario para satisfacer el pedido. Si hay
   * vehículos disponibles se asigna al viaje y pasa a estado 'con vehiculo'.
   * Finalmente se asigna un chofer al viaje. Si no hay choferes disponibles,
   * lanza SinChoferDisponibleException. En cambio, si hay un chofer disponible,
   * se asigna y el viaje pasa a 'iniciado'.
   * @Precondiciones:
   * pedido != null
   * @Invariantes:
   * pedido pasado como parámetro no se modifica.
   * @param pedido
   * @throws Exception
   */
  public void procesarPedido(Pedido pedido)
      throws PedidoInvalidoException, SinVehiculosDisponiblesException, SinChoferDisponibleException {
    assert pedido != null;
    
  
    Vehiculo vehiculo=this.asignarVehiculo(pedido);
    Chofer chofer = this.asignarChofer();

    ViajeAbstract viaje = FactoryViaje.getViaje(pedido, vehiculo, chofer);
    viajes.add(viaje);
    
  }

  public Vehiculo asignarVehiculo(Pedido pedido) throws PedidoInvalidoException, SinVehiculosDisponiblesException {
	  Combi combi = getCombiDisponible();
	    Automovil automovil = getAutomovilDisponible();
	    Moto moto = getMotoDisponible();
	    Vehiculo vehiculo = vehiculoConMayorPrioridad(pedido, moto, automovil, combi);
	    if(vehiculo == null) {
	      if(!pedidoValido(pedido))
	        throw new PedidoInvalidoException();
	      throw new SinVehiculosDisponiblesException();
	    }
	  return vehiculo;
  }
  public Chofer asignarChofer() throws SinChoferDisponibleException {
	  Chofer chofer = getChoferDisponible();
	    if(chofer == null) {
	      throw new SinChoferDisponibleException();
	    }
	  return chofer;
  }
  
  /**
   * @Precondiciones:
   * pedido != null
   * @Invariantes:
   * El pedido pasado como parámetro no se modifica.
   * @param pedido
   * @return
   */
  private boolean pedidoValido(Pedido pedido) {
    assert pedido != null;
    if(pedido.getCantPasajeros() > 10)
      return false;
    return pedido.getCantPasajeros() <= 4 || !pedido.isSPF();
  }

  /**
   * @Precondiciones:
   * pedido != null
   * @Postcondiciones:
   * Retorna SinVehiculosDisponiblesException si todos los vehiculos pasados son null.
   * Si no retorna el vehiculo con mayor prioridad de los 3 (puede ser null si ninguno de los vehiculos era apto para el pedido)
   * @param pedido
   * @param moto
   * @param automovil
   * @param combi
   * @return
   * @throws SinVehiculosDisponiblesException
   */
  private Vehiculo vehiculoConMayorPrioridad(Pedido pedido, Moto moto, Automovil automovil, Combi combi) throws SinVehiculosDisponiblesException {
    assert pedido != null;
    List<Vehiculo> vehiculos = new ArrayList<>();
    if(moto != null) vehiculos.add(moto);
    if(automovil != null) vehiculos.add(automovil);
    if(combi != null) vehiculos.add(combi);
    if(vehiculos.isEmpty()) {
      throw new SinVehiculosDisponiblesException();
    }
    Integer mayorPrioridad = -1;
    Vehiculo vehiculoMayorPrioridad = null;
    for(Vehiculo v : vehiculos) {
      Integer prioridad = v.getPrioridad(pedido);
      if(prioridad != null && mayorPrioridad < prioridad) {
        mayorPrioridad = prioridad;
        vehiculoMayorPrioridad = v;
      }
    }
    return vehiculoMayorPrioridad;
  }
  /**
   *este metodo no se utiliza ya que el costo del viaje es el que se utiliza de referencia para el calculo de los suedos
   *este metodo tendra mas sentido en la segunda parte cuando haya una interfas del cliente y se tenga que pagar un viaje 
   */
  public void procesarPago(Cliente cliente) {

  }

  public void guardarCalificacionChofer() {}

  /**
   * @Precondiciones:
   * viaje != null
   * @Postcondiciones:
   * chofer y vehiculo del viaje pasan al final de sus listas y quedan marcados como disponibles
   * @param viaje
   */
  public void registrarViajeFinalizado(ViajeAbstract viaje) {
    assert viaje != null;
    Chofer chofer = viaje.getChofer();
    Vehiculo vehiculo = viaje.getVehiculo();
    chofer.setOcupado(false);
    vehiculo.setDisponible(true);
    choferes.remove(chofer);
    choferes.add(chofer);
    vehiculos.remove(vehiculo);
    vehiculos.add(vehiculo);
  }

  /**
   * @Postcondiciones:
   * Retorna instancia de Combi si encuentra una disponible, si no null.
   * @return
   */
  private Combi getCombiDisponible() {
    for (Vehiculo v : vehiculos) {
      if (v.isDisponible() && v instanceof Combi)
        return (Combi)v;
    }
    return null;
  }
  /**
   * @Postcondiciones:
   * Retorna instancia de Automovil si encuentra uno disponible, si no null.
   * @return
   */
  private Automovil getAutomovilDisponible() {
    for (Vehiculo v : vehiculos) {
      if (v.isDisponible() && v instanceof Automovil)
        return (Automovil)v;
    }
    return null;
  }
  /**
   * @Postcondiciones:
   * Retorna instancia de Moto si encuentra una disponible, si no null.
   * @return
   */
  private Moto getMotoDisponible() {
    for (Vehiculo v : vehiculos) {
      if (v.isDisponible() && v instanceof Moto) 
        return (Moto)v;
    }
    return null;
  }
  /**
   * @Postcondiciones:
   * Retorna instancia de Chofer si encuentra uno disponible, si no null.
   * @return
   */
  private Chofer getChoferDisponible() {
    for (Chofer c : choferes) {
      if (!c.getOcupado())
        return c;
    }
    return null;
  }

  // Altas y bajas
  public void agregarVehiculo(Vehiculo vehiculo) { vehiculos.add(vehiculo); }
  public void sacaVehiculo(Vehiculo vehiculo) { vehiculos.remove(vehiculo); }
  public void agregaChofer(Chofer chofer) { choferes.add(chofer); }
  public void sacaChofer(Chofer chofer) { choferes.remove(chofer); }
  public void agregaCliente(Cliente cliente) { clientes.add(cliente); }
  public void sacaCliente(Cliente cliente) { clientes.remove(cliente); }
  public void agregaViaje(ViajeAbstract viaje) { viajes.add(viaje); }
  public void sacaViaje(IViaje viaje) { viajes.remove(viaje); }

  /**
   * @Postcondiciones:
   * Retorna un ArrayList ordenado de mayor a menor por costo de los viajes.
   * @Invariantes:
   * No se modifica el ArrayList original (viajes).
   * @return
   */
  public ArrayList<ViajeAbstract> listadoViajes() {
    ArrayList<ViajeAbstract> clonViajes = new ArrayList<>();
    for(IViaje viaje : viajes)
      clonViajes.add((ViajeAbstract)viaje);
    quicksort(clonViajes, 0, clonViajes.size() - 1);
    return clonViajes;
  }
  private void quicksort(ArrayList<ViajeAbstract> array, int begin, int end) {
    if(begin >= end) return;

    int partitionIndex = partition(array, begin, end);

    quicksort(array, begin, partitionIndex-1);
    quicksort(array, partitionIndex+1, end);
  }
  private int partition(ArrayList<ViajeAbstract> array, int begin, int end) {
    ViajeAbstract pivot = array.get(end);
    int i = begin-1;

    for(int j = begin; j < end; j++) {
      if(array.get(j).compareTo(pivot) > 0) {
        i++;
        swap(array, i, j);
      }
    }
    swap(array, i+1, end);
    return i+1;
  }
  private void swap(ArrayList<ViajeAbstract> array, int i, int j) {
    ViajeAbstract temp = array.get(i);
    array.set(i, array.get(j));
    array.set(j, temp);
  }

  public double getSueldoBrutoChofer(String dni) {
	  double ans=0;
	  for(Chofer chof:choferes) {
		  if(chof.getDni().equalsIgnoreCase(dni)) {
			  ans=chof.getSueldoBruto();
		  }
	  }
	  return ans;
  }
  public double getSueldoNetoChofer(String dni) {
	  double ans=0;
	  for(Chofer chof:choferes) {
		  if(chof.getDni().contains(dni)) {
			  ans=chof.getSueldoNeto();
		  }
	  }
	  return ans;
  }

  public Cliente getCliente(String username, String password){
		    assert username != null && password != null ;
		    for (Cliente cliAct : clientes) {
		        if (cliAct.getNombreUs().equals(username) && cliAct.getContrasenia().equals(password)) {
		        	 return cliAct;
		        }else {
		        	if (cliAct.getNombreUs().equals(username)) {
		        		System.out.println("contrasenia incorrecta");
		        		return null;
		        	}
		        	else
		        	{
		        		 return null;
		        	}
		        }
		    }
		    return null;
		 
}

  public ArrayList<ViajeAbstract> getViajesCliente(Cliente cliente) {
    ArrayList<ViajeAbstract> viajesCliente = new ArrayList<>();
    for(ViajeAbstract viaje : viajes) {
      Cliente auxCliente = viaje.getPedido().getCliente();
      if(auxCliente == cliente) {
        viajesCliente.add(viaje);
      }
    }
    return viajesCliente;
  }

  public void Muestrasalariomensual(Administrador admin,LocalDate date) {
	  
	  for(Chofer act:choferes) {
		  System.out.print("nombre: "+act.getNombre() +" dni: "+act.getDni());
		  System.out.println(" salario mensual "+admin.salarioMensual(act, date));
	  }
  }
 
  	public String toStringChoferes() {
	  String stChof="";
	  Iterator<Chofer> iter_Chof=getChoferes().iterator();
	  while(iter_Chof.hasNext()) {
		  stChof=stChof+((Chofer)iter_Chof.next()).toString();
		  stChof=stChof+"\n";
	  }
	  return stChof;
  	}

	  public String toStringVehiculos() {
		  String stVeh="";
		  Iterator<Vehiculo> iter_stVeh=getVehiculos().iterator();
		  while(iter_stVeh.hasNext()) {
			  stVeh=stVeh+((Vehiculo)iter_stVeh.next()).toString();
			  stVeh=stVeh+"\n";
		  }
		  return stVeh;
	  }

	
	public String toStringClientes() {
		 String stClientes="";
		  Iterator<Cliente> iter_stClientes=getClientes().iterator();
		  while(iter_stClientes.hasNext()) {
			  stClientes=stClientes+((Cliente)iter_stClientes.next()).toString();
			  stClientes=stClientes+"\n";
		  }
		return stClientes;
	}

	
	public String toStringViajes() {
		 String stViajes="";
		  Iterator<ViajeAbstract> iter_stViajes=getViajes().iterator();
		  while(iter_stViajes.hasNext()) {
			  stViajes=stViajes+((ViajeAbstract)iter_stViajes.next()).toString();
			  stViajes=stViajes+"\n";
		  }
		return stViajes;
	}
  
	  

	
}

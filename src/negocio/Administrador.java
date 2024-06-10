package negocio;

import excepciones.UsuarioRepetidoException;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * se encarga de la gestión del sistema, tanto de los choferes,vehiculos,clientes y viajes
 */
public class Administrador extends Usuario {
  private Sistema sistema;

  public Administrador(String nombreUs, String contrasenia, String nombreReal) {
    super(nombreUs, contrasenia, nombreReal);
    sistema = Sistema.getInstance();
  }

  /**
   * @Precondiciones:
   * username, password, realname != null
   * @Postcondiciones:
   * Si ya existe un usuario con ese nombre de usuario, lanza UsuarioRepetidoException.
   * Si no, se agrega el nuevo cliente al sistema.
   * @param username nombre de usuario del cliente
   * @param password contrasenia del cliente
   * @param realname nombre real del cliente
   * @throws UsuarioRepetidoException si se repite el nombre de usuario se lanza la excepcion
   */
  public void altasCliente(String username, String password, String realname)
    throws UsuarioRepetidoException {
    assert username != null && password != null && realname != null;
    ArrayList<Cliente> clientes = sistema.getClientes();
    Cliente c = new Cliente(username, password, realname);
    for (Cliente cliAct : clientes) {
        if (cliAct.getNombreUs().equals(c.getNombreUs())) {
            throw new UsuarioRepetidoException();
        }
    }
    clientes.add(c);
  }

  /**
   * @Precondiciones:
   * dni, nombre, ganancia_viaje != null
   * @Postcondiciones:
   * Se agrega el nuevo chofer al sistema.
   * @param dni dni del chofer dato necesario para buscarlo en la lista de choferes
   * @param nombre nombre del chofer
   * @param ganancia_viaje porcentaje de ganancia que recibira un chofer por viaje realizado
   */
  public void altasChoferContratado(String dni, String nombre, double ganancia_viaje) {
    assert dni != null && nombre != null;
    ChoferContratado chof = new ChoferContratado(dni,nombre,ganancia_viaje);
    sistema.agregaChofer(chof);
  }

  /**
   * @Precondiciones:
   * dni, nombre, sueldobasico, aportes != null
   * @Postcondiciones:
   * Se agrega el nuevo chofer al sistema.
   * @param dni
   * @param nombre
   * @param sueldobasico sueldo basico del chofer
   * @param aportes   porcentaje descontado al sueldo bruto del chofer
   */
  public void altasChoferPermanente(String dni,String nombre,int sueldobasico,int aportes) {
    assert dni != null && nombre != null;
    ChoferPermanente chof = new ChoferPermanente(dni,nombre,sueldobasico,aportes);
    sistema.agregaChofer(chof);
  }

  /**
   * @Precondiciones:
   * dni, nombre != null
   * @Postcondiciones:
   * Se agrega el nuevo chofer al sistema.
   * @param dni
   * @param nombre
   * @param sueldo_basico
   * @param aportes
   */
  public void altasChoferTemporario(String dni, String nombre, double sueldo_basico, double aportes) {
    assert dni != null && nombre != null;
    ChoferTemporario chof = new ChoferTemporario(dni,nombre,sueldo_basico,aportes);
    sistema.agregaChofer(chof);
  }

  /**
   * tipo debe ser el nombre del vehículo con la primera letra en mayúscula
   * Por ejemplo: Automovil, Moto, Combi.
   * @Precondiciones:
   * tipo, patente != null
   * @param tipo
   * @param patente
   */
  public void altasVehiculo(String tipo, String patente) {
    assert tipo != null && patente != null;
    sistema.agregarVehiculo(FactoryVehiculos.createVehiculo(tipo, patente));
  }

  /**
   * @Precondiciones:
   * nombreUs, newNombreUs, newPass, newName != null
   * @Postcondiciones:
   * nombreUs, contrasenia y nombreReal cambiados a los pasaedos por parámetro
   * @param nombreUs nombre de usuario actual
   * @param newNombreUs nuevo nombre de usuario
   * @param newPass nueva contrasenia
   * @param newName nuevo nombre
   */
  public void modificarCliente(String nombreUs, String newNombreUs, String newPass, String newName) {
    assert nombreUs != null && newNombreUs != null && newPass != null && newName != null;
    ArrayList<Cliente> clientes = sistema.getClientes();
    int i = 0;
    while(i < clientes.size() && !clientes.get(i).getNombreUs().equals(nombreUs))
      i++;
    if(i < clientes.size()) {
      Cliente act = clientes.get(i);
      act.setNombreUs(newNombreUs);
      act.setContrasenia(newPass);
      act.setNombreReal(newName);
    }
  }

  /**
   * @Precondiciones:
   * dni, newdni, nombre != null
   * @Postcondiciones:
   * dni y nombre de chofer cambiados a los pasados por parámetro.
   * @param dni
   * @param newdni
   * @param nombre
   */
  public void modificarChofer(String dni, String newdni,String nombre) {
    assert dni != null && newdni != null && nombre != null;
    ArrayList<Chofer> choferes = sistema.getChoferes();
    int i = 0;
    while( i < choferes.size() && !choferes.get(i).getDni().equals(dni))
      i++;
    if(i < choferes.size()) {
      Chofer act = choferes.get(i);
      act.setDni(newdni);
      act.setNombre(nombre);
    }
  }

  /**
   * @Precondiciones:
   * nropatente, newpatente != null
   * @Postcondiciones:
   * Si existe un vehiculo con ese nroPatente, nroPatente se cambia al pasado por parámetro.
   * Si no, no se cambia nada.
   * @param nropatente
   * @param newpatente
   */
  public void modificarVehiculo(String nropatente,String newpatente) {
    assert nropatente != null && newpatente != null;
    ArrayList<Vehiculo> vehiculos = sistema.getVehiculos();
    int i = 0;
    while(i < vehiculos.size() && !vehiculos.get(i).getNropatente().equals(nropatente))
        i++;
    if(i < vehiculos.size()) {
        Vehiculo act = vehiculos.get(i);
        act.setNropatente(newpatente);
    }
  }
  public Cliente consultasCliente(String usuario) {
	  Cliente res=null;
	  for(Cliente act:sistema.getClientes()) {
		  if(act.getNombreUs().contains(usuario)) {
			  res=act;
		  }
	  }
	  return res;
  }
  public Chofer consultasChofer(String dni) {
	  Chofer res=null;
	  for(Chofer act:sistema.getChoferes()) {
		  if(act.getDni().contains(dni)) {
			  res=act;
		  }
	  }
	  return res;
  }
  public Vehiculo consultasVehiculo(String patente) {
	  Vehiculo res=null;
	  for(Vehiculo act:sistema.getVehiculos()) {
		  if(act.getNropatente().contains(patente)) {
			  res=act;
		  }
	  }
	  return res;
  }

  /**
   * @return la lista de choferes
   */
  public ArrayList<Chofer> listadoChoferes() {
    ArrayList<Chofer> choferes = sistema.getChoferes();
    return choferes;
  }

  /**
   * @return la lista de clientes
   */
  public ArrayList<Cliente> listadoClientes() {
    ArrayList<Cliente> clientes = sistema.getClientes();
    return clientes;
  }

  /**
   * @return la lista de vehiculos
   */
  public ArrayList<Vehiculo> listadoVehiculos() {
    ArrayList<Vehiculo> vehiculos = sistema.getVehiculos();
    return vehiculos;
  }
  public ArrayList<ViajeAbstract> listadoViajes() {
    return sistema.listadoViajes();
  }
  public double salarioMensual(Chofer chofer,LocalDate date) {
	  double salario_mensual=0;
		  if ( chofer instanceof ChoferPermanente) {
			  salario_mensual=chofer.getSueldoBruto();  
			  }
			  else if (chofer instanceof ChoferTemporario) {
				  ChoferTemporario t=(ChoferTemporario)chofer;
				  t.setCant_viajes(date);
				  salario_mensual=t.getSueldoBruto();
			  }else if (chofer instanceof ChoferContratado) {
					  ChoferContratado c=(ChoferContratado) chofer;
					  salario_mensual= c.getSueldoBruto(date);
				  }
	  return salario_mensual;
  }
  
  public double dineroNecesario(LocalDate date) {
	  double totcash=0;
	  for(Chofer act:sistema.getChoferes()) {
		  if ( act instanceof ChoferPermanente) {
			totcash+=act.getSueldoBruto();  
		  }
		  else if (act instanceof ChoferTemporario) {
			  ChoferTemporario t=(ChoferTemporario)act;
			  t.setCant_viajes(date);
			  totcash+=t.getSueldoBruto();
		  }else if (act instanceof ChoferContratado) {
				  ChoferContratado c=(ChoferContratado) act;
					  totcash+= c.getSueldoBruto(date);
			  }
		  }
	  return totcash;
  }
}

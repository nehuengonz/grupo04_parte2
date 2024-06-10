package negocio;

/**
 * patron Facotory aplicado para el viaje, 
 * este se utiliza al crear el viaje correcto cuando se realiza el pedido
 * ademas de decorarlo con el costo del baul y el costo de llevar mascota
 */
public class FactoryViaje {

	/**
	 * Precondiciones:
	 * pedido, vehiculo y chofer != null.
	 * Postcondiciones:
	 * Retorna un viaje creado a partir del pedido y con el vehiculo y el chofer asignados
	 * El vehiculo y el chofer pasan a estar ocupados.
 	 * @param pedido
	 * @param vehiculo
	 * @param chofer
	 * @return IViaje
	 */
	public static ViajeAbstract getViaje(Pedido pedido, Vehiculo vehiculo, Chofer chofer) {
		assert pedido != null;
		assert vehiculo != null;
		assert chofer != null;
		ViajeAbstract respuesta = null;
		ViajeAbstract encapsulado = null;
		ViajeAbstract capa1 = null;

		vehiculo.setDisponible(false);
		chofer.setOcupado(true);

		encapsulado = fromZona(pedido, vehiculo, chofer);

		if (encapsulado != null)
		{
			//se decora el viaje con el baul y la mascota si hace falta
			if (pedido.getUsaBaul()) capa1 = new ViajeConBaul(encapsulado);
				else capa1 = encapsulado;

			if (pedido.isSPF()) respuesta = new ViajeConMascota(capa1);
				else respuesta = capa1;
		}
		return respuesta;
	}

	private static ViajeAbstract fromZona(Pedido pedido, Vehiculo vehiculo, Chofer chofer ) {
	  switch(pedido.getZona()) {
		  case ESTANDAR:
			  return new ViajeEstandar(pedido, vehiculo, chofer);
		  case PELIGROSA:
			  return new ViajeZonaPeligrosa(pedido, vehiculo, chofer);
		  case SIN_ASFALTAR:
		  default:
			  return new ViajeCalleSinAsfaltar(pedido, vehiculo, chofer);
	  }
	}
}

package negocio;


/**
 * patron Factory utilizado para la creacion del vehiculo,
 * esta esta implementada en la alta de vehiculo del administrador
 */
public class FactoryVehiculos {

	//crea un vehiculo dependiendo el tipo
	public static Vehiculo createVehiculo(String tipo,String patente){
		if(tipo=="Moto"){
			return new Moto(patente);
		}else if(tipo=="Automovil"){
			return new Automovil(patente);
		}else if(tipo=="Combi"){
			return new Combi(patente);
		}else{
			return null;
		}
	}
	
	
}



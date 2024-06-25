package serializacion;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilterInputStream;
import java.io.IOException;

import modelo.Sistema;
import presentacion.*;

import java.io.FileNotFoundException;
import controlador.Controlador_ventana_Login;
import modelo.*;

public class ReadXML {
private static final String SERIALIZED_FILE_NAME="choferes.xml";
	
	public static void main(String[] args) {
		
		//
		Ventana_Login vL= new Ventana_Login();
		vL.setVisible(true);
		Controlador_ventana_Login cvc=new Controlador_ventana_Login();
		cvc.setvL(vL);
		//XMLDecoder decoder=null;
		Sistema SYS =Sistema.getInstance();
		IPersistencia<Object> persistencia=new PersistenciaXML();
		try {
			persistencia.abrirInput(SERIALIZED_FILE_NAME);
			SistemaDTO sisdto=(SistemaDTO) persistencia.leer();
			//decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(SERIALIZED_FILE_NAME)));
			SYS.setChoferes(sisdto.getChoferes());
			SYS.setClientes(sisdto.getClientes());
			SYS.setVehiculos(sisdto.getVehiculos());
			SYS.setViajes(sisdto.getViajes());
			//
			persistencia.cerrarInput();
		}catch(IOException filenotfound) {
			System.out.println("ERROR:file not found");
		}
		//SistemaDTO chof_list=(SistemaDTO) decoder.readObject();
		//System.out.println(chof_list);
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//////////simulacion
		FlotaVehiculos fv=new FlotaVehiculos(2,4,3);
		RecursoCompartido rc= new RecursoCompartido(3,4,3,2,fv);
		Simulacion sim=new Simulacion();
		sim.simular();
		
		
	}
	
}

package serializacion;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDate;

import modelo.*;

import java.beans.*;
public class WriteXML {
	private static final String SERIALIZED_FILE_NAME="choferes.xml";
	
	public static void main(String[] args) {
		IPersistencia persistencia=new PersistenciaXML();
		
		Sistema SYS = Sistema.getInstance();
		ChoferContratado Chofer1 = new ChoferContratado("123456", "juan", 40);
	    ChoferContratado Chofer2 = new ChoferContratado("333333", "pablo", 40);
	    ChoferContratado Chofer3 = new ChoferContratado("111111", "pedro", 40);
	    ChoferContratado Chofer4 = new ChoferContratado("999999", "solari", 40);
	    ChoferPermanente chofer5=new ChoferPermanente("123124","persona1",100000,20);
	    ChoferTemporario chofer6=new ChoferTemporario("666666", "yo", 100000,20);
	    LocalDate l5=LocalDate.of(2000, 03, 3);
	    chofer5.setFecha_ingreso(l5);
	    SYS.agregaChofer(Chofer1);
	    SYS.agregaChofer(Chofer2);
	    SYS.agregaChofer(Chofer3);
	    SYS.agregaChofer(Chofer4);
	    SYS.agregaChofer(chofer5);
	    SYS.agregaChofer(chofer6);
		SistemaDTO chof_list=new SistemaDTO(SYS.getChoferes());
		
		
		//XMLEncoder encoder=null;
		try {
			persistencia.abrirOutput(SERIALIZED_FILE_NAME);
			//encoder=new XMLEncoder(new BufferedOutputStream(new FileOutputStream(SERIALIZED_FILE_NAME)));
			persistencia.escribir(chof_list);
			 System.out.println("archivo escrito exitosamente!!");
			persistencia.cerrarOutput();
		}catch(IOException filenotfound) {
			System.out.println("ERROR:file not found");
		}
		//encoder.writeObject(chof_list);
		
	}
}

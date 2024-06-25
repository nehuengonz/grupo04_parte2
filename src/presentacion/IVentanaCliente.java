package presentacion;

import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.Date;

import modelo.Cliente;
import modelo.Zona;

public interface IVentanaCliente {

	boolean getMascota();
	boolean getBaul();
	Zona getTipo();
	int getCantPasajeros();
	LocalDateTime getfecha();
	Cliente getcliente();
	
	void setActionListener(ActionListener actionListener);
	void setLoginListener(ILoginController listener);
}

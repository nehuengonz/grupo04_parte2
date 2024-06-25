package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public interface IVentanaLogin {
	
	String gettextoLogin();
	String gettextoPass();
	
	String gettextoRLogin();
	String gettextoRPass();
	String gettextoRname();
	//void append(String linea);
	void setActionListener(ActionListener actionListener);
	void setLoginListener(ILoginController listener);
	
}

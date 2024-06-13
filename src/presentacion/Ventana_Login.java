package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.Button;
import javax.swing.border.TitledBorder;
import javax.swing.JTabbedPane;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextArea;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class Ventana_Login extends JFrame implements IVentanaLogin, MouseListener, ActionListener {

	private JPanel contentPane;
	private JTextField textLUsuario;
	private JTextField textLpass;
	private JTextField textRUsuario;
	private JTextField textRpass;
	private JTextField textRname;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private Button button_login;
	private JPanel panel_1;
	private JLabel lblNewLabel_2;
	private Button button_register_1;
	private JLabel lblNewLabel_2_1;
	private JLabel errormsjlabel;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana_Login frame = new Ventana_Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ventana_Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 254, 306);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 202, 245);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Login", null, panel, null);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Usuario", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setLayout(null);
		
		this.lblNewLabel = new JLabel("nombre de usuario:");
		lblNewLabel.setBounds(10, 21, 101, 14);
		panel.add(lblNewLabel);
		
		textLUsuario = new JTextField();
		textLUsuario.setBounds(10, 36, 133, 20);
		panel.add(textLUsuario);
		textLUsuario.setColumns(10);
		
		this.lblNewLabel_1 = new JLabel("contrasenia:");
		lblNewLabel_1.setBounds(10, 63, 101, 14);
		panel.add(lblNewLabel_1);
		
		textLpass = new JTextField();
		textLpass.setBounds(10, 78, 133, 20);
		panel.add(textLpass);
		textLpass.setColumns(10);
		
		this.button_login = new Button("login");
		button_login.addActionListener(this);
		button_login.addMouseListener(this);
		button_login.setBounds(10, 104, 70, 22);
		panel.add(button_login);
		
		errormsjlabel = new JLabel("");
		errormsjlabel.setForeground(new Color(255, 0, 0));
		errormsjlabel.setBounds(10, 137, 101, 14);
		panel.add(errormsjlabel);
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(10, 137, 46, 14);
		panel.add(lblNewLabel_4);
		
		this.panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Usuario", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		tabbedPane.addTab("Register", null, panel_1, null);
		
		this.lblNewLabel_2 = new JLabel("nombre de usuario:");
		lblNewLabel_2.setBounds(10, 11, 101, 14);
		panel_1.add(lblNewLabel_2);
		
		textRUsuario = new JTextField();
		textRUsuario.setColumns(10);
		textRUsuario.setBounds(10, 25, 133, 20);
		panel_1.add(textRUsuario);
		
		JLabel lblNewLabel_1_1 = new JLabel("contrasenia:");
		lblNewLabel_1_1.setBounds(10, 56, 101, 14);
		panel_1.add(lblNewLabel_1_1);
		
		textRpass = new JTextField();
		textRpass.setColumns(10);
		textRpass.setBounds(10, 78, 133, 20);
		panel_1.add(textRpass);
		
		this.button_register_1 = new Button("register");
		button_register_1.setBounds(10, 149, 70, 22);
		panel_1.add(button_register_1);
		
		textRname = new JTextField();
		textRname.setColumns(10);
		textRname.setBounds(10, 123, 133, 20);
		panel_1.add(textRname);
		
		this.lblNewLabel_2_1 = new JLabel("nombre real:");
		lblNewLabel_2_1.setBounds(10, 109, 101, 14);
		panel_1.add(lblNewLabel_2_1);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setForeground(new Color(255, 0, 0));
		lblNewLabel_3.setBounds(20, 177, 123, 14);
		panel_1.add(lblNewLabel_3);
	}

	public void setActionListener(ActionListener actionListener) {
		this.button_login.addActionListener(actionListener);
		this.button_register_1.addActionListener(actionListener);
	}
	 public void setLoginListener(ILoginController listener) {
	        button_login.addActionListener(e -> listener.login(gettextoLogin(),gettextoPass()));
	   }

	 public void displayErrorMessage(String message) {
		 errormsjlabel.setText(message);
	 }
	@Override
	public String gettextoLogin() {
		
		return this.textLUsuario.getText();
	}

	@Override
	public String gettextoPass() {
		return this.textLpass.getText();
	}

	@Override
	public String gettextoRLogin() {
		return this.textRUsuario.getText();
	}

	@Override
	public String gettextoRPass() {
		return this.textRpass.getText();
	}

	@Override
	public String gettextoRname() {
		return this.textRname.getText();
	}
	public void mouseClicked(MouseEvent e) {
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	public void actionPerformed(ActionEvent e) {
	}
}

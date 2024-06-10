package presentacion;

import java.awt.EventQueue;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.border.CompoundBorder;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.Button;

public class Ventana_Cliente extends JFrame {

	private LocalDateTime date;
	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana_Cliente frame = new Ventana_Cliente();
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
	public Ventana_Cliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 64, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 414, 239);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(new CompoundBorder());
		tabbedPane.setBounds(0, 0, 414, 239);
		panel.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Pedido", null, panel_1, null);
		panel_1.setLayout(null);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Zona estandar");
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(6, 7, 95, 23);
		panel_1.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Zona Peligrosa");
		buttonGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setBounds(103, 7, 95, 23);
		panel_1.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Zona Sin Asfaltar");
		buttonGroup.add(rdbtnNewRadioButton_2);
		rdbtnNewRadioButton_2.setBounds(200, 7, 109, 23);
		panel_1.add(rdbtnNewRadioButton_2);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Viaje Con Mascota?");
		chckbxNewCheckBox.setBounds(6, 33, 119, 23);
		panel_1.add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Viaje Con Baul?");
		chckbxNewCheckBox_1.setBounds(6, 59, 109, 23);
		panel_1.add(chckbxNewCheckBox_1);
		
		date= date.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMM-dd");
		formatter=formatter.withChronology(null);
		JFormattedTextField dateform = new JFormattedTextField(date);
		
		dateform.setText(date.format(formatter));
		dateform.setToolTipText("");
		dateform.setBounds(20, 112, 95, 20);
		panel_1.add(dateform);
		
		JLabel lblNewLabel = new JLabel("Fecha:");
		lblNewLabel.setBounds(16, 89, 95, 14);
		panel_1.add(lblNewLabel);
		
		JSpinner CantPasj_spinner = new JSpinner();
		CantPasj_spinner.setModel(new SpinnerNumberModel(1, 1, 10, 1));
		CantPasj_spinner.setBounds(20, 168, 53, 30);
		panel_1.add(CantPasj_spinner);
		
		JLabel lblNewLabel_1 = new JLabel("Cantidad de Pasajeros:");
		lblNewLabel_1.setBounds(20, 143, 125, 14);
		panel_1.add(lblNewLabel_1);
		
		Button button = new Button("Realizar pedido");
		button.setBounds(280, 175, 119, 23);
		panel_1.add(button);
		
		JLabel Pedido_Invalido = new JLabel("");
		Pedido_Invalido.setBounds(280, 155, 101, 14);
		panel_1.add(Pedido_Invalido);
		
	}
}

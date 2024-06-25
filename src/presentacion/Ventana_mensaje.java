package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class Ventana_mensaje extends JFrame {

	private JPanel contentPane;
	 private JTextArea area = new JTextArea();

	/**
	 * Create the frame.
	 */
	public Ventana_mensaje() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 331, 127);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Aceptado/Rechazado");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel.setForeground(new Color(255, 128, 0));
		lblNewLabel.setBounds(10, 0, 295, 36);
		contentPane.add(lblNewLabel);
		
		this.setVisible(true);
		JTextArea textArea = new JTextArea();
		textArea.setBounds(20, 33, 265, 36);
		JScrollPane scroll=new JScrollPane(area);
		this.getContentPane().add(scroll);
		contentPane.add(textArea);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 33, 265, 36);
		contentPane.add(scrollPane);
	}
	 
    public void appendText(String arg)
    {
	    this.area.append(arg+"\n");
    }
}

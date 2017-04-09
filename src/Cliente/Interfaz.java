package Cliente;

import java.awt.Dimension;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Interfaz  extends JFrame implements WindowListener
{
	private JTextField textFIP;
	private JTextField textFPuerto;
	private JTextField textFObjetos;
	private JLabel lbPuerto;
	private JLabel lblNumObjetos;
	private Cliente client;
	
	public Interfaz()
	{
		setSize(new Dimension(301, 233));
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Server info", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(0, 0, 288, 164);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		textFIP = new JTextField();
		textFIP.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textFIP.setBounds(135, 40, 121, 20);
		panel.add(textFIP);
		textFIP.setColumns(10);
		
		textFPuerto = new JTextField();
		textFPuerto.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textFPuerto.setBounds(135, 81, 121, 20);
		panel.add(textFPuerto);
		textFPuerto.setColumns(10);
		
		textFObjetos = new JTextField();
		textFObjetos.setBounds(135, 119, 121, 20);
		panel.add(textFObjetos);
		textFObjetos.setColumns(10);
		
		JLabel lbDirIP = new JLabel("IP del servidor");
		lbDirIP.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lbDirIP.setBounds(10, 43, 95, 14);
		panel.add(lbDirIP);
		
		lbPuerto = new JLabel("Puerto del servidor");
		lbPuerto.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lbPuerto.setBounds(10, 84, 115, 17);
		panel.add(lbPuerto);
		
		lblNumObjetos = new JLabel("Numero objetos");
		lblNumObjetos.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNumObjetos.setBounds(10, 122, 100, 14);
		panel.add(lblNumObjetos);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				client.setServerIP(textFIP.getText());
				client.setPort(Integer.parseInt(textFPuerto.getText()));
				client.setNumObjetos(Integer.parseInt(textFObjetos.getText()));
			}
		});
		btnEnviar.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnEnviar.setBounds(0, 161, 288, 33);
		getContentPane().add(btnEnviar);
	}
	
	public static void main(String args[])
	{
		Interfaz interfaz = new Interfaz();
		interfaz.setVisible(true);
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}

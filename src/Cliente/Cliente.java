package Cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import com.sun.imageio.plugins.common.InputStreamAdapter;

public class Cliente {
	
	private static String IPThis;
	private static String puerto;
	private static Socket socket;
	private static String IPServer;
	
	private static int numObjetos;
	
	public Cliente(){
		
	}
	
	public static void main(String args[]) throws IOException
	{
		System.out.println("/**********************************************************/\n "
				+ "UDP CLIENT INITIALIZING \n /**********************************************************/");
		
		//Crear el host name del server
		String severHostName = "localhost";
		
		//Crear la direccion del servidor
		InetAddress serverIPAdress = null;
		
		//Crear el numero del puerto
		int serverPortNumber = 9000;
		
		//Crear el socket del cliente que se va a usar para conectarse con el servidor de UDP
		DatagramSocket clientSocket = new DatagramSocket();
		
		//Encontrar la direccion IP del servidor con el host name
		serverIPAdress = InetAddress.getByName(severHostName);
		
		System.out.println("Conectandose al servidor con direccion IP " + serverIPAdress 
				+ " por el puerto UDP " + serverPortNumber + "\n");
		
		//Enviar el objeto al servidor
		String nombre = "Arci";
		
		//Preparar el mensaje que se va a enviar
		String message = "Hola soy " + nombre + "desde el host" + InetAddress.getLocalHost();
		
		//Preparar el buffer para enviar el mensaje
		byte[] sendData = new byte[message.length()*8];
		sendData = message.getBytes();
		
		DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverIPAdress, serverPortNumber);
		clientSocket.send(sendPacket);
		
//		try {
//			socket = new Socket(IPThis,9000);
//			
//			PrintWriter out = new PrintWriter(socket.getOutputStream());
//			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//			
//		} catch (UnknownHostException e) {
//			e.printStackTrace();
//			System.out.println("La ip local esta erronea");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}

}

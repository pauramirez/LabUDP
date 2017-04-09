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
import java.time.LocalDateTime;
import java.time.format.FormatStyle;

import com.sun.imageio.plugins.common.InputStreamAdapter;

import javafx.util.converter.LocalDateTimeStringConverter;

public class Cliente {

	private static String serverIP;
	private static int port;
	private static int numObjetos;
	private static int seqNumber;

	public Cliente(){

	}

	public static void main(String args[]) throws IOException
	{
		System.out.println("/**********************************************************/\n "
				+ "UDP CLIENT INITIALIZING \n /**********************************************************/");

		//Crear el host name del server
		String severHostName = serverIP;

		//Crear la direccion del servidor
		InetAddress serverIPAdress = null;

		//Crear el numero del puerto
		int serverPortNumber = port;

		//Crear el socket del cliente que se va a usar para conectarse con el servidor de UDP
		DatagramSocket clientSocket = new DatagramSocket();

		//Encontrar la direccion IP del servidor con el host name
		serverIPAdress = InetAddress.getByName(severHostName);

		System.out.println("Conectandose al servidor con direccion IP " + serverIPAdress 
				+ " por el puerto UDP " + serverPortNumber + "\n");

		//Enviar el objeto al servidor
		String nombre = "Arci";

		//Preparar el mensaje que se va a enviar
		LocalDateTimeStringConverter tSent = new LocalDateTimeStringConverter();
		String message = "Hola soy " + nombre + " desde el host " + InetAddress.getLocalHost()
		+ "marca de tiempo " + tSent + " y numero de secuencia " + seqNumber;

		//Preparar el buffer para enviar el mensaje
		byte[] sendData = new byte[message.length()*8];
		sendData = message.getBytes();

		DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverIPAdress, serverPortNumber);
		while(numObjetos>0)
		{
			clientSocket.send(sendPacket);
		}

		seqNumber ++;
	}

	public static String getServerIP() {
		return serverIP;
	}

	public static void setServerIP(String serverIP) {
		Cliente.serverIP = serverIP;
	}

	public static int getPort() {
		return port;
	}

	public static void setPort(int port) {
		Cliente.port = port;
	}

	public static int getNumObjetos() {
		return numObjetos;
	}

	public static void setNumObjetos(int numObjetos) {
		Cliente.numObjetos = numObjetos;
	}




}

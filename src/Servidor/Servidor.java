package Servidor;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;

public class Servidor {

	public static void main(String args[])throws IOException
	{
		System.out.println("/**********************************************************/\n "
				+ "UDP SERVER INITIALIZING \n /**********************************************************/");
		
		//Declaracion del socket UDP
		DatagramSocket serverSocket = null;
		int port;
		port = 9000;
		
		//Creacion del socket UDP con puerto especifico
		serverSocket = new DatagramSocket(port);
		System.out.println("Creacion del socket del servidor en el puerto " + port);
		
		//Preparar la estructuda de los paquetes recibidos
		int dataLength = 100;
		byte[] recievedData = new byte[dataLength]; //buffer del servidor
		DatagramPacket recievePacket = new DatagramPacket(recievedData, recievedData.length);
		
		while(true)
		{
			//Esperar por los paquetes entrantes 
			System.out.println("Esperando por la llegada de nuevos mensajes por el puerto " + port +"...");
			serverSocket.receive(recievePacket);
			
			//Extraer los datos del paquete recibido
			InetAddress IPAdress = recievePacket.getAddress();	
			int clientPort = recievePacket.getPort();
			String message = new String(recievePacket.getData());
			
			//Se debe recortar el mensaje con el fin de quitarle los bytes vacios 
			message = message.trim();
			System.out.println("[UDP SERVER] El mensaje {" + message + "}. \n ");
			
			//enviar la respuesta al cliente
			byte[] sendData =new byte[1024];
			String responseMessage = "Mensaje del cliente recibido";
			sendData = responseMessage.getBytes();
			
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAdress, clientPort);
			serverSocket.send(sendPacket);
			
		}
		
	}
}

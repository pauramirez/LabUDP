package Servidor;

import java.awt.List;
import java.io.File;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;


public class Server extends Thread
{
    DatagramSocket socket;

    public Server(DatagramSocket soc)
    {
        socket = soc;
    }
    
    public void run() 
    {
        try
        {
            int dataLength = 100;
		byte[] recievedData = new byte[dataLength]; //buffer del servidor
		DatagramPacket recievePacket = new DatagramPacket(recievedData, recievedData.length);
		
		while(true)
		{
			//Esperar por los paquetes entrantes 
			
			socket.receive(recievePacket);
			
			//Extraer los datos del paquete recibido
			InetAddress IPAdress = recievePacket.getAddress();	
			int clientPort = recievePacket.getPort();
			String message = new String(recievePacket.getData());
			
			procesarClientes(socket);
			
			//Se crea el archivo de texto del cliente
			List clientText = new List();
			File arch = new File("Cliente del puerto " + clientPort + " con informacion " + clientText);
			arch.setWritable(true);
			
			//Se debe recortar el mensaje con el fin de quitarle los bytes vacios 
			message = message.trim();
                        while(!message.equals(null))
                        {
                            System.out.println("[UDP SERVER] El mensaje {" + message + "}. \n ");
                            clientText.add(message);  
                            
                            byte[] sendData =new byte[1024];
                            String responseMessage = "Mensaje del cliente recibido";
                            sendData = responseMessage.getBytes();

                            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAdress, clientPort);
                            socket.send(sendPacket);  
                        }
			
			//enviar la respuesta al cliente			
		}
            }
        catch (Exception e)
        {
            
        }
    }
	
	public static void procesarClientes(DatagramSocket socket)throws IOException
	{
		System.out.println("Procesando los pedidos entrantes");
		
	}
}
package Servidor;

import java.io.IOException;
import java.net.DatagramSocket;


public class Servidor {
	
	public static boolean listening;

	public static void main(String args[])throws IOException
	{
		System.out.println("/********************/\n "
				+ "UDP SERVER INITIALIZING \n /********************/");
		listening = true;
		
		//Declaracion del socket UDP
		DatagramSocket serverSocket;
		int port;
		port = 9090;
		
		//Creacion del socket UDP con puerto especifico
                while(listening)
                {
                    serverSocket = new DatagramSocket(port);
                    System.out.println("Creacion del socket del servidor en el puerto " + port);
                    System.out.println("Esperando por la llegada de nuevos mensajes por el puerto " + port +"...");
                    
                    new Server(serverSocket).run();
                } 
        }                
}

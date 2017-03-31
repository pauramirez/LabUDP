package Cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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
	
	public static void main(String args[])
	{
		try {
			socket = new Socket(IPThis,9000);
			
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
			System.out.println("La ip local esta erronea");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

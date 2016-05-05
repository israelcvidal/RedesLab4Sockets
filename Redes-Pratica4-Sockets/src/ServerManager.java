import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ServerManager implements Runnable{
	private Socket client;
	private Scanner in;
	private String str;

	public ServerManager(Socket c) {
		client = c;
	}
	
	//le do socket e escreve na tela.
	public void run() {
		try {
			in = new Scanner (client.getInputStream());
			while(true){
				str = in.nextLine();
				System.out.println(str);
			}				
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
	}
}

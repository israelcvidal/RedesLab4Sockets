import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class KeyboardManager implements Runnable {
	private Socket client; 
	private Scanner teclado;
	private PrintWriter out ;
	private String name;
	
	public KeyboardManager(Socket c, String n) {
		client = c;
		name = n;
		System.out.println(name + ", seja bem vindo ao chat!");

	}
	
	//le do teclado e manda pro socket
	public void run() {
		teclado = new Scanner(System.in);
		try {
			out = new PrintWriter(client.getOutputStream());
			
			while(true){
				String str = teclado.nextLine();
				out.println(name + " diz: " + str);
				out.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

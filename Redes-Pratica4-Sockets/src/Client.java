import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	public static void main (String[] args) {
		Socket skt;
		String name;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Digite o nome do cliente:");
		name = scan.next().toString();
		
		//scan.close();
		
		try {
			
			skt = new Socket("localhost", 12345);
			KeyboardManager km = new KeyboardManager(skt, name );
			ServerManager sv = new ServerManager(skt);
			
			//cria duas novas trheads. 1 para KM e outra para SM. 
			new Thread(km).start();
			new Thread(sv).start();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

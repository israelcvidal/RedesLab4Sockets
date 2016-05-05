import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

public class ClientManager implements Runnable {
	private Socket client;
	private List<Socket> socketList;
	private Scanner in;
	private String str;
	private PrintWriter out;
	
	public ClientManager(Socket c, List<Socket> sl){
		client = c;
		socketList = sl;
	}
	
	
	
	public void run() {
		int x;
		while (true){
			//escuto do socket do client e mando para todos os outros. 
			try {
				in = new Scanner (client.getInputStream());
				str = in.nextLine();
				
				for(x=0; x < socketList.size() ; x++ ){
					if(socketList.get(x) != client ){
						out = new PrintWriter(socketList.get(x).getOutputStream());
						out.println(str);
						out.flush();
					}
				}
			} catch (IOException e) {
				e.printStackTrace();	
			}
			
		}
	}
} 
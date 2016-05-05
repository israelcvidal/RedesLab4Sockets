import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
	private List<Socket> socketList = new ArrayList<Socket>();
	
	public void addSocketList(Socket s){
		socketList.add(s);
	}
	
	public List<Socket> getSocketList(){
		return socketList;
	}
	
	public static void main(String[] args) {
		ServerSocket server;
		Server servidor = new Server();
		try {
			server = new ServerSocket(12345);
			
			//o servidor 12345 aceita a conexao e cria uma thread pra o novo client
			while (true) {
				Socket client = server.accept();
				servidor.addSocketList(client);
				ClientManager newClient = new ClientManager(client, servidor.getSocketList());
				new Thread(newClient).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
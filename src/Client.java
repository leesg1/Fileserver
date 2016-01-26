import java.io.*;
import java.net.*;

class Client {
	
	public static int port;
	Client() {
		// which calls the common constructor with the GUI set to null
		this("localhost", port);
	}
	
	public Client(String string, int i) {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] argv) throws Exception {
		int port = Integer.parseInt(argv[0]);
		String sentence = "HELO text\n";
		Socket socket = new Socket("localhost", 1500);
		DataOutputStream outToServer = new DataOutputStream(socket.getOutputStream());
		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		outToServer.writeBytes(sentence + "\n");
		inFromServer.close();
		outToServer.close();
		socket.close();
	}
}
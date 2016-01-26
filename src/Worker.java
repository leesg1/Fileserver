import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.net.Socket;
import java.net.UnknownHostException;

public class Worker implements Runnable {

	public Worker(Socket socket) throws IOException, InterruptedException {
		BufferedReader inFromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String message = inFromClient.readLine();
		System.out.println("Message from client:" + message);
		Thread.sleep(1000);
		if(message.equals("HELO text\n".trim())){
			dealWithHELO(socket);
		}
		else if(message.equals("KILL_SERVICE\n".trim())){
			dealWithKill(socket);
		}
		else{
			dealWithOtherMessages();
		}
	}

	private void dealWithOtherMessages() {
		// do some stuff
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void dealWithHELO(Socket socket) throws UnknownHostException {
		System.out.println("HELO text\nIP:" + Inet4Address.getLocalHost()+"\nPort:"
			+socket.getLocalPort()+"\nStudentID:11460342\n");
	}
	
	private void dealWithKill(Socket socket) throws IOException {
		socket.close();
		ThreadPool.executor.shutdownNow();
	}

	public void run() {
	}
}
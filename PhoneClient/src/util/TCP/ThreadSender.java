package util.TCP;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Vector;

public class ThreadSender extends Thread{
	DataOutputStream		output;
	private Vector<String>	toSend;

	public ThreadSender(OutputStream output){
		this.output = new DataOutputStream(output);
		this.toSend = new Vector<>();
	}

	public ThreadSender(Socket serverSocket) throws IOException{
		this.output = new DataOutputStream(serverSocket.getOutputStream());
		this.toSend = new Vector<>();
	}

	public void send(String toSend){
		this.toSend.add(toSend);
	}

	private void send() throws IOException{
		while(!this.toSend.isEmpty()){
			this.output.write((this.toSend.get(0) + '\n').getBytes());
			this.output.flush();
			System.out.println("Client send:" + this.toSend.get(0) + '\n');
			this.toSend.remove(0);
		}
	}

	@Override
	public void run(){
		try{
			while(true){
				send();
			}
		}catch(IOException e){

		}
	}
}

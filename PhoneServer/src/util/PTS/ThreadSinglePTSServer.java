package util.PTS;

import java.io.IOException;
import java.net.Socket;
import java.util.Vector;

import util.TCP.ThreadSingleTCPServer;

public class ThreadSinglePTSServer extends ThreadSingleTCPServer{

	private String	broadcast;
	private String	toCheck;
	private String	username;

	public ThreadSinglePTSServer(Socket clientSocket) throws IOException{
		super(clientSocket);
		this.broadcast = new String();
		this.toCheck = new String();
		this.username = new String();
	}

	public String getBroadcast(){
		return broadcast;
	}

	public String getToCheck(){
		return toCheck;
	}

	public String getUsername(){
		return username;
	}

	public void setBroadcast(String broadcast){
		this.broadcast = broadcast;
	}

	public void setToCheck(String toCheck){
		this.toCheck = toCheck;
	}

	public void setUsername(String username){
		this.username = username;
	}

	protected void check(){
		// TODO: Fazer todas as checagens aqui!!!
	}

	@Override
	public void run(){
		try{
			this.threadReceiver.start();
			this.threadSender.start();
			while(clientSocket.isConnected()){
				Vector<String> received = getReceived();
				for(int index = 0; index < received.size(); index++){
					PTS pts = new PTS(received.get(index));
					switch(pts.getType()){
						case "log":
							// TODO: Isto tem que ser feito na classe Log
							if(!pts.isValue()){
								switch(pts.getPts().get(0).getType()){
									case "in":
										// TODO: Isto tem que ser feito na
										// classe In
										this.toCheck = pts.toString();// manda
																		// checar
																		// se
																		// existe
																		// esse
																		// usu�rio
																		// para
																		// poder
																		// se
																		// logar
									break;

									case "on":
										// TODO: Isto tem que ser feito na
										// classe On
										this.toCheck = pts.toString();// manda
																		// checar
																		// se
																		// existe
																		// esse
																		// usu�rio
																		// para
																		// poder
																		// se
																		// registrar
									break;

									case "off":
										// TODO: Isto tem que ser feito na
										// classe Off
										PTS ptsTemp = new PTS();
										ptsTemp.setType("log");
										ptsTemp.setValue("ok");
										if(pts.getPts().get(0).getValue()
												.equals(this.username)){
											this.threadSender.send(ptsTemp
													.toString());// TODO:
																	// Isto
																	// tem
																	// que
																	// ser
																	// feito
																	// na
																	// classe
																	// Off
																	// repassado
																	// para
																	// classe
																	// Log
																	// e
																	// repassado
																	// para
																	// esta
																	// tudo
																	// de
																	// forma
																	// semelhande
																	// como
																	// �
																	// repassado
																	// nestas
																	// classes:
																	// da
																	// ThreadSender
																	// e
																	// ThreadReceiver
																	// para
																	// ThreadSingleTCPServer
																	// e dela
																	// para
																	// ThreadTCPServer
											this.broadcast = (pts.toString());// envia
																				// broadcast
																				// do
																				// usu�rio
																				// que
																				// saiu;
										}
									break;

									default:
									break;
								}
							}
						break;
						case "call":
							// TODO: fazer de forma semelhante ao Log
					}
					check();
				}
			}
			this.threadSender.stop();
			this.threadReceiver.stop();
			close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
package tcp;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
class Ex05_Thread extends Thread{
	public static int num = 1;
	private Socket sock;
	public Ex05_Thread( Socket sock ) {
		this.sock = sock;
		start();
	}
	public void run() {
		num++;
		InputStream in;
		String readData = null;
		while(true) {
			try {
				in = sock.getInputStream();
				DataInputStream dis = new DataInputStream(in);
				readData = dis.readUTF();
				System.out.println("수신 데이터 : "+readData);
			}catch (Exception e) {
				
			}
		}
	}
}
public class Ex05_server {
	public static void main(String[] args) throws Exception{
		ServerSocket server = new ServerSocket(12345);
		//이게 블록 당한다
		while(true) {
			Socket sock = server.accept();
			new Ex05_Thread( sock );
		}
	}
}



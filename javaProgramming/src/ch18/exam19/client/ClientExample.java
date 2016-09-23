package ch18.exam19.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Reader;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Scanner;

public class ClientExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//소켓생성
		Socket socket = new Socket();
		
		try {
			//연결요청하기
			SocketAddress sa = new InetSocketAddress("192.168.0.9",5001);
			socket.connect(sa);
			System.out.println("[서버와 연결됨]");
			
			//보낼 데이터를 키보드로부터 읽기
			Scanner scanner = new Scanner(System.in);
			System.out.print("보낼 데이터 : ");
			String data = scanner.nextLine();
			
			//서버로 데이터를 보내기
			OutputStream os = socket.getOutputStream();
			byte[] sendValues = data.getBytes("UTF-8");
			os.write(sendValues);
			os.flush();
			
			//서버에서 보낸 데이터를 읽기
			InputStream is = socket.getInputStream();
			byte[] receiveValues = new byte[1024];
			int byteNum = is.read(receiveValues);
		    data = new String(receiveValues,0,byteNum,"UTF-8");
			System.out.println(data);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		//서버의 연결을 끊음
		try {
			socket.close();
		} catch (IOException e) {}
	}
}
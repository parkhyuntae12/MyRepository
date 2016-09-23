package ch18.exam20.client;

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
		//���ϻ���
		Socket socket = new Socket();
		
		try {
			//�����û�ϱ�
			SocketAddress sa = new InetSocketAddress("192.168.0.9",5001);
			socket.connect(sa);
			System.out.println("[������ �����]");
			
			//���� �����͸� Ű����κ��� �б�
			Scanner scanner = new Scanner(System.in);
			System.out.print("���� ������ : ");
			String data = scanner.nextLine();
			try{
				//������ �����͸� ������
				OutputStream os = socket.getOutputStream();
				byte[] sendValues = data.getBytes("UTF-8");
				os.write(sendValues);
				os.flush();
				
				//�������� ���� �����͸� �б�
				InputStream is = socket.getInputStream();
				byte[] receiveValues = new byte[1024];
				int byteNum = is.read(receiveValues);
			    data = new String(receiveValues,0,byteNum,"UTF-8");
				System.out.println(data);
			}catch(Exception e){
				System.out.println("[���� ������ ��������]");	
			}
		} catch (IOException e) {
			System.out.println("[���� ������ �ȵ�]");	
		}
		//������ ������ ����
		try {
			socket.close();
		} catch (IOException e) {}
		System.out.println("[Ŭ���̾�Ʈ�� ����]");	
	}
}
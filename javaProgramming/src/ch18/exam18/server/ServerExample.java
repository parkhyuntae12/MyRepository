package ch18.exam18.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerExample {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		System.out.println("���� ����");
		ServerSocket serverSocket =null;
		try {
			//������ � IP�� ������ �� �ֵ��� �� ��
			serverSocket = new ServerSocket(5001);
			
			
			
			//Ŭ���̾�Ʈ�� ������ �����ϰ� ��ſ� Socket�� ����
			for(int i=0; i<10; i++){
				System.out.println("Ŭ���̾�Ʈ�� ������ ��ٸ�");
				Socket socket = serverSocket.accept();
				
				//Ŭ���̾�Ʈ���� ���� �����͸� �ޱ� 
				InputStream is = socket.getInputStream();
				Reader reader = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(reader);
				String data = br.readLine();//�����͸� ������� ����
				
				//Ŭ���̾�Ʈ�� ���� ������
				OutputStream os = socket.getOutputStream();
				PrintStream ps = new PrintStream(os);
				ps.println("[����]"+data);
				ps.flush();
				
				//Ŭ���̾�Ʈ�� ������ ����
				socket.close();//�ش� Ŭ���̾�Ʈ���� ������ �������
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			serverSocket.close();//������ü�� ����
		} catch (IOException e) {}
		System.out.println("���� ����");
	}	
}
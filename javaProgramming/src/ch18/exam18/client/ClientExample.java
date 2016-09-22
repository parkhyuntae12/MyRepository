package ch18.exam18.client;

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
			
			//������ �����͸� ������
			OutputStream os = socket.getOutputStream();
			PrintStream ps = new PrintStream(os);
			ps.println(data);
			ps.flush();
			//�������� ���� �����͸� �б�
			InputStream is = socket.getInputStream();
			Reader reader = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(reader);
			data = br.readLine();
			System.out.println(data);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		//������ ������ ����
		try {
			socket.close();
		} catch (IOException e) {}
	}
}
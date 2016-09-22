package ch18.exam17.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerExample {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		ServerSocket serverSocket =null;
		try {
			//������ � IP�� ������ �� �ֵ��� �� ��
			serverSocket = new ServerSocket(5001);
			
			//������ Ư�� IP�� ������ �� �ֵ��� �� ��
			/*serverSocket = new ServerSocket();
			SocketAddress sa = new InetSocketAddress("192.168.0.9",5001);//IP�ּҷ� ���������� 
			serverSocket.bind(sa);*/
			
			//Ŭ���̾�Ʈ�� ������ �����ϰ� ��ſ� Socket�� ����
			for(int i=0; i<10; i++){
				System.out.println("Ŭ���̾�Ʈ�� ������ ��ٸ�");
				Socket socket = serverSocket.accept();
				
				//Ŭ���̾�Ʈ�� IP ���� ���
				String clientIP = socket.getInetAddress().getHostAddress();
				System.out.println("Ŭ���̾�Ʈ("+clientIP +")�� ������ ������");
				
				//Ŭ���̾�Ʈ�� ������ ����
				socket.close();//�ش� Ŭ���̾�Ʈ���� ������ �������
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			serverSocket.close();//������ü�� ����
		} catch (IOException e) {}
	}	
}
package ch18.exam22.client;

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
	private static Socket socket;
	private static boolean stop;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//���ϻ���
		socket = new Socket();
		
		try {
			//�����û�ϱ�
			SocketAddress sa = new InetSocketAddress("192.168.0.9+",5001);
			socket.connect(sa);
			System.out.println("[������ �����]");
			
			Thread thread = new Thread() {
				@Override
				public void run() {
				sendAndReceive();
				}
			};
			
			thread.start();

		} catch (IOException e) {
			System.out.println("[���� ������ �ȵ�]");	
		}
	}
	private static void sendAndReceive(){
		try{
			while(!stop){
				//���� �����͸� Ű����κ��� �б�
				Scanner scanner = new Scanner(System.in);
				System.out.print("��ɾ� �Է�[send or stop]: ");
				String data = scanner.nextLine();
				if(data.equals("send")){
					System.out.print("���� ������ : ");
					data = scanner.nextLine();
					
					//������ �����͸� ������
					OutputStream os = socket.getOutputStream();
					byte[] sendValues = data.getBytes("UTF-8");
					os.write(sendValues);//sendValues�� �����Ѵ� 
					os.flush();
					
					//�������� ���� �����͸� �б�
					InputStream is = socket.getInputStream();
					byte[] receiveValues = new byte[1024];
					int byteNum = is.read(receiveValues);
				    data = new String(receiveValues,0,byteNum,"UTF-8");
					System.out.println(data);
					
				}else if(data.equals("stop")){
					clientStop();
				}
			}
		}catch(Exception e){
			System.out.println("[���� ������ ��������]");	
		}
	}
	private static void clientStop(){
		//Ŭ���̾�Ʈ�� ���� ���� ��Ű��
		try{
			stop=true;//������ �ޱ� ����
			socket.close();//Ŭ���̾�Ʈ�� ���� ����
			System.out.println("[Ŭ���̾�Ʈ�� ����]");		
		}catch(Exception e){}
	}
}
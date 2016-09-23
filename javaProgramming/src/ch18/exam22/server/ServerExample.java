package ch18.exam22.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ServerExample {
	private static ServerSocket serverSocket;
	private static boolean stop;
	private static ExecutorService executorService;
	public static void main(String[] args){
		// TODO Auto-generated method stub
		System.out.println("���� ����");
		try {
			//������Ǯ ����
			executorService = Executors.newFixedThreadPool(50);
			//������ � IP�� ������ �� �ֵ��� �� ��
			serverSocket = new ServerSocket(5001);
			
			//Ŭ���̾�Ʈ�� ������ �����ϴ� �۾� ����
			Runnable runnable = new Runnable(){
				@Override
				public void run() {
					waitAndAccept();
				}
			};
			//�۾��� ������Ǯ�� �۾�Ǯ�� �ֱ�
			executorService.submit(runnable);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Scanner scanner = new Scanner(System.in);
		while(true){
				System.out.print("��ɾ� �Է� : ");
				String command = scanner.nextLine();
				if(command.equals("stop")){
				stop = true;//�۾������� ����(Ŭ���̾�Ʈ�� ���� ������ ����)
				try {
					serverSocket.close();//������ü�� ����
					executorService.shutdown();
				} catch (IOException e) {}
				System.out.println("���� ����");
				System.exit(0);//���� ���μ����� ����
				}
				}
	}	
	private static void waitAndAccept(){
		try{
			while(!stop){//�÷���(������ �����ϰ� ����)
				Socket socket = serverSocket.accept();//���ŷ Ŭ���̾�Ʈ�� ����Ǹ� ���ŷ ����
				//����� ����ϴ� ��Ű�ü(client ��ü)����
				Client client = new Client(socket);
				}
			}catch(Exception e){
				e.printStackTrace();
			 }
		}
		static class Client{//��øŬ����
			Socket socket;
		
		
			public Client(Socket socket){
				this.socket=socket;
				receive();
		}
			public void receive(){//���ν����尡 ó���ϸ� �ȵȴ�
				//Ŭ���̾�Ʈ�� �����͸� �ް� ���� �����⸦ �ϴ� �۾� ����
				Runnable runnable = new Runnable(){
					@Override
					public void run() {
						try{
							while(true){
								//Ŭ���̾�Ʈ���� ���� �����͸� �ޱ� 
								InputStream is = socket.getInputStream();
								byte[] receiveValues = new byte[1024];
								int byteNum = is.read(receiveValues);
								if(byteNum != -1){
									String data = new String(receiveValues,0,byteNum,"UTF-8");
									//Ŭ���̾�Ʈ�� ���� ������
									OutputStream os = socket.getOutputStream();
									byte[] sendValues = data.getBytes("UTF-8");
									os.write(sendValues);
									os.flush();
								}else{
									break;
								}
							 }
							}catch(IOException e){}
						//Ŭ���̾�Ʈ�� ������ ����
						try{
							socket.close();//�ش� Ŭ���̾�Ʈ���� ������ �������
						}catch(IOException e){}
					}
				};
				
				//�۾��� ������Ǯ�� �۾�que�� �ֱ�
				executorService.submit(runnable);
			}
		}
	}
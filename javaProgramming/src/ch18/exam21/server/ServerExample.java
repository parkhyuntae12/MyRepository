package ch18.exam21.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerExample {
	private static ServerSocket serverSocket;
	private static boolean stop;
	public static void main(String[] args){
		// TODO Auto-generated method stub
		System.out.println("서버 시작");
		try {
			//서버의 어떤 IP라도 접근할 수 있도록 한 것
			serverSocket = new ServerSocket(5001);
			
			//클라이언트의 연결을 수락하고 통신용 Socket을 생성
			Thread thread = new Thread(){//익명객체
				@Override
				public void run() {
					waitAndAccept();
				}
			};
			thread.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Scanner scanner = new Scanner(System.in);
		while(true){
				System.out.print("명령어 입력 : ");
				String command = scanner.nextLine();
				if(command.equals("stop")){
				stop = true;//작업스레드 중지(클라이언트의 연결 수락을 중지)
				try {
					serverSocket.close();//서버자체를 종료
				} catch (IOException e) {}
				System.out.println("서버 종료");
				System.exit(0);//서버 프로세스를 종료
				}
				}
	}	
	private static void waitAndAccept(){
		try{
			while(!stop){//플래그(스레드 안전하게 종료)
				Socket socket = serverSocket.accept();//블로킹 클라이언트와 연결되면 블로킹 해제
				try{
					//클라이언트에서 보낸 데이터를 받기 
					InputStream is = socket.getInputStream();
					byte[] receiveValues = new byte[1024];
					int byteNum = is.read(receiveValues);
					if(byteNum != -1){
						String data = new String(receiveValues,0,byteNum,"UTF-8");
						//클라이언트로 에코 보내기
						OutputStream os = socket.getOutputStream();
						byte[] sendValues = data.getBytes("UTF-8");
						os.write(sendValues);
						os.flush();
					}else{
						System.out.println("클라이언트가 정상종료됨");
					}
				
					//클라이언트의 연결을 끊음
					socket.close();//해당 클라이언트와의 연결을 끊어버림
				}catch(IOException e){
					System.out.println("클라이언트가 비정상종료됨");
				}
				}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
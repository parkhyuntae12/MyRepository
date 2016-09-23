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
		System.out.println("서버 시작");
		try {
			//스레드풀 생성
			executorService = Executors.newFixedThreadPool(50);
			//서버의 어떤 IP라도 접근할 수 있도록 한 것
			serverSocket = new ServerSocket(5001);
			
			//클라이언트의 연결을 수락하는 작업 생성
			Runnable runnable = new Runnable(){
				@Override
				public void run() {
					waitAndAccept();
				}
			};
			//작업을 스레드풀의 작업풀에 넣기
			executorService.submit(runnable);
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
					executorService.shutdown();
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
				//통신을 담당하는 통신객체(client 객체)생성
				Client client = new Client(socket);
				}
			}catch(Exception e){
				e.printStackTrace();
			 }
		}
		static class Client{//중첩클래스
			Socket socket;
		
		
			public Client(Socket socket){
				this.socket=socket;
				receive();
		}
			public void receive(){//메인스레드가 처리하면 안된다
				//클라이언트의 데이터를 받고 에코 보내기를 하는 작업 생성
				Runnable runnable = new Runnable(){
					@Override
					public void run() {
						try{
							while(true){
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
									break;
								}
							 }
							}catch(IOException e){}
						//클라이언트의 연결을 끊음
						try{
							socket.close();//해당 클라이언트와의 연결을 끊어버림
						}catch(IOException e){}
					}
				};
				
				//작업을 스레드풀의 작업que에 넣기
				executorService.submit(runnable);
			}
		}
	}
package ch12.exam13;

public class ThreadGroupExample2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread thread;
		
		thread = new Thread("t1"){
			@Override
			public void run() {
			while(true){
				System.out.println(getName()+": 실행중..");
				if(isInterrupted()) break;
			}
				System.out.println(getName()+": 종료");
			}
		};
		thread.start();
		
		thread = new Thread("t2"){
			@Override
			public void run() {
			while(true){
				System.out.println(getName()+": 실행중..");
				if(isInterrupted()) break;
			}
				System.out.println(getName()+": 종료");
			}
		};
		
		thread.start();
		
		ThreadGroup sub = new ThreadGroup("sub");
		
		thread = new Thread(sub,"t3"){
			@Override
			public void run() {
			while(true){
				System.out.println(getName()+": 실행중..");
				if(isInterrupted()) break;
			}
				System.out.println(getName()+": 종료");
			}
		};
		
		thread.start();
		
		thread = new Thread(sub,"t4"){
			@Override
			public void run() {
			while(true){
				System.out.println(getName()+": 실행중..");
				if(isInterrupted()) break;
			}
				System.out.println(getName()+": 종료");
			}
		};
		
		thread.start();
		
		try {thread.sleep(3000);} catch (InterruptedException e) {}
		sub.interrupt();
		Thread.currentThread().getThreadGroup().interrupt();// 메인을 다종료시킬때
		// new Thread("t1"){} =
		// class xxx extends thread{
		//public xxx(){
        //super("t1"); 
		//} 
	//} new xxx();//부모생성자를 t1이란 이름을 주고 만들겠다
	}
}
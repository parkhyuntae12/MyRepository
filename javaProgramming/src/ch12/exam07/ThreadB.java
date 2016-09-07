package ch12.exam07;

public class ThreadB extends Thread{
	public boolean stop = false;
	public boolean work = true;
	
	@Override
	public void run() {
		while(!stop){
			if(work){
				System.out.println("ThreadB 작업 내용");
			}else{
				Thread.yield();//실행대기상태로 보낸다 (실행대기중인 다른스레드에게 양보)
			}
		}
		System.out.println("ThreadB 종료");
	}
}
package ch12.exam07;

public class ThreadA extends Thread{
	public boolean stop = false;
	public Work work = Work.CONTINUE;
	
	@Override
	public void run() {
		while(!stop){
			if(work == Work.CONTINUE){
				System.out.println("ThreadA 작업 내용");
			}else	if(work == Work.PAUAE){
				Thread.yield();//실행대기상태로 보낸다 (실행대기중인 다른스레드에게 양보)
			}
		}
		System.out.println("ThreadA 종료");
	}
}
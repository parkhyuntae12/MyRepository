package ch12.exam07;

public class ThreadB extends Thread{
	public boolean stop = false;
	public boolean work = true;
	
	@Override
	public void run() {
		while(!stop){
			if(work){
				System.out.println("ThreadB �۾� ����");
			}else{
				Thread.yield();//��������·� ������ (���������� �ٸ������忡�� �纸)
			}
		}
		System.out.println("ThreadB ����");
	}
}
package ch12.exam07;

public class ThreadA extends Thread{
	public boolean stop = false;
	public Work work = Work.CONTINUE;
	
	@Override
	public void run() {
		while(!stop){
			if(work == Work.CONTINUE){
				System.out.println("ThreadA �۾� ����");
			}else	if(work == Work.PAUAE){
				Thread.yield();//��������·� ������ (���������� �ٸ������忡�� �纸)
			}
		}
		System.out.println("ThreadA ����");
	}
}
package testhome.test12;

public class MovieThread2 extends Thread{
	@Override
	public void run() {
		while(true){
			System.out.println("�������� ����մϴ�.");
			try{Thread.sleep(1000);}catch(InterruptedException e){}
		}
	}
}

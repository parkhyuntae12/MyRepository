package testhome.test12;

public class MovieThread1 extends Thread{
	@Override
	public void run() {
		while(true){
			System.out.println("�������� ����մϴ�.");
			if(this.isDaemon()){
				break;
			}
		} 
	}
}

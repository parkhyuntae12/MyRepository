package ch12.exam08;

public class WaitNotifyExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WorkObject shareObject = new WorkObject();
		
		Thread ThreadA = new ThreadA(shareObject);
		Thread ThreadB = new ThreadB(shareObject);
		
		ThreadA.start();
		ThreadB.start();
	}
}
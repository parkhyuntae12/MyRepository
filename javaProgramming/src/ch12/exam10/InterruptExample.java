package ch12.exam10;

public class InterruptExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	PrintThread3 pt = new PrintThread3();
	pt.start();
	
	try {Thread.sleep(3000);} catch (InterruptedException e) {}
	
	pt.interrupt();
	}
}
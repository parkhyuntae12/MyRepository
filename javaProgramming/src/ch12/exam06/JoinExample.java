package ch12.exam06;

public class JoinExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SumThread sumThread = new SumThread();
		sumThread.start();
		
		try {sumThread.join();} catch (InterruptedException e) {}
		System.out.println("1~100 �� : "+sumThread.getSum());
	}
}
package ch12.exam06;

public class JoinExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SumThread sumThread = new SumThread();
		sumThread.start();
		
		try {
			sumThread.join(); //sum스레드가 종료할때까지 메인스레드를 일시정지시킴
		} catch (InterruptedException e) {
			
		}
		System.out.println("1~100 합 : "+sumThread.getSum());
	}
}
package ch12.exam06;

public class JoinExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SumThread sumThread = new SumThread();
		sumThread.start();
		
		try {
			sumThread.join(); //sum�����尡 �����Ҷ����� ���ν����带 �Ͻ�������Ŵ
		} catch (InterruptedException e) {
			
		}
		System.out.println("1~100 �� : "+sumThread.getSum());
	}
}
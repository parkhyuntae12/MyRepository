package testhome.test12;

public class ThreadExample2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread thread = new MovieThread();
		thread.interrupt();
		thread.start();
		try{Thread.sleep(1000);}catch(InterruptedException e){}
	}
}

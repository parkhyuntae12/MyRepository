package ch12.exam01;

import java.awt.Toolkit;

public class BeepPrintExample4 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		
		Thread thread = new SoundThread();
		thread.start();
		
		for(int i=0; i<5; i++){
			System.out.println("¶ò");
			System.out.println("Ãâ·Â :"+Thread.currentThread().getName());
			try{Thread.sleep(500);}catch(Exception e){}
		}
	}
}
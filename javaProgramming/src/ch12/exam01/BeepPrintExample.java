package ch12.exam01;

import java.awt.Toolkit;

public class BeepPrintExample {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		for(int i=0; i<5; i++){
			toolkit.beep();
			System.out.println(Thread.currentThread().getName());
			Thread.sleep(500);
		}
		for(int i=0; i<5; i++){
			System.out.println("¶ò");
			System.out.println(Thread.currentThread().getName());
			Thread.sleep(500);
		}
	}
}
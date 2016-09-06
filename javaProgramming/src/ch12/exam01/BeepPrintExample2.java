package ch12.exam01;

import java.awt.Toolkit;

public class BeepPrintExample2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		
		Thread thread = new Thread(new Runnable(){
			@Override
		public void run() {
			for(int i=0; i<5; i++){
				toolkit.beep();
				System.out.println("¼Ò¸® :"+Thread.currentThread().getName());
				try{Thread.sleep(500);}catch(Exception e){}
			}
		}
		});
		thread.start();
		for(int i=0; i<5; i++){
			System.out.println("¶ò");
			System.out.println("Ãâ·Â : "+Thread.currentThread().getName());
			try{Thread.sleep(500);}catch(Exception e){}
		}
	}
}
package ch12.exam03;

public class Calculator {
	private int memory;

	public int getMemory() {
		return memory;
	}

	public synchronized void setMemory(int memory) {
		this.memory = memory;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {}
			System.out.println(Thread.currentThread().getName()+": "+this.memory);//현재이코드를 실행하는 스레드이름
	}
	
		public synchronized void method(){
			
		}
	
//	public void setMemory(int memory) {
//		synchronized(this){
//		this.memory = memory;
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {}
//			System.out.println(Thread.currentThread().getName()+": "+this.memory);//현재이코드를 실행하는 스레드이름
//		}
//		}
}
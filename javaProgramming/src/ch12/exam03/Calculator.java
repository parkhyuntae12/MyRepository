package ch12.exam03;

public class Calculator {
	private int memory;

	public int getMemory() {
		return memory;
	}

	public synchronized void setMemory(int memory) {
		this.memory = memory;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {}
			System.out.println(Thread.currentThread().getName()+": "+this.memory);//�������ڵ带 �����ϴ� �������̸�
	}
	
		public synchronized void method(){
			
		}
	
//	public void setMemory(int memory) {
//		synchronized(this){
//		this.memory = memory;
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {}
//			System.out.println(Thread.currentThread().getName()+": "+this.memory);//�������ڵ带 �����ϴ� �������̸�
//		}
//		}
}
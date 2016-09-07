package ch12.exam13;

public class ThreadGroupExample {
	public static void main(String[] args){
		
		Thread thread = Thread.currentThread();//현재 스레드객체를 리턴
		System.out.println(thread.getName()); 
		
		for(int i=0; i<10; i++){ //i는 파이널특성을 갖고있어서 외부에서 변경이안된다(i++때문에 변경)
			int count=i;			  //그래서 안에서 변수선언을 해야 한단
			Thread thread2 = new Thread() {//익명 자식객체(익명자식객체안에서 로컬변수를쓰면파이널 특성이다)
			@Override
				public void run() {
				while(true){
					System.out.println("Thread"+count+ "실행중...");
					if(isInterrupted())break;
				}
				System.out.println("Thread2"+count+" 종료");
				}	
			};
			thread2.start();
		}
		ThreadGroup mainGroup = thread.getThreadGroup();
		System.out.println(mainGroup.getName());	
		System.out.println(mainGroup.activeCount());//현재활동하고 있는 스레드 수
		
		try{Thread.sleep(1000);}catch(InterruptedException e){}
		
		mainGroup.interrupt();
		}
}
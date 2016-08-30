package ch07.exam13;

public abstract class Phone {
	String number;
	
	public abstract void ring();  //추상메소드(존재는하지만 내용은 뭔지모르고 공통된것만정의) 
										//내용은 자식클래스가 채워야된다 =재정의
				
	public void sendVoice(){
		System.out.println("음성을 전송합니다");
	}
	public void receiveVoice(){
		System.out.println("음성을 수신합니다.");
	}
}

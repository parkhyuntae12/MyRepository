package ch08.exam01;

public class Example {
	public static void  powerOn(RemoteControl rc){
		rc.turnOn();         //다형성이 이용된다 
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int max = RemoteControl.MAX_VOLUME;
		int min = RemoteControl.MIN_VOLUME; //인터페이스에서 상수는 매개변수의 값을 제공할목적으로 값을 입력한다
		
		//RemoteControl.turnOn();
		//RemoteControl.turnOff();
		//RemoteControl.setVolume(5);
		
		//RemoteControl.setMute(true);
		
		
		RemoteControl.changeBattery();
		
		
		
		//--------------------------------------------------------------------
		
		Television tv = new Television();
		tv.turnOn();
		
		RemoteControl rc = tv;
		rc.turnOn();
	
		Audio audio = new Audio();
		audio.turnOn();
		
		rc = audio;
		rc.turnOn();
		//--------------------------------------------------------------------
		
		
		powerOn(new Television());  // RemoteControl rc=new Television();
		powerOn(new Audio());
		
		
		
		
		
		
		
	}
}
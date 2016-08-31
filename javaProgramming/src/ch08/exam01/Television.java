package ch08.exam01;

public class Television implements RemoteControl{

	@Override //
	public void turnOn() {
		System.out.println("TV¸¦ ÄÕ´Ï´Ù.");
		
	}

	@Override
	public void turnOff() {
		System.out.println("TV¸¦ ²ü´Ï´Ù.");
		
	}

	@Override
	public void setVolume(int volume) {
		System.out.println("ÇöÀç TVº¼·ý : "+volume);
	}  
	
}

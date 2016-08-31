package ch08.exam03;

public class Example {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoteControl rc = new Television();
		rc.setMute(true);
		rc.setVolume(200);
		RemoteControl.changeBattery();
	}
}
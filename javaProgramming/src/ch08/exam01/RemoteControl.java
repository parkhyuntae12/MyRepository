package ch08.exam01;

public interface RemoteControl {
		//Constant
		int MAX_VOLUME = 10;
		int MIN_VOLUME=0;
		
		//Abstract Method
		void turnOn();
		void turnOff();
		void setVolume(int volume);
	
		
		//Default Method
		default void setMute(boolean mute){
			if(mute){
				System.out.println("����ó���մϴ�.");
			}else{
				System.out.println("���������մϴ�.");
			}
		}
		
		
		//Static Method
		static public void changeBattery(){
			System.out.println("�������� ��ȯ�մϴ�.");
		}
		
		
}

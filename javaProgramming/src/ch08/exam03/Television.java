package ch08.exam03;

public class Television implements RemoteControl{
	private int volume;
	
	@Override //
	public void turnOn() {
		System.out.println("TV를 켭니다.");
		
	}

	@Override
	public void turnOff() {
		System.out.println("TV를 끕니다.");
		
	}

	@Override
	public void setVolume(int volume) {
		if(volume>RemoteControl.MAX_VOLUME){// 상수에 값을 넣으면 코드 가속성이 좋아진다
			this.volume = RemoteControl.MAX_VOLUME;
		}else if(volume<RemoteControl.MIN_VOLUME){
			this.volume = RemoteControl.MIN_VOLUME;
		}else{
			this.volume=volume;
		}
		System.out.println("현재 TV볼륨 : "+this.volume);
		}  
	public int getVolume(){
		return volume;
	}
}

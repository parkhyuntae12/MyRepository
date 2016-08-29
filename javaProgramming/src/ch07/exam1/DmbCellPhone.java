package ch07.exam1;

public class DmbCellPhone extends CellPhone{ //내부중에서라도 생성자와인스턴스메소드안에서만 쓸수있다.
	//Field
	int channel;
	
	
	//Constructor
	public DmbCellPhone(String model,String color,int channel){
		this.model=model; //this=super (부모한테 물려받은 객체만) (자식내에서만 this와 super를 쓸수잇다)
		super.color=color;//this가 자식의 객체 super는 부모의 객체
		this.channel=channel;
	}
	//Method
	void turnOnDmb(){ 
		System.out.println("채널" + channel +"번 DMB 방송 수신을 시작합니다.");
		}
	void changeChannelDmb(int channel){
		System.out.println("채널" + channel);
	}
	void turnOffDmb(){}
}
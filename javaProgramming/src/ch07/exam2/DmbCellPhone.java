package ch07.exam2;

public class DmbCellPhone extends CellPhone{ //�����߿����� �����ڿ��ν��Ͻ��޼ҵ�ȿ����� �����ִ�.
	//Field
	int channel;
	
	
	//Constructor
	public DmbCellPhone(String model,String color,int channel){
		super(model,color); // �޼ҵ尡 �ƴ϶� �θ�������̴�.
		//this.model=model; //this=super (�θ����� �������� ��ü��) (�ڽĳ������� this�� super�� �����մ�)
		//super.color=color;//this�� �ڽ��� ��ü super�� �θ��� ��ü
		this.channel=channel;
	}
	//Method
	void turnOnDmb(){ 
		System.out.println("ä��" + channel +"�� DMB ��� ������ �����մϴ�.");
		}
	void changeChannelDmb(int channel){
		System.out.println("ä��" + channel);
	}
	void turnOffDmb(){}
}

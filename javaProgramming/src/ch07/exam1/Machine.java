package ch07.exam1;

public class Machine {
	//Field
	public String kind;
	public String maker;
	
	
	//Constructor
	public Machine(){
		System.out.println("Machine() �����");
	}
	
	//Method
	public void powerOn(){
		System.out.println(maker+":"+ kind + "�Ŀ���");
	}
	public void powerOff(){
		System.out.println(maker+":"+ kind + "�Ŀ�����");
	}
}
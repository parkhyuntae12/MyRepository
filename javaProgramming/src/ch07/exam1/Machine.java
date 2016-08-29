package ch07.exam1;

public class Machine {
	//Field
	public String kind;
	public String maker;
	
	
	//Constructor
	public Machine(){
		System.out.println("Machine() 실행됨");
	}
	
	//Method
	public void powerOn(){
		System.out.println(maker+":"+ kind + "파워온");
	}
	public void powerOff(){
		System.out.println(maker+":"+ kind + "파워오프");
	}
}
package ch07.exam5;

public class Machine {
	public void  work(){
		System.out.println("Machine-work()����");
	}
	public final void powerOn(){ //������ �Ұ�
		System.out.println("������ �����մϴ�.");
	}
	public final void powerOff(){
		System.out.println("������ �����ϴ�.");
	}
}
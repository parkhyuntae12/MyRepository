package ch07.exam13;

public abstract class Phone {
	String number;
	
	public abstract void ring();  //�߻�޼ҵ�(����������� ������ �����𸣰� ����Ȱ͸�����) 
										//������ �ڽ�Ŭ������ ä���ߵȴ� =������
				
	public void sendVoice(){
		System.out.println("������ �����մϴ�");
	}
	public void receiveVoice(){
		System.out.println("������ �����մϴ�.");
	}
}

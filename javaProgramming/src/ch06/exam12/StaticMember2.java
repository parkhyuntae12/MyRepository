package ch06.exam12;

public class StaticMember2 {
	//Static Field
	static String field;
	String field2;//��ü�� �־�߸� �ʱ�ȭ����
	
	
	
	//Static Block // �޼ҵ� ��� ����
	static{
		System.out.println("Static Block ����");
		field="�ڹ�";
		
	} 
	
	
	//Static Method
	static void method(){
		field="�ڹ�";
	}
	void method2(){
		field="�ڹ�";
		field2="�ڹ�";
	}
	
	public static void main(String[] args){ //������ Ŭ����������ƴϴ� ���� ���������� �߰�
		field="�ڹ�";
		method();
		
		StaticMember2 sm = new StaticMember2();
		sm.field2="�ڹ�";
		sm.method2();
	}
	
	
}

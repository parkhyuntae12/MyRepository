package ch06.exam12;

public class Example {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Instance Member ���
		InstanceMember im = new InstanceMember();
		im.field = "�ڹ�";
		im.method();  //im��ü�������ؼ� ��ü�ȿ��� �޼ҵ�ȣ��
		
		
		//Static Member ��� // Ŭ���� �̸�Ȱ��
	//	StaticMember.field="�ڹ�";
	//	StaticMember.method();
		//StaticMember sm= new StaticMember(); 
		// ��������� ���� �����ɶ� ���簡��(���������ϰ� ����)
		System.out.println(StaticMember.field);
		StaticMember.method();
	}
}
package ch07.exam6.pack1;

public class B { //��Ͼȿ��� �ʵ�,������,�޼ҵ� ���� �����ϴ�
	//Field
	A a = new A(); 
	//a= new A();<-�̰��� �����̾ƴ϶� �ʱ�ȭ(���๮)�̱⶧���� ����
	//Constructor
	B(){
		A a = new A();
		
	}
	//Method
	void method(){
		A a = new A();
	}
}
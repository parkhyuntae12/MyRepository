package ch09.exam01;

public class Example {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a = new A();
		A.B b = a.new B(); //�ν��Ͻ� Ŭ�����̱⶧���� A��ü���־�� �������� �߾Ⱦ�
		b.field1 = 10;
		b.method1();
	}
}
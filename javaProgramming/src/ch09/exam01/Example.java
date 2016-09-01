package ch09.exam01;

public class Example {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a = new A();
		A.B b = a.new B(); //인스턴스 클래스이기때문에 A객체가있어야 생성가능 잘안씀
		b.field1 = 10;
		b.method1();
	}
}
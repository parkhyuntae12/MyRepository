package ch06.exam16.pack1;

public class A { //클래스멤버라면 모두 접근제한자를 쓸수있다(생성자 안에서도 가능)
	//Field
	private int field1;
	int field2; //같은패키지안에서만 사용가능
	public int field3; //모든구역에서 사용가능(패키지 기준)
	
	//Constructor
	private A(){}
    A(int field1){}
	public A(int field1,int field2){}
	
	//Method
	private void method1(){}
	void method2(){}
	public void method3(){}
	
	
}

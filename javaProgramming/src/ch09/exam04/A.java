package ch09.exam04;

public class A {
	
	public A(){
		B b = new B();// A라는 객체가 생성된다는 가정하에 된다
	}
	void method(){ // A라는 객체가 생성된다는 가정하에 된다
		B b = new B();  
	}
	static void method2(){
		
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
	public class B{  
		int field1;
		
		void method1(){}
		
	}
}

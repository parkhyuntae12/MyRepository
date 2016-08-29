package ch07.exam6.pack1;

public class B { //블록안에는 필드,생성자,메소드 선언만 가능하다
	//Field
	A a = new A(); 
	//a= new A();<-이것은 선언문이아니라 초기화(실행문)이기때문에 에러
	//Constructor
	B(){
		A a = new A();
		
	}
	//Method
	void method(){
		A a = new A();
	}
}
package ch07.exam6.pack2;

import ch07.exam6.pack1.A;

public class D extends A{
	//Field
	//A a = new A();
	
	
	//Constructor
	D(){
//		A a =new A();
//		a.field=4;       상속x
//		a.method(); 
		super(); //protected 는 super허용가능 자식이 부모를 호출할때 
		field = 4;
		method();
	}
	//Method
	void method2(){
		field = 4;
		method();
	}
}
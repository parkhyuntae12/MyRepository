package ch07.exam6.pack2;

import ch07.exam6.pack1.A;

public class D extends A{
	//Field
	//A a = new A();
	
	
	//Constructor
	D(){
//		A a =new A();
//		a.field=4;       ���x
//		a.method(); 
		super(); //protected �� super��밡�� �ڽ��� �θ� ȣ���Ҷ� 
		field = 4;
		method();
	}
	//Method
	void method2(){
		field = 4;
		method();
	}
}
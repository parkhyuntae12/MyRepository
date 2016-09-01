package ch09.exam07;

public class A {
	int field = 5;
	
	public void method(){
		class B{
			int field =10;
			B(){
			field =20;
			this.field=30;
			A.this.field=40; //A클래스에 필드를 부르는법 A에 this라는 객체를부르는뜻
			}
		}  
		B b = new B(); 
		System.out.println("B의 필드 : " +b.field);
		System.out.println("A의 필드 : " +field);
}
}
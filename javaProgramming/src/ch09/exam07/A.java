package ch09.exam07;

public class A {
	int field = 5;
	
	public void method(){
		class B{
			int field =10;
			B(){
			field =20;
			this.field=30;
			A.this.field=40; //AŬ������ �ʵ带 �θ��¹� A�� this��� ��ü���θ��¶�
			}
		}  
		B b = new B(); 
		System.out.println("B�� �ʵ� : " +b.field);
		System.out.println("A�� �ʵ� : " +field);
}
}
package ch09.exam06;

public class A {
	int field = 10;
	public void method(){
		final int local = 10;
		class B{
			void method(){
			field=5;
			int result = local+field ; //���ú����� ����Ŭ�����ȿ��� ������ �����տ� final�� �ٿ����Ѵ�
										   //���������Ҽ����� ������ �����ϴ�.
										  //
			}
		}  
		B b = new B(); 
	
}
}
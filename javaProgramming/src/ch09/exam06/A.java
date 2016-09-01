package ch09.exam06;

public class A {
	int field = 10;
	public void method(){
		final int local = 10;
		class B{
			void method(){
			field=5;
			int result = local+field ; //로컬변수를 로컬클래스안에서 쓰려면 변수앞에 final를 붙여야한다
										   //값을변경할순없고 실행은 가능하다.
										  //
			}
		}  
		B b = new B(); 
	
}
}
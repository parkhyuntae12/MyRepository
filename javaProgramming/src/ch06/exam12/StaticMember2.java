package ch06.exam12;

public class StaticMember2 {
	//Static Field
	static String field;
	String field2;//객체가 있어야만 초기화가능
	
	
	
	//Static Block // 메소드 출력 가능
	static{
		System.out.println("Static Block 실행");
		field="자바";
		
	} 
	
	
	//Static Method
	static void method(){
		field="자바";
	}
	void method2(){
		field="자바";
		field2="자바";
	}
	
	public static void main(String[] args){ //메인은 클래스멤버가아니다 단지 실행을위해 추가
		field="자바";
		method();
		
		StaticMember2 sm = new StaticMember2();
		sm.field2="자바";
		sm.method2();
	}
	
	
}

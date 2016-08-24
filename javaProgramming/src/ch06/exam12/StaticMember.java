package ch06.exam12;

public class StaticMember {
	//Static Field
	static String field;
	//Static Block
	static{
		System.out.println("Static Block 실행");
		field="자바";
	}  //메소드 영역에 코드가 적재될때 자동실행 적재는 클래스를
	//Static Method
	static void method(){
		
	}
}

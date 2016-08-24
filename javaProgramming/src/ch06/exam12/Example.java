package ch06.exam12;

public class Example {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Instance Member 사용
		InstanceMember im = new InstanceMember();
		im.field = "자바";
		im.method();  //im객체로접근해서 객체안에서 메소드호출
		
		
		//Static Member 사용 // 클래스 이름활용
	//	StaticMember.field="자바";
	//	StaticMember.method();
		//StaticMember sm= new StaticMember(); 
		// 변수선언시 값이 지정될때 적재가됨(변수선언하고 쓸때)
		System.out.println(StaticMember.field);
		StaticMember.method();
	}
}
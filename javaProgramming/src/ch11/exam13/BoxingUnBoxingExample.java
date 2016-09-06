package ch11.exam13;

public class BoxingUnBoxingExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer obj =100; //100이라는 값을  Integer 객체로만들어서 박싱한후 obj에 번지를 대입
		int value = obj; //obj의 포장한객체의 값을 꺼낸후 value에 대입
		
		int result = obj+200;
		System.out.println(result);
	}
}
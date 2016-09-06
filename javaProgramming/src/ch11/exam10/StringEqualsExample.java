package ch11.exam10;

public class StringEqualsExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String strVar1 ="홍길동";
		String strVar2 = "홍길동";
		
		System.out.println(strVar1 == strVar2);//문자열일때 번지수 비교
		System.out.println(strVar1.equals(strVar2));//값을비교
	}
}
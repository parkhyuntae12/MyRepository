package ch11.exam03;

public class Example {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date d1 = new Date();
		String d1str = d1.toString();
		System.out.println(d1str);
		System.out.println(d1); //객체를 출력하면 객체 대표문자열이 나온다
		String result = d1+"맑음";
		
		java.util.Date d2= new java.util.Date();
		String d2Str = d2.toString();
		System.out.println(d2Str);
	}

}

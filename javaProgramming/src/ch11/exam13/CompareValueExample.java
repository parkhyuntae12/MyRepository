package ch11.exam13;

public class CompareValueExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer obj1= 500;
		Integer obj2 = 500;
		
		System.out.println(obj1==obj2);
		System.out.println(obj1.intValue() == obj2.intValue());
		System.out.println(obj1.equals(obj2));//integer로 재정의해서 값을 비교한다
		
		
		Integer obj3 = 100;
		Integer obj4 = 100;
		System.out.println(obj3==obj4);//true가나오는 것을논리적으로 설명안됨 이 연산자는 사용하지마라
		System.out.println(obj3.intValue() == obj4.intValue());
		System.out.println(obj3.equals(obj4));
	}
}
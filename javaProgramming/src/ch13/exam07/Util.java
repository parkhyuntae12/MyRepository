package ch13.exam07;

public class Util {
	public static <T extends Number>int compare(T t1,T t2){ //number를 상속하지않으면 object의 자식메소드는 다올수 있다
																				//number를 상속하면 number의 자식메소드를 사용할수있다
	double v1 = t1.doubleValue();
	double v2 = t2.doubleValue();
	/*if(v1<v2) return -1;
	else if(v1==v2) return 0;
	else return 1;*/
	
	return Double.compare(v1, v2);
	}
}
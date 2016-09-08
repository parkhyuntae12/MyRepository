package ch13.exam02;

import java.util.Date;

public class BoxExample {
	public static void main(String[] args){
		Box<String>box = new Box<>();//<> 다이아몬드 연산자 타입을적지않아도 앞에타입에맞게 자동생성
		box.setItem("홍길동");
		String name = box.getItem();
		
		Box<Integer>box2 = new Box<>();
		box2.setItem(10);
		int value = box2.getItem();
		
		Box<Date> box3 = new Box<>();
		box3.setItem(new Date());
		Date now = box3.getItem();
	}
}
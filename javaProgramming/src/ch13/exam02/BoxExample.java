package ch13.exam02;

import java.util.Date;

public class BoxExample {
	public static void main(String[] args){
		Box<String>box = new Box<>();//<> ���̾Ƹ�� ������ Ÿ���������ʾƵ� �տ�Ÿ�Կ��°� �ڵ�����
		box.setItem("ȫ�浿");
		String name = box.getItem();
		
		Box<Integer>box2 = new Box<>();
		box2.setItem(10);
		int value = box2.getItem();
		
		Box<Date> box3 = new Box<>();
		box3.setItem(new Date());
		Date now = box3.getItem();
	}
}
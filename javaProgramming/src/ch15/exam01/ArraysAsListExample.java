package ch15.exam01;

import java.util.Arrays;
import java.util.List;

public class ArraysAsListExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String>list= Arrays.asList("Java", "jdbc", "Database");
		System.out.println(list.size());
		for(String str : list){
			System.out.println(str);
		}
		//list.add("SQL");
		list.remove(1);//Arrays.asList�� ��������� ���̺����� �ȵ�.
	}
}
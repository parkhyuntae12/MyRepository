package ch15.exam02;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Set �迭 �÷��� ����
		Set <String> set = new HashSet<>();
		
		//��ü ����
		set.add("Servet/JSP");
		set.add("Java");
		set.add("JDBC");
		set.add("Java");//�����
		set.add("IBATIS");
		System.out.println(set.size());
		System.out.println();
		
		//��ü�� �ϰ� ó���ϱ�
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()){
			String str = iterator.next();
			if(str.equals("JDBC")){
				iterator.remove();
			}
			System.out.println(str); //set�ȿ��� ���� str�� ����ϴϱ� �������
		}
		System.out.println();
		
		for(String str : set){
			System.out.println(str);
		/*  if(str.equals("JDBC")){
				iterator.remove();
			}*/
		}
		System.out.println();
	}
}
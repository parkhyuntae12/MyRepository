package ch15.exam01;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//List �迭�� �÷��� ����
		List <String> list = new ArrayList<>();//<>Ÿ�Ը�ø� ��ü������ ���������� object�� �ڵ�����
		
		//��ü����
		list.add("Java");
		list.add("JDBC");
		list.add("Servlet/JSP");
		list.add(2,"Database");//2���� ����(����2���� 3������ �и�)
		list.add("iBatis");
		
		//����� ��ü�� ���
		int size = list.size();
		System.out.println("�� ��ü�� �� : "+size);
		
		//��ü ã��
		String skill = list.get(2);
		System.out.println("2 : "+skill);
		
		//��ü ��ü�� �ϰ� ó��
		for(int i=0; i<list.size(); i++){
			String str = list.get(i);
			System.out.println(i+":"+str);
		}
		System.out.println();
		
		for(String str : list){
			System.out.println(str);
		}
		System.out.println();
		//��ü ����
		list.remove(2);//��ĭ�� �����
		list.remove(2);
		list.remove("iBatis");// =new String("iBatis"));
		System.out.println(list.size());
	}
}
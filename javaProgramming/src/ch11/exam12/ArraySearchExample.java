package ch11.exam12;

import java.util.Arrays;

public class ArraySearchExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] scores = {99,97,98};
		Arrays.sort(scores);
		int index = Arrays.binarySearch(scores, 99);//������ �׸��� �˻��ؾ� �Ѵ�
		System.out.println("ã�� �ε���: " + index);
		
		String [] names ={"ȫ�浿","�ڵ���","��μ�"};
		Arrays.sort(names);
		index = Arrays.binarySearch(names, "ȫ�浿");
		System.out.println("ã���ε��� :"+ index);
		
		Member m1 = new Member("ȫ�浿");
		Member m2 = new Member("�ڵ���");
		Member m3 = new Member("��μ�");
		Member[] members = {m1,m2,m3};
		Arrays.sort(members);
		index = Arrays.binarySearch(members, m1);
		System.out.println("ã���ε��� :"+ index);
	}
}
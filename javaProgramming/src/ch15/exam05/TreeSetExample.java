package ch15.exam05;

import java.util.NavigableSet;
import java.util.TreeSet;

public class TreeSetExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeSet <Integer> scores = new TreeSet<>();
		
		scores.add(87);
		scores.add(98);
		scores.add(75);
		scores.add(95);
		scores.add(80);
		
		//����ã��
		int firstScore = scores.first();
		System.out.println(firstScore);
		System.out.println();
		
		int lastScore = scores.last();
		System.out.println(lastScore);
		System.out.println();
		
		int lowerScore = scores.lower(95); //95�ٷ� �Ʒ��� lower�� �־��� ��ü ����x
		System.out.println(lowerScore);
		System.out.println();
		
		int higherScore = scores.higher(95); //95�ٷ� ������ 
		System.out.println(higherScore);
		System.out.println();
		
		int floorScore = scores.floor(95);//floor�� �־�����ü����
		System.out.println(floorScore);
		System.out.println();
		
		int ceilingScore = scores.ceiling(95);
		System.out.println(ceilingScore);
		System.out.println();
		
		//����
		NavigableSet <Integer> descendingSet = scores.descendingSet();//����
		for(Integer score : descendingSet){
			System.out.print(score+",");
		}
		System.out.println();
		
		NavigableSet <Integer> ascendingSet = descendingSet.descendingSet();//����
		for(Integer score : ascendingSet){
			System.out.print(score+",");
		}
		System.out.println();
		
		//�����˻�
		TreeSet<String> words = new TreeSet<>(); //words �������� �����ڵ�� �˻�
		words.add("apple");
		words.add("forever");
		words.add("description");
		words.add("ever");
		words.add("zoo");
		words.add("base");
		words.add("guess");
		words.add("cherry");
		
		NavigableSet <String> ns = words.descendingSet().descendingSet();
		for(String word : ns){
			System.out.print(word+",");
		}
		System.out.println();
		
		NavigableSet <String> ns2 = words.subSet("c", true, "f", false); //c���� f�̸� "f", true�� forever�� ��¾ȵ�
		for(String word : ns2){
			System.out.print(word+",");
		}
		System.out.println();
	}
}
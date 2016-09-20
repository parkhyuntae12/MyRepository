package ch15.exam06;

import java.util.NavigableSet;
import java.util.TreeSet;

public class TreeSetExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeSet<Person> treeSet1 = new TreeSet<>();
		treeSet1.add(new Person("ȫ�浿",25));
		treeSet1.add(new Person("���ڹ�",30));
		treeSet1.add(new Person("�ڵ���",21));
		
		TreeSet<Fruit> treeSet2 = new TreeSet<>(new FruitComparator()); //��ü�񱳱���� ���� ��ü�� add�� �ɼ�����
		treeSet2.add(new Fruit("���",3000));
		treeSet2.add(new Fruit("������",5000));
		treeSet2.add(new Fruit("����",2500));
		
		//����
		NavigableSet<Person> ns1 = treeSet1.descendingSet();
		for(Person p :ns1){
			System.out.println(p);
		}
		System.out.println();
		
		NavigableSet<Fruit> ns2 = treeSet2.descendingSet();
		for(Fruit f : ns2){
			System.out.println(f);
		}
		System.out.println();
	}
}
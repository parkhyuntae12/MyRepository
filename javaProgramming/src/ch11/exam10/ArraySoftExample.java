package ch11.exam10;

import java.util.Arrays;

public class ArraySoftExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] scores ={99,97,98};
		
		Arrays.sort(scores); //sort:�������� ����
		System.out.println(Arrays.toString(scores));
		
		Member2[] members ={
				new Member2("ȫ�浿",99),
				new Member2("�ڵ���",97),
				new Member2("��μ�",98)
		};
		Arrays.sort(members);
		System.out.println(Arrays.toString(members));
	}
}	

	class Member2 implements Comparable{
		String name;
		int score;
		Member2(String name,int score){
			this.name=name;
			this.score=score;
	}
		@Override
		public int compareTo(Object o) {//compareTo
//			Member2 target = (Member2) o;
//			return target.name.compareTo(name);
			System.out.println("compareTo");
			Member2 target = (Member2) o;
			return score-target.score;
		}
		
		@Override
		public String toString() {
		return name;
		}
}
	
	
	
	
	
	
	
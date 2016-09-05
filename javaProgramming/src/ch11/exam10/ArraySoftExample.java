package ch11.exam10;

import java.util.Arrays;

public class ArraySoftExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] scores ={99,97,98};
		
		Arrays.sort(scores); //sort:¿À¸§Â÷¼ø Á¤·Ä
		System.out.println(Arrays.toString(scores));
		
		Member2[] members ={
				new Member2("È«±æµ¿",99),
				new Member2("¹Úµ¿¼ö",97),
				new Member2("±è¹Î¼ö",98)
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
	
	
	
	
	
	
	
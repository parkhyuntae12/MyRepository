package ch11.exam12;

import java.util.Arrays;

public class ArraySearchExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] scores = {99,97,98};
		Arrays.sort(scores);
		int index = Arrays.binarySearch(scores, 99);//정렬후 항목을 검색해야 한다
		System.out.println("찾은 인덱스: " + index);
		
		String [] names ={"홍길동","박동수","김민수"};
		Arrays.sort(names);
		index = Arrays.binarySearch(names, "홍길동");
		System.out.println("찾은인덱스 :"+ index);
		
		Member m1 = new Member("홍길동");
		Member m2 = new Member("박동수");
		Member m3 = new Member("김민수");
		Member[] members = {m1,m2,m3};
		Arrays.sort(members);
		index = Arrays.binarySearch(members, m1);
		System.out.println("찾은인덱스 :"+ index);
	}
}
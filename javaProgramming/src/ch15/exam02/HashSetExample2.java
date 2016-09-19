package ch15.exam02;

import java.util.HashSet;
import java.util.Set;

public class HashSetExample2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set <Member> set = new HashSet<>(); //hashcode로 동등비교를 하기때문에 hash가 붙는다
		
		Member m1 = new Member("홍길동",25);
		Member m2 = new Member("홍길동",25);
		
		System.out.println(m1==m2);
		System.out.println(m1.hashCode()==m2.hashCode());
		System.out.println(m1.equals(m2));//object equals 는 ==와 똑같다(번지비교)
		
		
		set.add(m1);
		set.add(m2);
		System.out.println(set.size());
	}
}
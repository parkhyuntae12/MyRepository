package ch15.exam02;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Set 계열 컬렉션 생성
		Set <String> set = new HashSet<>();
		
		//객체 저장
		set.add("Servet/JSP");
		set.add("Java");
		set.add("JDBC");
		set.add("Java");//덮어쓰기
		set.add("IBATIS");
		System.out.println(set.size());
		System.out.println();
		
		//객체를 일괄 처리하기
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()){
			String str = iterator.next();
			if(str.equals("JDBC")){
				iterator.remove();
			}
			System.out.println(str); //set안에서 지움 str를 출력하니까 상관없음
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
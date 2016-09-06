package ch11.exam10;

import java.util.StringTokenizer;

public class StringSplitStringTokenizer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String data = "홍길동,이수홍,박연수,감자바,최명호"; // ,으로구분된 문자열을 토큰이라한다.
		
		String[] dataArray = data.split(",");
		for(String name:dataArray){
			System.out.println(name);	
		}
		StringTokenizer st = new StringTokenizer(data,",");
		System.out.println(st.countTokens());
		while(st.hasMoreTokens()){//가지고 올 토큰이 있냐
			String name = st.nextToken();
			System.out.println(name);
		
		}
			data = "홍길동&이수홍,박연수,감자바-최명호";
			
			dataArray = data.split("&|,|-");
			System.out.println(dataArray.length);
			for(String name1 : dataArray){
				System.out.println(name1);	
			}
	}
}
package ch11.exam10;

import java.util.StringTokenizer;

public class StringSplitStringTokenizer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String data = "ȫ�浿,�̼�ȫ,�ڿ���,���ڹ�,�ָ�ȣ"; // ,���α��е� ���ڿ��� ��ū�̶��Ѵ�.
		
		String[] dataArray = data.split(",");
		for(String name:dataArray){
			System.out.println(name);	
		}
		StringTokenizer st = new StringTokenizer(data,",");
		System.out.println(st.countTokens());
		while(st.hasMoreTokens()){//������ �� ��ū�� �ֳ�
			String name = st.nextToken();
			System.out.println(name);
		
		}
			data = "ȫ�浿&�̼�ȫ,�ڿ���,���ڹ�-�ָ�ȣ";
			
			dataArray = data.split("&|,|-");
			System.out.println(dataArray.length);
			for(String name1 : dataArray){
				System.out.println(name1);	
			}
	}
}
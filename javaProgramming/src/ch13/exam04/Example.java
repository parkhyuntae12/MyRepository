package ch13.exam04;

import java.util.Date;

public class Example {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, Date>map = new HashMap<String, Date>();
		map.add("���н�", new Date());
		
		Date date = map.get("���н�");
		}
}
package ch13.exam06;

public class CompareMethodExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pair<String,String> p1 = new Pair<String,String>("name","ȫ�浿");
		Pair<String,String> p2 = new Pair<String,String>("name","�谡��");
		boolean result = Util.compare(p1,p2);
		System.out.println(result);
		//Util.compare(new Pair<String,String>("name","ȫ�浿"), new Pair<String,String>("name","�谡��"));
		
	}
}
package ch13.exam06;

public class CompareMethodExample2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pair<String,String> p1 = new Pair<String,String>("name","È«±æµ¿");
		Pair<String,String> p2 = new Pair<String,String>("name","±è°¡À»");
		Pair <String,String> result = Util.max(p1,p2);
		
		Pair<String,Integer> p3 = new Pair<String,Integer>("name",10);
		Pair<String,Integer> p4 = new Pair<String,Integer>("name",30);
		Pair <String,Integer> result2 = Util.max(p3,p4);
		
		System.out.println(result);
		//Util.compare(new Pair<String,String>("name","È«±æµ¿"), new Pair<String,String>("name","±è°¡À»"));
		
	}
}
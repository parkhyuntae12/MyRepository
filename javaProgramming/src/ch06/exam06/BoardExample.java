package ch06.exam06;

public class BoardExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Board b1 = new Board(3);
		Board b2 = new Board(1,"力格");
		Board b3 = new Board("力格",1);
		
		String s1 =new String();
		String s2 = new String("全辨悼");
		
		byte[] data ={65,66,67};
		String s3 = new String(data);
		System.out.println(s3);
		
		String s4 = new String(data,1,2);
		System.out.println(s4);
	}

}

package ch11.exam01;

public class Example {
	public static void main(String[] args){
		Board b1 = new Board(1,"title","content");
		Board b2 = new Board(1,"title","content");
		
		System.out.println(b1==b2);
		System.out.println(b1.equals(b2)); //b1을기준으로 b2와비교
	}
}

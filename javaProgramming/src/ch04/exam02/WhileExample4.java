package ch04.exam02;

public class WhileExample4 {

	public static void main(String[] args) throws Exception {
		System.out.println("���α׷� ����");
		
		int num = 0;
		
		while(num != 113) {
			num = System.in.read();
			
			if(num != 13 && num != 10) {
				System.out.println(num);
			}
		}
		
		System.out.println("���α׷� ����");
	}
	
}

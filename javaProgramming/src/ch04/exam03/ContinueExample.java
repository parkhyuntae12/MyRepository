package ch04.exam03;

public class ContinueExample {
	public static void main(String[] args) throws Exception {
		//Ű����κ��� 1(49)~3(51)������ ��ȣ �̿��� 
		//�ٸ� ��ȣ�� �ԷµǸ� �ٽ� �Է��� �ϵ��� �ϼ���.
		
		while(true) {
			int num = System.in.read();
			if(num<49 || num > 51) {
				continue;
			}
			System.out.println(num);
		}
		
	}
}

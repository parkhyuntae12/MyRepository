package ch11.exam10;

public class StringCharAtExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ssn = "010624-1230123";
		char sex = ssn.charAt(7);// ssn.charAt(x);  ssn �迭�� x��° ���ڸ� ������ٴ�
		switch(sex){
		case '1':
		case '3':
			System.out.println("����");
			break;
		case '2':
		case '4':
			System.out.println("����");
			break;
		}
	}
}
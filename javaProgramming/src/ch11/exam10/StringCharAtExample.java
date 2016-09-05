package ch11.exam10;

public class StringCharAtExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ssn = "010624-1230123";
		char sex = ssn.charAt(7);// ssn.charAt(x);  ssn 배열의 x번째 문자를 갖고오겟다
		switch(sex){
		case '1':
		case '3':
			System.out.println("남자");
			break;
		case '2':
		case '4':
			System.out.println("여자");
			break;
		}
	}
}
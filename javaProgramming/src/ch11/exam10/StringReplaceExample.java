package ch11.exam10;

public class StringReplaceExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String oldStr = "�ڹٴ� ��ü�������Դϴ�. �ڹٴ� ǳ���� API�� �����մϴ�.";
		String newStr = oldStr.replace("�ڹ�", "Java");
		System.out.println(oldStr);
		System.out.println(newStr);
		System.out.println(oldStr == newStr);
	}
}
package ch11.exam10;

public class StringToLowerUpperCaseExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String oldStr = "Java Programming";
		String newStr = oldStr.toLowerCase();//toLowerCase:소문자
		System.out.println(oldStr);
		System.out.println(newStr);
		System.out.println(oldStr == newStr);
		System.out.println("--------------------------------------------------------------------------- ");
		System.out.println(oldStr.equals("java programming"));
		System.out.println(oldStr.toLowerCase().equals("JAVA programming".toLowerCase()));
		System.out.println(oldStr.toUpperCase().equals("java programming".toUpperCase()));
		System.out.println("--------------------------------------------------------------------------- "); 
		String targetStr = "            Java        Programming                 ";
		System.out.println(oldStr == targetStr);
		System.out.println(oldStr.equals(targetStr));
		System.out.println(oldStr.equals(targetStr.trim()));//trim():앞뒤 공백을 잘라버린다
	}
}
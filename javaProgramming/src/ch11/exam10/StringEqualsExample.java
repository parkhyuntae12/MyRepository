package ch11.exam10;

public class StringEqualsExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String strVar1 ="ȫ�浿";
		String strVar2 = "ȫ�浿";
		
		System.out.println(strVar1 == strVar2);//���ڿ��϶� ������ ��
		System.out.println(strVar1.equals(strVar2));//������
	}
}
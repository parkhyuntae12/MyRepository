package ch05.exam01;

public class ValueReferenceCompare {

	public static void main(String[] args) {
		//�� ��
		int v1 = 100;
		int v2 = 100;
		System.out.println(v1 == v2);
		System.out.println(v1 != v2);

		//���� ��(��ü ��)
		String r1 = new String("�ڹ�");
		String r2 = new String("�ڹ�");
		System.out.println(r1 == r2);
		System.out.println(r1 != r2);
		
		String r3 = "�ڹ�";
		String r4 = "�ڹ�";
		System.out.println(r3 == r4);
		System.out.println(r3 != r4);
	}

}

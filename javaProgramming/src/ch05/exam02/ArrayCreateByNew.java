package ch05.exam02;

public class ArrayCreateByNew {
	public static void main(String[] args) {
		//�⺻ Ÿ�� �迭
		int[] arr1 = new int[3];
		arr1[0] = 10;
		arr1[1] = 10;
		arr1[2] = 30;
		for(int i=0; i<arr1.length; i++) {
			System.out.println("arr1[" + i + "] = " + arr1[i]);
		}
		
		System.out.println(arr1[0] == arr1[1]);
		
		//���� Ÿ�� �迭
		String[] arr4 = new String[3];
		arr4[0] = "�ڹ�";
		arr4[1] = new String("�ڹ�");
		arr4[2] = "���ѹα�";
		for(int i=0; i<arr4.length; i++) {
			System.out.println("arr4[" + i + "] = " + arr4[i]);
		}
		
		System.out.println(arr4[0].equals(arr4[1]));
	}
}

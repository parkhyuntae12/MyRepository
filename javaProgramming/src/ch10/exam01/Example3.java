package ch10.exam01;

public class Example3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	try{	
		String data1 = args[0];
			String data2 = args[1];
			
			int value = Integer.parseInt("data1");
			int value2 = Integer.parseInt("data2");
			
	
	}catch(ArrayIndexOutOfBoundsException e){
		System.out.println("�Էµ� ���� Ʋ���ϴ�.");
	}catch (NumberFormatException e ){
		System.out.println("���ڸ� �Է����� �ʾҽ��ϴ�.");
	}catch(Exception e){ // ��翹�ܸ� �����ϱ� ������ ���� ���������� �ȵ�
		System.out.println("����ó���� ��");
}
}
}
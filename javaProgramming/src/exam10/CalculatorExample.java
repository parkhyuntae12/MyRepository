package exam10;

public class CalculatorExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculator myCalcu = new Calculator();
		//���簢���� ���� ���ϱ�
		double result1 = myCalcu.areaRectangle(10);
		//���簢���� ���� ���ϱ�
		double result2 = myCalcu.areaRectangle(10,20);
		//�ﰢ���� ���� ���ϱ�
		double result3 = myCalcu.areaRectangle(10,2);
		
		//������
		System.out.println("���簢���� ���� :"+result1);
		System.out.println("���簢���� ���� :"+result2);
		System.out.println("�ﰢ���� ���� :"+result3);
	}

}

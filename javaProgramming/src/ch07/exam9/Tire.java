package ch07.exam9;

public class Tire {
	
	//�ʵ�
	public int maxRotation; //�ִ�ȸ����(Ÿ�̾� ����)
	public int accmulatedRotation; //���� ȸ����
	public String location; // Ÿ�̾��� ��ġ
	
	//������
	public Tire(String location, int maxRotation){
		this.location = location;
		this.maxRotation = maxRotation;
	}
	//�޼ҵ�
	public boolean roll(){
		++accmulatedRotation; //����ȸ���� 1���� 
		if(accmulatedRotation<maxRotation){
			System.out.println(location + "Tire ���� : "+(maxRotation-accmulatedRotation)+"ȸ");
			return true;
		}else {
			System.out.println("***"+location + "Tire ��ũ ***");
			return false;
		}
	}
}

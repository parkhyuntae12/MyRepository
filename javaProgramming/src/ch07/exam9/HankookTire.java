package ch07.exam9;

public class HankookTire extends Tire{
	public HankookTire(String location, int maxRotation){
		super(location, maxRotation);
	}
	@Override//�����Ϸ����� �˻縦 �ñ�°�
	public boolean roll(){
		++accmulatedRotation;
		if(accmulatedRotation<maxRotation){
			System.out.println(location + "HanKookTire ���� : "+(maxRotation-accmulatedRotation)+"ȸ");
			return true;
		}else{
			System.out.println("***"+location +"HanKookTire ��ũ ***" );
			return false;
		}
	}
}

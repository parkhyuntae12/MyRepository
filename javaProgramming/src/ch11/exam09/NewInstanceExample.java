package ch11.exam09;

public class NewInstanceExample {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Class clazz = Class.forName("ch11.exam09." + args[0]); //forname ��ü�������̾ȵǵ� �Էµ��������� �ε����ش�
		// ���ü�� ���ü� ������ ������� ����(���ϵ� �����) ��ü�� ���;��Ѵ�
		Object obj =clazz.newInstance(); //args[0]�� ���������� ��ü�� ������ش� ����Ʈ �����ڰ� �־���Ѵ�
		Action action = (Action) obj; //������ 
		action.execute();
		
	}

}

package testhome.test04;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//4x+5y=60�Ǹ�� �ظ� ���ؼ� (x,y)���·� ���
		int x,y=0;
		for(x=0; x<=10; x++){
			for(y=0; y<=10; y++){
				if((4*x)+(5*y)==60){
					System.out.println("("+x+","+y+")");
				}
			}
		}
	}
}
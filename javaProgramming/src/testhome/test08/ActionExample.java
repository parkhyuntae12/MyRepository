package testhome.test08;

public class ActionExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Action action = new Action(){
			@Override
			public void work() {
				System.out.println("���縦 �մϴ�.");
			}
		};
		action.work();
	}
}
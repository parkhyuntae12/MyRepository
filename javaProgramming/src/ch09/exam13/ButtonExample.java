package ch09.exam13;

public class ButtonExample {
	public static void main(String[] args){
		Button btnOk = new Button();
		
		int value = 10;
		btnOk.setOnClickListener(new Button.OnClickLsitener(){ 
			@Override
			public void onClick(){
				System.out.println("������" +value+"����մϴ�.");
			}
		} );
		btnOk.click();
	}
}

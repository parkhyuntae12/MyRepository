package ch09.exam11;

public class ButtonExample {
	public static void main(String[] args){
		Button btnOk = new Button();
		btnOk.setOnClickListener(new Button.OnClickLsitener()  { 
			@Override
			public void onClick(){
				System.out.println("������ ����մϴ�.");
			}
		} );
				
		Button btnCancel = new Button();
		btnCancel.setOnClickListener(new Button.OnClickLsitener()  { 
			@Override
			public void onClick(){
				System.out.println("������ �����մϴ�.");
			}
			
		} );
	}
	
}

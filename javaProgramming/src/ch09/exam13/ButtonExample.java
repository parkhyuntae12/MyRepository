package ch09.exam13;

public class ButtonExample {
	public static void main(String[] args){
		Button btnOk = new Button();
		
		int value = 10;
		btnOk.setOnClickListener(new Button.OnClickLsitener(){ 
			@Override
			public void onClick(){
				System.out.println("음악을" +value+"재생합니다.");
			}
		} );
		btnOk.click();
	}
}

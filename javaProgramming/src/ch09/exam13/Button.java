package ch09.exam13;

public class Button {

 public static interface OnClickLsitener{ //중첩인터페이스	
	 void onClick(); 
 }

 private 	OnClickLsitener onClickListener;
 
 public void setOnClickListener(OnClickLsitener onClickListener) {
	this.onClickListener = onClickListener;
}

public void click(){
	if(onClickListener !=null){
	onClickListener.onClick();
	}
 }
}

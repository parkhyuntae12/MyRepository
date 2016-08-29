package ch06.exam17;

public class Member {
 private String mid; //읽기만 하고 값을 변경하지 않는방법 1.final활용 2.setter생성하지않는방법
 private String mname;
 private String mpassword;
 private int mage;
 private boolean madult;
 private double mheight;
 
 public Member(String mid){
	 this.mid = mid;
 }
 public String getMid(){
	 return mid;
 }
 
 public void setMheight(double mheight){ //잘못된 값이 들어가도 검산이 가능하기 때문에 유용
	 if(mheight<0.0){
		 mheight=0.0;
	 }
	 this.mheight = mheight;
 }
 
}

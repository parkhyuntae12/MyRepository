package ch06.exam17;

public class Member {
 private String mid; //�б⸸ �ϰ� ���� �������� �ʴ¹�� 1.finalȰ�� 2.setter���������ʴ¹��
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
 
 public void setMheight(double mheight){ //�߸��� ���� ���� �˻��� �����ϱ� ������ ����
	 if(mheight<0.0){
		 mheight=0.0;
	 }
	 this.mheight = mheight;
 }
 
}

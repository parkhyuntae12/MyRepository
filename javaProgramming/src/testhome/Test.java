package testhome;

public class Test {
	//Field
	private int num; // ��ȣ
	private int score; //����
	private String name; //�̸�
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	//Constructor
	Test(){
		
	}
	Test(int num,int score, String name){
		this.num=num; 
		this.score=score;
		this.name=name;
	}
	//Method
}

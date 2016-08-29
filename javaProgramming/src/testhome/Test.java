package testhome;

public class Test {
	//Field
	private int num; // 번호
	private int score; //점수
	private String name; //이름
	
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

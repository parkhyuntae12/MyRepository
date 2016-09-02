package ch11.exam01;

public class Board {
	private int bno;
	private String title;
	private String content;
	
	
	public Board(int bno, String title, String content) {
//		super(); //object를의미
		this.bno = bno;
		this.title = title;
		this.content = content;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Board){//A instanceof B A가 B형태로 만들어졋냐
			Board target = (Board) obj; 
			if(bno == target.bno){ //bno가 private 타입이므로 외부에서 접근이 불가능하다 문법적으로는 불가능하다
										  //하지만 여기서는 같은 클래스안에서 target으로 접근을 하기때문에 가능하다고 보자
				return true;
			}
		}
			return false;
		}
}

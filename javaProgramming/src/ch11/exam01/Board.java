package ch11.exam01;

public class Board {
	private int bno;
	private String title;
	private String content;
	
	
	public Board(int bno, String title, String content) {
//		super(); //object���ǹ�
		this.bno = bno;
		this.title = title;
		this.content = content;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Board){//A instanceof B A�� B���·� ������
			Board target = (Board) obj; 
			if(bno == target.bno){ //bno�� private Ÿ���̹Ƿ� �ܺο��� ������ �Ұ����ϴ� ���������δ� �Ұ����ϴ�
										  //������ ���⼭�� ���� Ŭ�����ȿ��� target���� ������ �ϱ⶧���� �����ϴٰ� ����
				return true;
			}
		}
			return false;
		}
}

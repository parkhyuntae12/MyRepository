package testhome.test15;

import java.util.List;

public class ListExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BoardDao  dao = new BoardDao();
		List<Board1> list = dao.getBoardList();
		for(Board1 board : list){
			System.out.println(board.getTitle()+"-"+board.getContent());
		}
	}
}
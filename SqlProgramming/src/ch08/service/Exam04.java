package ch08.service;

import java.util.Date;

import ch08.dao.BoardDao;
import ch08.dto.Board;

public class Exam04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BoardDao dao = new BoardDao();
		
		Board board = new Board();
		board.setBno(1);
		board.setBtitle("제목1");
		board.setBcontent("내용1");
		board.setBwriter("user1");
		board.setBhitcount(1);
		board.setBdate(new Date());
		
		dao.insert(board);
	 }
}
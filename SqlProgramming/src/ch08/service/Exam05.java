package ch08.service;

import java.util.Date;

import ch08.dao.BoardDao;
import ch08.dto.Board;


public class Exam05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BoardDao dao = new BoardDao();
		
		Board board = new Board();
		board.setBno(2);
		board.setBtitle("제목2");
		board.setBcontent("내용2");
		board.setBwriter("user2");
		board.setBhitcount(2);
		board.setBdate(new Date());
		
		dao.update(board);
	 }
}
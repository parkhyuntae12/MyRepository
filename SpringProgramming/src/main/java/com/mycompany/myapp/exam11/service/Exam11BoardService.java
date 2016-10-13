package com.mycompany.myapp.exam11.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.exam11.dao.Exam11BoardDao;
import com.mycompany.myapp.exam11.dto.Board;

@Component("aaaa")
public class Exam11BoardService {
	//컨트롤러는 무조건 관리객체가 되야한다 서비스는@Component(의존주입이 되려면 관리객체가 되야한다)
	//다른객체에서 사용할때 주입을 받아서 사용하는게 아니라 매개값으로 넘겨주는 거라면 관리객체가 되지않아도 된다
	//관리객체는 사용이 끝나도 스프링에 계속 남아있어야 한다. 
	private static final Logger logger = LoggerFactory.getLogger(Exam11BoardService.class);
	
	@Autowired
	private Exam11BoardDao boardDao;
		
	public void write(Board board){
		logger.info("write 처리");
		boardDao.insert(board);
	}
	
	public List<Board> getList(){
		logger.info("getList 처리");
		List<Board> list = boardDao.selectList();
		return list;
	}
	
	public Board getBoard(int bno){
		logger.info("getBoard 처리");
		Board board = boardDao.selectBoard(bno);
		return board;
	}
	
	public void updateBoard(Board board){
		logger.info("updateBoard 처리");
		boardDao.update(board);
	}
	
	public void deleteBoard(int bno){
		logger.info("deleteBoard 처리");
		boardDao.delete(bno);
	}
}
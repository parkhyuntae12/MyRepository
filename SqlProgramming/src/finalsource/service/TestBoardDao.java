package finalsource.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;

import finalsource.dao.BoardDao;
import finalsource.dto.Board;
import finalsource.dto.Member;

public class TestBoardDao {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//testInsert();
		//testSelectByBno();
		//testSelectByBtitle();
		//testUpdate();
		//testDeleteByBno();
	}
		public static void testInsert(){
			Connection conn = null;
			try {
				Class.forName("oracle.jdbc.OracleDriver");
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","tester1","kosa12345");
				
				BoardDao dao = new BoardDao();
				dao.setConn(conn);
				
				Board board = new Board();
				board.setBno(4);
				board.setBtitle("제목10");
				board.setBcontent("내용10");
				board.setBwriter("user10");
				board.setBhitcount(26);
				board.setBdate(new Date());
				int rowNo = dao.insert(board);
				System.out.println(rowNo+"행이 저장됨");
			} catch (Exception e) {
				e.printStackTrace();
			  }finally{
					try{conn.close();}catch(SQLException e){}
				}
		}
		
		public static void testSelectByBno(){
			
		}
		
		
		
		
		
		
		
	
}
package finalsource.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import finalsource.dao.BoardDao;
import finalsource.dao.MemberDao;
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
		testSelectByPage(2,10);
	}
	
		public static void testSelectByPage(int pageNo, int rowsPerPage){
			Connection conn = null;
			try {
				Class.forName("oracle.jdbc.OracleDriver");
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","tester1","kosa12345");
				
				BoardDao dao = new BoardDao();
				dao.setConn(conn);
				
				List<Board> list = dao.selectByPage(pageNo,rowsPerPage);
				for(Board board : list){
					System.out.print(board.getBno()+":");
					System.out.print(board.getBtitle()+":");
					System.out.print(board.getBcontent()+":");
					System.out.print(board.getBwriter()+":");
					System.out.print(board.getBhitcount()+":");
					System.out.print(board.getBdate()+":");
					System.out.println();
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			  }finally{
					try{conn.close();}catch(SQLException e){}
				}
		}
	
		public static void testInsert(){
			Connection conn = null;
			try {
				Class.forName("oracle.jdbc.OracleDriver");
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","tester1","kosa12345");
				
				BoardDao dao = new BoardDao();
				dao.setConn(conn);
				
				Board board = new Board();
				board.setBtitle("제목10");
				board.setBcontent("내용10");
				board.setBwriter("user10");
				int rowNo = dao.insert(board);
				
			    System.out.println(rowNo+"행이 저장됨");
			} catch (Exception e) {
				e.printStackTrace();
			  }finally{
					try{conn.close();}catch(SQLException e){}
				}
		}
		
		public static void testSelectByBno(){
			Connection conn = null;
			try {
				Class.forName("oracle.jdbc.OracleDriver");
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","tester1","kosa12345");
				
				BoardDao dao = new BoardDao();
				dao.setConn(conn);
				
				Board board = dao.selectByBno(4);
				if(board !=null){
					System.out.print(board.getBno()+":");
					System.out.print(board.getBtitle()+":");
					System.out.print(board.getBcontent()+":");
					System.out.print(board.getBwriter()+":");
					System.out.print(board.getBhitcount()+":");
					System.out.print(board.getBdate()+":");
					System.out.println();
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			  }finally{
					try{conn.close();}catch(SQLException e){}
				}
		}
		
		public static void testSelectByBtitle(){
			Connection conn = null;
			try {
				Class.forName("oracle.jdbc.OracleDriver");
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","tester1","kosa12345");
				
				BoardDao dao = new BoardDao();
				dao.setConn(conn);
				
				List<Board> list = dao.selectByBtitle("제목1");
				for(Board board : list){
					System.out.print(board.getBno()+":");
					System.out.print(board.getBtitle()+":");
					System.out.print(board.getBcontent()+":");
					System.out.print(board.getBwriter()+":");
					System.out.print(board.getBhitcount()+":");
					System.out.print(board.getBdate()+":");
					System.out.println();
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			  }finally{
					try{conn.close();}catch(SQLException e){}
				}
		}
		
		public static void testUpdate(){
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
				
				int rowNo = dao.update(board);
				System.out.println(rowNo+"행이 수정됨");
				
			} catch (Exception e) {
				e.printStackTrace();
			  }finally{
					try{conn.close();}catch(SQLException e){}
				}
		}
		
		public static void testDeleteByBno(){
			Connection conn = null;
			try {
				Class.forName("oracle.jdbc.OracleDriver");
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","tester1","kosa12345");
				
				BoardDao dao = new BoardDao();
				dao.setConn(conn);
				
				int rowNo = dao.deleteByBno(4);
				System.out.println(rowNo+"행이 삭제됨");
				
			} catch (Exception e) {
				e.printStackTrace();
			  }finally{
					try{conn.close();}catch(SQLException e){}
				}
		
		}
}
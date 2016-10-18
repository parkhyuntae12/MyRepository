package ch07.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ch07.dto.Board;

public class BoardDao {

	public Board selectByBno(int bno) {
		Board board = null;
		String sql = "create table board(? number(10) not null,btitle varchar(100) not null,bcontent varchar(4000) not null,bwriter varchar(10) not null,bhitcount number(5) null,bdate date null)";
		Connection conn = null;
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","tester1","kosa12345");
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				board = new Board();
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBcontent(rs.getString("bcontent"));
			}
			rs.close();
			pstmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {conn.close();} catch (SQLException e) {}
		}
		return board;
	}

	public List<Board> selectAll() {
		List<Board> list = new ArrayList<>();
		String sql = "create table board(bno number(10) not null,btitle varchar(100) not null,bcontent varchar(4000) not null,bwriter varchar(10) not null,bhitcount number(5) null,bdate date null)";
		Connection conn =null;
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","tester1","kosa12345");
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				Board b = new Board();
				b.setBno(rs.getInt("bno"));
				b.setBtitle(rs.getString("btitle"));
				b.setBcontent(rs.getString("content"));
				list.add(b);
			}
			rs.close();
			pstmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {conn.close();} catch (SQLException e) {}
		}
		return list;
	}	
}
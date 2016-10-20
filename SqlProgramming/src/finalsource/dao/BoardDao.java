package finalsource.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import finalsource.dto.Board;

public class BoardDao {
	private Connection conn;
	
	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public int insert(Board board) throws SQLException{
		String sql = "insert into board(bno,btitle,bcontent,bwriter,bhitcount,bdate) values(seq_board_bno.nextval,?,?,?,0,sysdate)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, board.getBtitle());
		pstmt.setString(2, board.getBcontent());
		pstmt.setString(3, board.getBwriter());
		int rowNo= pstmt.executeUpdate();
		pstmt.close();
		return rowNo;
	}
	
	public Board selectByBno(int bno) throws SQLException{
		String sql="select btitle,bcontent,bwriter,bhitcount,bdate from board where bno=?";
		Board board = null;
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, bno);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()){
			board= new Board();
			//board.setBno(rs.getInt("bno"));
			board.setBtitle(rs.getString("btitle"));
			board.setBcontent(rs.getString("bcontent"));
			board.setBwriter(rs.getString("bwriter"));
			board.setBhitcount(rs.getInt("bhitcount"));
			board.setBdate(rs.getDate("bdate"));
		}
		rs.close();
		pstmt.close();
		return board;
	}
	
	public List<Board> selectByBtitle(String btitle) throws SQLException{//List 타입일때 값이 없을시 리턴타입은 빈 Member 객체가 리턴된다
		List<Board> list = new ArrayList<>();
		String sql = "select bno,bcontent,bwriter,bhitcount,bdate from board where btitle like ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, "%"+btitle+"%");
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			Board board = new Board();
			board.setBno(rs.getInt("bno"));
			//board.setBtitle(rs.getString("btitle"));
			board.setBcontent(rs.getString("bcontent"));
			board.setBwriter(rs.getString("bwriter"));
			board.setBhitcount(rs.getInt("bhitcount"));
			board.setBdate(rs.getDate("bdate"));
			list.add(board);
		}
		rs.close();
		pstmt.close();
		return list;
	}
	
	public int update(Board board) throws SQLException{//행의 수 리턴 
		String sql="update board set btitle=?,bcontent=?,bwriter=?,bhitcount=?,bdate=? where bno=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, board.getBtitle());
		pstmt.setString(2, board.getBcontent());
		pstmt.setString(3, board.getBwriter());
		pstmt.setInt(4, board.getBhitcount());
		pstmt.setDate(5, new Date(board.getBdate().getTime()));
		pstmt.setInt(6, board.getBno());
		int rowNo= pstmt.executeUpdate();
		pstmt.close();
		return rowNo;
	}
	
	public int deleteByBno(int bno) throws SQLException{//삭제할 때는 유일한 값으로 검색해서 지운다
		String sql="delete board where bno=? ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, bno);
		int rowNo = pstmt.executeUpdate();
		pstmt.close();
		return rowNo;
	}
}
package finalsource.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import finalsource.dto.Member;

public class MemberDao {
	private Connection conn; //주입받고, 하나의 연결로 트랜잭션을 처리하려고
	
	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public int insert(Member member) throws SQLException{
		String sql="insert into member(mid,mname,mpassword,mage,mbirth) values(?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, member.getMid());
		pstmt.setString(2, member.getMname());
		pstmt.setString(3, member.getMpassword());
		pstmt.setInt(4, member.getMage());
		pstmt.setDate(5, new Date(member.getMbirth().getTime()));
		int rowNo= pstmt.executeUpdate();
		pstmt.close();
		return rowNo;
	}
	
	public Member selectByMid(String mid) throws SQLException{
		String sql="select mid,mname,mpassword,mage,mbirth from member where mid=?";
		Member member = null;// 객체를 쓸 준비를 하기 위해 null 처리
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, mid);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()){
			member = new Member();
			member.setMid(rs.getString("mid"));
			member.setMname(rs.getString("mname"));
			member.setMpassword(rs.getString("mpassword"));
			member.setMage(rs.getInt("mage"));
			member.setMbirth(rs.getDate("mbirth"));
		}
		rs.close();
		pstmt.close();
		return member;
	}
	
	public List<Member> selectByMname(String mname) throws SQLException{//List 타입일때 값이 없을시 리턴타입은 빈 Member 객체가 리턴된다
		String sql="select mid,mname,mpassword,mage,mbirth from member where mname like ?";
		List<Member> list = new ArrayList<>();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, "%"+mname+"%");
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			Member member = new Member();
			member.setMid(rs.getString("mid"));
			member.setMname(rs.getString("mname"));
			member.setMpassword(rs.getString("mpassword"));
			member.setMage(rs.getInt("mage"));
			member.setMbirth(rs.getDate("mbirth"));
			list.add(member);
		}
		rs.close();
		pstmt.close();
		return list;
	}
	
	public int update(Member member) throws SQLException{//행의 수 리턴 
		String sql="update member set  mname=?,mpassword=?,mage=?,mbirth=? where mid=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, member.getMname());
		pstmt.setString(2, member.getMpassword());
		pstmt.setInt(3, member.getMage());
		pstmt.setDate(4, new Date(member.getMbirth().getTime()));
		pstmt.setString(5, member.getMid());
		int rowNo= pstmt.executeUpdate();
		pstmt.close();
		return rowNo;
	}
	
	public int deleteByMid(String mid) throws SQLException{//삭제할 때는 유일한 값으로 검색해서 지운다
		String sql="delete member where mid=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, mid);
		int rowNo = pstmt.executeUpdate();
		pstmt.close();
		return rowNo;
	}
}
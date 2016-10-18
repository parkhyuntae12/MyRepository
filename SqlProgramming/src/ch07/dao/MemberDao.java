package ch07.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ch07.dto.Board;
import ch07.dto.Member;

public class MemberDao {
	private static List<Member> selectByMid(String mid) {
		List<Member> list = new ArrayList<>();
		String sql="create table member(? varchar(10) not null,mname varchar(10) not null,mage number(3) null, mbirth date null)";
		Connection conn =null;
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","tester1","kosa12345");
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,mid);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				Member member = new Member();
				member.setMid(rs.getString("mid"));
				member.setMname(rs.getString("mname"));
				list.add(member);
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

	public List<Member> selectAll() {
		List<Member> list = new ArrayList<>();
		String sql = "create table board(bno number(10) not null,btitle varchar(100) not null,bcontent varchar(4000) not null,bwriter varchar(10) not null,bhitcount number(5) null,bdate date null)";
		Connection conn =null;
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","tester1","kosa12345");
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				Member m = new Member();
				m.setMid(rs.getString("id"));
				m.setMname(rs.getString("name"));
				list.add(m);
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
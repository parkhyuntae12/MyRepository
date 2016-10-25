package com.mycompany.myapp.exam13.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.exam13.dto.Member;


@Component
public class Exam13MemberDao {
	@Autowired//주입받겠다
	private JdbcTemplate jdbcTemplate;
	
	public int insert(Member member){
		String sql="insert into member(mid,mname,mpassword,mage,mbirth) values(?,?,?,?,?)";
		int rowNo= jdbcTemplate.update(
				sql, 
				member.getMid(),
				member.getMname(),
				member.getMpassword(),
				member.getMage(),
				member.getMbirth()
				);
		return rowNo;
	}
	
	public Member selectByMid(String mid){
		String sql="select mid,mname,mpassword,mage,mbirth from member where mid=?";
		List<Member> list = jdbcTemplate.query(
				sql,
				new Object[] {mid},
				new RowMapper<Member>(){//rowmapper를 구현한 익명 객체
					@Override
					public Member mapRow(ResultSet rs, int rowNum) throws SQLException{
						//maprow는 행의수만큼 실행하는데 rs에는 resultset의 객체가 들어온다 rowNum은 잘 사용x
						//rowNum은 현재 몇번째행의 작업이 진행되는지 나타낸다
						Member member = new Member();
						member.setMid(rs.getString("mid"));
						member.setMname(rs.getString("mname"));
						member.setMpassword(rs.getString("mpassword"));
						member.setMage(rs.getInt("mage"));
						member.setMbirth(rs.getDate("mbirth"));
						return member;
					}
				}
				);
		return(list.size()!=0)?list.get(0):null;
	}
	/*
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
	*/
}
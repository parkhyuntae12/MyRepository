package com.mycompany.myweb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mycompany.myweb.dto.Member;

@Component
public class MemberDao {
	//DAO = 실질적인 DB와의 연결을 담당하는 일을 가진 객체
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int insert(Member member){
		String sql="insert into member(mid,mname,mpassword,maddress,mtel,memail) values(?,?,?,?,?,?)";
		//jdbcTemplate 클래스의 특징
		//데이터 조회, 삽입, 수정, 삭제를 위한 SQL쿼리를 실행할 수 있다. 
		//jdbcTemplate클래스를 사용하려면 jdbcTemplate 객체를  생성할 때 DataSource를 전달해주면 된다.

		int row = jdbcTemplate.update(
				sql,
				member.getMid(),
				member.getMname(),
				member.getMpassword(),
				member.getMaddress(),
				member.getMtel(),
				member.getMemail()
	);
		return row;
}
	public int update(Member member){
		String sql="update member set mpassword=?,maddress=?,mtel=?,memail=?,where mid=?";
		int row = jdbcTemplate.update(
				sql,
				member.getMpassword(),
				member.getMaddress(),
				member.getMtel(),
				member.getMemail(),
				member.getMid()
				);
		return row;
	}
	
	public int delete(String mid){
		String sql = "delete from member where mid=?";
		int row = jdbcTemplate.update(sql,mid);
		return row;
	}
	
	public Member selectByMid(String mid){
		String sql = "select mid,mname,mpassword,maddress,mtel,memail from member where mid=?";
		List<Member> list = jdbcTemplate.query(sql, new Object[]{mid},new RowMapper<Member>(){
			//query라는 메소드에 두번쨰에 배열이 들어오는데 new를 지정해줘야함
			//Object[] arr1 = new Object[3];o
			//Object[] arr2 = {"a","b","c"};x
			// object[] arr3;
			//arr3 = new Object[]{"a","b","c"};o
			// arr3 ={"a","b","c"};x 앞에 타입이 없이 데이터를 넣을 수 없다
			@Override
			public Member mapRow(ResultSet rs, int row) throws SQLException {
				Member member = new Member();
				member.setMid(rs.getString("mid"));
				member.setMname(rs.getString("mname")); 
				member.setMpassword(rs.getString("mpassword"));
			    member.setMaddress(rs.getString("maddress"));
			    member.setMtel(rs.getString("mtel"));
			    member.setMemail(rs.getString("memail"));
			    return member;
			}
		});
		return (list.size()!=0?list.get(0):null);
	}
	
	public String selectByMemail(String memail){
		String sql = "select mid from member where memail=?";
		List<String> list = jdbcTemplate.query(sql, new Object[]{memail},new RowMapper<String>(){
			@Override
			public String mapRow(ResultSet rs, int row) throws SQLException {
				return rs.getString("mid");
			}
		});
		return (list.size()!=0)? list.get(0):null; 
	}
}
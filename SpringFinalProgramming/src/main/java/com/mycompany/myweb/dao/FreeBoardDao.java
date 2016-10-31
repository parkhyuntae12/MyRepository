package com.mycompany.myweb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mycompany.myweb.dto.FreeBoard;

@Component
public class FreeBoardDao {//스프링의 장점:의존성 관리 수월(필요할때마다 불러올수 있다 ex)@autowired),불필요한 코드가 준다(try/catch,resultset,커넥션 등등)
	//DAO = 실질적인 DB와의 연결을 담당하는 일을 가진 객체
	@Autowired
	private JdbcTemplate jdbcTemplate;//관리객체를 만들어서 주입한다
	
	public int insert(FreeBoard freeBoard){	
		String sql="insert into freeboard(bno,btitle,bcontent,bwriter,bhitcount,bdate) values(seq_freeboard_bno.nextval,?,?,?,0,sysdate)";
		int row = jdbcTemplate.update(
				sql,
				freeBoard.getBtitle(),
				freeBoard.getBcontent(),
				freeBoard.getBwriter()
				);
		return row;
	}
	
	public int update(FreeBoard freeBoard){
		String sql="update freeboard set btitle=?,bcontent=?,bhitcount=? where bno=?";
		int row = jdbcTemplate.update(
				sql,
				freeBoard.getBtitle(),
				freeBoard.getBcontent(),
				freeBoard.getBhitcount(),
				freeBoard.getBno()
				);
		return row;
	}
	
	public int delete(int bno){
		String sql="delete from freeBoard where bno=?";
		int row = jdbcTemplate.update(sql,bno);
		return row;
	}
	
	public FreeBoard selectByBno(int bno){
		String sql="select bno,btitle,bcontent,bwriter,bhitcount,bdate from freeboard where bno=?";
		List<FreeBoard> list = jdbcTemplate.query(sql, new Object[]{bno},new RowMapper<FreeBoard>(){
			@Override
			public FreeBoard mapRow(ResultSet rs, int row) throws SQLException {
				FreeBoard freeBoard = new FreeBoard();
				freeBoard.setBno(rs.getInt("bno"));
				freeBoard.setBtitle(rs.getString("btitle"));
				freeBoard.setBcontent(rs.getString("bcontent"));
				freeBoard.setBwriter(rs.getString("bwriter"));
				freeBoard.setBhitcount(rs.getInt("bhitcount"));
				freeBoard.setBdate(rs.getDate("bdate"));
				return freeBoard;
			}
		});
		return (list.size()!=0)? list.get(0):null;
	}
	
	public List<FreeBoard> selectByPage(int pageNo, int rowsPerPage){
		String sql="";
		 sql += "select rn, bno,btitle,bwriter,bhitcount,bdate ";
		 sql += "from( ";
		 sql += "select rownum as rn, bno,btitle,bwriter,bhitcount,bdate ";
        sql += "from (select bno,btitle,bwriter,bhitcount,bdate from freeboard order by bno desc) ";
        sql += "where rownum<=? ";
        sql += ") ";
        sql += "where rn>=? ";
        List<FreeBoard> list = jdbcTemplate.query(
        		sql, 
        		new Object[]{(pageNo*rowsPerPage),((pageNo-1))*rowsPerPage+1},
        		new RowMapper<FreeBoard>(){
        			//각컬럼의 값을 객체의 어느행에 넣어줄지 연결시켜줘서 저장시켜주는 역할
        			@Override
        			public FreeBoard mapRow(ResultSet rs, int row) throws SQLException {
        				FreeBoard freeBoard = new FreeBoard();
        				freeBoard.setBno(rs.getInt("bno"));
        				freeBoard.setBtitle(rs.getString("btitle"));
        				freeBoard.setBwriter(rs.getString("bwriter"));
        				freeBoard.setBhitcount(rs.getInt("bhitcount"));
        				freeBoard.setBdate(rs.getDate("bdate"));
        				return freeBoard;
        			}
        		}
        		);
        return list;
	}
	
	public int count(){//count를 추가한 의미 
		String sql="select count (*) from freeboard";//이 문은 무조건 하나의 값을 가져온다 
		int count = jdbcTemplate.queryForObject(sql, Integer.class);
		//sql문을 실행후 하나의 객체를 리턴한다(전제조건 무조건 하나의 행,값만 가져온다는 보장이 있어야한다 없으면 예외발생)
		//Integer.class =객체의 타입지정 (후 리턴) 
		//int count 가아니라 원래는 Integer count여야한다 but int로 언박싱해서 받을수 있다
		return count;
	}
}
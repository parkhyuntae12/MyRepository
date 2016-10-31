package com.mycompany.myweb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mycompany.myweb.dto.PhotoBoard;

@Component
public class PhotoBoardDao {
	//DAO = 실질적인 DB와의 연결을 담당하는 일을 가진 객체
	@Autowired
	private JdbcTemplate jdbcTemplate;//관리객체를 만들어서 주입한다
	
	public int insert(PhotoBoard photoBoard){	
		String sql="insert into photoBoard(bno,btitle,bcontent,bwriter,bhitcount,bdate,originalfile,savedfile,mimetype) values(seq_photoboard_bno.nextval,?,?,?,0,sysdate,?,?,?)";
		int row = jdbcTemplate.update(
				sql,
				photoBoard.getBtitle(),
				photoBoard.getBcontent(),
				photoBoard.getBwriter(),
				photoBoard.getOriginalfile(),
				photoBoard.getSavedfile(),
				photoBoard.getMimetype()
				);
		return row;
	}
	
	public int update(PhotoBoard photoBoard){
		String sql="update photoBoard set btitle=?,bcontent=?,bhitcount=?,originalfile=?,savedfile=?,mimetype=? where bno=?";
		int row = jdbcTemplate.update(
				sql,
				photoBoard.getBtitle(),
				photoBoard.getBcontent(),
				photoBoard.getBhitcount(),
				photoBoard.getOriginalfile(),
				photoBoard.getSavedfile(),
				photoBoard.getMimetype(),
				photoBoard.getBno()
				);
		return row;
	}
	
	public int delete(int bno){
		String sql="delete from photoBoard where bno=?";
		int row = jdbcTemplate.update(sql,bno);
		return row;
	}
	
	public PhotoBoard selectByBno(int bno){
		String sql="select bno,btitle,bcontent,bwriter,bhitcount,bdate,originalfile,savedfile,mimetype from photoboard where bno=?";
		List<PhotoBoard> list = jdbcTemplate.query(sql, new Object[]{bno},new RowMapper<PhotoBoard>(){
			@Override
			public PhotoBoard mapRow(ResultSet rs, int row) throws SQLException {
				PhotoBoard photoBoard = new PhotoBoard();
				photoBoard.setBno(rs.getInt("bno"));
				photoBoard.setBtitle(rs.getString("btitle"));
				photoBoard.setBcontent(rs.getString("bcontent"));
				photoBoard.setBwriter(rs.getString("bwriter"));
				photoBoard.setBhitcount(rs.getInt("bhitcount"));
				photoBoard.setBdate(rs.getDate("bdate"));
				photoBoard.setOriginalfile(rs.getString("originalfile"));
				photoBoard.setSavedfile(rs.getString("savedfile"));
				photoBoard.setMimetype(rs.getString("mimetype"));
				return photoBoard;
			}
		});
		return (list.size()!=0)? list.get(0):null;
	}
	
	public List<PhotoBoard> selectByPage(int pageNo, int rowsPerPage){
		String sql="";
		 sql += "select rn,bno,btitle,bhitcount,bdate,savedfile ";
		 sql += "from( ";
		 sql += "select rownum as rn,bno,btitle,bhitcount,bdate,savedfile ";
        sql += "from (select bno,btitle,bhitcount,bdate,savedfile from photoboard order by bno desc) ";
        sql += "where rownum<=? ";
        sql += ") ";
        sql += "where rn>=? ";
        List<PhotoBoard> list = jdbcTemplate.query(
        		sql, 
        		new Object[]{(pageNo*rowsPerPage),((pageNo-1))*rowsPerPage+1},
        		new RowMapper<PhotoBoard>(){
        			//각컬럼의 값을 객체의 어느행에 넣어줄지 연결시켜줘서 저장시켜주는 역할
        			@Override
        			public PhotoBoard mapRow(ResultSet rs, int row) throws SQLException {
        				PhotoBoard photoBoard = new PhotoBoard();
        				photoBoard.setBno(rs.getInt("bno"));
        				photoBoard.setBtitle(rs.getString("btitle"));
        				photoBoard.setBhitcount(rs.getInt("bhitcount"));
        				photoBoard.setBdate(rs.getDate("bdate"));
        				photoBoard.setSavedfile(rs.getString("savedfile"));
        				return photoBoard;
        			}
        		}
        		);
        return list;
	}
	
	public int count(){//count를 추가한 의미 
		String sql="select count (*) from photoboard";//이 문은 무조건 하나의 값을 가져온다 
		int count = jdbcTemplate.queryForObject(sql, Integer.class);
		//sql문을 실행후 하나의 객체를 리턴한다(전제조건 무조건 하나의 행,값만 가져온다는 보장이 있어야한다 없으면 예외발생)
		//Integer.class =객체의 타입지정 (후 리턴) 
		//int count 가아니라 원래는 Integer count여야한다 but int로 언박싱해서 받을수 있다
		return count;
	}
}
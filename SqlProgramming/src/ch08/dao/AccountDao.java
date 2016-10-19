package ch08.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ch08.dto.Account;

public class AccountDao {//Dao를 작성할땐 try catch를 쓰면 절대 안된다, 트랜잭션을 만드는 코드가 잇으면 안된다
	private Connection conn;

	public void setConn(Connection conn) {
		this.conn = conn;
	}
	
	public int update(Account account) throws SQLException{
		//update의 리턴타입을 void로하면 몇개의 행이 수정되었는지 알수없다
		String sql="update account set abalance=? where ano=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		//여기서는 try catch로 예외를 잡으면 안된다 try catch로 예외를 잡으면 어떠한 예외도 생기지 않는 메소드가 된다
		//rollback 할수있는 기회가 없어진다
		pstmt.setInt(1, account.getAbalance());
		pstmt.setString(2, account.getAno());
		int rowNo = pstmt.executeUpdate();
		return rowNo;
	}
}
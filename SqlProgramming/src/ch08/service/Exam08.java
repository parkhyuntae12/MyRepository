package ch08.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import ch08.dao.AccountDao;
import ch08.dto.Account;

public class Exam08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","tester1","kosa12345");
			
			//트랜잭션 작업을 시작
			conn.setAutoCommit(false);
			
			AccountDao accountdao = new AccountDao();
			accountdao.setConn(conn);
			
				//작업1
				Account account1 = new Account();
				account1.setAno("111-111");
				account1.setAbalance(500000);
				int rowNo1 = accountdao.update(account1);
				
				//작업2
				Account account2 = new Account();
				account1.setAno("111-113");
				account1.setAbalance(200000);
				int rowNo2 =accountdao.update(account2);
				
				if(rowNo1==1 && rowNo2==1){
					conn.commit();
					System.out.println("계좌이체 성공함");
				}else{
					conn.rollback();
					System.out.println("계좌가 존재하지 않아서 계좌이체 실패함");
				}
			
				conn.commit();
		} catch (Exception e) {
			try {conn.rollback();} catch (SQLException e1) {}
			System.out.println("예외가 발생하여 계좌이체 실패함");
		  }finally{
				try{
					conn.setAutoCommit(true);//모든 작업이 끝나면 반드시 트랜잭션 작업을 true로 돌려놔야한다.
					conn.close();
					}catch(SQLException e){}
			}
	}
}
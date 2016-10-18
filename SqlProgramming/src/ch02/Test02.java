package ch02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test02 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
	Class.forName("oracle.jdbc.OracleDriver");
	Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","tester1","kosa12345");
	
	String sql="select ename,empno,sal from emp where ename like ?";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, "%성%");
	ResultSet rs = pstmt.executeQuery();
	while(rs.next()){
		int empno= rs.getInt(2);
		String ename = rs.getString("ename");
	}
}
}
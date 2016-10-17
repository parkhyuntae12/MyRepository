package ch02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Exam02 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		//연결객체 만들기(사용후엔 연결을 확실히 끊어줘야 한다)
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345");
		/*
		Driver oracleDriver = new OracleDriver();
		DriverManager.registerDriver(oracleDriver);//=Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345");
		*/
		
		//매개변수화된 query문(SQL)문
		String sql="select ename, empno, sal from emp where ename like ?";//물음표일부분을 문자화 할수없다 '김?',' '%?%' =x 
		PreparedStatement pstmt = conn.prepareStatement(sql);
		//준비가끝난 객체              //sql을 실행준비시키는 메소드
		pstmt.setString(1, "%성%"); //sql문 조건문 다음에 ?가 2개일 경우 (1,x) 첫번째 물음표에 x 대입 (2,y) 2번째 물음표에 y대입 
		ResultSet rs = pstmt.executeQuery();//executeQuery()=select * from emp where ename like ?를 oracle로 보낸다
		while(rs.next()){
			int empno=rs.getInt(2);
			String ename = rs.getString("ename");
			int sal = rs.getInt("sal");
			System.out.println(empno+":"+ename+":"+sal);
		}
		//데이터를 읽으려면 rs.getxxx(1); (가속성 떨어짐) , rs.getxxx("empno"); 컬럼의 이름을 사용하는게 더 좋다 
		//xxx는 읽고싶은 데이터타입이 온다 숫자는 String도 가능
		//date도 String타입으로 읽을수있다
		rs.close();
		pstmt.close();
		conn.close();
	}
}
package ch03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exam06 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		/*Employee emp = getEmployee(1001);
		System.out.println(emp.getEmpno()+":"+emp.getEname()+":"+emp.getSal());*/
		
		
//		List<Department> result = getDepartment("개발");
//		for(Department dept: result){
//			System.out.println(dept.getDeptno()+":"+dept.getDname()+":"+dept.getLoc());
//		}
	}

	private static Employee getEmployee(int searchEmpno) throws ClassNotFoundException, SQLException {
		//select * from emp where empno=?
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345");
		
		String sql="select * from emp where empno=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, 1001);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			int empno=rs.getInt("empno");
			String ename = rs.getString("ename");
			double sal = rs.getDouble("sal");
			System.out.println(empno+":"+ename+":"+sal);
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		return null;
	}
	
//	private static List<Department> getDepartment(String searchDname) {
//		//select * from dept where dname like ? 
//		Scanner scanner = new Scanner(System.in);
//		while(true){
//			System.out.print("검색할 이름: ");
//			String name= scanner.nextLine();
//			List<Department> result = getList(name); 
//			for(Department dept:result){
//				System.out.println(dept.getDeptno()+":"+dept.getDname());
//			}
//			
//		}
//	}
//	public static List<Department> getList(String searchDname){
//		List<Department> list = new ArrayList<>();
//		Connection conn=null;
//		try{
//			Class.forName("oracle.jdbc.OracleDriver");
//			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1","kosa12345");
//			String sql="select * from dept where dname like ?";
//			PreparedStatement pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, "%"+searchDname+"%");
//			ResultSet rs = pstmt.executeQuery();
//			while(rs.next()){
//				Department dept = new Department();
//				dept.setDeptno(rs.getInt("deptno"));
//				dept.setDname(rs.getString("dname"));
//				dept.setLoc(rs.getString("loc"));
//				list.add(dept);
//			}
//			rs.close();
//			pstmt.close();
//			conn.close();
//		}catch(Exception e){
//			try{conn.close();} catch(SQLException e2){}
//			e.printStackTrace();
//		}
//		return list;
	//}

	/*private static Employee getEmployee(int searchEmpno) {
		//null을 리턴할수 있고(rs.next()=false일때),employee 객체를 리턴 가능(rs.next()=true일때)
		Employee employee = null;
		String sql = "select * from emp where empno=?";
		Connection conn = null;// 초기화 하지 않고 선언만 하면 초기화에러(메모리 x)
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","tester1","kosa12345");
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, searchEmpno);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){b
				employee = new Employee();
				employee.setEmpno(rs.getInt("empno"));
				employee.setEname(rs.getString("ename"));
				employee.setJob(rs.getString("job"));
				employee.setMgr(rs.getInt("mgr"));
				employee.setHiredate(rs.getDate("hiredate"));
				employee.setSal(rs.getDouble("sal"));
				employee.setComm(rs.getDouble("comm"));
				employee.setDeptno(rs.getInt("deptno"));
			}
			rs.close();
			pstmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {conn.close();} catch (SQLException e) {}
		}
		return employee;
	}*/
	
	private static List<Department> getDepartment(String searchDname) {
		List<Department> list = new ArrayList<>();
		String sql="select * from dept where dname like ?";
		Connection conn =null;
		Scanner scanner = new Scanner(System.in);
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","tester1","kosa12345");
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,"%"+searchDname+"%");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				Department dept = new Department();
				dept.setDeptno(rs.getInt("deptno"));
				dept.setDname(rs.getString("dname"));
				dept.setLoc(rs.getString("loc"));
				list.add(dept);
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
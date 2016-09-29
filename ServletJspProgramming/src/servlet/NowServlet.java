package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NowServlet extends HttpServlet{ //URL로 접근하면 다 GET 방식이다. //서블릿은 한번 생성되면 재사용된다.
	//필드   //클라이언트가 최초로 요청될떄 생성후 이후로는 재사용된다.
	private String location;
	
	
	//생성자
	public NowServlet()
	{
		System.out.println("NowServlet 객체 생성");
	}
	
	//초기화 메소드
	@Override
		public void init(ServletConfig config) throws ServletException { //<init-param>을 받기위해 실행한거라 생각해도 무방
		System.out.println("NowServlet 초기화");
		location = config.getInitParameter("location");
		
		}
	
	
	//메소드
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//클라이언트가 GET방식으로 요청했을때 이 메소드를 사용
		response.setContentType("text/html; charset=UTF-8");
		//헤더를 더 추가 시킬려면 response.setHeader(name, value); 를 쓴다. ex)
		//OutputStream os =response.getOutputStream();
		PrintWriter out = response.getWriter(); //둘의 출력 스트림은 본문행에 기입된다.	init	
		out.println("<html>");
		out.println("<head><meta charset='UTF-8'></head>");
		out.println("<body>");
		out.println("현재 "+location+"시간: "+ new Date().toString());
		out.println("</body>");
		out.println("</html>");
		}
}

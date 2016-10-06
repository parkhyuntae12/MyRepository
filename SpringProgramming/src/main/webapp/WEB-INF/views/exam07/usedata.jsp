<%@ page contentType="text/html;charset=UTF-8"%><%--<%@지시자를 사용하겠다--%>
<%@ page import="com.mycompany.myapp.exam07.*"%><%-- --%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- prefix="" uri="" ->네임스페이스선언(중복을 피하면서 어떤 마크업에 속하는지 접두사를사용)--%>



<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	</head>
	<body>
		 데이터 찾기
		 <hr />
		 [HttpServletRequest를 이용해서 찾기]<br/>
		 데이터1 : <%=(String)request.getAttribute("data1") %><br/><%--request안에 data1에 저장되어있는 문자열을 찾아서 <%%>안에 넣어라--%>
		 데이터2 : <%=(String)request.getAttribute("data2") %><br/><br/><%--getAttribute는 object타입이므로 String으로 타입변환 --%>
		 
		 [HttpSession를 이용해서 찾기]<br/>
		 데이터1 : <%=(String)session.getAttribute("data1") %><br/>
		 데이터2 : <%=(String)session.getAttribute("data2") %><br/><br/>
		  
		 [EL을 이용해서 찾기]<br/>
		 데이터1 : ${data1}<br/><%--request에서 먼저 찾는다 request에 데이터가없으면 session에서 찾는다--%>
		 데이터2 : ${data2}<br/><br/>
		 
		 [객체의 속성(필드)값 얻기]<br/>
         <%Board board = (Board)request.getAttribute("board");%><%--<%%>안에 내용을 실행해라 --%>
		 <%if(board !=null) {%>
		  번호:<%=board.getBno()%><br/>
		  제목:<%=board.getTitle()%><br/>
		  내용:<%=board.getContent()%><br/>
		  조회수:<%=board.getHitcount()%><br/><br/>
         <%}%>
         <%-- 
         번호:${board.bno}<br/><%-- 자바에선 .은 접근연산자이지만 ${} {}안에서의 .은 getter를 호출한다(board.getBno()) 
		 제목:${board.title}<br/>
		 내용:${board.content}<br/>
		 조회수:${board.hitcount}<br/><br/>
		 --%>
		 <br/><br/>
		[컬렉션 이용하기]]<br/><br/>
		 
		 <table style="border-collapse: collapse; border: 1px solid black; width:600px;">
		 	<tr style="background-color: #ffcc00;">
		 		<td style="border:1px solid black;">번호</td>
		 		<td style="border:1px solid black;">제목</td>
		 		<td style="border:1px solid black;">내용</td>
		 		<td style="border:1px solid black;">조회수</td>
		 	</tr>
		 	 <%-- 	
		 	 <%List<Board>list = (List<Board>)request.getAttribute("boardlist"); %>
		 	<%if(list !=null) {%>
			<%for(Board b : list) {%>
				<tr>
					<td style="border:1px solid black;"><%=b.getBno()%></td>
		 			<td style="border:1px solid black;"><%=b.getTitle()%></td>
		 			<td style="border:1px solid black;"><%=b.getContent()%></td>
		 			<td style="border:1px solid black;"><%=b.getHitcount()%></td>
				</tr>
			<%}%>
		<%}%> 
		--%>
		
			  <c:forEach var="c" items="${boardlist}">
				<tr>
					<td style="border:1px solid black;">${c.bno}</td>
		 			<td style="border:1px solid black;">${c.title}</td>
		 			<td style="border:1px solid black;">${c.content}</td>
		 			<td style="border:1px solid black;">${c.hitcount}</td>
			 	</tr>
			</c:forEach> 
		 </table>
	</body>
</html>
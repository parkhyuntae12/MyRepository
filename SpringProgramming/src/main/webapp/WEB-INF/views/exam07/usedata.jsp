<%@ page contentType="text/html;charset=UTF-8"%>

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
		 데이터2 : ${data2}<br/>
	</body>
</html>
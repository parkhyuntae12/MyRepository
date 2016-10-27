<%@ page  contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html> <!-- root 태크, 엘리먼트라고 하기도 한다. -->
	<head> <!-- 헤드엘리먼트 -->
		<meta charset="UTF-8">
	</head>
	<body> <!-- 브라우저에 나오는 부분 -->
		SpringFinalProgramming
		<hr/>
		1.
		<c:if test="${login == null}">
			<a href="<%=pageContext.getServletContext().getContextPath()%>/member/login">로그인</a>
		</c:if>
		<c:if test="${login != null}">
			<a href="<%=pageContext.getServletContext().getContextPath()%>/member/logout">로그아웃</a>
		</c:if>
		<br/>
		2.<a href="${pageContext.servletContext.contextPath}/freeboard/list">자유 게시판</a><br/>
		3.<a href="${pageContext.servletContext.contextPath}/photoboard/list">포토 게시판</a><br/>
		
	</body>
</html>

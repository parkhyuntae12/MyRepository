<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!-- 임포트기능이라 생각  c:if를쓰기위한 태그-->
<!DOCTYPE html >
<html>
<head>
	<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	로그인
	<hr/>
	<form method="post">
		아이디:<input type="text" name="mid" value="${findMid}"/>
		<c:if test="${error == 'LOGIN_FAIL_MID'}">*아이디가 존재하지 않음</c:if>
		<!-- error라고하는 이름의 등록된 것과 LOGIN_FAIL_MID이 같다면 아이디가 존재하지 않음 출력 -->
	    <br/>
		패스워드:<input type="password" name="mpassword"/>
		<c:if test="${error == 'LOGIN_FAIL_MPASSWORD'}">*패스워드가 틀림</c:if>
		<br/>
		<input type ="submit" value="로그인"/>
	</form>
	<a href="${pageContext.servletContext.contextPath}/member/join">회원가입</a><!-- 절대경로 -->
	<br/>
	<a href="findMid">아이디 찾기</a><!-- 상대경로 -->
	<br/>
	비밀번호 찾기
</body>
</html>
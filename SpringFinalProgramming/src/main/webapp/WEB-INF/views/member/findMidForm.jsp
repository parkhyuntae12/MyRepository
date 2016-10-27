<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!-- 임포트기능이라 생각  c:if를쓰기위한 태그-->
<!DOCTYPE html >
<html>
<head>
	<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	아이디 찾기
	<hr/>
	<form method="post">
		이메일:<input type="email" name="memail"/>${error}
		<br/>
		<input type ="submit" value="찾기"/>
	</form>
</body>
</html>
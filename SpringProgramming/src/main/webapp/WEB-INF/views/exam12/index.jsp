<%@ page contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	</head>
	<body>
		Exam12
		<hr/>
		[공통]<br/>
		-메이븐 설정 파일 수정(Spring JDBC와 커넥션 풀 의존성 라이브러리 추가)<br/><br/>
		
		1)웹 어플리케이션이 커넥션 풀을 가지고 있는 경우 <br/>
		- 스프링 설정 파일(servlet-context.xml)
		
		2)Tomcat(WAS)가 커넥션 풀을 가지고 있는 경우<br/>
		-Tomcat(WAS)에서 커넥션 풀 설정(참조: ) <br/>
		-웹애플리케이션 DD 설정(참조 :)<br/>
		-스프링 설정 파일(servlet-context.xml) 설정<br/><br/>
		
		[테스트]<br/>
		<a href="/myapp/exam12/join">회원가입</a>
		
		
	</body>
</html>
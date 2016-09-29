<%@ page  contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>
<html> <!-- root 태크, 엘리먼트라고 하기도 한다. -->
	<head> <!-- 헤드엘리먼트 -->
		<meta charset="UTF-8">
	</head>
	<body> <!-- 브라우저에 나오는 부분 -->
		Exam02
		<hr/>
		<a href="/myapp/exam02/join?mid=user1&mname=홍길동&mage=30">가입</a><br/><!-- ?뒤에값들을 요청 -->
		<a href="/myapp/exam02/login?id=user1&password=12345">로그인</a><br/>
		<a href="/myapp/exam02/order?pid=5&pname=마우스&pprice=5000&pcompany=삼성">주문</a><br/>
		<a href="/myapp/exam02/write?bno=10&title=게시물제목&content=게시물내용">글쓰기</a><br/>
		<a href="/myapp/exam02/update?bno=10&title=게시물제목&content=게시물내용&count=3">수정</a><br/>
		<a href="/myapp/exam02/send?bno=20&title=게시물제목&content=게시물내용&hitcount=5">보내기</a><br/>
		
	
	</body>
</html>
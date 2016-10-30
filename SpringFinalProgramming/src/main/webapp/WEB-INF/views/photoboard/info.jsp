<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!-- 임포트기능이라 생각  c:if를쓰기위한 태그-->
<!DOCTYPE html >
<html>
<head>
	<meta charset="UTF-8">
	
<title>Insert title here</title>
</head>
<body>
	정보
	<hr/>
		<table style="width:570px text-align=center;">
		    <tr>
				<td style="background-color:orange; width:100px">번호</td>
				<td>${photoboard.bno}</td>
			</tr>
			<tr>
				<td style="background-color:orange; width:100px">제목</td>
				<td>${photoboard.btitle}</td>
			</tr>
			<tr>
				<td style="background-color:orange; width:100px">내용</td>
				<td><pre>${photoboard.bcontent}</pre></td>
			</tr>	
			<tr>
				<td style="background-color:orange; width:100px">글쓴이</td>
				<td>${photoboard.bwriter}</td>
			</tr>
			<tr>
				<td style="background-color:orange; width:100px">조회수</td>
				<td>${photoboard.bhitcount}</td>
			</tr>
			<tr>
				<td style="background-color:orange; width:100px">날짜</td>
				<td>${photoboard.bdate}</td>
			</tr>
			<tr>
				<td style="background-color:orange; width:100px">사진</td>
				<td><img src="showPhoto?savedfile=${photoboard.savedfile}" width="500px"/></td><!-- 파일타입을 받고 싶으면 enctype를 설정
				멀티파트 관리객체를 만든후 라이브러리 생성 멀티파트타입으로 받아야한다-->
			</tr>	
		</table>
		<div>
			<c:if test="${login == photoboard.bwriter}">
				<a href="modify?bno=${photoboard.bno}">[수정]</a>
				<a href="remove?bno=${photoboard.bno}">[삭제]</a>
			</c:if>
			<a href="list">[목록]</a>
		</div>
	
</body>
</html>
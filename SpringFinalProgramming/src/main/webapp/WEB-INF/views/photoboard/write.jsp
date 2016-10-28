<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!-- 임포트기능이라 생각  c:if를쓰기위한 태그-->
<!DOCTYPE html >
<html>
<head>
	<meta charset="UTF-8">
	
<title>Insert title here</title>
</head>
<body>
	글쓰기
	<hr/>
	<form method="post" enctype="multipart/form-data"><!--  -->
		<table>
			<tr>
				<td style="background-color:orange; width:100px">제목</td>
				<td><input type="text" name="btitle" style="width:600px;"/></td>
			</tr>
			<tr>
				<td style="background-color:orange; width:100px">내용</td>
				<td><textarea name="bcontent" style="width:600px; height:200px;"></textarea></td>
			</tr>	
			<tr>
				<td style="background-color:orange; width:100px">사진</td>
				<td><input type="file" name="photo"/></td><!-- 파일타입을 받고 싶으면 enctype를 설정
				멀티파트 관리객체를 만든후 라이브러리 생성 멀티파트타입으로 받아야한다-->
			</tr>	
		</table>
		<input type="submit" value="글쓰기"/>
	</form>
</body>
</html>
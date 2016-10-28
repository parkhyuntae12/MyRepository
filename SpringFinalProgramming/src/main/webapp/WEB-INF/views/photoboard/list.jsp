<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!-- 임포트기능이라 생각  c:if를쓰기위한 태그-->
<!DOCTYPE html >
<html>
<head>
	<meta charset="UTF-8">
	<style type="text/css">
		*{
			font-family:돋움;
			font-size:12px;
		}
		a{
		  text-decoration:none;
		  color:black;
		}
		a:HOVER{
		  color:green;
		}
	</style>
<title>Insert title here</title>
</head>
<body>
	포토 게시판
	<hr/>
	
	<c:if test="${login!=null}">
	<a href="write">[글쓰기]</a>
	</c:if>
	
	 <table style="width:600px">
	   <tr>
	   	<td>
	   	  <c:forEach var="photoBoard" items="${list}"><!-- var 변수명은 아무거나 상관없다 -->
	   	  <a href="info?bno=${photoBoard.bno}">
	   	  	<div style="background-image:url(showPhoto?savedfile=${photoBoard.savedfile}); width:120px; height:130px; margin:5px; display:inline-block; background-size:120 130px">
	   	  								<!-- 프로젝트경로x,실제파일경로 -->		
	   	  		<div style="height:100px;">
	   	  			<span style="color:white; font-size:12px">${photoBoard.bdate}</span>
	   	 		</div>
	   	  		<div>
	   	  			<table style="width:100%; height:30px; background-color:black; opacity: 0.5;">
	   	  				<tr>
	   	  					<td style="text-align:left; color:white">${photoBoard.btitle}</td>
	   	  					<td style="text-align:right; color:aqua">${photoBoard.bhitcount}</td>
	   	  				</tr>
	   	  			</table>
	   	  		</div>
	   	  	</div>
	   	  </a>
	   	  </c:forEach>
	   	</td>
	   </tr>
	 </table>
	 
	  <div style="width:600px">
	  
	 	<a href="list?pageNo=1">[처음]</a>
	 	
	 	<c:if test="${groupNo>1}">
	 		<a href="list?pageNo=${startPageNo-1}">[이전]</a>
	 	</c:if><!-- 이전번호가 나오게하는 조건 pageNo가 2부터 이전버튼 나오게함 -->
	 	
	 	<c:forEach var="i" begin="${startPageNo}" end="${endPageNo}">
	 	  &nbsp;
	 		<a href="list?pageNo=${i}"
	 		<c:if test="${pageNo==i}">style="color:red"</c:if>
	 		>${i}</a>
	 		&nbsp;
	 	</c:forEach>
	 	
	 	<c:if test="${groupNo<totalGroupNo}">
	 		<a href="list?pageNo=${endPageNo+1}">[다음]</a>
	 	</c:if>
	 	
	 	<a href="list?pageNo=${totalPageNo}">[맨끝]</a>
	 </div>
</body>
</html>
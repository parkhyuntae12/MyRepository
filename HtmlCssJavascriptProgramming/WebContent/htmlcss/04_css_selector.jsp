<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css"><%-- 우선순위 : 태그이름<클래스이름<id이름 --%>
/*	*{color:red;}<%-- *=모든태그 --%> */
	div{background-color:yellow;}
	#div2{background-color:aqua;} <%--id가 div2인 것--%>
	.div3{background-color:hotpink;} <%--클래스명이 div3인 것--%>
	
	#div4,#p1,#h1{background-color:orange;}
	
	#div5 p{background-color:blue;}
	#div6 > p{background-color:green;}
	
	[checked] {color:green;} <%-- checked라는 속성을 가진 모든것 --%>
	[selected=true] {color:green;} <%-- selected의 속성중 값인 true를 가진 모든것 --%>
	
	a {color:black; text-decoration:none;} /*text-decoration:장식*/
	/*a:active{color:red;} */ /*링크를 클릭할때*/
	/*a:link{color:green;} */ /*한번도 방문하지 않은 태그*/
	a:hover{color:blue; text-decoration:underline;} /* 링크에 마우스를 올릴때 */
	
	#form1 [checked] {background-color:green;}
	
	
	
	
</style>
<title>index</title>
</head>
<body>
	CSS 선택자<%--id는 같은 이름이 있으면 안된다(유일) class는 같은 이름이 중복되어도된다(그룹이름) --%>
	<hr />
	<div>A</div>
	<div id="div2" class="div3">B</div>
	<div class="div3">C</div>
	<div class="div3">D</div>
	
	<br/>
	
	<div id="div4">E</div>
	<p id="p1">F</p>
	<h3 id="h1">G</h3>
	
	<br/>
	
	<div id="div5">
		<p>H</p>
		<p>H</p>
	</div>
	
	<div id="div6">
		<div><p>H</p></div>
		<p>H</p>
	</div>
	
	<div>
		<div checked="true">A</div>
		<div checked="false">B</div>
		<div selected="false">C</div>
		<div selected="true">D</div>
		<div selected="true">E</div>
	</div>
	<br/>
	
	<div style="background-color:white;"><%-- 인라인 스타일(태그에서 바로 스타일을 주는방법) --%>
	    <a href="http://www.naver.com">네이버</a><br/>
		<a href="http://tomcat.apache.org">톰캣</a><br/>
		<a href="http://tomcat.w3c.org">W3C</a><br/>
	</div>
	
	<form id="form1">
		<div checked="true">A</div>
		<div checked="false">B</div>
	</form>
	
</body>
</html>

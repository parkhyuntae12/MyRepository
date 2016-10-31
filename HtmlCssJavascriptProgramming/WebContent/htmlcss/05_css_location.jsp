<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"><!-- 생략가능 (브라우저해석방식) -->
<!-- External Style Sheet -->
<link rel="stylesheet" type="text/css" href="05_style.css"> <!-- rel=관계 type=문법  -->

<style type="text/css">
	.menu{background-color:#ffffff;}
	.menu li{color:orange;}
</style>

<title>index</title>
</head>
<body>
	CSS Location
	<hr/>
	
	<header>제목</header>
	<p>내용</p>
	<a href="http://tomcat.apache.org">톰캣</a>
	
	<div class="menu">
		<ul>
			<li>menu1</li>
			<li>menu2</li>
			<li>menu3</li>
		</ul>
	</div>
	
	<div style="text-align:center; background-color:yellow">
		본문 내용입니다.
	</div>
</body>
</html>	
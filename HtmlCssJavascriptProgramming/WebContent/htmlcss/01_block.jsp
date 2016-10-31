<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"><!-- 생략가능 (브라우저해석방식) -->
<title>index</title>
</head>
<body>
	Block 엘리먼트
	<hr/>
	<h1>Block</h1>
	<div style="background-color:#ff0000; height:50px; border:1px solid green"></div>
	<div style="background-color:#0000ff; height:50px; border:1px solid yellow"></div>
	<h1 style="background-color:#0000ff; height:50px; border:1px solid yellow">제목</h1>
	<p style="background-color:#0000ff; height:50px; border:1px solid yellow">내용</p>
	<form style="background-color:#0000ff; height:50px; border:1px solid yellow"></form>
	<h1>In-line</h1>
	<span style="color:red; border:1px solid red;">Important</span>
	<span style="color:green;">Important</span>
	<span style="color:blue;">Important</span>
	<img src="../common/image/naver.jpg" style="border:3px soild yellow;"/>
	
	<h1>Block -> Inline</h1>
	<div style="width:200px; height:50px; border:1px solid green; display:inline-block;"></div>
	<div style="width:200px; height:50px; border:1px solid red; display:inline-block;"></div>
	
	<h1>Example</h1>
	<div style="width:200px; height:50px; border:1px solid green; display:inline-block;">
		<div style="background-color:#ff0000; height:30px;"></div>
	</div>
</body>
</html>
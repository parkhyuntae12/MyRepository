<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"><!-- 생략가능 (브라우저해석방식) -->
<script type="text/javascript" src="../common/js/jquery-1.12.4.min.js"></script>
<script>
window.onload = function(){
	console.log("0");
}
$(document).on("ready",function(){//document라는 객체에서 ready 이벤트가 발생하면 함수 실행
	console.log("1");
});
//=
$(document).ready(function(){
	console.log("2");
});
//=
$(function(){
	console.log("3");
});
</script>
</head>
<body>
	ready 이벤트 처리
	<hr/>
	<img src="../common/image/naver.jpg"/>
</body>
</html>
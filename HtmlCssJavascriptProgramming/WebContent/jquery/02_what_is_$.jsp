<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"><!-- 생략가능 (브라우저해석방식) -->
<script>
	//함수(객체) 대입
	var $ = function(selector){
		console.log("aaa");
		return document.querySelectorAll(selector);//selectorAll:모든객체를 배열로 리턴
	}; 
	
	//동적 메소드 추가
	$.ajax =function(){
		console.log("bbb");
	};
	
	function test(){
		$("#div1")[0].innerHTML = "수정내용";
		$.ajax();
	}
</script>
</head>
<body>
	$는 함수형 객체
	<hr/>
	<button onclick="test()">버튼</button>
	<div id="div1">최초내용</div>
	<script type="text/javascript">
		
	</script>
</body>
</html>
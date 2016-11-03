<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"><!-- 생략가능 (브라우저해석방식) -->
<script type="text/javascript" src="../common/js/jquery-1.12.4.min.js"></script>
<script>
	function test1(){
		//$("#div1")[0].innerHTML = "수정내용";// 권장 ㄴㄴ
		$("#div1").html("수정내용");
	}
	
	function test2(){
		$(".div2").html("수정내용");
		$(".div2").css("background-color","red");
	}
	
	function test3(){
		$("#img3").attr("src","../common/image/naver.jpg")
	}
</script>
</head>
<body>
	객체 찾기
	<hr/>
	<button onclick="test1()">버튼</button>
	<div id="div1">최초내용</div>
	
	<button onclick="test2()">버튼2</button>
	<div class="div2">최초내용</div>
	<div class="div2">최초내용</div>
	<div class="div2">최초내용</div>

	<button onclick="test3()">버튼3</button>
	<img id="img3" src="../common/image/i.jpg"/>
</body>
</html>
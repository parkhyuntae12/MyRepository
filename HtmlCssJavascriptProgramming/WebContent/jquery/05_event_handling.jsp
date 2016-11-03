<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"><!-- 생략가능 (브라우저해석방식) -->
<script type="text/javascript" src="../common/js/jquery-1.12.4.min.js"></script>
<script>
	$(function(){
		$("#btn1").on("click", function(){
			$("#div1").append('<img id="img1" src="../common/image/i.jpg" width="200px" height="200px"/>&nbsp');
		});
		
		$(".img2").on("mouseover",function(){
			$(".img2").attr("src","../common/image/naver.jpg");
		});
		$(".img2").on("mouseout",function(){
			$(".img2").attr("src","../common/image/i.jpg");
		});	
	});
	
</script>
</head>
<body>
	이벤트 처리
	<hr/>
	<button id="btn1">버튼1</button>
	<div id="div1">
		<img id="img1" src="../common/image/i.jpg" width="200px" height="200px"/>
	</div>
	<br/><br/><br/><br/>
	<div>
		<img class="img2" src="../common/image/i.jpg" width="500px" height="500px"/>
		<img class="img2" src="../common/image/i.jpg" width="500px" height="500px"/>
	</div>
</body>
</html>
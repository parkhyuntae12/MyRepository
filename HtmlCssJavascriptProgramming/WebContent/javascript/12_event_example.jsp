<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"><!-- 생략가능 (브라우저해석방식) -->
<script type="text/javascript"> 
	function checkMid(){
		var mid = document.querySelector("#mid");
		mid.value = mid.value.toLowerCase();	
	}
	window.onload = function (){
		document.querySelector("#mid");
		mid.addEventListener("keypress", checkMid);
		document.querySelector("#mid");
		mid.addEventListener("keyup", checkMid);
	}
	
	function changeImg(img){
		if(event.type == "mouseover"){
			img.src="../common/image/photo1.jpg";
		}else if(event.type =  "mouseout"){
			img.src="../common/image/naver.jpg";
		}
	}
	
	window.addEventListener("load", function(){
		var img2 = document.querySelector("#img2");
		
		img2.addEventListener("mouseover", changeImg);
		img2.addEventListener("mouseout", changeImg);
	});
	
	function changeImg2(){
		var img = event.target;
		if(event.type == "mouseover"){
			img.src="../common/image/photo1.jpg";
		}else if(event.type =  "mouseout"){
			img.src="../common/image/naver.jpg";
		}
	}
	
	window.addEventListener("load", function(){
		var img2 = document.querySelector("#img2");
		
		img2.addEventListener("mouseover", changeImg2);
		img2.addEventListener("mouseout", changeImg2);
	});

	function changeColor(div){
		if(event.type == "mouseover"){
			div.style.backgroundColor="blue";
		}else if(event.type =  "mouseout"){
			div.style.backgroundColor="red";
		}
	}
</script>
<title>index</title>
</head>
<body>
	다양한 Event 처리
	<hr/>
	<h3>[Ex1]</h3>
	<form>
<!-- <input id="mid" type="text" name="mid" onkeypress="checkMid()" onkeyup="checkMid()"/> -->
	 <input id="mid" type="text" name="mid"/>
	</form>	
	
	<br/><br/><br/><br/>
	<h3>[Ex2]</h3>
	<img id="img1" src="../common/image/naver.jpg" width="200px" onmouseover="changeImg(this)" onmouseout="changeImg(this)"/>
	<img id="img2" src="../common/image/naver.jpg" width="200px"/>
	
	<br/><br/><br/><br/>
	<h3>[Ex3]</h3>
	<div id="div1" style="width:200px; height:200px; background-color:red; "onmouseover="changeColor(this)" onmouseout="changeColor(this)"></div>
</body>
</html>
<!-- 이벤트 소스(태그)에서 이벤트 함수를 지정할 경우 이벤트가 발생했을 때 함수가 실행 -->
<!-- 이벤트 소스에 add -->
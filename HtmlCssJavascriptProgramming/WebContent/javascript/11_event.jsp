<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"><!-- 생략가능 (브라우저해석방식) -->
<script type="text/javascript"> 
	function changeImg1(){
		var img1 = document.querySelector("#img1");
		img1.src = "../common/image/naver.jpg"; 
	}
	
	function changeImg2(){
		var img1 = document.querySelector("#img2");
		img2.src = "../common/image/naver.jpg"; 
	}
	
	function changeImg3(){
		var img3 = document.querySelector("#img3");
		img3.src = "../common/image/naver.jpg"; 
	}
	
	window.onload = function(){//window=브라우저
		var btn2 = document.querySelector("#btn2"); //제일 마지막에 실행되야한다(브라우저가 다읽고 실행되야해서)
		btn2.onclick = changeImg2;//익명객체와 같다
		
		var btn3 = document.querySelector("#btn3");
		/*	btn3.addEventListener("click",function() { //btn3에서 click이 발생했을때 함수를 실행하겟다
			var img3 = document.querySelector("#img3");
			img3.src = "../common/image/photo3.jpg"; */
		// ==
			btn3.addEventListener("click", changeImg3);// 제일 범용적인 방법 
	};
	
	/*
	function fun1(){
		console.log("window.onload");
	}
	window.onload = fun1();//fun1을 실행하고 결과값을 대입한다, 함수만 지정해야 한다 fun1이 와야함 ()제외
	//=	
	window.onload = function(){
		console.log("window.onload");
	};//window 객체에서 load라는 이벤트가 발생햇을때 function을 실행하겟다 
	*/
</script>
<title>index</title>
</head>
<body>
	Event 처리방법
	<hr/>
		<h3>[how1]</h3>
		<button onclick="changeImg1()">버튼1</button> <!--  -->
		<img id="img1" src="" width="100px"/>
		
		<h3>[how2]</h3>
		<button id="btn2">버튼2</button><br/>
		<img id="img2" src="" width="100px"/>
		
		<h3>[how3]</h3>
		<button id="btn3">버튼3</button><br/>
		<img id="img3" src="" width="100px"/>
</body>
</html>
<!-- 이벤트 소스(태그)에서 이벤트 함수를 지정할 경우 이벤트가 발생했을 때 함수가 실행 -->
<!-- 이벤트 소스에 add -->
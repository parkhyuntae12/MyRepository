<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"><!-- 생략가능 (브라우저해석방식) -->
<script type="text/javascript"> 
<!-- DOM = 브라우저가 html을 받으면  html내에 들어 있는 요소를 객체로 만든다 -->
<!-- DOM은 브라우저에서 자동 생성 -->
	function onclickButton1(){
		console.log("onclickButton1() 실행");
		//var div1 = document.getElementById("div1");
		var div1 = document.querySelector("#div1");
		console.log(div1);
		div1.innerHTML = "수정내용"; <!-- 최초내용을 수정내용으로 바꿔치기하겟다-->
	}	
	function onclickButton2(){
		//var imgArr = document.getElementsByClassName("photo");
		var imgArr = document.querySelectorAll(".photo");
		imgArr[0].src="../common/image/photo2.jpg";
	}
	function onclickButton3(){
		var mid;
		var mpassword;
		
		//how1
	//	var mid = document.querySelector("#form1 [name=mid]").value;
	//	console.log("mid :" + mid);
		
	//	var mpassword = document.querySelector("#form1 [name=mpassword]").value;
	//	console.log("mpassword :" + mpassword);
	
		//how2 (form에 name이 있어야 한다)
		mid = document.form1.mid.value;//document중 name이 form1인 것을 찾아서 mid 객체의 값을 가져옴
		mpassword = document.form1.mpassword.value;
	//	console.log("mid :" + mid);
	//	console.log("mpassword :" + mpassword);
		
		//유효성 검사
		if(mid == ""){ //스크립트에서의 문자열 비교
			alert("아이디를 입력하세요.");
		}else if(mpassword==""){
			alert("비밀번호를 입력하세요.");
		}
	
		//서버전송
	//	var form1 = document.querySelector("#form1");
	//	form1.submit();
		document.form1.submit();
	}
	
</script>
<title>index</title>
</head>
<body>
	DOM 사용
	<hr/>
		<button onclick="onslickButton1()">버튼1</button><!-- 클릭이 될때 onclickButton1()실행-->
		<div id="div1">최초 내용</div>
		
		<button onclick="onclickButton2()">버튼2</button>
		<div>
			<img class="photo" src="../common/image/photo1.jpg" width="200px"/>
		</div>
		
		<button onclick="onclickButton3()">버튼3</button>
		<div>
			<form id="form1" name="form1">
				아이디 : <input id="mid" type="text" name="mid"/><br/>
				비밀번호 : <input id="mpassword" type="password" name="mpassword"/><br/>
			</form>
		</div>
</body>
</html>
<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"><!-- 생략가능 (브라우저해석방식) -->
<script type="text/javascript">
//스크립트에서는 로컬변수와 글로벌 변수가 있다
//글로벌변수 = 자바에서의 전역변수
//로컬변수 = 자바에서의 지역변수
// var로 선언이 안된 변수를 쓰면 스크립트에서는 전역변수로 해석한다
// ex) carName = "volvo";
//자바는 블록단위에 지역변수가 존재하지만 스크립트는 블록단위에 지역변수는 존재x, 함수단위에 지역변수만 존재한다
	var v1 = "A";//전역변수
	
	function fun1(){
		var v2 = "B";//지역변수
		v3 = "C"; //전역변수로 해석
		console.log("v1:"+v1);
		console.log("v2:"+v2);
		console.log("v3:"+v3);
	}
	
	function fun2(){
		console.log("v1:"+v1);
		console.log("v3:"+v3);
		console.log("v2:"+v2);
	}
	
	function fun3(){
		if(true){
			var v4 = "D";
		}
		console.log("v4 : "+v4);
	}
</script>
</head>
<body>
	지역변수와 전역변수
	<hr/>
	<script type="text/javascript">
		fun1();
		console.log("---------------------");
		//fun2();
		fun3();
	</script>
	
</body>
</html>
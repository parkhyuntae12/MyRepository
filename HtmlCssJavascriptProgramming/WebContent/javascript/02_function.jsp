<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"><!-- 생략가능 (브라우저해석방식) -->
<script type="text/javascript">//type="text/javascript" 생략가능(디폴트)
//스크립트(function)는 리턴타입이 없다 리턴값은 있다, 매개변수의 타입이 없다           
//ex) fuction myFunction(p1,p2){return p1*p2;}
//리턴 키워드가 있고 값이 지정되야함
//스크립트는 선언을 해야 쓸수 있다
//<head>문 안에 있는 <script>는 선언문 
//<body>문 안에 있는 <script<는 실행문
//같은 <body>문 안에 있어도 실행은 되지만 잘 쓰지 않는 방법이다

	function sum(from, to){//sum=함수이름 
		var sum=0; //로컬변수 선언 (from,to도 로컬변수라고 할수잇다)
		for(var i=from; i<=to; i++){
			sum +=i;
		}
		return sum;
	}
</script>
</head>
<body>
	함수선언
	<hr/>
	<script>//실행문
		console.log("1부터 10까지의 합: "+sum(1,10));
	</script>
	
</body>
</html>
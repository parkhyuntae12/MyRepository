<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"><!-- 생략가능 (브라우저해석방식) -->
<script type="text/javascript">
	var v1 = 10;
	var v2 = "자바스크립트";
	var v3 = true;
	var v4 = {name:"홍길동", age:27}; /*스크립트에서는 {}을 객체선언이라고 부른다, 객체의 번지가 대입된다(v4에)*/
	var v5 = function(){};//자바의 메소드역할, 함수라는 객체가 존재한다, 함수=객체(스크립트에서만)
	var v6 = null; //자바에선 null이 참조할 값이 없다라는 의미 
	var v7 = new Date(); //객체를 만들어서 대입 가능하다
	var v8 = [1,2,3]; //배열(=객체)   *참조타입은 다 object

	console.log("v1 : "+typeof(v1)); //typeof 변수의 타입조사
	console.log("v2 : "+typeof(v2));
	console.log("v3 : "+typeof(v3));
	console.log("v4 : "+typeof(v4));
	console.log("v5 : "+typeof(v5));
	console.log("v6 : "+typeof(v6));
	console.log("v7 : "+typeof(v7));
	console.log("v8 : "+typeof(v8));
	
	v1 = 3.14; //이미 결정된 변수에 또 다른 값을 지정할수 있다..
	v1="Java";
	v1="Java"+8; 
</script>
</head>
<body>
	데이터 타입
	<hr/>
	
	
</body>
</html>
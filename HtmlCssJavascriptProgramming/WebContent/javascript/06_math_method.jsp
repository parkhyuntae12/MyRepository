<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"><!-- 생략가능 (브라우저해석방식) -->
<title>index</title>
</head>
<body>
	수학 관련 메소드
	<hr/>
	<script type="text/javascript">
		var max = Math.max(10,30,20);
		console.log(max);
		
		var integer = Math.round(5.6);
		console.log(integer);
		
		var diceNum = Math.floor(Math.random()*6)+1;
		console.log(diceNum);
	</script>
</body>
</html>
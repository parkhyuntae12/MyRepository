<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"><!-- 생략가능 (브라우저해석방식) -->
<title>index</title>
</head>
<body>
	배열
	<hr/>
	<script type="text/javascript">
		var cars = ["Saab", "Volvo", "BMW"];
		console.log(cars[0]);
		console.log(cars[1]);
		console.log(cars[2]);
		for(var i=0; i<cars.length; i++){
			console.log(cars[i]);
		}
		
		var cars2 = new Array("Saab","Volvo","BMW");
		cars2.sort();
		for(var i=0; i<cars2.length; i++){
			console.log(cars2[i]);
		}
		
		var fruits = ["Banana", "Orange", "Apple", "Mango"];
		fruits.push("Lemon");//새로 데이터를 넣겟다
		fruits[5] = "포도";//가능하대
		for(var i=0; i<fruits.length; i++){
			console.log(fruits[i]);
		}
	</script>
</body>
</html>
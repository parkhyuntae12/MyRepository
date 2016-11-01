<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"><!-- 생략가능 (브라우저해석방식) -->
<style type="text/css">
	*{
		margin:0;
		padding:0;
	}
	.container{
		width:100%;
		border:1px solid gray;
	}
	header, footer{
		padding: 1em;
		color:white;
		background-color:black;
		text-align:center;
	}
	nav{
		float:left;	
		height:500px;
		margin:0px;
		padding:1em;
		background-color:orange;
		width:300px;		
	}
	nav ul{
		list-style-type:none;
		padding:0;
	}
	nav ul a{
		text-decoration:none;
	}
	article{
		margin-left:170px;	
		padding:1em;
		overflow:hidden;
	}
	footer{
		clear:both;
	}
</style>
<title>index</title>
</head>
<body>
	<div class="container">

		<header><!-- 특별한 모양을 가지고 있지는 않다, 검색엔진이 -->
		   <h1>City Gallery</h1>
		</header>
		  
		<nav>
		  <ul>
		    <li><a href="#">London</a></li>
		    <li><a href="#">Paris</a></li>
		    <li><a href="#">Tokyo</a></li>
		    <li><a href="#">Tokyo</a></li>
		    <li><a href="#">Tokyo</a></li>
		    <li><a href="#">Tokyo</a></li>
		    <li><a href="#">Tokyo</a></li>
		    <li><a href="#">Tokyo</a></li>
		    <li><a href="#">Tokyo</a></li>
		    <li><a href="#">Tokyo</a></li>
		    <li><a href="#">Tokyo</a></li>
		    <li><a href="#">Tokyo</a></li>
		    <li><a href="#">Tokyo</a></li>
		    <li><a href="#">Tokyo</a></li>
		    <li><a href="#">Tokyo</a></li>
		    <li><a href="#">Tokyo</a></li>
		    <li><a href="#">Tokyo</a></li>
		  </ul>
		</nav>
		
		<article>
		  <h1>London</h1>
		  <p>London is the capital city of England. It is the most populous city in the  United Kingdom, with a metropolitan area of over 13 million inhabitants.</p>
		  <p>Standing on the River Thames, London has been a major settlement for two millennia, its history going back to its founding by the Romans, who named it Londinium.</p>
		</article>
		
		<footer>Copyright © W3Schools.com</footer>
	</div>	
</body>
</html>	
<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<!-- 헤드엘리먼트 -->
<meta charset="UTF-8">
<title>index</title>
	<link rel="stylesheet" type="text/css"
		href="../common/bootstrap-3.3/css/bootstrap.min.css">
	<script type="text/javascript" src="../common/js/jquery-1.12.4.min.js"></script>
	<script type="text/javascript"
		src="../common/bootstrap-3.3/js/bootstrap.min.js"></script>
	<style type="text/css">
		div{
			border:1px solid gray;
		}
	</style>
</head>
<body>
	Grid System
	<hr/>
	<div class="row">
	  <div class="col-md-1">.col-md-1</div>
	  <div class="col-md-1">.col-md-1</div>
	  <div class="col-md-1">.col-md-1</div>
	  <div class="col-md-1">.col-md-1</div>
	  <div class="col-md-1">.col-md-1</div>
	  <div class="col-md-1">.col-md-1</div>
	  <div class="col-md-1">.col-md-1</div>
	  <div class="col-md-1">.col-md-1</div>
	  <div class="col-md-1">.col-md-1</div>
	  <div class="col-md-1">.col-md-1</div>
	  <div class="col-md-1">.col-md-1</div>
	  <div class="col-md-1">.col-md-1</div>
   </div>
   
   <div class="row">
	  <div class="col-md-8">.col-md-8</div>
	  <div class="col-md-4">.col-md-4</div>
	</div>
	<div class="row">
	  <div class="col-xs-12 col-md-8">.col-xs-12 .col-md-8</div><!-- 부모의 12등분(12등분은 정해져잇다) -->
	  <div class="col-xs-6 col-md-4">.col-xs-6 .col-md-4</div>
	</div>
</body>
</html>
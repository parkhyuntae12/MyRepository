<%@ page contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	</head>
	
	<body>
		[회원 정보]<br/>
		<hr/>
			아이디: ${member.mid}<br/><!-- getmethod를 호출해서 넣어준다 -->
			이름: ${member.mname}<br/>
			비밀번호: ${member.mpassword}<br/>
			나이: ${member.mage}<br/>
			생년월일: ${member.mbirth}<br/>
		</form>
	</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../common/menubar.jsp"/>
	<h2>회원가입</h2>
	<form action="" method="post" id="enrollForm"></form>
	<table>
		<tr>
			<td>* ID</td>
			<td>
				<input name="userId" required>
				<div id="checkResult" style="font-size: 0.8em; display: none;"></div>
			</td>
		</tr>
	</table>

</body>
</html>
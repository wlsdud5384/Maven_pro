<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"
    %>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    <%
    	request.setCharacterEncoding("UTF-8");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인페이지</title>
	<script src="http://code.jquery.com/jquery-latest.js"></script>
</head>
<body>

	<h3>회원 정보 조회창</h3>
	<form name="frmLogin" method="post" action="${contextPath }/member/listTest.do">
		
		<table>
			<tr>
		<td>
		<input type="button" value="회원 정보 조회">
		</td>
		</tr>
		</table>
	</form>
</body>
</html>
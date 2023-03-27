<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"
    %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     
    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
    <c:set var="result" value="${param.result}"/>
    
    <%
    	request.setCharacterEncoding("UTF-8");
    %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인창</title>
<c:choose>
<c:when test="${result=='loginFailed' }">
<script>
	window.onload=function() {
		alert("test9.do를 호출합니다.");
	}
</script>
</c:when>
</c:choose>
</head>
<body>
	<form name="frmLogin" method="post" action="${contextPath }/member/login.do">
		<table border="1" width="80%" align="center">
		
				<tr align="center">
					<td colspan="2">
					<a
						 href="${contextPath}/member/testform.do">
						<input type="button" value="회원정보조회">
						</a>
						
						</td>
			</tr>
		</table>
	
	</form>
	
	
</body>
</html>
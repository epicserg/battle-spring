<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
	<head>

	</head>
	<body>
		<h1>Register here</h1>
		
		<a href="<c:url value="/" />">main</a>
	 	<c:if test="${message!=null}">
	 		Incorrect input: ${message}
	 	</c:if>
	 	<form:form method="POST" action="sendregister.html" commandName="sendregister">
	 		
			    <table>
				    <tr>
				    	<td>Username</td>
				        <td><form:input path="userName" /></td> 
				    </tr>

				    <tr>
				    	<td>password</td>
				        <td><form:input path="passWord" /></td>
				    </tr>
				    <tr>
				    	<td>confirm password</td>
				        <td><form:input path="confirmPassword" /></td>
				    </tr>
				    
				    <tr>
				        <td colspan="2">
				            <input type="submit" value="register"/>
				        </td>
				    </tr>
				</table> 
		</form:form>
	</body>
</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
	<body>
		Hi, ${name} <br/> 
		<form name='f' action="<c:url value='j_spring_security_logout ' />"
		method='POST'>
		
		<input name="submit" type="submit"
					value="submit" />
		
		</form>
		
		
	</body>
</html>	
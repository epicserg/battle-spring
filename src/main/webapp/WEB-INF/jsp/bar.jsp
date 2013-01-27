<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<body>
		
		<c:if test="${error!=null}">
			${error} <br/>
		</c:if>
		<c:set var="regpage" value="/WEB-INF/jsp/register.jsp"/>
		<c:if test="${page!=regpage}">
			<a href="<c:url value="/register" />">register</a>
		</c:if>
		 <form method="POST" action="<c:url value='j_spring_security_check' />"  commandName="login">
		    <table>
			    <tr>
			    	<td>UserName</td>
			        <td><input type='text' name='j_username' value=''></td> 
			    </tr>
			    <tr>
			    	<td>password</td>
			        <td><input type='password' name='j_password' /></td>
			    </tr>
			    <tr>
			        <td colspan="2">
			            <input type="submit" value="login"/>
			        </td>
			    </tr>
			</table> 
		</form>
	</body>
</html>
<!--  
<head>
    <script language="javascript">
        function forceHttpsOnSubmit(objForm) {
            objForm.action = objForm.action.replace("http:", "https:").replace("localhost:8080","localhost:8443");
        }
    </script>
</head>
<body>
<form method="post" action="/j_spring_security_check" onsubmit="forceHttpsOnSubmit(this)">
<c:set var="regpage" value="/WEB-INF/jsp/register.jsp"/>
        <div id="passwordLoginOption" class="form">
            <div class="row">
                <div class="label left">
                    <label for="j_username">login:</label>
                </div>
                <div class="right">
                    <div class="textWrapper">
                        <input type="text" name="j_username"/>
                    </div>
                </div>
                <div class="cl"></div>
            </div>
            <div class="row">
                <div class="label left">
                    <label for="j_password">password:</label>
                </div>
                <div class="right">
                    <div class="textWrapper">
                        <input type="password" name="j_password"/>
                    </div>
                </div>
                <div class="cl"></div>
            </div>
            <div class="row">
                <div class="right">
                    <label class="forCheckbox" for='_spring_security_remember_me'>
                        Remember me:
                        <input type='checkbox' name='_spring_security_remember_me'/>
                    </label>
                </div>
                <div class="cl"></div>
            </div>
            <div class="buttons">
                <input type="submit" value="Login"/>
            </div>
        </div>
    </form>
</body>
-->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html style="height: 100%;">
<head>
  <meta name="generator" content=
  "HTML Tidy for Linux/x86 (vers 11 February 2007), see www.w3.org">
    <link rel="stylesheet" type="text/css" href="<c:url value='/res/css/playboard.css'/>""/> 

  <title>Battleshipz</title>
</head>

<body style="height: 100%;" >

	<div class="BackGround"/>
  <table width="100%" style="height: 100%;">
  <col width="20%">
  <col width="585px">
  <col width="20%">
    <tr style="height:100px">
      <td id="firstd" colspan="3">
        <div>
        	<div class="left">
        		<h1>Battleships v 0.1</h1>
        	</div>
        	<div class="right">
				<jsp:include page="${barpage}" />
        	</div>
        </div>
      </td>
    </tr>

    <tr valign="top" style="height: 100%;">
      <td class="yellowcolumn" >
      	
          <c:forEach var="link" items="${urls}" varStatus="status"> 
			<form method="link" action="<c:url value="/${link.value}" />">
				<input class ="customButton" type="submit" value="${link.key }">
			</form>
          </c:forEach>     		
      </td>

      <td id="thirdtd">
	      <div>
	      	
	      	<jsp:include page="${page}" />
	      </div>
      </td>
      <td class="yellowcolumn" >
  		
      </td>
    </tr>


    <tr style="height:30px">
      <td id="fourthtd" colspan="3">Blackbearded 2012</td>
    </tr>
  </table>

</body>
</html>
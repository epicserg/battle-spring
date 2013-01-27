<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lobby</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/res/css/playboard.css'/>""/>
</head>
<body>
	here you can see the list of active and inactive rooms. 
	<table border="1" width=400px id='lol'>
		<th >
		a
		</th>
		<th >
		a
		</th>
	</table>
	<br/>
	<div id="createRoomButton" >
		<button onclick="createRoom()" >Create room</button>
	</div>
	<div  title="Basic dialog" class="center"  id="createRoom">
		<button type="button" onclick="closeForm()" class="right">close</button><br/>
		<form id="newRoomForm">
			<div class="divcenter">
				<table>
					<tr>
						<td>
							Room Name :
						</td>
						<td>
							<input  class="required"  type="text" name="RoomName"  id="RoomName" /> 
						</td>
					</tr>
					<tr>
						<td>
							Password (optional ):
						</td>
						<td>
							<input   type="text" name="RoomPassword"  id="RoomPassword" /> 
						</td>
					</tr>
				</table>
			</div>
		</form>
		<button type="button" onclick="sendForm()" class="left">Create</button>
	</div>
	<script type="text/javascript" src="<c:url value='/res/javascript/JQuery.js'/>"" ></script> 
	<script type="text/javascript" src="<c:url value='/res/javascript/lobbyTable.js'/>""></script> 
	<script type="text/javascript" src="<c:url value='/res/javascript/lobbyActions.js'/>""></script> 
</body>
</html>
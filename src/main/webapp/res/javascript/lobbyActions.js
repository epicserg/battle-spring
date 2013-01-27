function createRoom(){
	$('#createRoom').show();
	
}

function closeForm(){
	$('#createRoom').hide();
}
function sendForm(){
	if($("#RoomName").val().length>0){
		var roomName =$("#newRoomForm").serialize();
		console.log(roomName);
		$.ajax({
			  url: "registerlobbyroom",
			  context: document.body,
			  type :  "GET",
			  data : roomName,
			  error: function(msg)  
		        {  
		            alert("fail"); 
		        }
			  
			}).done(function() { 
				closeForm();
				$("#createRoomButton").hide();
				return;
			});
	}
	
	
}
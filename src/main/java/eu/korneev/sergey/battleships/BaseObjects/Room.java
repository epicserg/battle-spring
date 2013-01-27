package eu.korneev.sergey.battleships.BaseObjects;

import eu.korneev.sergey.battleships.enums.RoomStatus;


public class Room {
	
	private String roomName;
	private RoomStatus status= RoomStatus.OPEN;
	private boolean isPrivate;
	private String passWordHashCode;
	
	public Room(String roomName ,String password) {
		this.roomName=roomName;
		this.passWordHashCode=Integer.toString( password.hashCode());
		isPrivate=true;
	}
	public Room(String roomName ) {
		this.roomName=roomName;

		
	}

	public boolean isPrivate() {
		return isPrivate;
	}



	public String getRoomName() {
		return roomName;
	}

	public boolean compareHashCode(String password){
		return Integer.toString( password.hashCode()).equals(passWordHashCode);
	}

	public RoomStatus getStatus() {
		return status;
	}

	public void setStatus(RoomStatus status) {
		this.status = status;
	}
	

	

}

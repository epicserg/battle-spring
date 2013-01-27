package eu.korneev.sergey.battleships.services;

import java.util.Map;

import eu.korneev.sergey.battleships.BaseObjects.Room;

public interface LobbyRoomService {


	boolean registerNewRoom(String roomName, String playerName,
			String messageToPlayer,String passWord);
	
	
	boolean destroyRoom(String playername) ;
	
	Map<String,Room> getOpenRooms();
	
	Map<String,Room> getClosedRooms() ;
	
	Map<String,Room> getActiveRooms() ;
	
	
}

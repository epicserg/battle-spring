package eu.korneev.sergey.battleships.services.implementations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import eu.korneev.sergey.battleships.BaseObjects.Room;
import eu.korneev.sergey.battleships.services.LobbyRoomService;

public class LobbyRoomServiceImpl implements LobbyRoomService {

	
	private Map<String,Room> openRooms;
	private Map<String,Room> closedRooms;
	private Map<String,Room> activeRooms;
	private ArrayList<Map<String, Room>> allRooms;
	
	public LobbyRoomServiceImpl(){
		openRooms = new HashMap<String,Room>();
		closedRooms=new HashMap<String,Room>();
		activeRooms= new HashMap<String,Room>();
		allRooms=new ArrayList<Map<String,Room>>();
		allRooms.add(openRooms);allRooms.add(closedRooms);allRooms.add(activeRooms);
	}
	
	@Override
	public boolean registerNewRoom(String roomName, String playerName ,String messageToPlayer,String passWord) {
		if(passWord==null){
			synchronized(openRooms) {
				if(openRooms.containsKey(playerName)){
					openRooms.put(playerName, new Room(roomName,passWord));
					return true;
				}
			}
		}
		else{
			synchronized(closedRooms) {
				if(closedRooms.containsKey(playerName)){
					closedRooms.put(playerName, new Room(roomName,passWord));
					return true;
				}
			}			
		}
		messageToPlayer="You can't create more than one room in our lobby ";
		return false;
	}

	@Override
	public boolean destroyRoom(String playername)  {
		Object result = null;
		for (Map room :allRooms)
			synchronized(room) {
				if(openRooms.remove(playername)!=null){
					return true;
				}
			}
		return false;
		
	}

	@Override
	public Map<String, Room> getOpenRooms() {
		return openRooms;
	}

	public Map<String,Room> getClosedRooms() {
		return closedRooms;
	}
	
	public Map<String,Room> getActiveRooms() {
		return activeRooms;
	}

}

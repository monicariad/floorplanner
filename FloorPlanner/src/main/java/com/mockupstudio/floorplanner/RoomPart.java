package com.mockupstudio.floorplanner;

import java.awt.Polygon;
import java.util.ArrayList;
import java.util.List;

public class RoomPart {
	List<Wall> roomWalls = new ArrayList<Wall>();
	Location location = null;
	Polygon roomPart = new Polygon();
	
	
	
	public RoomPart(List<Wall> roomWalls,Location location){
		RoomPartCreator createRoomPart = new RoomPartCreator(roomWalls,location);
		roomPart = createRoomPart.getRoom();
	}

	
	public Polygon getPolygon(){
		return this.roomPart;
	}
}

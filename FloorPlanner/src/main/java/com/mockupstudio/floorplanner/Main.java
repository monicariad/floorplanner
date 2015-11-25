package com.mockupstudio.floorplanner;

import java.awt.Polygon;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		
	/*	//inputs for floorplan
		//simple square
		List<Wall> floorPlanWalls = new ArrayList<Wall>();
		floorPlanWalls.add(new Wall(5,90));
		floorPlanWalls.add(new Wall(5,0));
		floorPlanWalls.add(new Wall(5,-90));
		floorPlanWalls.add(new Wall(5,180));
		
		//inputs for roompart
		 //simple sqaure
		List<Wall> roomWalls = new ArrayList<Wall>();
		roomWalls.add(new Wall(1,90));
		roomWalls.add(new Wall(1,0));
		roomWalls.add(new Wall(1,-90));
		roomWalls.add(new Wall(1,180));
		Location location = new Location(4.5,4.5);*/
		
		//inputs for floorplan
		//simple hexagon
		List<Wall> floorPlanWalls = new ArrayList<Wall>();
		floorPlanWalls.add(new Wall(5,90));
		floorPlanWalls.add(new Wall(5,45));
		floorPlanWalls.add(new Wall(5,0));
		floorPlanWalls.add(new Wall(5,-45));
		floorPlanWalls.add(new Wall(5,-90));
		floorPlanWalls.add(new Wall(5,-135));
		floorPlanWalls.add(new Wall(5,180)); // also can be -180
		floorPlanWalls.add(new Wall(5,135));
		
		//inputs for roompart
		// oriented rectangle
		List<Wall> roomWalls = new ArrayList<Wall>();
		roomWalls.add(new Wall(1,135));
		roomWalls.add(new Wall(1,45));
		roomWalls.add(new Wall(1,-45));
		roomWalls.add(new Wall(1,-135));
		Location location = new Location(2.566,6.5);
				
		
		
		//create floor plan
		FloorPlanCreator createFloorPlan = new FloorPlanCreator(floorPlanWalls);
		Polygon floorPlan = createFloorPlan.getFloorPlan();
		//create roompart
	//	RoomPartCreator createRoomPart = new RoomPartCreator(roomWalls,location);
		//Polygon roomPart = createRoomPart.getRoom();
		RoomPart roomPart = new RoomPart(roomWalls, location);
		
		//test various parameters of roompart
		RoomPartFit fitRoomPart = new RoomPartFit();
		boolean isInside = fitRoomPart.isInside(floorPlan, roomPart);
		System.out.println("isInside :"+isInside);
		double offset = fitRoomPart.getOffset(floorPlan, roomPart);
		System.out.println("Offset :"+offset);
		boolean isAligned = fitRoomPart.isAligned(floorPlan, roomPart);
		System.out.println("isAligned :"+isAligned);
	}

}

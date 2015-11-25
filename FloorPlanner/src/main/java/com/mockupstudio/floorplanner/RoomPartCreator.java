package com.mockupstudio.floorplanner;


import java.awt.Polygon;
import java.util.ArrayList;
import java.util.List;

public class RoomPartCreator {

	
	List<Wall> roomWalls = new ArrayList<Wall>();
	Location location = null;
	Polygon roomPart = new Polygon();
	double height = 0,width=0;
	double maxDim = 15; // 15 meter limit
	public RoomPartCreator(List<Wall> roomWalls,Location location) {
		super();
		this.roomWalls = roomWalls;
		this.location = location;
	}

	public Polygon getRoom()
	{
		height = 0;
		width=0;
		anchorRoom(this.location);
		roomPart.addPoint(location.pixel.x, location.pixel.y);
		
		for (int i = 0; i < roomWalls.size(); i++) {
			Wall wall = roomWalls.get(i);
			
			if(putWall(wall.length,wall.angle))
			{
				int x = PixelDistanceConverter.toPixel(width);
				int y = PixelDistanceConverter.toPixel(height);
				roomPart.addPoint(x,y);
			}
			else
			{
				System.out.println("Dimension went out of bounds (15m)");
				break;
			}
		}
		
		return roomPart;
	}
	
	public boolean putWall(double length,double angle)
	{
		double tempWidth =0;
		double tempHeight = 0;
		angle = (angle*Math.PI)/180;
			tempWidth = width +length*Math.cos(angle);
			tempHeight = height+length*Math.sin(angle);
			if(tempHeight >maxDim || tempWidth > maxDim)
				return false;
			else
			{
				height = tempHeight;
				width = tempWidth;
			}
			return true;
	}
	public void anchorRoom(Location location)
	{
		width = location.x ;
		height = location.y;
	}
}

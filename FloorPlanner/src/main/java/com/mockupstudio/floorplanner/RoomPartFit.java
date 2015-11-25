package com.mockupstudio.floorplanner;

import java.awt.Polygon;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class RoomPartFit {

	
	
	public boolean isInside(Polygon floorPlan,RoomPart room)
	{
		
		
		Point2D.Double topLeft = new Point2D.Double(room.getPolygon().xpoints[1],room.getPolygon().ypoints[1]);
		Point2D.Double topRight = new Point2D.Double(room.getPolygon().xpoints[2],room.getPolygon().ypoints[2]);
		Point2D.Double bottomLeft = new Point2D.Double(room.getPolygon().xpoints[0],room.getPolygon().ypoints[0]);
		Point2D.Double bottomRight = new Point2D.Double(room.getPolygon().xpoints[3],room.getPolygon().ypoints[3]);
		return floorPlan.contains(topLeft)&&floorPlan.contains(topRight)&&
				floorPlan.contains(bottomLeft)&&floorPlan.contains(bottomRight);
		
	}
	public double getOffset(Polygon floorPlan,RoomPart room)
	{
	
		
		Point2D.Double topLeft = new Point2D.Double(room.getPolygon().xpoints[1],room.getPolygon().ypoints[1]);
		Point2D.Double topRight = new Point2D.Double(room.getPolygon().xpoints[2],room.getPolygon().ypoints[2]);
		Point2D.Double bottomLeft = new Point2D.Double(room.getPolygon().xpoints[0],room.getPolygon().ypoints[0]);
		Point2D.Double bottomRight = new Point2D.Double(room.getPolygon().xpoints[3],room.getPolygon().ypoints[3]);
		
		Line2D alignmentLine = getAlignmentLine(floorPlan,room);
		//checks if rectangle is completely outside and return 0 since its invalid
		if(floorPlan.contains(topLeft)&&floorPlan.contains(topRight)&&
				floorPlan.contains(bottomLeft)&&floorPlan.contains(bottomRight))
			return 0;
		else if((!floorPlan.contains(topLeft))&&(!floorPlan.contains(topRight))&&(!floorPlan.contains(bottomLeft))&&(!floorPlan.contains(bottomRight)))
		{
			return 0;
		}
		//checks
		else if((!floorPlan.contains(topLeft))&&(!floorPlan.contains(topRight)))
		{
			
			return PixelDistanceConverter.pixelToOffset(alignmentLine.ptLineDist(bottomRight));
		}
		else if((!floorPlan.contains(bottomLeft))&&(!floorPlan.contains(bottomRight)))
		{
			return PixelDistanceConverter.pixelToOffset(alignmentLine.ptLineDist(topRight));
		}
		else if((!floorPlan.contains(topLeft))&&(!floorPlan.contains(bottomLeft)))
		{
			return PixelDistanceConverter.pixelToOffset(alignmentLine.ptLineDist(bottomRight));
		}
		else if((!floorPlan.contains(bottomRight))&&(!floorPlan.contains(topRight)))
		{
			return PixelDistanceConverter.pixelToOffset(alignmentLine.ptLineDist(bottomLeft));
		}
		return 0;
	}
	
	public boolean isAligned(Polygon floorPlan,RoomPart room)
	{
	
		Point2D.Double topLeft = new Point2D.Double(room.getPolygon().xpoints[1],room.getPolygon().ypoints[1]);
		Point2D.Double topRight = new Point2D.Double(room.getPolygon().xpoints[2],room.getPolygon().ypoints[2]);
		Point2D.Double bottomLeft = new Point2D.Double(room.getPolygon().xpoints[0],room.getPolygon().ypoints[0]);
		Point2D.Double bottomRight = new Point2D.Double(room.getPolygon().xpoints[3],room.getPolygon().ypoints[3]);
		
		Line2D alignmentLine = getAlignmentLine(floorPlan,room);
		//checks if rectangle is completely outside and return 0 since its invalid
		if(floorPlan.contains(topLeft)&&floorPlan.contains(topRight)&&
				floorPlan.contains(bottomLeft)&&floorPlan.contains(bottomRight))
		{
			// method yet to be developed
			return false;
		}
		else if((!floorPlan.contains(topLeft))&&(!floorPlan.contains(topRight))&&(!floorPlan.contains(bottomLeft))&&(!floorPlan.contains(bottomRight)))
		{
			return false;
		}
		//checks
		else if((!floorPlan.contains(topLeft))&&(!floorPlan.contains(topRight)))
		{
			
			Line2D.Double line = new Line2D.Double(topLeft, topRight);
			return !line.intersectsLine(alignmentLine);
		}
		else if((!floorPlan.contains(bottomLeft))&&(!floorPlan.contains(bottomRight)))
		{
			Line2D.Double line = new Line2D.Double(bottomLeft, bottomRight);
			return !line.intersectsLine(alignmentLine);
		}
		else if((!floorPlan.contains(topLeft))&&(!floorPlan.contains(bottomLeft)))
		{
			Line2D.Double line = new Line2D.Double(topLeft, bottomLeft);
			return !line.intersectsLine(alignmentLine);
		}
		else if((!floorPlan.contains(bottomRight))&&(!floorPlan.contains(topRight)))
		{
			Line2D.Double line = new Line2D.Double(bottomRight, topRight);
			return !line.intersectsLine(alignmentLine);
		}
		return false;
	}
	

	public Line2D.Double getAlignmentLine(Polygon floorPlan,RoomPart room)
	{
		int[] xCoordinates = floorPlan.xpoints;
		int[] yCoordinates = floorPlan.ypoints;
		Line2D.Double vertLine = new Line2D.Double(room.getPolygon().xpoints[0],room.getPolygon().ypoints[0],room.getPolygon().xpoints[1],room.getPolygon().ypoints[1]);
		Line2D.Double horzLine = new Line2D.Double(room.getPolygon().xpoints[1],room.getPolygon().ypoints[1],room.getPolygon().xpoints[2],room.getPolygon().ypoints[2]);
		for (int i = 0; i < floorPlan.npoints; i++) {
			Line2D.Double line = null;
			if(i<floorPlan.npoints-1)
			line = new Line2D.Double(xCoordinates[i], yCoordinates[i],
					xCoordinates[i+1], yCoordinates[i+1]); 
			else
				line = new Line2D.Double(xCoordinates[i], yCoordinates[i],
						xCoordinates[0], yCoordinates[0]);
			
			if(line.intersectsLine(vertLine)||line.intersectsLine(horzLine))
			{
				return line;
			}
		}
		// returns null if it finds no side interecting with the room
		return null;
	}
	
	
}

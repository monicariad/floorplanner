package com.mockupstudio.floorplanner;

import java.awt.Polygon;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;



public class FloorPlanCreator {
	
	// Point2D.Double  startPoint = new Point2D.Double(31,31);
	Point2D.Double  startPoint = new Point2D.Double(0,0); // starting point in canvas at left bottom
	List<Wall> floorPlanWalls = new ArrayList<Wall>();
	Polygon floorPlan = new Polygon();
	double height = 0,width=0;
	double maxDim = 15; // 15 meter limit
	public FloorPlanCreator(List<Wall> floorPlanWalls) {
		super();
		this.floorPlanWalls = floorPlanWalls;
	}

	public Polygon getFloorPlan()
	{
		
		
		height = 0;
		width=0;
		floorPlan.addPoint((int)startPoint.x, (int)startPoint.y);
		
		for (int i = 0; i < floorPlanWalls.size(); i++) {
			Wall wall = floorPlanWalls.get(i);
			
			if(putWall(wall.length,wall.angle))
			{
				int x = PixelDistanceConverter.toPixel(width);
				int y = PixelDistanceConverter.toPixel(height);
				floorPlan.addPoint(x,y);
			}
			else
			{
				System.out.println("Dimension went out of bounds (15m)");
				break;
			}
		}
		return floorPlan;
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
	
}

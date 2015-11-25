package com.mockupstudio.floorplanner;

import java.awt.Polygon;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class FloorPlan {
	Point2D.Double  startPoint = new Point2D.Double(0,0); // starting point in canvas at left bottom
	List<Wall> floorPlanWalls = new ArrayList<Wall>();
	Polygon floorPlan = new Polygon();
}

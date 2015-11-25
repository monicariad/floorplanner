package com.mockupstudio.floorplanner;



import java.awt.Point;

public class Location {
	Point pixel = new Point();;
	double x;
	double y;
	Location(double x,double y)
	{
		this.x = x;
		this.y = y;
		pixel.x = (int) PixelDistanceConverter.toPixel(x);
		pixel.y = (int) PixelDistanceConverter.toPixel(y);
	}
	public Location(Point pixel)
	{
		this.pixel = pixel;
		this.x = PixelDistanceConverter.toLocation(pixel.x);
		this.y = PixelDistanceConverter.toLocation(pixel.y);
	}

}

package com.mockupstudio.floorplanner;



public class PixelDistanceConverter {
	public static int toPixel(double distance)
	{
		//return (int) (31+((distance*450)/15));
		return (int) (((distance*450)/15));
	}
	
	
    public static double toLocation(double pixel)
	{
		//return (((pixel-31)*15)/450);
    	return (((pixel)*15)/450);
	}
    public static double pixelToOffset(double pixels)
    {
    	return ((pixels*15)/450);
    }
    
}

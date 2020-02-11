import java.util.Scanner;
/**
 * 
 * @author LENOVO LAPTOP
 *
 */

public class Galamsey {
	private String vegetation_color;
	private int Color_value;
	private int year;
	static Position position;
	private static double latitude;
	private static double longitude;

	public static class Position {
		public double latitude;
		public double longitude;

		public Position() {
			latitude = 0.0;
			longitude = 0.0;
		}

		public Position(double latitude, double longitude) {
			this.latitude = latitude;
			this.longitude = longitude;

		}
	}
		
public Galamsey() {
	
}


public Galamsey(String vegetation_color, int Color_value, double latitude, double longitude) {
	this.vegetation_color = vegetation_color;
	this.Color_value=Color_value;
	this.year=year;
	this.latitude=latitude;
	this.longitude= longitude;
}


/**
 * @return the vegetation_color
 */



public String getVegetation_color() {
	return vegetation_color;
}


/**
 * @param vegetation_color the vegetation_color to set
 */


public void setVegetation_color(String vegetation_color) {
	this.vegetation_color = vegetation_color;
}


/**
 * @return the color_value
 */


public int getColor_value() {
	return Color_value;
}


/**
 * @param color_value the color_value to set
 */
public void setColor_value(int color_value) {
	Color_value = color_value;
}


/**
 * @return the year
 */
public int getYear() {
	return year;
}


/**
 * @param year the year to set
 */
public void setYear(int year) {
	this.year = year;
}


/**
 * @return the position
 */

	/**
	 * This sets the latitude of the site
	 * @param latitude
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	/**
	 * This returns the latitude 
	 * @return latitude
	 */
	public static double getLatitude() {
		return latitude;
	}


	/**
	 * This returns the longitude
	 * @return longitude
	 */
	public static double getLongitude() {
		return longitude;
	}

	/**
	 * This sets the longitude of the site
	 * @param longitude
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	

	/**
	 *
	 * @return
	 */
	public static String getPosition() {
		return getLatitude() +
				" " + getLongitude();
	}
/**
 * 
 * @return GalamseyDets
 */
public String GalamseyDetails() {
	String GalamseyDets = "The vegetation color is " + this.getVegetation_color() + "\n" +
						 "The color value is " + this.getColor_value() + "\n" +
						"The position is " + this.getPosition() +" \n" +
						 "The year in which it happened is" + this.getYear() + "\n";
	return GalamseyDets;
						
			}


	
	
	
	
	
	




	

}



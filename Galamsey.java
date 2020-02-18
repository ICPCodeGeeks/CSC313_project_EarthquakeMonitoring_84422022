package earthquakemonitoring;

/**
 * 
 * @author Kwabena Koranteng and Richard Anatsui
 *
 */

public class Galamsey {
	private String vegetation_color;
	private int Color_value;
	private int year;
	Position position;
	private double latitude;
	private double longitude;

    /**
     *nested Position class for latitude and longitude
     */
    public class Position {
            public double latitude;
            public double longitude;

            /**
             * default constructor for position class
             */
            public Position() {
			latitude = 0.0;
			longitude = 0.0;
		}

            /**
             * second constructor for position class
             * @param latitude
             * @param longitude
             */
            public Position(double latitude, double longitude) {
			this.latitude = latitude;
			this.longitude = longitude;

		}
	}
		
    /**
     *default constructor
     */
    public Galamsey() {
        
    }

    /**
     *second constructor
     * @param vegetation_color
     * @param Color_value
     * @param year
     * @param latitude
     * @param longitude
     */
    public Galamsey(String vegetation_color, int Color_value, int year, double latitude, double longitude) {
	this.vegetation_color = vegetation_color;
	this.Color_value=Color_value;
	this.year=year;
	this.latitude=latitude;
	this.longitude= longitude;
}


/**
 * This method gets the vegetation color of a galamsey object
 * @return the vegetation_color
 */



public String getVegetation_color() {
	return vegetation_color;
}


/**
 * This method sets the vegetation color of a galamsey object
 * @param vegetation_color the vegetation_color to set
 */


public void setVegetation_color(String vegetation_color) {
	this.vegetation_color = vegetation_color;
}


/**
 * This method gets the color value of a galamsey object
 * @return int color_value
 */


public int getColor_value() {
	return Color_value;
}


/**
 * This method sets the color value of a galamsey object
 * @param color_value the color_value to set
 */
public void setColor_value(int color_value) {
	Color_value = color_value;
}


/**
 * This method gets the year of a galamsey object
 * @return int year
 */
public int getYear() {
	return year;
}


/**
 * This method sets the year of a galamsey object
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
	public double getLatitude() {
		return latitude;
	}


	/**
	 * This returns the longitude
	 * @return longitude
	 */
	public double getLongitude() {
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
	 *This method returns the position
	 * @return String getLatitude()+getLongitude()
	 */
	public String getPosition() {
		return getLatitude() +
				" " + getLongitude();
	}
/**
 * This method returns the details of a galamsey object
 * @return String GalamseyDets
 */
public String GalamseyDetails() {
	String GalamseyDets = "The vegetation color is " + getVegetation_color() + "\n" +
						 "The color value is " + getColor_value() + "\n" +
						"The position is " + getPosition() +" \n" +
						 "The year in which it happened is " + getYear() + "\n";
	return GalamseyDets;
						
			}


	
	
	
	
	
	




	

}



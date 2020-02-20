package earthquakemonitoring;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * @Author Aileen Akpalu
 */
public class TableContent {
    /**
     * Variables for ViewGalam class
     */
    SimpleIntegerProperty id,years;
    SimpleStringProperty obs_name,country_name;
    SimpleDoubleProperty area_c,avg;


    /**
     * Variables for ViewGala and GalaList classes
     */
    SimpleIntegerProperty GID,year;
    SimpleStringProperty vegetation_color;
    SimpleIntegerProperty color_value;
    SimpleDoubleProperty latitude,longitude;


    /**
     * Variables for ListEvent class
     */
    SimpleIntegerProperty OID,GI;
    SimpleStringProperty obs_nam;
    SimpleIntegerProperty l_v;

    /**
     * Variables for the Gal_ob class
     * Observatory ID and observatory name
     */
    SimpleIntegerProperty ID;
    SimpleStringProperty name_o;



    /**
     *
     * @param id
     * @param obs_name
     * @param years
     * @param area_c
     */
    public TableContent(int id, String obs_name,String country_name,int years,Double area_c,Double avg){
        this.id=new SimpleIntegerProperty(id);
        this.obs_name=new SimpleStringProperty(obs_name);
        this.country_name=new SimpleStringProperty(country_name);
        this.years=new SimpleIntegerProperty(years);
        this.area_c=new SimpleDoubleProperty(area_c);
        this.avg= new SimpleDoubleProperty(avg);

    }

    /**
     *
     * @param OID
     * @param obs_nam
     * @param GI
     * @param l_v
     */
    public TableContent(int OID,String obs_nam, int GI,int l_v){
        this.OID=new SimpleIntegerProperty(OID);
        this.obs_nam=new SimpleStringProperty(obs_nam);
        this.GI=new SimpleIntegerProperty(GI);
        this.l_v=new SimpleIntegerProperty(l_v);

    }

    /**
     *
     * @param ID
     * @param name_o
     */
    public TableContent(int ID,String name_o){
        this.ID=new SimpleIntegerProperty(ID);
        this.name_o=new SimpleStringProperty(name_o);
    }


    /**
     *
     * @param GID
     * @param vegetation_color
     * @param color_value
     * @param latitude
     * @param longitude
     * @param year
     */
    public TableContent(int GID,String vegetation_color,int color_value,Double latitude, Double longitude, int year){
        this.GID=new SimpleIntegerProperty(GID);
        this.vegetation_color=new SimpleStringProperty(vegetation_color);
        this.color_value=new SimpleIntegerProperty(color_value);
        this.latitude=new SimpleDoubleProperty(latitude);
        this.longitude= new SimpleDoubleProperty(longitude);
        this.year= new SimpleIntegerProperty(year);
    }


    /**
     * This returns data from the avg column
     * @return avg
     */
    public double getAvg() {
        return avg.get();
    }

    /**
     * This returns data from the avg column
     * @return avg
     */
    public SimpleDoubleProperty avgProperty() {
        return avg;
    }
    /**
     * This sets data to the avg column
     * @return avg
     */
    public void setAvg(double avg) {
        this.avg.set(avg);
    }
    /**
     * This returns data from the ID column
     * @return avg
     */
    public int getID() {
        return ID.get();
    }
    /**
     * This returns data from the ID column
     * @return avg
     */
    public SimpleIntegerProperty IDProperty() {
        return ID;
    }
    /**
     * This sets data to the ID column
     * @return avg
     */
    public void setID(int ID) {
        this.ID.set(ID);
    }
    /**
     * This returns data from the obs_name column
     * @return avg
     */
    public String getName_o() {
        return name_o.get();
    }
    /**
     * This returns data from the obs_name column
     * @return avg
     */
    public SimpleStringProperty name_oProperty() {
        return name_o;
    }
    /**
     * This sets data to the obs_name column
     * @return avg
     */
    public void setName_o(String name_o) {
        this.name_o.set(name_o);
    }
    /**
     * This returns data from the ID column
     * @return avg
     */
    public int getId() {
        return id.get();
    }
    /**
     * This returns data from the ID column
     * @return avg
     */
    public SimpleIntegerProperty idProperty() {
        return id;
    }
    /**
     * This sets data from the ID column
     * @return avg
     */
    public void setId(int id) {
        this.id.set(id);
    }
    /**
     * This returns data from the year column
     * @return avg
     */
    public int getYears() {
        return years.get();
    }
    /**
     * This returns data from the year column
     * @return avg
     */
    public SimpleIntegerProperty yearsProperty() {
        return years;
    }
    /**
     * This sets data from the year column
     * @return avg
     */
    public void setYears(int years) {
        this.years.set(years);
    }
    /**
     * This returns data from the obs_name column
     * @return avg
     */
    public String getObs_name() {
        return obs_name.get();
    }
    /**
     * This returns data from the obs_name column
     * @return avg
     */
    public SimpleStringProperty obs_nameProperty() {
        return obs_name;
    }
    /**
     * This sets data from the obs_name column
     * @return avg
     */
    public void setObs_name(String obs_name) {
        this.obs_name.set(obs_name);
    }
    /**
     * This returns data from the area_covered column
     * @return avg
     */
    public double getArea_c() {
        return area_c.get();
    }
    /**
     * This returns data from the area_covered column
     * @return avg
     */
    public SimpleDoubleProperty area_cProperty() {
        return area_c;
    }
    /**
     * This sets data from the area_covered column
     * @return avg
     */
    public void setArea_c(double area_c) {
        this.area_c.set(area_c);
    }
    /**
     * This returns data from the ID column
     * @return avg
     */
    public int getGID() {
        return GID.get();
    }

    public SimpleIntegerProperty GIDProperty() {
        return GID;
    }
    /**
     * This sets data from the ID column
     * @return avg
     */
    public void setGID(int GID) {
        this.GID.set(GID);
    }
    /**
     * This returns data from the year column
     * @return avg
     */
    public int getYear() {
        return year.get();
    }
    /**
     * This returns data from the year column
     * @return avg
     */
    public SimpleIntegerProperty yearProperty() {
        return year;
    }
    /**
     * This sets data from the year column
     * @return avg
     */
    public void setYear(int year) {
        this.year.set(year);
    }
    /**
     * This returns data from the veg_color column
     * @return avg
     */
    public String getVegetation_color() {
        return vegetation_color.get();
    }
    /**
     * This returns data from the veg_color column
     * @return avg
     */
    public SimpleStringProperty vegetation_colorProperty() {
        return vegetation_color;
    }
    /**
     * This sets data from the veg_color column
     * @return avg
     */
    public void setVegetation_color(String vegetation_color) {
        this.vegetation_color.set(vegetation_color);
    }
    /**
     * This returns data from the col_val column
     * @return avg
     */
    public int getColor_value() {
        return color_value.get();
    }
    /**
     * This returns data from the col_val column
     * @return avg
     */
    public SimpleIntegerProperty color_valueProperty() {
        return color_value;
    }
    /**
     * This sets data from the col_val column
     * @return avg
     */
    public void setColor_value(int color_value) {
        this.color_value.set(color_value);
    }
    /**
     * This returns data from the latitude column
     * @return avg
     */
    public double getLatitude() {
        return latitude.get();
    }
    /**
     * This returns data from the latitude column
     * @return avg
     */
    public SimpleDoubleProperty latitudeProperty() {
        return latitude;
    }
    /**
     * This sets data from the latitude column
     * @return avg
     */
    public void setLatitude(double latitude) {
        this.latitude.set(latitude);
    }
    /**
     * This returns data from the longitude column
     * @return avg
     */
    public double getLongitude() {
        return longitude.get();
    }
    /**
     * This returns data from the longitude column
     * @return avg
     */
    public SimpleDoubleProperty longitudeProperty() {
        return longitude;
    }
    /**
     * This sets data to the longitude column
     * @return avg
     */
    public void setLongitude(double longitude) {
        this.longitude.set(longitude);
    }
    /**
     * This returns data from the country column
     * @return avg
     */
    public String getCountry_name() {
        return country_name.get();
    }
    /**
     * This returns data from the country column
     * @return avg
     */
    public SimpleStringProperty country_nameProperty() {
        return country_name;
    }
    /**
     * This sets data to the country column
     * @return avg
     */
    public void setCountry_name(String country_name) {
        this.country_name.set(country_name);
    }
    /**
     * This returns data from the OID column
     * @return avg
     */
    public int getOID() {
        return OID.get();
    }
    /**
     * This returns data from the OID column
     * @return avg
     */
    public SimpleIntegerProperty OIDProperty() {
        return OID;
    }
    /**
     * This sets data to the OID column
     * @return avg
     */
    public void setOID(int OID) {
        this.OID.set(OID);
    }
    /**
     * This returns data from the GID column
     * @return avg
     */
    public int getGI() {
        return GI.get();
    }
    /**
     * This returns data from the GID column
     * @return avg
     */
    public SimpleIntegerProperty GIProperty() {
        return GI;
    }
    /**
     * This sets data to the GID column
     * @return avg
     */
    public void setGI(int GI) {
        this.GI.set(GI);
    }
    /**
     * This sets data from the obs_name column
     * @return avg
     */
    public String getObs_nam() {
        return obs_nam.get();
    }
    /**
     * This returns data from the obs_name column
     * @return avg
     */
    public SimpleStringProperty obs_namProperty() {
        return obs_nam;
    }
    /**
     * This sets data from the obs_name  column
     * @return avg
     */
    public void setObs_nam(String obs_nam) {
        this.obs_nam.set(obs_nam);
    }
    /**
     * This returns data from the col_val column
     * @return avg
     */
    public int getL_v() {
        return l_v.get();
    }
    /**
     * This returns data from the col_val column
     * @return avg
     */
    public SimpleIntegerProperty l_vProperty() {
        return l_v;
    }
    /**
     * This sets data from the col_val column
     * @return avg
     */
    public void setL_v(int l_v) {
        this.l_v.set(l_v);
    }
}

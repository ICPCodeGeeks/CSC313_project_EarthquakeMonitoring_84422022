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

    public double getAvg() {
        return avg.get();
    }

    public SimpleDoubleProperty avgProperty() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg.set(avg);
    }

    public int getID() {
        return ID.get();
    }

    public SimpleIntegerProperty IDProperty() {
        return ID;
    }

    public void setID(int ID) {
        this.ID.set(ID);
    }

    public String getName_o() {
        return name_o.get();
    }

    public SimpleStringProperty name_oProperty() {
        return name_o;
    }

    public void setName_o(String name_o) {
        this.name_o.set(name_o);
    }

    public int getId() {
        return id.get();
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public int getYears() {
        return years.get();
    }

    public SimpleIntegerProperty yearsProperty() {
        return years;
    }

    public void setYears(int years) {
        this.years.set(years);
    }

    public String getObs_name() {
        return obs_name.get();
    }

    public SimpleStringProperty obs_nameProperty() {
        return obs_name;
    }

    public void setObs_name(String obs_name) {
        this.obs_name.set(obs_name);
    }

    public double getArea_c() {
        return area_c.get();
    }

    public SimpleDoubleProperty area_cProperty() {
        return area_c;
    }

    public void setArea_c(double area_c) {
        this.area_c.set(area_c);
    }

    public int getGID() {
        return GID.get();
    }

    public SimpleIntegerProperty GIDProperty() {
        return GID;
    }

    public void setGID(int GID) {
        this.GID.set(GID);
    }

    public int getYear() {
        return year.get();
    }

    public SimpleIntegerProperty yearProperty() {
        return year;
    }

    public void setYear(int year) {
        this.year.set(year);
    }

    public String getVegetation_color() {
        return vegetation_color.get();
    }

    public SimpleStringProperty vegetation_colorProperty() {
        return vegetation_color;
    }

    public void setVegetation_color(String vegetation_color) {
        this.vegetation_color.set(vegetation_color);
    }

    public int getColor_value() {
        return color_value.get();
    }

    public SimpleIntegerProperty color_valueProperty() {
        return color_value;
    }

    public void setColor_value(int color_value) {
        this.color_value.set(color_value);
    }

    public double getLatitude() {
        return latitude.get();
    }

    public SimpleDoubleProperty latitudeProperty() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude.set(latitude);
    }

    public double getLongitude() {
        return longitude.get();
    }

    public SimpleDoubleProperty longitudeProperty() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude.set(longitude);
    }

    public String getCountry_name() {
        return country_name.get();
    }

    public SimpleStringProperty country_nameProperty() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name.set(country_name);
    }

    public int getOID() {
        return OID.get();
    }

    public SimpleIntegerProperty OIDProperty() {
        return OID;
    }

    public void setOID(int OID) {
        this.OID.set(OID);
    }

    public int getGI() {
        return GI.get();
    }

    public SimpleIntegerProperty GIProperty() {
        return GI;
    }

    public void setGI(int GI) {
        this.GI.set(GI);
    }

    public String getObs_nam() {
        return obs_nam.get();
    }

    public SimpleStringProperty obs_namProperty() {
        return obs_nam;
    }

    public void setObs_nam(String obs_nam) {
        this.obs_nam.set(obs_nam);
    }

    public int getL_v() {
        return l_v.get();
    }

    public SimpleIntegerProperty l_vProperty() {
        return l_v;
    }

    public void setL_v(int l_v) {
        this.l_v.set(l_v);
    }
}

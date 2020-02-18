package earthquakemonitoring;


/**
 *
 * @author Richard Anatsui and Aileen 
 * @version v.1
 */
public class Observatory {
    private String ObsName;
    private String CountryName;
    private int year;
    private double areaCovered;
    private int count_a=0;
    private int count_b=0;
    private int count_c=0;
    private int total_count= count_a+count_b+count_c;
    
    /**
     * creating default constructor
     */
    public Observatory(){
        
    }
    
    Galamsey gam= new Galamsey();
    Galamseydb g1= new Galamseydb();
    /**
     * creating second constructor
     * @param ObsName
     * @param CountryName
     * @param year
     * @param areaCovered
     */
    public Observatory(String ObsName, String CountryName, int year, double areaCovered) {
        this.ObsName = ObsName;
        this.CountryName = CountryName;
        this.year = year;
        this.areaCovered = areaCovered;
    }

    /**
     * getter method for Observatory name
     * @return ObsName
     */
    public String getObsName() {
        return ObsName;
    }

    /**
     *setter method for Observatory name
     * @param ObsName
     */
    public void setObsName(String ObsName) {
        this.ObsName = ObsName;
    }

    /**
     *getter method for Country name
     * @return CountryName
     */
    public String getCountryName() {
        return CountryName;
    }

    /**
     *setter method for Country name
     * @param CountryName
     */
    public void setCountryName(String CountryName) {
        this.CountryName = CountryName;
    }

    /**
     *getter method for Year Galamsey started
     * @return year
     */
    public int getYear() {
        return year;
    }

    /**
     *setter method for Year Galamsey started
     * @param year
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     *getter method for Area covered by observatory
     * @return areaCovered
     */
    public double getAreaCovered() {
        return areaCovered;
    }

    /**
     *setter method for Area covered by observatory
     * @param areaCovered
     */
    public void setAreaCovered(double areaCovered) {
        this.areaCovered = areaCovered;
    }
    
    /**
     * This method displays the details of the Observatory
     * @return String details
     */
    public String displayDetails(){
        try{
        String details= "Observatory Name: "+ getObsName()+"\n"
                +"Country Name: "+ getCountryName()+"\n"
                +"Year Galamsey started: "+ getYear()+"\n"
                +"Area covered by observatory: "+ getAreaCovered();
        return details;
        }catch(Exception e){
            System.out.println(e);
        }
        return null;
    }
    
    /**
     *This method returns the number of occurrences of the 
     * color value of a galamsey object
     * @return int count
     */
    public int count(){
        try{
        if(gam.getColor_value()==1){
            count_a++;
        }
        else if(gam.getColor_value()==2){
            count_b++;

        }
        else if(gam.getColor_value()==3){
            count_c++;
        }
        return total_count;
        }catch(Exception e){
            System.out.println(e);
        }
        return -1;
    }
      /**
     * This method returns the largest "galamsey" colour value.
     * @return int large
     */
    public int largest(){
       try{
       return g1.maxGalamsey();
       }catch(Exception e){
           System.out.println(e);
       }
       return -1;
    }


    /**
     * This method returns the average "galamsey" colour value.
     * @return double average
     */
    public double average(){
        try{
            return g1.averageGalamsey();
        }catch(Exception e){
            System.out.println(e);
        }
        return -1.0;
    }

    /**
     * This method returns the list of all "galamsey" events with a colour value greater than
     * a given number n.
     * @param Galamsey_Operations
     * @param n
     */
    public String Galamsey_List(int col_val){
        try{
        return g1.greaterGalamsey(col_val);
        
        }catch(Exception e){
            System.out.println(e);
        }
        return null;
    }
}

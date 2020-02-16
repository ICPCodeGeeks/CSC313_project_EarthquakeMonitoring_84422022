package earthquakemonitoring;


import java.util.Hashtable;
import java.util.Iterator;


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
       int large= Math.max(Math.max(count_a,count_b),count_c);
       if(large==count_a){
           System.out.println("Green");
       }
       else if (large==count_b){
           System.out.println("Yellow");
       }
       else{
           System.out.println("Brown");
       }
       return large;
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
        int total=count_a+2*(count_b)+ 3*(count_c);
        double average= total/total_count;
        return average;
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
    public void Galamsey_List(Hashtable Galamsey_Operations, int n){
        try{
        Iterator<Integer> A1 = Galamsey_Operations.keySet().iterator();
        while (A1.hasNext()) {
            int key = A1.next();
            Galamsey gy = (Galamsey) Galamsey_Operations.get(key);
            if(gy.getColor_value()>n){
                System.out.println(gy.GalamseyDetails()+ displayDetails());
            }
        }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}

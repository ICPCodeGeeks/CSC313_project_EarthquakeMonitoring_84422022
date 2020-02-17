package earthquakemonitoring;

import java.sql.SQLException;
import java.util.Hashtable;
import java.util.Iterator;

/**
 * @author Aileen Akpalu and Richard Anatsui
 * @version 1.0.1
 */
public class Monitoring {
    /**
     * This is the defualt constructor
     */
    public Monitoring(){

}
    Observatory o= new Observatory();
    Galamseydb g1= new Galamseydb();
    Galamsey gam= new Galamsey();
    /**
     * This method returns the largest "galamsey" colour value.
     * @return large
     */
    public int largests() throws SQLException{
        
        return g1.maxGalamsey();
    }


    /**
     * This method returns the average "galamsey" colour value.
     * @return average
     */
    public String average(){

        return g1.maxAvgObserv();
    }

    /**
     * This method returns the list of all "galamsey" events with a colour value greater than
     * a given number n.
     * @param Galamsey_Operations
     * @param n
     */
    public String Galamsey_List(int col_val){
        try{
            return g1.getAllGalamsey(col_val);
        
        }catch(Exception e){
            System.out.println(e);
        }
        return null;
    }
}

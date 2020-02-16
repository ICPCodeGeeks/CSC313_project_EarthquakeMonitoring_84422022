package earthquakemonitoring;

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
    Galamsey gam= new Galamsey();
    /**
     * This method returns the largest "galamsey" colour value.
     * @return large
     */
    public int largests(){
        
        return o.largest();
    }


    /**
     * This method returns the average "galamsey" colour value.
     * @return average
     */
    public double average(){

        return o.average();
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
                System.out.println(gy.GalamseyDetails()+ o.displayDetails());
            }
            else{
                System.out.println("No events beyond this colour value");
            }
        }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}

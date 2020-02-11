package galamseys;

import java.util.Hashtable;
import java.util.Iterator;

/**
 * @author Aileen Akpalu
 * @version 1.0.1
 */
public class Monitoring {
    /**
     * This is the defualt constructor
     */
    public Monitoring(){

}
    /**
     * This method returns the largest "galamsey" colour value.
     * @return large
     */
    public static int largests(){
        return Observatory.largest();
    }


    /**
     * This method returns the average "galamsey" colour value.
     * @return average
     */
    public static double average(){

        return Observatory.average();
    }

    /**
     * This method returns the list of all "galamsey" events with a colour value greater than
     * a given number n.
     * @param Galamsey_Operations
     * @param n
     */
    public static void Galamsey_List(Hashtable Galamsey_Operations, int n){
        Iterator<Integer> A1 = Galamsey_Operations.keySet().iterator();
        while (A1.hasNext()) {
            int key = A1.next();
            Galamsey gy = (Galamsey) Galamsey_Operations.get(key);
            if(gy.getColor_value()>n){
                System.out.println(gy.GalamseyDetails()+ Observatory.displayDetails());
            }
            else{
                System.out.println("No events beyond this colour value");
            }
        }
    }
}
